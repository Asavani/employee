package com.niit.validation;

import java.util.regex.Pattern;

public class employeesValid {

	public int name_IsEmpty(String param1)
	{
		int flg=1;
		System.out.println(param1);
		
		if(!param1.isEmpty() || param1!=null )
		{
			flg=0;
		}
		return flg;
	}
	public int dobCheck(String date)
	{
		int flg=1;
		String dateRegex="^\\d{4}-\\d{2}-\\d{2}$";
		 Pattern pat = Pattern.compile(dateRegex);
		 boolean stat=pat.matcher(date).matches();
		 System.out.println(stat);
		 if(stat==true)
		 {
			 return flg=0;
		 }
			
		return flg;
	}
	public int mobileCheck(String mob)
	{
		int flg=1;
		String mobRegex="^\\d{10}$";
		Pattern pat = Pattern.compile(mobRegex);
		 boolean stat=pat.matcher(mob).matches();
		 if(stat==true)
		 {
			 flg=0;
		 }
		return flg;
	}
	public int emailCheck(String email)
	{
		int flg=1;
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
		 Pattern pat = Pattern.compile(emailRegex);
		 boolean stat=pat.matches(emailRegex, email);
		 if(stat==true)
		 {
			 return flg=0;
		 }
		return flg;
	}
	public int name_IsNull(String param1)
	{
		System.out.println(param1);
		int flg=1;
		if(param1.length()>0)
		{
			flg=0;
		}
		return flg;
	}
	
	public int num_IsEmpty(int no)
	{
		int flg=1;
		if(no!=0)
		{
			flg=0;
		}
		return flg;
	}
	public int Float_IsEmpty(float f)
	{
		int flg=1;
		if(f!=0.0f)
		{
			
			flg=0;
		}
		return flg;
	}
	
}
