package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SewaDao;
import model.Sewa;

/**
 * Servlet implementation class BayarSewa
 */
@WebServlet("/detailsewa")
public class DetailSewa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SewaDao sewaDao = new SewaDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSewa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/detailsewa.jsp");
		Sewa sewa = (Sewa) request.getSession(false).getAttribute("sewa");
		try {
			sewaDao.tampil_sewa(sewa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sewa.getStatus());
		request.getSession().setAttribute("sewa", sewa);
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
