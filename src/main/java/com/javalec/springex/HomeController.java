package com.javalec.springex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)// "/"로 들어온 모든요청을 여기로 받아옴
	public String home(Locale locale, Model model) {//model이 request대신임
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);//현재 시스템시간 받아와서 string으로 저장.
		
		model.addAttribute("serverTime", formattedDate );//어트리뷰트에 싣기 request.setattribute대신임
		
		return "home"; //home값 반환 prefix와 suffix가 붙어서 /WEB-INF/views/ + home+.jsp = /WEB-INF/views/home.jsp를 view로 실행함
	}
	
}
