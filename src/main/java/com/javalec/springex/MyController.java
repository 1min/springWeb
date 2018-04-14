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
	
	@RequestMapping("/confirm")//confirm���� ������
	public String confirm(HttpServletRequest request,Model model) {//HttpServletRequest��ü�� request�޾ƿ���
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		
		return "/confirm";//confirm���� ������
		
	}
	
	@RequestMapping("/checkid")
	public String checkid(@RequestParam("id") String id,@RequestParam("pw")String pw,Model model) {
		//@requestParam("id")String id�� String id = request.getParameter("id")�� ��������
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "/checkid";
		
	}
	
	@RequestMapping("/join")
	public String join(Member member) {//ª�� �Ķ���� �޾Ƽ� ��ü�� �ѱ��
		
		return "/join";	
	}
	
//	@RequestMapping("/join")���� ����ҷ��� �̷���
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
