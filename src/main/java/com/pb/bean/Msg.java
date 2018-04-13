package com.pb.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * ͨ�÷�����
 * @author haohan
 *
 */
public class Msg {
	//״̬��
	private int code;
	//��ʾ��Ϣ
	private String msg;
	//�û�Ҫ���ظ������������
	private Map<String, Object> extend = new HashMap<String, Object>();
	//����ɹ�
	public static Msg success() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("�����ɹ���");
		return result;
	}
	//����ʧ��
	public static Msg error() {
		Msg resuslt = new Msg();
		resuslt.setCode(100);
		resuslt.setMsg("����ʧ��!");
		return resuslt;
	}
	
	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}