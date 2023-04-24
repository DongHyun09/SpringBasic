<<<<<<< HEAD
package com.newlecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("test");
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("data", "Hello Spring MVC");
//		mav.setViewName("WEB-INF/view/index.jsp");

		return mav;
	}
}
=======
/*
 * package com.newlecture.controller;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.servlet.mvc.Controller;
 * 
 * public class IndexController implements Controller{
 * 
 * @Override public ModelAndView handleRequest(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { // TODO Auto-generated
 * method stub return null; } }
 */
>>>>>>> branch 'main' of https://github.com/DongHyun09/SpringBasic.git
