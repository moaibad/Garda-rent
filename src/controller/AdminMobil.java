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

import dao.MobilDao;
import model.Mobil;
import model.Sewa;

/**
 * Servlet implementation class AdminMobil
 */
@WebServlet("/adminmobil")
public class AdminMobil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MobilDao mobilDao = new MobilDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMobil() {
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
	    List<Mobil> listMobil = new ArrayList<Mobil>();
	    
	    try {
			listMobil = mobilDao.list_mobil();
			session.setAttribute("listMobil", listMobil);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/daftarmobil.jsp");
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
