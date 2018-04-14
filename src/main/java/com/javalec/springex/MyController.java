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
		return "redirect:redirectestNG";//"redirect:http://localhost:8181/springex/redirectest.jsp"ó�� Ǯ��ε� �����ϴ�
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
//	public String create(@ModelAttribute("student")Student student,BindingResult result) {//BindingReuslt�� ���� �߻��� �װ� ���� ��ü ��ȿ���˻�뵵
//		
//		String page="createDonePage";
//		
//		StudentValidator validator = new StudentValidator();//��ȿ���˻� ��ü����
//		validator.validate(student,result);//��ȿ���˻� �ؼ� result�� ���������� ��������
//		if(result.hasErrors()) {//������ ������
//			page="createPage";//createPage�� ������
//		}
//		
//		
//		return page;
//	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("student")@Valid Student student,BindingResult result) {//BindingReuslt�� ���� �߻��� �װ� ���� ��ü ��ȿ���˻�뵵
		
		String page="createDonePage";
		
		//StudentValidator validator = new StudentValidator();//��ȿ���˻� ��ü����
		//validator.validate(student,result);//��ȿ���˻� �ؼ� result�� ���������� ��������
		
		if(result.hasErrors()) {//������ ������
			page="createPage";//createPage�� ������
		}
		
		
		return page;
	}
	
	@InitBinder//�������� �ڵ�ȣ����
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
