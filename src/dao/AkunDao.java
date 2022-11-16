package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Akun;

public class AkunDao {

  public int registerCustomer(Akun akun) throws ClassNotFoundException {
    String sql = "{call registrasiAkun (?, ?, ?, ?, ?)}";

    int result = 0;

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
      callableStatement.setString(1, akun.getEmail());
      callableStatement.setString(2, akun.getPassword());
      callableStatement.setString(3, akun.getNama());
      callableStatement.setString(4, akun.getUsername());
      callableStatement.setString(5, akun.getRole());

      System.out.println(callableStatement);

      // Step 3: Execute the query or update query
      callableStatement.executeUpdate();
      callableStatement.close();
      connection.close();
    } catch (Exception e) {
      // process sql exception
      e.printStackTrace();
    }
    return result;
  }

  public Akun login(Akun akun) throws ClassNotFoundException {
    String sql = "select * from akun where username=? and password=?";

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
      preparedStatement.setString(1, akun.getUsername());
      preparedStatement.setString(2, akun.getPassword());

      // Step 3: Execute the query or update query
      result = preparedStatement.executeQuery();

      if (result.next()) {
        akun.setId(result.getString("id"));
        akun.setEmail(result.getString("email"));
        akun.setPassword(result.getString("password"));
        akun.setNama(result.getString("nama"));
        akun.setRole(result.getString("role"));
        result.close();
        preparedStatement.close();
        connection.close();
        return akun;
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
