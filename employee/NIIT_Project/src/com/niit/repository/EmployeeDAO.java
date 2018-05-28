package com.niit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.niit.enitity.City;
import com.niit.enitity.Employee;
import com.niit.enitity.Skill;
import com.niit.enitity.State;
import com.niit.utility.MyConnect;

public class EmployeeDAO {

	public int AddState(State state) {
		// TODO Auto-generated method stub
		int flg=1;
		
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("insert into state(state_name) values(?)");
			pst.setString(1,state.getState_name());
			if(pst.executeUpdate()==1)
			{
				flg=0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flg;
	}
	public List<State> getState()
	{
		List<State> list=new ArrayList<>();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from state");
			ResultSet  rs=pst.executeQuery();
			while(rs.next())
			{
				State state=new State();
				state.setState_id(rs.getInt("state_id"));
				state.setState_name(rs.getString("state_name"));
				list.add(state);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public List<City> getCity(int sid)
	{
		List<City> list=new ArrayList<>();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from city where state_id=?");
			pst.setInt(1, sid);
			ResultSet  rs=pst.executeQuery();
			while(rs.next())
			{
				City state=new City();
				state.setCity_id(rs.getInt("city_id"));
				state.setCity_name(rs.getString("city_name"));
				list.add(state);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public int AddCity(City city) {
		// TODO Auto-generated method stub
		int flg=1;
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("insert into city(city_name,state_id) values(?,?)");
			pst.setString(1,city.getCity_name());
			pst.setInt(2,city.getState_id());
			System.out.println(pst.executeUpdate());
			if(pst.executeUpdate()==1)
			{
				flg=0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flg;
	}

	public int AddEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		int flg=1;
		try {
			Connection con=new MyConnect().getConn();
			//PreparedStatement pst=con.prepareStatement("insert into employee(ename,dob,gender,address,state_id,city_id,mob,scper,hsc,hscper,graduate,graduateper,postgraduate,postgradper,email,password,supvid,supvname,ibuname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement pst4=con.prepareStatement("select email from employee where email=?");
			pst4.setString(1,emp.getEmail());
			ResultSet rs=pst4.executeQuery();
			if(!rs.next())
			{
			PreparedStatement pst=con.prepareStatement("insert into employee(ename,dob,gender,address,state_id,city_id,mob,sscper,hsc,hscper,graduate,graduateper,postgraduate,postgradper,email,password,supvid,spuvname,ibuname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1,emp.getEname());
			pst.setString(2,emp.getDob());
			pst.setString(3,emp.getGender());
			pst.setString(4,emp.getAddress());
			pst.setInt(5,emp.getState_id());
			pst.setInt(6,emp.getCity_id());
			pst.setString(7,emp.getEmpMob());
			pst.setFloat(8, emp.getSscper());
			pst.setString(9,emp.getHsc());
			pst.setFloat(10,emp.getHscper());
			pst.setString(11, emp.getGrad());
			pst.setFloat(12,emp.getGrad_per());
			pst.setString(13,emp.getPostgrad());
			pst.setFloat(14,emp.getPostGradper());
			pst.setString(15,emp.getEmail());
			pst.setString(16,emp.getPassword());
			pst.setInt(17,emp.getSupid());
			pst.setString(18,emp.getSuprvname());
			pst.setString(19,emp.getIbuname());
			
			if(pst.executeUpdate()==1)
			{
				PreparedStatement pst3=con.prepareStatement("SELECT eid FROM employee ORDER BY eid DESC");
				ResultSet rs1=pst3.executeQuery();
				if(rs1.next())
				{
					emp.setEid(rs1.getInt(1));
				String[] splited = emp.getSkill().split("\\s+");
			PreparedStatement pst1=con.prepareStatement("select skill_id from skill where skill_name=?");
			ResultSet rs2;
			PreparedStatement pst2;
			for(int i=0;i<splited.length;i++)
			{
				pst1.setString(1,splited[i]);
				rs=pst1.executeQuery();
				if(rs.next())
				{
					pst2=con.prepareStatement("insert into empskill(eid,skill_id) values(?,?)");
					pst2.setInt(1,emp.getEid());
					pst2.setInt(2,rs.getInt(1));
					pst2.executeUpdate();
				}
			}
			}
				flg=0;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flg;
	}

	public int DeleteEmp(Employee emp) {
		// TODO Auto-generated method stub
		int flg=1;
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("delete from  employee where eid=?");
			pst.setInt(1,emp.getEid());
			if(pst.executeUpdate()==1)
			{
				flg=0;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return flg;
	}
	@Test
	public int UpdateEmp(Employee emp) {
		// TODO Auto-generated method stub
		int flg=1;
		try {
			Connection con=new MyConnect().getConn();
			//PreparedStatement pst=con.prepareStatement("insert into employee(ename,dob,gender,address,state_id,city_id,mob,scper,hsc,hscper,graduate,graduateper,postgraduate,postgradper,email,password,supvid,supvname,ibuname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			PreparedStatement pst=con.prepareStatement("update employee set ename=?,dob=?,gender=?,address=?,state_id=?,city_id=?,mob=?,sscper=?,hsc=?,hscper=?,graduate=?,graduateper=?,postgraduate=?,postgradper=?,password=?,supvid=?,spuvname=?,ibuname=? where eid=?");
			pst.setString(1,emp.getEname());
			pst.setString(2,emp.getDob());
			pst.setString(3,emp.getGender());
			pst.setString(4,emp.getAddress());
			pst.setInt(5,emp.getState_id());
			pst.setInt(6,emp.getCity_id());
			pst.setString(7,emp.getEmpMob());
			pst.setFloat(8, emp.getSscper());
			pst.setString(9,emp.getHsc());
			pst.setFloat(10,emp.getHscper());
			pst.setString(11, emp.getGrad());
			pst.setFloat(12,emp.getGrad_per());
			pst.setString(13,emp.getPostgrad());
			pst.setFloat(14,emp.getPostGradper());
			pst.setString(15,emp.getPassword());
			pst.setInt(16,emp.getSupid());
			pst.setString(17,emp.getSuprvname());
			pst.setString(18,emp.getIbuname());
			pst.setInt(19,emp.getEid());
			if(pst.executeUpdate()==1)
			{
				PreparedStatement pst3=con.prepareStatement("SELECT eid FROM employee ORDER BY eid DESC");
				ResultSet rs1=pst3.executeQuery();
				if(rs1.next())
				{
					emp.setEid(rs1.getInt(1));
				String[] splited = emp.getSkill().split("\\s+");
			
			ResultSet rs;
			PreparedStatement pst2;
			for(int i=0;i<splited.length;i++)
			{
				PreparedStatement pst1=con.prepareStatement("select skill_id from skill where skill_name=?");
				pst1.setString(1,splited[i]);
				rs=pst1.executeQuery();
				if(rs.next())
				{
					pst2=con.prepareStatement("update empskill set skill_id=? where eid=?");
					pst2.setInt(1,rs.getInt(1));
					pst2.setInt(2,emp.getEid());
					pst2.executeUpdate();
				}
			}
				}
				flg=0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return flg;
	}
	public ArrayList<Skill> getSskill()
	{
		ArrayList<Skill> skill=new ArrayList<>();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from skill");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Skill empskill=new Skill();
				empskill.setSkill_id(rs.getInt("skill_id"));
				empskill.setSkill_name(rs.getString("skill_name"));
				skill.add(empskill);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return skill;
	}
	public ArrayList<Employee> DispEmp() {
		// TODO Auto-generated method stub
		ArrayList<Employee> list=new ArrayList<>();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from employee");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setDob(rs.getString("dob"));
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setState_id(rs.getInt("state_id"));
				emp.setCity_id(rs.getInt("city_id"));
				emp.setEmpMob(rs.getString("mob"));
				emp.setSscper(rs.getFloat("sscper"));
				emp.setHsc(rs.getString("hsc"));
				emp.setHscper(rs.getFloat("hscper"));
				emp.setGrad(rs.getString("graduate"));
				emp.setPostGradper(rs.getFloat("graduateper"));
				emp.setPostgrad(rs.getString("postgraduate"));
				emp.setPostGradper(rs.getFloat("postgradper"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setSupid(rs.getInt("supvid"));
				emp.setSuprvname("spuvname");
				emp.setIbuname("ibuname");
				list.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}

	public List<Employee> find_emp(int id) {
		// TODO Auto-generated method stub
		ArrayList<Employee> emp1 = new ArrayList<>();
		Employee emp=new Employee();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from employee where eid=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{			
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setDob(rs.getString("dob"));
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setState_id(rs.getInt("state_id"));
				emp.setCity_id(rs.getInt("city_id"));
				emp.setEmpMob(rs.getString("mob"));
				emp.setSscper(rs.getFloat("sscper"));
				emp.setHsc(rs.getString("hsc"));
				emp.setHscper(rs.getFloat("hscper"));
				emp.setGrad(rs.getString("graduate"));
				emp.setPostGradper(rs.getFloat("graduateper"));
				emp.setPostgrad(rs.getString("postgraduate"));
				emp.setPostGradper(rs.getFloat("postgradper"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setSupid(rs.getInt("supvid"));
				emp.setSuprvname("spuvname");
				emp.setIbuname("ibuname");
				emp1.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return emp1;
	}
	
	public List<Employee> profile_emp(String email) {
		// TODO Auto-generated method stub
		ArrayList<Employee> emp1 = new ArrayList<>();
		Employee emp=new Employee();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from employee where email=?");
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{			
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setDob(rs.getString("dob"));
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setState_id(rs.getInt("state_id"));
				emp.setCity_id(rs.getInt("city_id"));
				emp.setEmpMob(rs.getString("mob"));
				emp.setSscper(rs.getFloat("sscper"));
				emp.setHsc(rs.getString("hsc"));
				emp.setHscper(rs.getFloat("hscper"));
				emp.setGrad(rs.getString("graduate"));
				emp.setPostGradper(rs.getFloat("graduateper"));
				emp.setPostgrad(rs.getString("postgraduate"));
				emp.setPostGradper(rs.getFloat("postgradper"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setSupid(rs.getInt("supvid"));
				emp.setSuprvname("spuvname");
				emp.setIbuname("ibuname");
				emp1.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return emp1;
	}
	public List<Employee> checkLogin(String email,String pasword)
	{
		List<Employee> emp1 = new ArrayList<>();
		Employee emp=new Employee();
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("select * from employee where email=?");
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{			
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setDob(rs.getString("dob"));
				emp.setGender(rs.getString("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setState_id(rs.getInt("state_id"));
				emp.setCity_id(rs.getInt("city_id"));
				emp.setEmpMob(rs.getString("mob"));
				emp.setSscper(rs.getFloat("sscper"));
				emp.setHsc(rs.getString("hsc"));
				emp.setHscper(rs.getFloat("hscper"));
				emp.setGrad(rs.getString("graduate"));
				emp.setPostGradper(rs.getFloat("graduateper"));
				emp.setPostgrad(rs.getString("postgraduate"));
				emp.setPostGradper(rs.getFloat("postgradper"));
				emp.setEmail(rs.getString("email"));
				emp.setPassword(rs.getString("password"));
				emp.setSupid(rs.getInt("supvid"));
				emp.setSuprvname("spuvname");
				emp.setIbuname("ibuname");
				emp1.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return emp1;
	}
		
}
