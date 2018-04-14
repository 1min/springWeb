package com.javalec.springex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/confirm")//confirm으로 들어오면
	public String confirm(HttpServletRequest request,Model model) {//HttpServletRequest객체는 request받아오기
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		
		return "/confirm";//confirm으로 보내기
		
	}
	
	@RequestMapping("/checkid")
	public String checkid(@RequestParam("id") String id,@RequestParam("pw")String pw,Model model) {
		//@requestParam("id")String id는 String id = request.getParameter("id")와 같은역할
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "/checkid";
		
	}
	
	@RequestMapping("/join")
	public String join(Member member) {//짧게 파라미터 받아서 객체로 넘기기
		
		return "/join";	
	}
	
//	@RequestMapping("/join")굳이 길게할려면 이렇게
//	public String join(@RequestParam("id")String id,@RequestParam("pw")String pw,Model model) {
//		
	
//	Member member = new Member();
//	member.setId(id);
//	member.setPw(pw);
//	
//	model.addAttribute("member",member);
//		return "/join";	
//	}
	
	
}
