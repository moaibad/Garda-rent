package controller;

import dao.MobilDao;
import model.Mobil;
import model.Sewa;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  MobilDao mobilDao = new MobilDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HomeServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());

    HttpSession session = request.getSession();
    List<Mobil> listMobil = new ArrayList<Mobil>();

    try {
      listMobil = mobilDao.list_tersedia();
      session.setAttribute("listMobil", listMobil);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerhome.jsp");
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
    doGet(request, response);
  }
}
