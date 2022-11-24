package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Mobil;
import model.Supir;

public class SupirDao {
	
	 public Supir tampil_supir() throws ClassNotFoundException {
		    String sql = "select * from supir where status = 'Tersedia'";

		    ResultSet rs = null;

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

		      // Step 3: Execute the query or update query
		      rs = preparedStatement.executeQuery();

		      if (rs.next()) {
		    	Supir supir = new Supir();
		        supir.setId(rs.getString("id"));
		        supir.setNama(rs.getString("nama"));
		        supir.setKtp(rs.getString("ktp"));
		        supir.setAlamat(rs.getString("alamat"));
		        supir.setStatus(rs.getString("status"));
				
		        rs.close();
		        preparedStatement.close();
		        connection.close();
		        return supir;
		      } else {
		        System.out.println("Mobil Gaada!");
		        rs.close();
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
