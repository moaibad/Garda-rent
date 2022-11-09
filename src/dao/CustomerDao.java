package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Customer;

import java.sql.CallableStatement;
import java.sql.Connection;

public class CustomerDao {
    
	public int registerCustomer(Customer customer) throws ClassNotFoundException {
        String sql = "{call registrasiCustomer (?, ?, ?, ?, ?, ?, ?)}";
        
        int result = 0;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TUBES", "tubes");

            // Step 2:Create a statement using connection object
            CallableStatement callableStatement = connection.prepareCall(sql)){
            callableStatement.setString(1, customer.getEmail());
        	callableStatement.setString(2, customer.getPassword());
    		callableStatement.setString(3, customer.getNama());
    		callableStatement.setString(4, customer.getKtp());
    		callableStatement.setString(5, customer.getSim());
    		callableStatement.setString(6, customer.getTelp());
    		callableStatement.setString(7, customer.getRole());


            System.out.println(callableStatement);
            
            // Step 3: Execute the query or update query
            callableStatement.executeUpdate();

        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	
	public Customer loginCustomer(Customer customer) throws ClassNotFoundException {
        String sql = "select * from customer where email=? and password=?";
        
        ResultSet result = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TUBES", "tubes");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareCall(sql)){
            preparedStatement.setString(1, customer.getEmail());
        	preparedStatement.setString(2, customer.getPassword());
            
            // Step 3: Execute the query or update query
            result = preparedStatement.executeQuery();
            
            if(result.next()) {
            	customer.setId(result.getString("id"));
            	customer.setEmail(result.getString("email"));
            	customer.setPassword(result.getString("password"));
            	customer.setNama(result.getString("nama"));
            	customer.setKtp(result.getString("ktp"));
            	customer.setSim(result.getString("sim"));
            	customer.setTelp(result.getString("telp"));
            	customer.setRole(result.getString("role"));
            	result.close();
            	preparedStatement.close();
            	connection.close();
            	return customer;
            }
            else {
            	System.out.println("Login Failed!");
            	result.close();
            	preparedStatement.close();
            	connection.close();
            	return null;
            }
          
        } catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
		return null;

    }
	
}

