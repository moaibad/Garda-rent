package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Akun;
import model.Pembayaran;
import model.Sewa;

public class SewaDao {

  public int tambahSewa(Sewa sewa) throws ClassNotFoundException {
    String sql = "{call tambahSewa (?, ?, ?, ?, ?, ?, ?, ?)}";

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
  
  public Sewa tampil_sewa(String id) throws ClassNotFoundException {
	    String sql = "select * from sewa where id=?";

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
	      preparedStatement.setString(1, id);

	      // Step 3: Execute the query or update query
	      result = preparedStatement.executeQuery();

	      if (result.next()) {
	    	Sewa sewa = new Sewa();
	        sewa.setId(result.getString("id"));
	        sewa.setCustomer_id(result.getString("customer_id"));
	        sewa.setAlamat(result.getString("alamat"));
	        sewa.setTotal_bayar(result.getInt("total_bayar"));
	        sewa.setMobil_id(result.getString("mobil_id"));
	        sewa.setStatus(result.getString("status"));
	        sewa.setLama_sewa(result.getInt("lama_sewa"));
	        sewa.setKtp(result.getString("ktp"));
	        sewa.setTelepon(result.getString("telepon"));
	        sewa.setNama(result.getString("nama"));
	        
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
  
  public List<Sewa> tampil_history(String customer_id) throws ClassNotFoundException {

	    List<Sewa> listSewa = new ArrayList<Sewa>();

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(
	    		"SELECT sewa.*, mobil.nama as nama_mobil " + 
	    		"FROM sewa " + 
	    		"INNER JOIN mobil ON sewa.mobil_id=mobil.id " + 
	    		"WHERE sewa.customer_id = ?")) {
	      preparedStatement.setString(1, customer_id);
	      
	      ResultSet rs = preparedStatement.executeQuery();
	      
	      while (rs.next()) {
				Sewa sewa= new Sewa();
				sewa.setId(rs.getString("id"));
				sewa.setNama(rs.getString("nama"));
				sewa.setTotal_bayar(rs.getInt("total_bayar"));
				sewa.setLama_sewa(rs.getInt("lama_sewa"));
				sewa.setStatus(rs.getString("status"));
				sewa.setMobil_id(rs.getString("mobil_id"));
				sewa.setNama_mobil(rs.getString("nama_mobil"));
				listSewa.add(sewa);
			}
	      
	      connection.close();
	      preparedStatement.close();
	      // Step 3: Execute the query or update query
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	    }
	    return listSewa;
  }
  
  
  public String getSewaId() throws ClassNotFoundException {
	    String sql = "select id from sewa order by id desc";

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

	      // Step 3: Execute the query or update query
	      result = preparedStatement.executeQuery();

	      if (result.next()) {
	    	String sewaId = result.getString("id");
	        result.close();
	        preparedStatement.close();
	        connection.close();
	        System.out.println(sewaId);
	        return sewaId;
	        
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



