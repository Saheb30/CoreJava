package org.saheb.clone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
	List<Employee> empList = new ArrayList<>();

	public List<Employee> getEmpList() {
		return empList;
	}

	public void addEmp(Employee emp) {
		empList.add(emp);
	}
	
	public void setEmpList(List<Employee> empList) {
		//this.empList = new ArrayList<>(empList);
		this.empList = Collections.unmodifiableList(empList);
	}
	
}
