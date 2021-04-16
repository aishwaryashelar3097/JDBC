package Payroll_Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbc1 {
	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3386/payroll_service;"
		String userName = "root";
		String password = "British@1234";
		Connection connection;
		System.out.println("Connecting to database:"+jdbcURL);
		connection =DriverManager.getConnnection(jdbcURL,userName,password);
		System.out.println("Connection is successful!!!"+connection);
		return connection;
	}
	public List<EmployeePayrollData> readData() {
		String sql= "SELECT * FROM employee Payroll;":
		List<EmployeePayrollData>employeePayrollList =new ArrayList<> ();
	    try {
	    	Connection connection = this.getConnection();
	    	Statement statement = connection.createStatement();
	    	ResultSet result = statement.executeQuery(sql);
	    	while(result.next()) {
	    		int id = result.getInt("id");
	    		String name= result.getString("name");
	    		double salary =result.getDouble("salary");
	    		LocalDate startDate = result.getDate("start").toLocalDate();
	    		employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate)):
	    	}
	    	catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return employePayrollList;
	    }
	}
	}
