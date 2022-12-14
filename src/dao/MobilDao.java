package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Akun;
import model.Mobil;
import model.Sewa;

public class MobilDao {
	
	public void tambah_mobil(Mobil mobil) throws ClassNotFoundException {
	    String sql = "{call tambahmobil (?, ?, ?, ?, ?, ?, ?, ?)}";

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
	      callableStatement.setString(1, mobil.getPlat());
	      callableStatement.setString(2, mobil.getNama());
	      callableStatement.setString(3, mobil.getTahun());
	      callableStatement.setString(4, mobil.getTipe());
	      callableStatement.setString(5, mobil.getMerek());
	      callableStatement.setInt(6, mobil.getKapasitas());
	      callableStatement.setString(7, mobil.getStatus());
	      callableStatement.setInt(8, mobil.getHarga());

	      System.out.println(callableStatement);

	      // Step 3: Execute the query or update query
	      callableStatement.executeUpdate();
	      callableStatement.close();
	      connection.close();
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	      System.out.println("Mobil gagal ditambahkan karena kesalahan input!");
	    }
	    
	  }

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
			mobil.setWarna(rs.getString("warna"));
			mobil.setKm(rs.getInt("km"));
			mobil.setStatus(rs.getString("status"));
	        
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
  
  public String getMobilId() throws ClassNotFoundException {
	    String sql = "select id from mobil order by id desc";

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
	    	String mobil_id = result.getString("id");
	        result.close();
	        preparedStatement.close();
	        connection.close();
	        System.out.println(mobil_id);
	        return mobil_id;
	        
	      } else {
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
  public List<Mobil> list_tersedia() throws ClassNotFoundException {

	    List<Mobil> listMobil = new ArrayList<Mobil>();

	    Class.forName("oracle.jdbc.driver.OracleDriver");

	    try (
	      Connection connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe","TEST","123");
	      // Step 2:Create a statement using connection object
	      PreparedStatement preparedStatement = connection.prepareCall(
	    		"SELECT * from mobil WHERE status = 'Tersedia'")) {
	      
	      
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
  
  public void update_mobil(Mobil mobil) throws ClassNotFoundException {
	    String sql = "{call updateMobil (?, ?, ?, ?, ?, ?, ?, ?)}";

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
	      callableStatement.setString(1, mobil.getId());
	      callableStatement.setString(2, mobil.getPlat());
	      callableStatement.setString(3, mobil.getStatus());
	      callableStatement.setInt(4, mobil.getHarga());
	      callableStatement.setInt(5, mobil.getKm());
	      callableStatement.setString(6, mobil.getWarna());
	      callableStatement.setInt(7, mobil.getKapasitas());
	      callableStatement.setString(8, mobil.getTahun());

	      System.out.println(callableStatement);

	      // Step 3: Execute the query or update query
	      callableStatement.executeUpdate();
	      callableStatement.close();
	      connection.close();
	    } catch (Exception e) {
	      // process sql exception
	      e.printStackTrace();
	      System.out.println("Mobil gagal diupdate !");
	    }
	    
	  }
  
}
