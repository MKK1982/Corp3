package com.Pisquare.Controllers;

import java.security.spec.KeySpec;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Pisquare.Beans.Login1;
import com.Pisquare.Beans.Search;
import com.Pisquare.Beans.Simple;
import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Dao.UserDetailsDao;
import com.Pisquare.Service.AsyncService;

@Component
@Controller
@Scope("session")
@SessionAttributes({"user","Current_Date","Branch","Current","Search_Info","FDSearch_Info","Search_Info_PreClosure","JLSearch_Info"})
public class UserController {
	

JdbcTemplate template;


	@Autowired
	private UserDetailsDao userDao;

	@Autowired
	private Configuration_Controller con;

	
	@Autowired 
	private UserDetailsDao dao10;
	
	  private String generatedOtp = null;

	    @RequestMapping(value = "register", method = RequestMethod.GET)
	    public String viewRegister(Map<String, Object> model) {
	        return "register";
	    }
	    @RequestMapping(value = "Memberlogin", method = RequestMethod.GET)
	    public String viewMemberlogin(Map<String, Object> model) {
	        return "Memberlogin";
	    }
	    @RequestMapping(value = "MemberHeader", method = RequestMethod.GET)
	    public String viewMemberHeader(Map<String, Object> model) {
	        return "MemberHeader";
	    }
	  
	
	    @RequestMapping(value = "SuccessApprovalMember1", method = RequestMethod.GET)
	    public String viewSuccessApprovalMember1(Map<String, Object> model) {
	        return "SuccessApprovalMember1";
	    }
	    @RequestMapping(value = "MemberForgotpassword", method = RequestMethod.GET)
	    public String viewMemberForgotpassword(Map<String, Object> model) {
	        return "MemberForgotpassword";
	    }
	 
	    @RequestMapping(value = "/sendOtp", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, String> sendOtp(@RequestBody Map<String, String> requestBody) {
	        String mobileNumber = requestBody.get("mobileNumber");

	        if (mobileNumber.length() != 10 || !mobileNumber.matches("[0-9]+")) {
	            Map<String, String> errorResponse = new HashMap<>();
	            errorResponse.put("message", "Invalid mobile number.");
	            return errorResponse;
	        }


	        Random rand = new Random();
	        generatedOtp = String.format("%06d", rand.nextInt(1000000));

	        // Simulate sending OTP via SMS (replace this with actual SMS service)
	        sendOtpViaSms(mobileNumber, generatedOtp);

	     
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "OTP has been sent to your mobile number.");
	        return response;
	    }

	    private void sendOtpViaSms(String mobileNumber, String otp) {
	     
	        System.out.println("Sending OTP to " + mobileNumber + ": " + otp);
	   
	    }

