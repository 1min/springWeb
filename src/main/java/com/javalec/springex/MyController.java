package com.javalec.springex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping("/sending")
	public String sending() {
		return "/sending";
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="/student")
	public String goStudent(HttpServletRequest request,Model model) {
		
		System.out.println("RequestMethod.POST");
		
		String id=request.getParameter("id");
		System.out.println("id:"+ id );
		model.addAttribute("studentid",id);
		
		return "/student";
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/student")
	public ModelAndView goStudent(HttpServletRequest request) {
		
		System.out.println("RequestMethod.GET");
		
		String id=request.getParameter("id");
		System.out.println("id:"+ id );
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentid",id);
		mv.setViewName("/student");
		return mv;
		
	}
	
	@RequestMapping("/studentview")
	public String studentview(@ModelAttribute("stv") StudentView studentview){
		return "studentview";
		
	}
	
	@RequestMapping("/redirectest")
	public String redirectest(HttpServletRequest request,Model model) {
		String id=request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:redirectestOK";
		}
		return "redirect:redirectestNG";//"redirect:http://localhost:8181/springex/redirectest.jsp"처럼 풀경로도 가능하다
	}
	
	@RequestMapping("/redirectestNG")
	public String redirectestNG() {
		
		return "/redirectestNG";
	}
	
	@RequestMapping("/redirectestOK")
	public String redirectestOK() {
		
		return "/redirectestOK";
	}
	
	@RequestMapping("/studentform")
	public String studentform() {
		
		return "createPage";
	}
	
//	@RequestMapping("/create")
//	public String create(@ModelAttribute("student")Student student,BindingResult result) {//BindingReuslt는 에러 발생시 그걸 담을 객체 유효성검사용도
//		
//		String page="createDonePage";
//		
//		StudentValidator validator = new StudentValidator();//유효성검사 객체생성
//		validator.validate(student,result);//유효성검사 해서 result에 에러있으면 에러담음
//		if(result.hasErrors()) {//에러가 있으면
//			page="createPage";//createPage로 보내줌
//		}
//		
//		
//		return page;
//	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("student")@Valid Student student,BindingResult result) {//BindingReuslt는 에러 발생시 그걸 담을 객체 유효성검사용도
		
		String page="createDonePage";
		
		//StudentValidator validator = new StudentValidator();//유효성검사 객체생성
		//validator.validate(student,result);//유효성검사 해서 result에 에러있으면 에러담음
		
		if(result.hasErrors()) {//에러가 있으면
			page="createPage";//createPage로 보내줌
		}
		
		
		return page;
	}
	
	@InitBinder//스프링이 자동호출함
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
