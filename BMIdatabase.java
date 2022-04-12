import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BMIdatabase
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database if not exists BMI");
			stmt.execute("use BMI");
			
			stmt.execute("create table if not exists dataTB"+"(name varchar(50),age int,number int,height float,weight float,id varchar(50),password varchar(50),things varchar(50))");
			con.close();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
