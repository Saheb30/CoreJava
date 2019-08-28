package org.saheb.clone;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Address add = new Address();
		add.setAddress("wadegaon");
		
		Employee emp = new Employee(add);
		Employee emp2 = (Employee) emp.clone(emp);
		System.out.println("emp->"+emp.hashCode());
		System.out.println("emp2->"+emp2.hashCode());
		//System.out.println(emp2.getAddress().getAddress());
		//emp2.getAddress().setAddress("Magarpatta");
		
		//System.out.println(add.getAddress());
		
		Department dept = new Department();
		dept.addEmp(emp);
		System.out.println(dept.getEmpList().size());
		
		dept.getEmpList().add(emp);
		System.out.println(dept.getEmpList().size());
		
		dept.getEmpList().get(0).getAddress().setAddress("abc");
		System.out.println(emp.getAddress().getAddress());
		
		
	}

}
