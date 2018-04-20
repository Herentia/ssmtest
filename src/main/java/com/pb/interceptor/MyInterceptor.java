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

//��ɲ��ǩ��������mybatis��ǰ�������ĸ�������ĸ�����
@Intercepts({
	@Signature(type=StatementHandler.class, method="parameterize", args=java.sql.Statement.class)
})
public class MyInterceptor implements Interceptor {

	/**
	 * ����Ŀ�귽����ִ��
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		//ִ��Ŀ�귽��
		System.out.println("���ط����� " + invocation.getMethod());
//		Object target = invocation.getTarget();
//		MetaObject metaObject = SystemMetaObject.forObject(target);
//		Object value = metaObject.getValue("parameterHandler.parameterObject");
//		metaObject.setValue("parameterHandler.parameterObject", 11);//ÿ�β�ѯʱ���Ὣ��ѯ������Ϊ11
		Object proceed = invocation.proceed();
		//����ִ�к�ķ���ֵ
		return proceed;
	}

	/**
	 * ��װĿ�����ΪĿ�괴��һ���������
	 */
	public Object plugin(Object target) {
		//���ذ�װĿ�����
		System.out.println("mybatis��Ҫ��װ�Ķ���" + target);
		Object wrap = Plugin.wrap(target, this);
		//���ص�ǰtarget�Ķ�̬����
		return wrap;
	}

	public void setProperties(Properties properties) {
		//��ȡ���õĲ���
		System.out.println("���������Ϣ" + properties);
	}

}
