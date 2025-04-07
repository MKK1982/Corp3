package com.Pisquare.Service;


import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



import org.springframework.stereotype.Component;

import com.mindgate.bbps.biller.util.HexUtil;

@Component
public class BbpsSecurityUtil
{


	public static final String AES_ALGORITHM = "AES";
	public static final String RSA_ALGORITHM = "RSA";

	public static final String AES_SECRETKEYSPEC = "AES";
	public static final int AES_KEY_SIZE = 256;
	public static final int GCM_IV_LENGTH = 12;
	public static final int GCM_TAG_LENGTH = 16;

	private static final String RSA_TRANSFORMATION = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";
	private static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";
	private static final String AES_TRANSFORMATION = "AES/GCM/NoPadding";

	//	private static final String SHA512 = "SHA-512";

	public boolean verifyDigitalSignature(String message, String signedString, String plainPublicKey)
	{
		PublicKey publicKey = getPublicKey(plainPublicKey);
		return verifyDigitalSignature(message, signedString, publicKey);
	}
	public boolean verifyDigitalSignature(String message, String signedString, PublicKey publicKey)
	{
		Signature sigVerify = null;
		byte[] reqSignature = null;
		boolean status = false;

		try
		{
			if (publicKey == null)
			{
				return status;
			}

			reqSignature = Base64.getDecoder().decode(signedString);

			sigVerify = Signature.getInstance(SIGNATURE_ALGORITHM);
			sigVerify.initVerify(publicKey);
			sigVerify.update(message.getBytes());

			if (sigVerify.verify(reqSignature))
				status = true;
		}
		catch (Exception e)
		{
			status = false;
		
		}

		return status;

	}

	public static PublicKey getPublicKey(String key)
	{
		byte[] keyBytes = null;
		PublicKey publicKey = null;
		KeyFactory keyFactory = null;

		try
		{
			keyBytes = Base64.getDecoder().decode(key);

			keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
			publicKey = keyFactory.generatePublic(publicKeySpec);
		}
		catch (Exception e)
		{
	
		}

		return publicKey;
	}

	public static PrivateKey getPrivateKey(String key)
	{
		byte[] keyBytes = null;
		PrivateKey privateKey = null;
		KeyFactory keyFactory = null;

		try
		{
			keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
			keyBytes = Base64.getDecoder().decode(key);
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(keyBytes);
			privateKey = keyFactory.generatePrivate(privateKeySpec);
		}
		catch (Exception e)
		{
		
		}

		return privateKey;
	}

	public String decryptMessage(String encryptedText, String plainPrivateKey) throws Exception
	{
		PrivateKey privateKey = getPrivateKey(plainPrivateKey);
		return decryptMessage(encryptedText, privateKey);
	}

	public String decryptMessage(String encryptedText, PrivateKey privateKey) throws Exception
	{
		Cipher cipher = Cipher.getInstance(RSA_TRANSFORMATION);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
	}

	public String decryptJson(String key, String request)
	{
		SecretKeySpec secretKeySpec = null;
		Cipher cipher;
		byte[] decrypted = null;
		String cipherText = null;

		try
		{
			secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8.name()), AES_SECRETKEYSPEC);

			byte[] secretKeyBytes = secretKeySpec.getEncoded();
			byte[] initVector = new byte[16];
			initVector = Arrays.copyOfRange(secretKeyBytes, 0, 16);
			IvParameterSpec iv = new IvParameterSpec(initVector);

			cipher = Cipher.getInstance(AES_TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
			decrypted = cipher.doFinal(Base64.getDecoder().decode(request));

			cipherText = new String(decrypted);
		}
		catch (Exception e)
		{
		
		}

