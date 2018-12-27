package design;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) throws java.lang.Exception, NullPointerException{

		String mission = "We want to maintain 15% yearly growth of the company.";
		String vision = "We want to contribute for the betterment of economy of the country.";

		EmployeeInfo employee1 = new EmployeeInfo("Cristiano Ronaldo", 222100);
		EmployeeInfo employee2 = new EmployeeInfo("Lionel Messi", 222101);
		EmployeeInfo employee3 = new EmployeeInfo("Zinedine Zidane", 222102);
		EmployeeInfo employee4 = new EmployeeInfo("Adson Pele", 222103);
		EmployeeInfo employee5 = new EmployeeInfo("Diego Maradona", 222104);

		employee1.assignDepartment("Research & Development");
		employee2.assignDepartment("Information Technology");
		employee3.assignDepartment("Account & Finance");
		employee4.assignDepartment("Manufacturing & Import");
		employee5.assignDepartment("Sales & Marketing");

		employee1.setSalary(10000);
		employee1.calculateSalary(employee1.getSalary());
		employee2.setSalary(12000);
		employee2.calculateSalary(employee2.getSalary());
		employee3.setSalary(10000);
		employee3.calculateSalary(employee3.getSalary());
		employee4.setSalary(1100);
		employee4.calculateSalary(employee4.getSalary());
		employee5.setSalary(11000);
		employee5.calculateSalary(employee5.getSalary());

		employee1.describeCompany();
		employee1.describeCompany(mission, vision);

		employee1.setPerformance(5);
		double bonus222100 = employee1.calculateEmployeeBonus(employee1.getSalary(), employee1.getPerformance());
		employee2.setPerformance(4);
		double bonus222101 = employee2.calculateEmployeeBonus(employee2.getSalary(), employee2.getPerformance());
		employee3.setPerformance(3);
		double bonus222102 = employee3.calculateEmployeeBonus(employee3.getSalary(), employee3.getPerformance());
		employee4.setPerformance(2);
		double bonus222103 = employee4.calculateEmployeeBonus(employee4.getSalary(), employee4.getPerformance());
		employee5.setPerformance(1);
		double bonus222104 = employee4.calculateEmployeeBonus(employee5.getSalary(), employee5.getPerformance());

		EmployeeInfo.calculateEmployeePension(employee1.getSalary());
		EmployeeInfo.calculateEmployeeBonus(employee1.getSalary(),employee1.getPerformance());

		Map<Integer, List<Object>> employeeInfo = new HashMap<Integer, List<Object>>();
		List<Object> employeeRecord222100 = new ArrayList<Object>();
		employeeRecord222100.add(employee1.employeeName());
		employeeRecord222100.add(employee1.employeeId());
		employeeRecord222100.add(bonus222100);

		List<Object> employeeRecord222101 = new ArrayList<Object>();
		employeeRecord222101.add(employee2.employeeName());
		employeeRecord222101.add(employee2.employeeId());
		employeeRecord222101.add(bonus222101);

		employeeInfo.put(222100, employeeRecord222100);
		employeeInfo.put(222101, employeeRecord222101);

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		connectToSqlDB.createTableFromStringToMySql("employee_record", "employee_id", "employee_info");


			for (Integer obj : employeeInfo.keySet()) {
				for (Object obj1 : employeeInfo.get(obj)) {
					//System.out.println(obj1);
					List<String> list1 = new ArrayList<>();
					list1.add(obj.toString());
					list1.add(obj.toString());
					connectToSqlDB.InsertDataFromArrayListToMySql(list1, "employee_record", "employee_id", "employee_info");
				}

			}


		System.out.println("Reading from database");
		List<String> empRec = connectToSqlDB.readDataBase("employee_record", "employee_id", "employee_info");
		for (String emp : empRec) {
			System.out.println(emp);
		}

	}

}
