package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Mobil;
import model.Sewa;

public class MobilDao {

	public List<Mobil> list_mobil() throws ClassNotFoundException {

	    List<Mobil> listMobil = new ArrayList<Mobil>();

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(
	    		"SELECT * from mobil")) {
	      
	      
	      ResultSet rs = preparedStatement.executeQuery();
	      
	      while (rs.next()) {
				Mobil mobil= new Mobil();
				mobil.setId(rs.getString("id"));
				mobil.setPlat(rs.getString("plat"));
				mobil.setNama(rs.getString("nama"));
				mobil.setTahun(rs.getString("tahun"));
				mobil.setTipe(rs.getString("tipe"));
				mobil.setMerek(rs.getString("merek"));
				mobil.setKapasitas(rs.getInt("kapasitas"));
				mobil.setHarga(rs.getInt("harga"));
				mobil.setStatus(rs.getString("status"));
				listMobil.add(mobil);
			}
	      
	      connection.close();
	      preparedStatement.close();
	      // Step 3: Execute the query or update query
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	    }
	    return listMobil;
  }
  
  public Mobil tampil_mobil(String mobil_id) throws ClassNotFoundException {
	    String sql = "select * from mobil where id=?";

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
	      preparedStatement.setString(1, mobil_id);

	      // Step 3: Execute the query or update query
	      rs = preparedStatement.executeQuery();

	      if (rs.next()) {
	    	Mobil mobil = new Mobil();
	        mobil.setId(rs.getString("id"));
			mobil.setPlat(rs.getString("plat"));
			mobil.setNama(rs.getString("nama"));
			mobil.setTahun(rs.getString("tahun"));
			mobil.setTipe(rs.getString("tipe"));
			mobil.setMerek(rs.getString("merek"));
			mobil.setKapasitas(rs.getInt("kapasitas"));
			mobil.setHarga(rs.getInt("harga"));
	        
	        rs.close();
	        preparedStatement.close();
	        connection.close();
	        return mobil;
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
