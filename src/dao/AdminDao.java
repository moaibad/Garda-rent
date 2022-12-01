package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Akun;
import model.Sewa;

public class AdminDao {
	
	public List<Akun> list_user() throws ClassNotFoundException {

	    List<Akun> listUser= new ArrayList<Akun>();

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(
	    		"SELECT * from akun where role = 'customer'")) {
	      
	      
	      ResultSet rs = preparedStatement.executeQuery();
	      
	      while (rs.next()) {
				Akun akun= new Akun();
				akun.setId(rs.getString("id"));
				akun.setEmail(rs.getString("email"));
				akun.setPassword(rs.getString("password"));
				akun.setRole(rs.getString("role"));
				akun.setUsername(rs.getString("username"));
				akun.setNama(rs.getString("nama"));
				listUser.add(akun);
			}
	      
	      connection.close();
	      preparedStatement.close();
	      // Step 3: Execute the query or update query
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	    }
	    return listUser;
	}
	
	public List<Sewa> list_sewa() throws ClassNotFoundException {

	    List<Sewa> listSewa= new ArrayList<Sewa>();

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(
	    		  "SELECT sewa.*, mobil.nama as nama_mobil,akun.nama as nama_akun "
		    		+ "FROM sewa "
		    		+ "INNER JOIN mobil ON sewa.mobil_id=mobil.id "
		    		+ "INNER JOIN akun on sewa.customer_id = akun.id "
		    		+ "order by sewa.id desc ")) {
	      
	      
	      ResultSet rs = preparedStatement.executeQuery();
	      
	      while (rs.next()) {
				Sewa sewa= new Sewa();
				sewa.setId(rs.getString("id"));
				sewa.setNama(rs.getString("nama_akun"));
				sewa.setTotal_bayar(rs.getInt("total_bayar"));
				sewa.setLama_sewa(rs.getInt("lama_sewa"));
				sewa.setStatus(rs.getString("status"));
				sewa.setMobil_id(rs.getString("mobil_id"));
				sewa.setNama_mobil(rs.getString("nama_mobil"));
				sewa.setTgl_sewa(rs.getDate("tanggal_sewa").toString());
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
	
}
