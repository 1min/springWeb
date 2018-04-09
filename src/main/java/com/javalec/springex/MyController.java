package com.javalec.springex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	
	@RequestMapping("/board/content")
	public String content(Model model) {//�������� �����ִ� model��ü
		model.addAttribute("id", "1234");//id�� ����
		
		return "board/content";
		
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {//�Ű����� �ȹ޾Ƶ��Ǵ� modelandview��ü �޼ҵ尡 ���ٸ�

		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);//id�� ����
		mv.setViewName("board/reply");//������Ϸ� �����ٰ���
		return mv;
		
	}
	
}
