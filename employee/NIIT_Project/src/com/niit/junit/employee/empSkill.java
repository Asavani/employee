package com.niit.junit.employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.niit.enitity.Skill;
import com.niit.validation.employeesValid;

public class empSkill {

	employeesValid valid;
	@Before
	public void setUp() throws Exception {
		valid=new employeesValid();
	}

	@Test
	public void addSkill() {
		int flg=1;
		Skill skill=new Skill();
		skill.setSkill_name("ORACLE");
		flg=valid.name_IsEmpty(skill.getSkill_name());
		if(flg==0)
		{
			assertEquals("Record Inserted",0,new Skill_Crud().addSkill(skill));
		}
		else
		{
			assertEquals("Record Not Inserted",0,flg);
		}
	}

}
