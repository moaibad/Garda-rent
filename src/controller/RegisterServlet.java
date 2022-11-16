package controller;

import dao.AkunDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Akun;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private AkunDao customerDao = new AkunDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RegisterServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());

    RequestDispatcher dispatcher = request.getRequestDispatcher(
      "/WEB-INF/views/customerregister.jsp"
    );
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String nama = request.getParameter("nama");
    String username = request.getParameter("username");

    Akun akun = new Akun();
    akun.setEmail(email);
    akun.setPassword(password);
    akun.setUsername(username);
    akun.setNama(nama);
    akun.setRole("customer");

    try {
      customerDao.registerCustomer(akun);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }
}
