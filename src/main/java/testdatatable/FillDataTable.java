package testdatatable;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.javafaker.Faker;
public class FillDataTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		Faker faker = new Faker();
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		  Statement stmt = null;
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/test", "postgres",
					"4a626021-e55a");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			try {
				stmt = connection.createStatement();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			for(int i=0;i<1000000;i++) {
			System.out.println("You made it, take control your database now!");
			String sql="insert into  test(name ,email ,phone,address ,gender) "
					+ "VALUES ('"
					+ faker.name().fullName()
					+ "', '"
					+ faker.commerce().department()
					+ "', "
					+ faker.number().numberBetween(1000000000, 1000000000)
					+ ", '"
					+ faker.address().fullAddress()
					+ "', '"
					+ faker.lorem().characters()
					+ " ')";
			System.out.println("sql ---> "+sql);
			try {
		         stmt.executeUpdate(sql);
		        
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			 try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}
