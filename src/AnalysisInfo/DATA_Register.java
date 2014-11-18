package AnalysisInfo;

class DATA_Register extends Format{
	String sql_regester;
	DATA_Register()
	{
		super();
		sql_regester="INSERT INTO TEST VALUES(";
	}
	void Username(String username)
	{
		sql_regester=sql_regester+"'"+username+"',";
	}
	void Password(String password)
	{
		sql_regester=sql_regester+"'"+password+"',";
	}
	void Phone(String phone)
	{
		sql_regester=sql_regester+"'"+phone+"',";
	}
	void Email(String email)
	{
		sql_regester=sql_regester+"'"+email+"',";
	}
	void Sex(String sex)
	{
		sql_regester=sql_regester+"'"+sex+"',";
	}
	void Question(String question)
	{
		sql_regester=sql_regester+"'"+question+"',";
	}
	void Answer(String answer)
	{
		sql_regester=sql_regester+"'"+answer+"',";
	}
	void Interest1(String insterest1)
	{
		sql_regester=sql_regester+"'"+insterest1+"',";
	}
	void Interest2(String insterest2)
	{
		sql_regester=sql_regester+"'"+insterest2+"',";
	}
	void Interest3(String insterest3)
	{
		sql_regester=sql_regester+"'"+insterest3+"');";
	}
	String return_info()
	{
		try{
			int i=sql.executeUpdate(sql_regester);
			if(i!=0)
			{
				System.out.println("Enter the data to the database!");
				return "Ok,the format is insert to the database";
			}
		}catch(Exception e)
		{
			 return "Can't write to the DATAbase!!";
		}
		 return "Can't write to the DATAbase!!";
	}
}
