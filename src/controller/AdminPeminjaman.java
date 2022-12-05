package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.SewaDao;
import model.Sewa;

/**
 * Servlet implementation class AdminPeminjaman
 */
@WebServlet("/adminpeminjaman")
public class AdminPeminjaman extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminDao adminDao = new AdminDao();
	SewaDao sewaDao = new SewaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPeminjaman() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
	    List<Sewa> listSewa = new ArrayList<Sewa>();
	    
	    String customer_id = request.getParameter("id");
	    
	    if(customer_id == null) {
	    	try {
	  	      listSewa = adminDao.list_peminjaman();
	  	      session.setAttribute("listSewa", listSewa);
	  	    } catch (ClassNotFoundException e) {
	  	      // TODO Auto-generated catch block
	  	      e.printStackTrace();
	  	    }
	    }
	    else {
	    	try {
				listSewa = sewaDao.tampil_history(customer_id);
				session.setAttribute("listSewa", listSewa);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/peminjaman.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
