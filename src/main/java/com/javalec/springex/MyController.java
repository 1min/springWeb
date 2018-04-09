package com.javalec.springex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	
	@RequestMapping("/board/content")
	public String content(Model model) {//리스폰스 날려주는 model객체
		model.addAttribute("id", "1234");//id값 셋팅
		
		return "board/content";
		
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {//매개인자 안받아도되는 modelandview객체 메소드가 좀다름

		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);//id값 셋팅
		mv.setViewName("board/reply");//어느파일로 보내줄건지
		return mv;
		
	}
	
}
