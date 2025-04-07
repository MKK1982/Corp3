package com.Pisquare.Controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


import com.Pisquare.Dao.UserDetailsDao;

//import com.spring.mvc.demo.exception.MyException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@Autowired
	private UserDetailsDao dao;

	/*@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex,HttpServletRequest req,HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("SessionException");
		String c=""+ex.getCause();
		session=req.getSession();
		String user=(String) session.getAttribute("user");
		if(user==null)
		return  new ModelAndView("Session");
		
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
		Date sysdate;
		//String s=sysdate.toString();
		int bcode=(int) session.getAttribute("Branch");
		sysdate=(Date) session.getAttribute("Current_Date");
		String sys=sd.format(sysdate);
		
		
		dao.saveException_Info(""+bcode,sys,ex.toString(),c,""+ex.getStackTrace()[0].getLineNumber(),ex.toString(),user,""+req.getRequestURL());
		
		
		return model;

	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView NullPointerException(NullPointerException ex,HttpServletRequest req,HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.addObject("errMsg", "Exception :"+ex.toString());
		//e.getStackTrace()[0].getLineNumber();
		model.addObject("errMsg2",  "Line :"+ex.getStackTrace()[0].getLineNumber()+" ,Casuse:"+ex.getCause());
		model.addObject("url", req.getRequestURL());
		model.setViewName("SessionException");
		String c=""+ex.getCause();
		session=req.getSession();
		String user=(String) session.getAttribute("user");
		if(user==null)
		return  new ModelAndView("Session");
		
		SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
		Date sysdate;
		//String s=sysdate.toString();
		int bcode=(int) session.getAttribute("Branch");
		sysdate=(Date) session.getAttribute("Current_Date");
		String sys=sd.format(sysdate);
		
		
		dao.saveException_Info(""+bcode,sys,ex.toString(),c,""+ex.getStackTrace()[0].getLineNumber(),ex.toString(),user,""+req.getRequestURL());
		
		
		return model;

	}
	
	// Convert a predefined exception to an HTTP Status code
	  @ResponseStatus(value=HttpStatus.CONFLICT,
	                  reason="Data integrity violation")  // 409
	  @ExceptionHandler(DataIntegrityViolationException.class)
	  public ModelAndView conflict(DataIntegrityViolationException de,HttpServletRequest req,HttpSession session) {
	    // Nothing to do
		  
		  ModelAndView model = new ModelAndView();
		
		  model.setViewName("SessionException");
			String c=""+de.getCause();
			session=req.getSession();
			String user=(String) session.getAttribute("user");
			if(user==null)
			return  new ModelAndView("Session");
			
			SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
			Date sysdate;
			//String s=sysdate.toString();
			int bcode=(int) session.getAttribute("Branch");
			sysdate=(Date) session.getAttribute("Current_Date");
			String sys=sd.format(sysdate);
			
			
			dao.saveException_Info(""+bcode,sys,de.toString(),c,""+de.getStackTrace()[0].getLineNumber(),de.toString(),user,""+req.getRequestURL());
			
			
			return model;
	  }
	  
	
	  
	  // Specify name of a specific view that will be used to display the error:
	  @ExceptionHandler(value=SQLException.class)
	  public ModelAndView databaseError(SQLException sq,HttpServletRequest req,HttpSession session) {
	    // Nothing to do.  Returns the logical view name of an error page, passed
		  ModelAndView model = new ModelAndView();
		
		  model.setViewName("SessionException");
			String c=""+sq.getCause();
			session=req.getSession();
			String user=(String) session.getAttribute("user");
			if(user==null)
			return  new ModelAndView("Session");
			
			SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
			Date sysdate;
			//String s=sysdate.toString();
			int bcode=(int) session.getAttribute("Branch");
			sysdate=(Date) session.getAttribute("Current_Date");
			String sys=sd.format(sysdate);
			
			
			dao.saveException_Info(""+bcode,sys,sq.toString(),c,""+sq.getStackTrace()[0].getLineNumber(),sq.toString(),user,""+req.getRequestURL());
			
			
			return model;
	    //return "error";
	  }

	*/
	}	
	
