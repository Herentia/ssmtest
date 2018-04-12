package com.pb.bean;

import java.math.BigDecimal;

public class Employee {
    private BigDecimal empId;

    private String empName;

    private String gender;

    private String email;

    private BigDecimal dId;
    
    //希望查询员工的时候将部门信息查出
    private Department department;

    public BigDecimal getEmpId() {
        return empId;
    }

    public void setEmpId(BigDecimal empId) {
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

    public BigDecimal getdId() {
        return dId;
    }

    public void setdId(BigDecimal dId) {
        this.dId = dId;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", gender=" + gender + ", email=" + email + ", dId=" + dId
				+ ", department=" + department + "]";
	}
    
}