	    @RequestMapping(value = "/verifyOtp", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, String> verifyOtp(@RequestBody Map<String, String> requestBody) {
	        String enteredOtp = requestBody.get("enteredOtp");


	        Map<String, String> response = new HashMap<>();
	        if (generatedOtp != null && generatedOtp.equals(enteredOtp)) {
	            response.put("message", "OTP Verified Successfully!");
	        } else {
	            response.put("message", "Invalid OTP. Please try again.");
	        }
	        return response;
	    }
	public static String newline = System.getProperty("line.separator");
	
	int Binfo=201;
	
	//public static String File_Path="/resources/images/Upload_Files/";
	//public static String File_Path2="/image/";
	//public static String JLPurifyFile_Path="e:/JL_Purity/";
	//public static String File_Path3="/SNNLJLIMAGE/";
	
		public static String File_Path=Configuration_Controller.MEM_INFO;		public static String MEM_INFO="/resources/images/Upload_Files/";
		
		public static String File_Path2=Configuration_Controller.MEM_ID;		public static String MEM_ID="/image/";
		
		public static String JLPurifyFile_Path=Configuration_Controller.JL_PURITY;		public static String JL_PURITY="e:/JL_Purity/";
		
		public static String File_Path3=Configuration_Controller.JL_IMAGE;		public static String JL_IMAGE="/SNNLJLIMAGE/";
	
	
	
	
	//Key generation----------------------------------------------------------

	  private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private KeySpec ks;
	    private SecretKeyFactory skf;
	    private Cipher cipher;
	    byte[] arrayBytes;
	    private String myEncryptionKey;
	    private String myEncryptionScheme;
	    SecretKey key;

	    public UserController() throws Exception {
	        myEncryptionKey = "ThisIsSpartaThisIsSparta";
	        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
	        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
	        ks = new DESedeKeySpec(arrayBytes);
	        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
	        cipher = Cipher.getInstance(myEncryptionScheme);
	        key = skf.generateSecret(ks);
	    }
	  // end Key generation ---------------------------------------------------------
	
	
	
/*
	 @RequestMapping(value = "/", method = RequestMethod.GET)
		public String viewLogin(Map<String, Object> model) throws ParseException {
			Login1 login = new Login1();
			model.clear();
			model.put("loginEntity", login);
			
				
			return "login";
		}
	 
	 */
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
		public String viewLogin(Map<String, Object> model) throws ParseException {
			Login1 login = new Login1();
			//model.clear();
			model.put("loginEntity", login);
			//con.Init_DB();
			//int count=0;
			
			//System.out.println("Before DB="+count);
				/// count=userDao.Check_Already_User("123456");
				//System.out.println("count="+count);
			
			 final Logger logger = Logger.getLogger(UserController.class);
			    logger.info("CorporateLogin SNNL started.");
			return "Login2";
		}
	 
	 @RequestMapping(value = "Login2", method = RequestMethod.GET)
		public String viewLoginLink(Map<String, Object> model) throws ParseException {
			Login1 login = new Login1();
			model.clear();
			model.put("loginEntity", login);
			
			String Inactive=dao10.Get_ScalarFun("SELECT count(*)as c1 FROM V$Session WHERE Status='INACTIVE' AND UserName IS NOT NULL and schemaname='DBUSER1' group by SchemaName order by SchemaName", 999);
			System.out.println(Inactive);
			int count=Integer.parseInt(Inactive);
				
			return "Login2";
		}
	 
	 @RequestMapping(value = "Home", method = RequestMethod.GET)
		public String viewHome(Map<String, Object> model) throws ParseException {
			
			
				
			return "Home";
		}
	
	 @RequestMapping(value = "index", method = RequestMethod.GET)
		public String viewindex(Map<String, Object> model) throws ParseException {
			
			
				
			return "index";
		}
	 
	 
	 @RequestMapping(value = "about", method = RequestMethod.GET)
		public String viewabout(Map<String, Object> model) throws ParseException {
			
			
				
			return "about";
		}
	 @RequestMapping(value = "AdminLogin", method = RequestMethod.GET)
		public String viewAdminLogin(Map<String, Object> model) throws ParseException {
			
			
				
			return "AdminLogin";
		}
	 @RequestMapping(value = "services", method = RequestMethod.GET)
		public String viewservices(Map<String, Object> model) throws ParseException {
			
			
				
			return "services";
		}
	 @RequestMapping(value = "contact", method = RequestMethod.GET)
		public String viewcontact(Map<String, Object> model) throws ParseException {
			
			
				
			return "contact";
		}
	 @RequestMapping(value = "refunds", method = RequestMethod.GET)
		public String viewrefunds(Map<String, Object> model) throws ParseException {
			
			
				
			return "refunds";
		}
	 @RequestMapping(value = "privacy", method = RequestMethod.GET)
		public String viewprivacy(Map<String, Object> model) throws ParseException {
			
			
				
			return "privacy";
		}
	 @RequestMapping(value = "terms", method = RequestMethod.GET)
		public String viewterms(Map<String, Object> model) throws ParseException {
			
			
				
			return "terms";
		}
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout1(Map<String, Object> model,HttpSession session,HttpServletRequest request,SessionStatus status) throws SQLException {
			 System.out.println("--------------------------------------LoginValidate------------------------------------");	
			session=request.getSession();
			//int b=(int) session.getAttribute("Branch");
			//dao16.removeBranchStatus(b);
			//session.invalidate();
			 System.out.println("--------------------------------------LoginValidate------------------------------------");
			
			Login1 login = new Login1();
			model.clear();
			model.put("loginEntity", login);
			
    		String user=(String) session.getAttribute("user");
    		String sessionid=session.getId();
			status.isComplete();
			session.invalidate();
			 final Logger logger = Logger.getLogger(UserController.class);
			    logger.info("CorporateLogin SNNL logout: "+user);
		     System.out.println("logout");
			return "Login2";
		}

	    
	    
	  
	    @RequestMapping(value = "/LoginValidate", params="normal", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("loginEntity") Login1 loginEntity, BindingResult result,ModelMap mp,@RequestParam String Username,HttpSession session,HttpServletRequest request,Map<String, Object> model,RedirectAttributes attributes) throws Exception 
	    {
	    	
	    	    	
	    	if (result.hasErrors()) {
	    		
	    		 //ModelAndView mv = new ModelAndView("login");
	    		//mv.addObject("errorMessage", "Login Credential");
	    		
	    		
	    		//-----------------------branch list---------------------
	    		
	    		//05-08-2024
	    		 attributes.addFlashAttribute("message","Enter proper Input");
					return "redirect:/";
				//return "Login2";
			}
	    	
	    	else
	    	{
	    		
	    		
	        String userName = loginEntity.getUsername();
	        String password = loginEntity.getPassword();
	      
	        int bcode1=Binfo;
	        int DBCode=bcode1;
	      
	        if(userName.equalsIgnoreCase("pisquare")&& password.equalsIgnoreCase("123456"))
	        {
        	    System.out.println("--------------------------------------LoginValidate------------------------------------");
	        	
	        	SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
	        	System.out.println("getting Current_Date=");
	        	//String Current=dao10.Get_Current_Date(DBCode);
	        	
	        	Date loginDate=new Date();
	        	Date Current_Date=new Date();
	        	
	        	String Current=sd.format(Current_Date);
	        	
	        	System.out.println("Current_Date="+Current);
	        	
	            
	        	 //----------------------------------------------------------------------------Branch code ------------------------------------------------------
	        	
	        	 int branch=bcode1;
	        	 
	        	 
	        		        	 //-----------------------------------------------------------------------------Session Info---------------------------------------------------
	             mp.put("Username", userName);
	             mp.addAttribute("user", userName);
	             mp.addAttribute("LoginDate",loginDate);
	             mp.addAttribute("Branch",branch);
	             mp.addAttribute("Current_Date", Current_Date);
	             mp.addAttribute("Current", Current);
	             
	             String  realPath = request.getRealPath("/resources/Images/");
	             mp.addAttribute("realPath", realPath);

	             session=request.getSession();
	             session.setAttribute("Branch", branch);
	            session.setAttribute("Username", userName);
	            session.setAttribute("Current_Date", Current_Date);
	            session.setAttribute("realPath", realPath);
	            session.setAttribute("user", userName);
	            
	           String branchString=request.getContextPath();
	           System.out.println("branchString="+branchString);
	           session.setAttribute("BranchString", branchString);
	           mp.addAttribute("BranchString", branchString); 
	         	
	          
	          	             
	         return "Home";
	        }
	        else
	        {
	        	ModelAndView mv = new ModelAndView("Login2");
	        	
	        	//-----------------------branch list---------------------
	    		
	    		
	        	
	        	mp.put("message","Login Credential");
	        	
	            mv.addObject("loginEntity", new Login1());
	            //mv.addObject("err", "Login Credential");
	            //mv.addObject("errorMessage", "Login Credential");
	            
	          //05-08-2024
	    		 attributes.addFlashAttribute("message","Login Credential");
					return "redirect:/";
	     	   //return "Login2";
	        }
			/* }
			 else
		        {
		        	ModelAndView mv = new ModelAndView("login");
		        	
		        	//-----------------------branch list---------------------
		    		
		    		
		        	
		        	mp.put("message","Login Credential-Branch Permission");
		        	
		            mv.addObject("loginEntity", new Login1());
		            //mv.addObject("err", "Login Credential");
		            //mv.addObject("errorMessage", "Login Credential");
		     	   return "login";
		        }
		        */
	   	}
	    } 
	 
	    
	    //--------------------------------------------------------------------------------------------------------------------------------------------------	    
	    @RequestMapping("/View_Transactions")
	    public ModelAndView ViewSB_Transactions_Corp(ModelMap mp,HttpServletRequest request,HttpSession session) throws Exception
	    {  
	    	///Session-------------------------------------------------------------
	    	 session=request.getSession();
	    		String user=(String) session.getAttribute("user");
	    		if(user==null)
	    		return  new ModelAndView("Session");
	      //--------------------------------------------------------------------
	    		
				
	
	    		
	    	session=request.getSession();
	    	SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
	    	
	    	int DBCode=(int) session.getAttribute("Branch");
	    	
	    	Date Current_Date=(Date) session.getAttribute("Current_Date");
	    	String Current=sd.format(Current_Date);
	    	int Tras_Id=1;
	    	
	    	String flag="notAll";
	    	//List<SimpleBranch> list=dao15.getSB_TransList();
	    	//List<SimpleBranch> list=dao15.getSB_TransList(0,Current,Current,DBCode);
	    	List<SimpleBranch> list=dao10.getTransaction_List(Tras_Id,Current,Current,flag,Binfo,DBCode);
	    	
	    	if(list.size()!=0)
	    	{
	    		mp.put("NoOfRecords", list.size());
	    	}
	    	else
	    	{
	    		mp.put("NoOfRecords", 0);
	    	}
	    	 Search search = new Search();
	    	 search.setFrom_Date(Current);
	    	 search.setTo_Date(Current);
	    		mp.put("kk", search);
	    		mp.addAttribute("kk", search);	
	    		mp.put("list",list);
	    	
	    		//Default Branch
	    		search.setBranch_Type("201-SNNL.Main");
	    		
	    		
	    		//Branch List----------------------------------------
	    		List <Simple> branchCode=dao10.getBranchCode();
				System.out.println("Branch_Code=getbranch");
				List<String> branchCodeList=new ArrayList<>();
				for(Simple s:branchCode)
				{
					String s3=s.getS1()+"-"+s.getS2();
					branchCodeList.add(s3);
					System.out.println(s3);  
					 
				}
				mp.put("BranchCodeList", branchCodeList);
				//---------------------------------------------
				
					int page=1;
					
					
			        PagedListHolder<SimpleBranch> pagedListHolder = new PagedListHolder<>(list);
			        pagedListHolder.setPageSize(10);
			        mp.put("maxPages", pagedListHolder.getPageCount());
			        int n= pagedListHolder.getPageCount();
			        
			        /*
			        if(page!=0 || page < 1 || page > pagedListHolder.getPageCount())
			        	page=1;
			        	mp.put("page", page);
			        	
			        if(page == 0 || page < 1 || page > pagedListHolder.getPageCount()){
			            pagedListHolder.setPage(0);
			           mp.put("list1", pagedListHolder.getPageList());
			        }
			        else*/ if(page <= pagedListHolder.getPageCount()) {
			            pagedListHolder.setPage(page);
			            mp.put("list", pagedListHolder.getPageList());
			        }
					 
			        int minPages=1;
			 		int maxPages=n;
			 		
			 		minPages=page/10;
			 		if(minPages==0)
			 		{
			 			minPages=1;
			 			maxPages=n;
			 		}
			 		else
			 		{
			 			minPages=minPages*10;
			 			maxPages=minPages+20;
			 		}
			 		
			        
			      
			      
			       
			        
			      
			        System.out.println("NoOfPages="+n);
			        
			        mp.put("minPages",minPages);
			        mp.put("maxPages",maxPages);
					
					mp.put("page", page);
					
					//Search Info
					 session.setAttribute("Search_Info",search);
				            	mp.addAttribute("Search_Info",search);
				            	return new ModelAndView("View_Transactions");
	    
	    } 
	    





						    }

