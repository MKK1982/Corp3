package com.Pisquare.Controllers;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JsonConverterUtilityP {
	/*private static final Logger logger = LogManager
			.getLogger(JsonConverterUtilityP.class);
	*/private static ObjectMapper mapper = null;

	private static void initMapper() {
		if (mapper == null) {
			Class arg = JsonConverterUtilityP.class;
			synchronized (JsonConverterUtilityP.class) {
				if (mapper == null) {
					mapper = new ObjectMapper();
					mapper.configure(
							DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
							false);
					mapper.setSerializationInclusion(Include.NON_NULL);
					//logger.info("", "Mapper init...");
				}
			}
		}

	}

	public static String convertJsonObjectToString(Object obj) {
		if (mapper == null) {
			initMapper();
		}

		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException arg1) {
			//logger.error("Error occured while converting: "
			//		+ obj.getClass().getName() + " Object to String" + arg1);
			return null;
		}
	}

	public static <T> T convertStringToJsonObject(String jsonStringValue,
			Class<T> type) {
		if (mapper == null) {
			initMapper();
		}

		if (jsonStringValue == null) {
			//logger.info("jsonStringValue is null");
			return null;
		} else {
			try {
				return mapper.readValue(jsonStringValue, type);
			} catch (IOException arg2) {
				//logger.info("Error occured while converting JSON String to "
				//		+ type.getClass().getName() + " Object" + arg2);
				return null;
			}
		}
	}
}