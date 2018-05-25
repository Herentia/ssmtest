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
 * 使用aop给dataSources设置使用哪个数据库连接
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
		//将数据库连接切换成第二个数据库
		System.out.println("开始切换到dataSource2数据库。。。");
		DataSources.setDataSource(Name);
//		DataSources.clearDataSource();
		
		
//		//获得目标方法标签
//        MethodSignature methodSignature = (MethodSignature) point.getSignature();
//        //获得目标方法标签里的值
//        String sigName = methodSignature.getMethod().getAnnotation(DeclareAnnotation.class).value();
//        //切换dataSource
//        DataSourceContextHolder.setDbType(sigName);
//        //用改变后的参数执行目标方法
//        Object obj = point.proceed();
//        //清空dataSource 方便下次拦截的时候传入
//        DataSourceContextHolder.clearDbType();
//        return obj;
	}

}
