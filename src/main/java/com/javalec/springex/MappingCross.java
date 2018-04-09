package com.javalec.springex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class MappingCross {

	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("hello", "우하하하 반갑네 반가워");
		mv.setViewName("/board/hello");
		
		
		return mv;
		
	}
}
