package com.pb.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

//完成插件签名，告诉mybatis当前插件完成哪个对象的哪个方法
@Intercepts({
	@Signature(type=StatementHandler.class, method="parameterize", args=java.sql.Statement.class)
})
public class MyInterceptor implements Interceptor {

	/**
	 * 拦截目标方法的执行
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		//执行目标方法
		System.out.println("拦截方法： " + invocation.getMethod());
//		Object target = invocation.getTarget();
//		MetaObject metaObject = SystemMetaObject.forObject(target);
//		Object value = metaObject.getValue("parameterHandler.parameterObject");
//		metaObject.setValue("parameterHandler.parameterObject", 11);//每次查询时都会将查询条件改为11
		Object proceed = invocation.proceed();
		//返回执行后的返回值
		return proceed;
	}

	/**
	 * 包装目标对象，为目标创建一个代理对象
	 */
	public Object plugin(Object target) {
		//拦截包装目标对象
		System.out.println("mybatis将要包装的对象" + target);
		Object wrap = Plugin.wrap(target, this);
		//返回当前target的动态代理
		return wrap;
	}

	public void setProperties(Properties properties) {
		//获取配置的参数
		System.out.println("插件配置信息" + properties);
	}

}
