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
	@RequestMapping(value = "/", method = RequestMethod.GET)// "/"�� ���� ����û�� ����� �޾ƿ�
	public String home(Locale locale, Model model) {//model�� request�����
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);//���� �ý��۽ð� �޾ƿͼ� string���� ����.
		
		model.addAttribute("serverTime", formattedDate );//��Ʈ����Ʈ�� �Ʊ� request.setattribute�����
		
		return "home"; //home�� ��ȯ prefix�� suffix�� �پ /WEB-INF/views/ + home+.jsp = /WEB-INF/views/home.jsp�� view�� ������
	}
	
}