		return cipherText;

	}

	public String encryptJson(String key, String request)
	{
		SecretKeySpec secretKeySpec = null;
		Cipher cipher;
		byte[] encrypted = null;
		String cipherText = null;

		try
		{
			secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8.name()), AES_SECRETKEYSPEC);

			byte[] secretKeyBytes = secretKeySpec.getEncoded();
			byte[] initVector = new byte[16];
			initVector = Arrays.copyOfRange(secretKeyBytes, 0, 16);
			IvParameterSpec iv = new IvParameterSpec(initVector);

			cipher = Cipher.getInstance(AES_TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
			encrypted = cipher.doFinal(request.getBytes());

			cipherText = Base64.getEncoder().encodeToString(encrypted);
		}
		catch (Exception e)
		{
	
		}

		return cipherText;

	}

	public String generateDigitalSignature(String JSONString, String plainPrivateKey)
	{
		PrivateKey privateKey = getPrivateKey(plainPrivateKey);
		return generateDigitalSignature(JSONString, privateKey);
	}
	public String generateDigitalSignature(String JSONString, PrivateKey privateKey)
	{
		Signature sigSign = null;
		String digiSignature = "";
		try
		{

			sigSign = Signature.getInstance(SIGNATURE_ALGORITHM);
			//sigSign.setParameter(spec);
			sigSign.initSign(privateKey);
			sigSign.update(JSONString.getBytes());
			byte[] signature = sigSign.sign();

			digiSignature = Base64.getEncoder().encodeToString(signature);
		}
		catch (NoSuchAlgorithmException e)
		{
		
		}
		catch (InvalidKeyException e)
		{
			
		}
		catch (SignatureException e)
		{
			
		}
		return digiSignature;
	}

	public String encryptRsaMessage(String plainText, PublicKey publicKey)
	{

		Cipher cipher;
		String result = null;
		try
		{
			cipher = Cipher.getInstance(RSA_TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			result = Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
		}
		catch (Exception e)
		{
			
		}

		return result;
	}


	//	public String encryptAesGcm(String message, String key)
	//	{
	//		SecretKeySpec skeySpec;
	//		Cipher cipher;
	//		GCMParameterSpec ivSpec;
	//		byte[] iv = new byte[12];
	//		byte encryptedMessage[] = null;
	//		byte[] hexMessage = null;
	//		String encryptedHexMessage = null;
	//		try
	//		{
	//			hexMessage = HexUtil.HexfromString(key);
	//			skeySpec = new SecretKeySpec(hexMessage, AES_SECRETKEYSPEC);
	//			ivSpec = new GCMParameterSpec(128, iv);
	//			cipher = Cipher.getInstance(AES_SECRETKEYSPEC);
	//			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);
	//			encryptedMessage = cipher.doFinal(message.getBytes());
	//			encryptedHexMessage = HexUtil.HextoString(encryptedMessage);
	//		}
	//		catch (Exception e)
	//		{
	//		}
	//		return encryptedHexMessage;
	//	}

	public String encryptAesGcm(String message, String key)
	{
		try
		{
			// Get Cipher Instance
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

			// Create SecretKeySpec
			SecretKeySpec keySpec = new SecretKeySpec(HexUtil.HexfromString(key), AES_SECRETKEYSPEC);

			// Create GCMParameterSpec
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, HexUtil.HexfromString(key.substring(0, GCM_IV_LENGTH)));

			// Initialize Cipher for ENCRYPT_MODE
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

			// Perform Encryption
			byte[] cipherText = cipher.doFinal(message.getBytes());

			return HexUtil.HextoString(cipherText);
		}
		catch (Exception e)
		{

		}
		return null;
	}

	public String encryptAesGcm(String message, SecretKey keySpec, GCMParameterSpec gcmParameterSpec)
	{
		try
		{
			// Get Cipher Instance
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

			// Initialize Cipher for ENCRYPT_MODE
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

			// Perform Encryption
			byte[] cipherText = cipher.doFinal(message.getBytes());

			return HexUtil.HextoString(cipherText);
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	//	public String decryptAesGcm(String message, String key)
	//	{
	//		SecretKeySpec skeySpec;
	//		Cipher cipher;
	//		GCMParameterSpec ivSpec;
	//		byte[] iv = new byte[12];
	//		byte decryptedMessage[] = null;
	//		byte[] hexMessage = null;
	//		String decryptedHexMessage = null;
	//		try
	//		{
	//			hexMessage = HexUtil.HexfromString(key);
	//			skeySpec = new SecretKeySpec(hexMessage, AES_SECRETKEYSPEC);
	//			ivSpec = new GCMParameterSpec(128, iv);
	//			cipher = Cipher.getInstance("AES/GCM/NoPadding");
	//			cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);
	//			decryptedMessage = cipher.doFinal(message.getBytes());
	//			decryptedHexMessage = HexUtil.HextoString(decryptedMessage);
	//		}
	//		catch (Exception e)
	//		{
	//		}
	//		return decryptedHexMessage;
	//	}

	public String decryptAesGcm(String cipherText, String key)
	{
		try
		{
			// Get Cipher Instance
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

			// Create SecretKeySpec
			SecretKeySpec keySpec = new SecretKeySpec(HexUtil.HexfromString(key), AES_SECRETKEYSPEC);

			// Create GCMParameterSpec
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, HexUtil.HexfromString(key.substring(0, GCM_IV_LENGTH)));

			// Initialize Cipher for DECRYPT_MODE
			cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

			// Perform Decryption
			byte[] decryptedText = cipher.doFinal(HexUtil.HexfromString(cipherText));

			return new String(decryptedText);
		}
		catch (Exception e)
		{
			
		}

		return null;
	}

	public String decryptAesGcm(String cipherText, SecretKeySpec keySpec, GCMParameterSpec gcmParameterSpec)
	{
		try
		{
			// Get Cipher Instance
			Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);

			// Initialize Cipher for DECRYPT_MODE
			cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

			// Perform Decryption
			byte[] decryptedText = cipher.doFinal(HexUtil.HexfromString(cipherText));

			return new String(decryptedText);
		}
		catch (Exception e)
		{
		
		}

		return null;
	}

	public String encrypt(String message, String key)
	{
		try
		{
			SecretKeySpec skeySpec = new SecretKeySpec(HexUtil.HexfromString(key), AES_SECRETKEYSPEC);
			Cipher cipher = Cipher.getInstance(AES_SECRETKEYSPEC);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte encstr[] = cipher.doFinal(message.getBytes());
			return HexUtil.HextoString(encstr);
		}
		catch (Exception nse)
		{
			return null;
		}
	}

	public String decrypt(String message, String key)
	{
		try
		{
			SecretKeySpec skeySpec = new SecretKeySpec(HexUtil.HexfromString(key), AES_SECRETKEYSPEC);
			Cipher cipher = Cipher.getInstance(AES_SECRETKEYSPEC);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte encstr[] = cipher.doFinal(HexUtil.HexfromString(message));
			return new String(encstr);
		}
		catch (Exception e)
		{
		
			return null;
		}
	}

}