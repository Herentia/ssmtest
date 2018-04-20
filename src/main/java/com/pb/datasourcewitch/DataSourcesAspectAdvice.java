package com.pb.datasourcewitch;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ʹ��aop��dataSources����ʹ���ĸ����ݿ�����
 * @author haohan
 *
 */
@Aspect
@Component
public class DataSourcesAspectAdvice {
	
	@Pointcut("execution(* com.pb.service.*.*(..))")
	public void pointCut() {}
	
	@Before(value = "pointCut()")
	public void dataSource2Test() {
		//�����ݿ������л��ɵڶ������ݿ�
		System.out.println("��ʼ�л���dataSource2���ݿ⡣����");
		DataSources.setDataSource("dataSource2");
		
		
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
