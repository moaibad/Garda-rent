<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Customer Register Form</h1>
  <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Nama</td>
     <td><input type="text" name="nama" /></td>
    </tr>
    <tr>
     <td>KTP</td>
     <td><input type="text" name="ktp" /></td>
    </tr>
    <tr>
     <td>SIM</td>
     <td><input type="text" name="sim" /></td>
    </tr>
    <tr>
     <td>No Telp</td>
     <td><input type="text" name="telp" /></td>
    </tr>
    <tr>
     <td>Role</td>
     <td><input type="text" name="role" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>