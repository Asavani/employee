package com.niit.junit.employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.niit.enitity.City;
import com.niit.enitity.Employee;
import com.niit.enitity.Skill;
import com.niit.enitity.State;
import com.niit.repository.EmployeeDAO;
import com.niit.validation.employeesValid;


public class Employee_Test {

	EmployeeDAO employee_crud;
	employeesValid emp_valid;
	@Before
	public void setUp() throws Exception {
		employee_crud=new EmployeeDAO();
		emp_valid=new employeesValid();
	}
    //Logic Of State
	
//	@Test
//	public void Add_State() {
//		int flg=1;
//		State state=new State();
//		state.setState_name("GUJARAT");
//		flg=emp_valid.name_IsEmpty(state.getState_name());
//		if(flg==0)
//		{
//			assertEquals("Record Inserted",0,new Employee_Crud().AddState(state));
//		}
//		else
//		{
//			assertEquals("Record Not Inserted",0,flg);
//		}
//		assertEquals("Record Inserted",0,new Employee_Crud().AddState(state));
//	}
	//Logic Of City
//	@Test
//	public void Add_City()
//	{
//		int flg=1;
//		City city=new City();
//		city.setCity_name("Amritsar");
//		flg=emp_valid.name_IsEmpty(city.getCity_name());
//		city.setState_id(2);
//		flg=emp_valid.num_IsEmpty(city.getState_id());
//		if(flg==0)
//		{
//			assertEquals("Record Inserted",0,new Employee_Crud().AddCity(city));
//		}
//		else
//		{
//			assertEquals("Record Not Inserted",0,flg);
//		}
//		assertEquals("Record Inserted",0,new Employee_Crud().AddCity(city));
//	}
	//Logic Of Employee
	
//	@Test
//	public void Add_Emp() 
//	{   
//		
//		int flg=1;
//		Employee emp=new Employee();
//		emp.setEname("Mayank");
//		flg=emp_valid.name_IsEmpty(emp.getEname());
//		if(flg==0)
//		{
//			emp.setGender("Male");
//			flg=emp_valid.name_IsEmpty(emp.getGender());
//			if(flg==0)
//			{
//				emp.setAddress("Vastrapur");
//				flg=emp_valid.name_IsEmpty(emp.getAddress());
//			}
//			if(flg==0)
//			{
//				emp.setState_id(1);
//				flg=emp_valid.num_IsEmpty(emp.getState_id());
//			}
//			if(flg==0)
//			{
//				emp.setCity_id(1);
//				flg=emp_valid.num_IsEmpty(emp.getCity_id());
//			}
//			if(flg==0)
//			{
//				emp.setEmail("asavani.anil@gmail.com");
//				flg=emp_valid.name_IsEmpty(emp.getEmail());
//				flg=emp_valid.emailCheck(emp.getEmail());
//			}
//			if(flg==0)
//			{
//				emp.setEmpMob("7600292343");
//				flg=emp_valid.mobileCheck(emp.getEmpMob());
//			}
//			if(flg==0)
//			{
//				emp.setSkill("JAVA ORACLE");
//				flg=emp_valid.name_IsNull(emp.getSkill());
//			}
//			if(flg==0)
//			{
//				emp.setSscper(74.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getSscper());
//			}
//			if(flg==0)
//			{
//				emp.setHsc("Science");
//				flg=emp_valid.name_IsEmpty(emp.getHsc());
//			}
//			if(flg==0)
//			{
//				emp.setHscper(54.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getSscper());
//			}
//			if(flg==0)
//			{
//				emp.setGrad("BBA");
//				flg=emp_valid.name_IsEmpty(emp.getGrad());
//			}
//			if(flg==0)
//			{
//				emp.setGrad_per(77.67f);
//				flg=emp_valid.Float_IsEmpty(emp.getGrad_per());
//			}
//			if(flg==0)
//			{
//				emp.setPostgrad("MBA");
//				flg=emp_valid.name_IsEmpty(emp.getPostgrad());
//			}
//			if(flg==0)
//			{
//				emp.setPostGradper(77.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getPostGradper());
//			}
//			
//
//			if(flg==0)
//			{
//				emp.setPassword("20081992");
//				flg=emp_valid.name_IsEmpty(emp.getPassword());
//			}
//			if(flg==0)
//			{
//				emp.setSupid(12);
//				flg=emp_valid.num_IsEmpty(emp.getSupid());
//			}
//			if(flg==0)
//			{
//				emp.setSuprvname("Gunjan Jah");
//				flg=emp_valid.name_IsEmpty(emp.getSuprvname());
//			}
//			if(flg==0)
//			{
//				emp.setDob("1992-10-12");
//				flg=emp_valid.name_IsEmpty(emp.getDob());
//				 flg=emp_valid.dobCheck(emp.getDob());
//			
//			}
//			if(flg==0)
//			{
//				emp.setGrad_per(55.66f);
//				 flg=emp_valid.Float_IsEmpty(emp.getGrad_per());
//			}
//			
//			if(flg==0)
//			{
//				emp.setIbuname("ILS");
//				 flg=emp_valid.name_IsEmpty(emp.getIbuname());
//			}
//		}
//		 
//		if(flg==0)
//		{
//			assertEquals("Record Inserted",0,new EmployeeDAO().AddEmp(emp));
//			//assertEquals("Record Inserted",0,flg);
//		}
//		
//		else
//		{
//			assertEquals("Record Not Inserted",0,flg);
//		}
//		
//		
//	}
//	
	//Logic Of Delete Employee
	
//	@Test
//	public void Delete_Emp()
//	{
//		int flg=1;
//		Employee emp=new Employee();
//		emp.setEid(2);
//		flg=emp_valid.num_IsEmpty(emp.getEid());
//		if(flg==0)
//		{
//			assertEquals("Record Deleted",0,employee_crud.DeleteEmp(emp));
//		}
//		else
//		{
//			assertEquals("Record Not Deleted",0,flg);
//		}
//	
//		
//	}
	
