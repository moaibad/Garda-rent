package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.Sewa;

public class SewaDao {
	
	public int tambahSewa(Sewa sewa) throws ClassNotFoundException {
        String sql = "{call tambahSewa (?, ?, ?, ?)}";
        
        int result = 0;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TEST", "123");

            // Step 2:Create a statement using connection object
            CallableStatement callableStatement = connection.prepareCall(sql)){
            callableStatement.setInt(1, sewa.getHarga());
        	callableStatement.setInt(2, sewa.getLama_sewa());
    		callableStatement.setString(3, sewa.getMobil_id());
    		callableStatement.setString(4, sewa.getCustomer_id());

            System.out.println(callableStatement);
            
            // Step 3: Execute the query or update query
            callableStatement.executeUpdate();

        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	
}
