package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MobilDao {
	
	public ResultSet tampilMobil() throws ClassNotFoundException {
        String sql = "select * from mobil";
        
        ResultSet result = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TUBES", "tubes");
        		
            // Step 2:Create a statement using connection object
            CallableStatement callableStatement = connection.prepareCall(sql)){
            
            System.out.println(callableStatement);
            
            // Step 3: Execute the query or update query
            result = callableStatement.executeQuery(sql);

        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	
}