	//Logic Of Update
	
//	@Test
//	public void Update_Emp()
//	{
//		int flg=1;
//		Employee emp=new Employee();
//		emp.setEid(1);
//		flg=emp_valid.num_IsEmpty(emp.getEid());
//		if(flg==0)
//		{
//			emp.setEname("Kamlesh");
//			flg=emp_valid.name_IsEmpty(emp.getEname());
//			if(flg==0)
//			{
//			emp.setGender("Male");
//			flg=emp_valid.name_IsEmpty(emp.getGender());
//			}
//			if(flg==0)
//			{
//				emp.setAddress("Memnagar");
//				flg=emp_valid.name_IsEmpty(emp.getAddress());
//			}
//			if(flg==0)
//			{
//				emp.setState_id(1);
//				flg=emp_valid.num_IsEmpty(emp.getState_id());
//			}
//			if(flg==0)
//			{
//				emp.setCity_id(2);
//				flg=emp_valid.num_IsEmpty(emp.getCity_id());
//			}
//			if(flg==0)
//			{
//				emp.setEmail("kamlesh_yahoo@gmail.com");
//				flg=emp_valid.name_IsEmpty(emp.getEmail());
//				flg=emp_valid.emailCheck(emp.getEmail());
//			}
//			if(flg==0)
//			{
//				emp.setEmpMob("7600292343");
//				flg=emp_valid.mobileCheck(emp.getEmpMob());
//			}
//			if(flg==0)
//			{
//				emp.setSkill("JAVA ORACLE");
//				flg=emp_valid.name_IsNull(emp.getSkill());
//			}
//			if(flg==0)
//			{
//				emp.setSscper(74.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getSscper());
//			}
//			if(flg==0)
//			{
//				emp.setHsc("Commerce");
//				flg=emp_valid.name_IsEmpty(emp.getHsc());
//			}
//			if(flg==0)
//			{
//				emp.setHscper(54.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getSscper());
//			}
//			if(flg==0)
//			{
//				emp.setGrad("BBA");
//				flg=emp_valid.name_IsEmpty(emp.getGrad());
//			}
//			if(flg==0)
//			{
//				emp.setGrad_per(77.67f);
//				flg=emp_valid.Float_IsEmpty(emp.getGrad_per());
//			}
//			if(flg==0)
//			{
//				emp.setPostgrad("MBA");
//				flg=emp_valid.name_IsEmpty(emp.getPostgrad());
//			}
//			if(flg==0)
//			{
//				emp.setPostGradper(77.55f);
//				flg=emp_valid.Float_IsEmpty(emp.getPostGradper());
//			}
//			
//
//			if(flg==0)
//			{
//				emp.setPassword("20081992");
//				flg=emp_valid.name_IsEmpty(emp.getPassword());
//			}
//			if(flg==0)
//			{
//				emp.setSupid(12);
//				flg=emp_valid.num_IsEmpty(emp.getSupid());
//			}
//			if(flg==0)
//			{
//				emp.setSuprvname("Gunjan Jah");
//				flg=emp_valid.name_IsEmpty(emp.getSuprvname());
//			}
//			if(flg==0)
//			{
//				emp.setDob("1992-10-12");
//				flg=emp_valid.name_IsEmpty(emp.getDob());
//				 flg=emp_valid.dobCheck(emp.getDob());
//			
//			}
//			if(flg==0)
//			{
//				emp.setGrad_per(55.66f);
//				 flg=emp_valid.Float_IsEmpty(emp.getGrad_per());
//			}
//			
//			if(flg==0)
//			{
//				emp.setIbuname("ILS");
//				 flg=emp_valid.name_IsEmpty(emp.getIbuname());
//			}
//		}
//		 
//		if(flg==0)
//		{
//			assertEquals("Record Updated",0,new EmployeeDAO().UpdateEmp(emp));
//			
//		}
//		
//		else
//		{
//			assertEquals("Record Not Updated",0,flg);
//		}
//		
//
//	}
	
//	@Test
//	public void Disp_Emp()
//	{
//		ArrayList<Employee> list=employee_crud.DispEmp();
//		assertFalse("Record Not Fetch",list.isEmpty());
//		
//	}
//	
//	@Test
//	public void Find_Emp()
//	{
//		int id=2;
//		int flg=1;
//		flg=emp_valid.num_IsEmpty(id);
//		if(flg==0)
//		{
//		List<Employee> emp=employee_crud.find_emp(id);
//		assertFalse("Record Not Fetch",emp.isEmpty());
//		}
//		else
//		{
//			assertEquals("Record Not Fetch",0,flg);
//		}
//	}
	
}
