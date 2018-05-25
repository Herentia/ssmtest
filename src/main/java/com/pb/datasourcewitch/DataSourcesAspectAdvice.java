package com.pb.datasourcewitch;

import javax.sql.DataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * ʹ��aop��dataSources����ʹ���ĸ����ݿ�����
 * @author haohan
 *
 */
//@Aspect
@Component
public class DataSourcesAspectAdvice {
	
	@Pointcut("execution(* com.pb.service.*.*(..))")
	public void pointCut() {}
	
	@Before(value = "pointCut()")
	public void dataSource2Test(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String Name = methodSignature.getMethod().getAnnotation(DeclareAnnotation.class).value();
		System.out.println(Name);
		//�����ݿ������л��ɵڶ������ݿ�
		System.out.println("��ʼ�л���dataSource2���ݿ⡣����");
		DataSources.setDataSource(Name);
//		DataSources.clearDataSource();
		
		
//		//���Ŀ�귽����ǩ
//        MethodSignature methodSignature = (MethodSignature) point.getSignature();
//        //���Ŀ�귽����ǩ���ֵ
//        String sigName = methodSignature.getMethod().getAnnotation(DeclareAnnotation.class).value();
//        //�л�dataSource
//        DataSourceContextHolder.setDbType(sigName);
//        //�øı��Ĳ���ִ��Ŀ�귽��
//        Object obj = point.proceed();
//        //���dataSource �����´����ص�ʱ����
//        DataSourceContextHolder.clearDbType();
//        return obj;
	}

}
