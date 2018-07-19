package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.TestPortal.Country;

public class MysqlDao {
	static MysqlDao mysqlDao=new MysqlDao();
	
	private MysqlDao(){}
	
	static public MysqlDao getMysqlDao(){
		return mysqlDao;
	}
	
	public List<Country> getCountryData() {
		List<Country> cList=null;
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root");  
			stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from country");
			
			
			cList = new ArrayList<Country>();
			while(rs.next())
			{
				Country c=new Country();
				c.setCode(rs.getString("Code"));
				c.setName(rs.getString("Name"));
				c.setContinent(rs.getString("Continent"));
				c.setRegion(rs.getString("Region"));
				c.setGovernmentForm(rs.getString("GovernmentForm"));
				cList.add(c);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cList;
	}
}
