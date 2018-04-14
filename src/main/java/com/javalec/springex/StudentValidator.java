package com.javalec.springex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{//Validator인터페이스를 상속받음

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);//검증할 클래스 타입 정보를 명시해줘야함
	}

	@Override
	public void validate(Object obj, Errors errors) {//obj는 어떤 객체를 받을것인지 errors는 에러가 발생하면 에러에 담을것
		// TODO Auto-generated method stub
		
		System.out.println("validate()");
		Student student = (Student)obj;
		String studentName=student.getName();//커맨드객체의 이름필드가져오기
		if(studentName==null || studentName.trim().isEmpty()) {//이름이 안적혀있거나 비어있으면(앞뒤로 공백자르고 비어있는지 검증) 필드에 맞는 타입값안써도 오류발생
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");//만약 비어있으면 errors에다가 name필드에 trouble일 발생했다고 전달
		}
		
		int studentid = student.getId();//커맨드객체의 id필드 가져오기
		if(studentid==0) {
			System.out.println("studentid is 0");
			errors.rejectValue("id", "trouble");//만약 비어있으면 errors에다가 id필드에 trouble일 발생했다고 전달 필드에 맞는 타입값안써도 오류발생
		}
		
	}

	
	
}
