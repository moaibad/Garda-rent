package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Akun;
import model.Pembayaran;
import model.Sewa;

public class SewaDao {

  public int tambahSewa(Sewa sewa) throws ClassNotFoundException {
    String sql = "{call tambahSewa (?, ?, ?, ?, ?, ?, ?, ?)}";

    int result;

    Class.forName("oracle.jdbc.driver.OracleDriver");

    try (
      Connection connection = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
      // Step 2:Create a statement using connection object
      CallableStatement callableStatement = connection.prepareCall(sql)) {
      callableStatement.setInt(1, sewa.getHarga());
      callableStatement.setInt(2, sewa.getLama_sewa());
      callableStatement.setString(3, sewa.getMobil_id());
      callableStatement.setString(4, sewa.getCustomer_id());
      callableStatement.setString(5, sewa.getKtp());
      callableStatement.setString(6, sewa.getAlamat());
      callableStatement.setString(7, sewa.getTelepon());
      callableStatement.setString(8, sewa.getNama());
      System.out.println(callableStatement);
      callableStatement.executeUpdate();
      connection.close();
      callableStatement.close();
      // Step 3: Execute the query or update query
    } catch (Exception e) {
      // process sql exception
      e.printStackTrace();
    }
    return 0;
  }
  
  public int tambahPembayaran(Pembayaran pembayaran) throws ClassNotFoundException {
	    String sql = "{call tambahPembayaran (?, ?, ?)}";

	    int result;

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      CallableStatement callableStatement = connection.prepareCall(sql)) {
	      callableStatement.setString(1, pembayaran.getRekening());
	      callableStatement.setInt(2, pembayaran.getNominal());
	      callableStatement.setString(3, pembayaran.getSewa_id());
	      System.out.println(callableStatement);
	      callableStatement.executeUpdate();
	      connection.close();
	      callableStatement.close();
	      // Step 3: Execute the query or update query
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	    }
	    return 0;
	  }
  
  public Sewa tampil_sewa(Sewa sewa) throws ClassNotFoundException {
	    String sql = "select * from sewa where mobil_id=?";

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
	      preparedStatement.setString(1, sewa.getMobil_id());

	      // Step 3: Execute the query or update query
	      result = preparedStatement.executeQuery();

	      if (result.next()) {
	        sewa.setId(result.getString("id"));
	        sewa.setCustomer_id(result.getString("customer_id"));
	        sewa.setAlamat(result.getString("alamat"));
	        sewa.setTotal_bayar(result.getInt("total_bayar"));
	        sewa.setMobil_id(result.getString("mobil_id"));
	        sewa.setStatus(result.getString("status"));
	        sewa.setLama_sewa(result.getInt("lama_sewa"));
	        sewa.setKtp(result.getString("ktp"));
	        sewa.setTelepon(result.getString("telepon"));
	        
	        
	        
	        result.close();
	        preparedStatement.close();
	        connection.close();
	        return sewa;
	      } else {
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
