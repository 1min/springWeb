package com.javalec.springex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{//Validator�������̽��� ��ӹ���

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);//������ Ŭ���� Ÿ�� ������ ����������
	}

	@Override
	public void validate(Object obj, Errors errors) {//obj�� � ��ü�� ���������� errors�� ������ �߻��ϸ� ������ ������
		// TODO Auto-generated method stub
		
		System.out.println("validate()");
		Student student = (Student)obj;
		String studentName=student.getName();//Ŀ�ǵ尴ü�� �̸��ʵ尡������
		if(studentName==null || studentName.trim().isEmpty()) {//�̸��� �������ְų� ���������(�յڷ� �����ڸ��� ����ִ��� ����) �ʵ忡 �´� Ÿ�԰��Ƚᵵ �����߻�
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");//���� ��������� errors���ٰ� name�ʵ忡 trouble�� �߻��ߴٰ� ����
		}
		
		int studentid = student.getId();//Ŀ�ǵ尴ü�� id�ʵ� ��������
		if(studentid==0) {
			System.out.println("studentid is 0");
			errors.rejectValue("id", "trouble");//���� ��������� errors���ٰ� id�ʵ忡 trouble�� �߻��ߴٰ� ���� �ʵ忡 �´� Ÿ�԰��Ƚᵵ �����߻�
		}
		
	}

	
	
}
