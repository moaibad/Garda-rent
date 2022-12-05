package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SewaDao;

/**
 * Servlet implementation class AdminHitungDenda
 */
@WebServlet("/adminhitungdenda")
public class AdminHitungDenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SewaDao sewaDao = new SewaDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHitungDenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sewa_id = request.getParameter("id");
		
		try {
			sewaDao.hitungDenda(sewa_id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/Garda-rent/admindetailsewa?id=" + sewa_id);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
