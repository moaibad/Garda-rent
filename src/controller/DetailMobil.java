package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MobilDao;
import model.Mobil;

/**
 * Servlet implementation class DetailMobil
 */
@WebServlet("/detailmobil")
public class DetailMobil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MobilDao mobilDao = new MobilDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMobil() {
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
		String mobil_id = request.getParameter("id");
		
		try {
			Mobil mobil = mobilDao.tampil_mobil(mobil_id);
			String status_mobil = mobil.getStatus();
			session.setAttribute("mobil",mobil);
			session.setAttribute("status_mobil",status_mobil);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/detailmobil.jsp");
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
