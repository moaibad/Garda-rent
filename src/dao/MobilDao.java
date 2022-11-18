package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Mobil;
import model.Sewa;

public class MobilDao {

  public ResultSet tampilMobil() throws ClassNotFoundException {
    String sql = "select * from mobil";

    ResultSet result = null;

    Class.forName("oracle.jdbc.driver.OracleDriver");

    try (
      Connection connection = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:xe",
        "TEST",
        "123"
      );
      // Step 2:Create a statement using connection object
      CallableStatement callableStatement = connection.prepareCall(sql)
    ) {
      System.out.println(callableStatement);

      // Step 3: Execute the query or update query
      result = callableStatement.executeQuery(sql);
    } catch (Exception e) {
      // process sql exception
      e.printStackTrace();
    }
    return result;
  }
  
  public Mobil tampil_mobil(String mobil_id) throws ClassNotFoundException {
	    String sql = "select * from mobil where id=?";

	    ResultSet result = null;

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe",
	        "TEST",
	        "123"
	      );
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(sql)
	    ) {
	      preparedStatement.setString(1, mobil_id);

	      // Step 3: Execute the query or update query
	      result = preparedStatement.executeQuery();

	      if (result.next()) {
	    	Mobil mobil = new Mobil();
	        mobil.setId(result.getString("id"));
	        mobil.setNama(result.getString("nama"));
	        mobil.setHarga(result.getInt("harga"));
	        
	        result.close();
	        preparedStatement.close();
	        connection.close();
	        return mobil;
	      } else {
	        System.out.println("Mobil Gaada!");
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
