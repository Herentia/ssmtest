package com.pb.datasourcewitch;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdvice
{
	//匹配org.crazyit.app.service.impl包下所有类的、
	//所有方法的执行作为切入点
	@Before("execution(* com.pb.service.*.*(..))")
	public void authority()
	{
		System.out.println("模拟执行权限检查");
	}
}


