package com.pb.datasourcewitch;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdvice
{
	//ƥ��org.crazyit.app.service.impl����������ġ�
	//���з�����ִ����Ϊ�����
	@Before("execution(* com.pb.service.*.*(..))")
	public void authority()
	{
		System.out.println("ģ��ִ��Ȩ�޼��");
	}
}


