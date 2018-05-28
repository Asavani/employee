package com.niit.junit.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.niit.enitity.Skill;
import com.niit.utility.MyConnect;

public class Skill_Crud {

	public int addSkill(Skill skill) {
		// TODO Auto-generated method stub
		int flg=1;
		try {
			Connection con=new MyConnect().getConn();
			PreparedStatement pst=con.prepareStatement("insert into skill(skill_name) values(?)");
			pst.setString(1,skill.getSkill_name());
			pst.executeUpdate();
			flg=0;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flg;
	}

}
