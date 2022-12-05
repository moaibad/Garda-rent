package controller;

import dao.AkunDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Akun;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private AkunDao akunDao = new AkunDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
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

    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
	HttpSession session = request.getSession();
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Akun akun = new Akun();
    akun.setUsername(username);
    akun.setPassword(password);

    try {
      akun = akunDao.login(akun);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (akun != null) {
      if (akun.getRole().equals("customer")) {
        System.out.println("Sesi Login : " + session.getId());
        session.setAttribute("akun", akun);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
      } else {
    	session.setAttribute("akun", akun);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/adminhome.jsp");
        dispatcher.forward(request, response);
      }
    } else {
      session.setAttribute("incorrect", "incorrect");
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);
    }
  }
}
