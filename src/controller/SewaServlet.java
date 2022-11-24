package controller;

import dao.MobilDao;
import dao.SewaDao;
import dao.SupirDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Mobil;
import model.Supir;

/**
 * Servlet implementation class SewaServlet
 */
@WebServlet("/sewa")
public class SewaServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  MobilDao mobilDao = new MobilDao();
  SupirDao supirDao = new SupirDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SewaServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
	  HttpSession session = request.getSession();
	  String mobil_id = request.getParameter("id");
	
	  Mobil mobil = new Mobil();
	  Supir supir = new Supir();
		
	  try {
		  mobil = mobilDao.tampil_mobil(mobil_id);
		  session.setAttribute("mobil", mobil);
		  
		  supir = supirDao.tampil_supir();
		  session.setAttribute("supir", supir);
	  } catch (ClassNotFoundException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
		
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sewamobil.jsp");
	  dispatcher.forward(request, response);	  
  }
  
  

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());

  }
}
