package com.pb.bean;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer empId;
    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u4e00-\\u9fa5]{2,5}$)", 
    			message="�û���Ϊ2-5Ϊ���Ļ���6-16λӢ��")
    private String empName;
    
    private String gender;
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", 
    			message="�����ʽ����ȷ")
    private String email;

    private int dId;
    
    private Department department;
    
    public Employee() {
		super();
	}
    
	public Employee(String empName, String gender, String email, int dId) {
		super();
		this.empName = empName;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}

	public Employee(Integer empId, String empName, String gender, String email,
			int dId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}