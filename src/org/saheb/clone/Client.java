package org.saheb.clone;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Address add = new Address();
		add.setStreet("wadegaon");
		
		Employee emp = new Employee(add);
		Employee emp2 = (Employee) emp.clone();
		System.out.println("emp->"+emp.hashCode());
		System.out.println("emp2->"+emp2.hashCode());
		
		emp2.getAddress().setStreet("Magarpatta");
		System.out.println("emp2::"+emp2.getAddress().getStreet());
		System.out.println("emp::"+add.getStreet());
		
		Department dept = new Department();
		dept.addEmp(emp);
		System.out.println(dept.getEmpList().size());
		
		dept.getEmpList().add(emp);
		System.out.println(dept.getEmpList().size());
		
		dept.getEmpList().get(0).getAddress().setStreet("abc");
		System.out.println(emp.getAddress().getStreet());
	}

}
