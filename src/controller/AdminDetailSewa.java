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
import dao.SewaDao;
import model.Mobil;
import model.Pembayaran;
import model.Sewa;

/**
 * Servlet implementation class AdminDetailSewa
 */
@WebServlet("/admindetailsewa")
public class AdminDetailSewa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SewaDao sewaDao = new SewaDao();
	MobilDao mobilDao = new MobilDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDetailSewa() {
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
		String sewa_id = request.getParameter("id");
		
		try {
			Sewa sewa = sewaDao.tampil_sewa(sewa_id);
			Pembayaran pembayaran = sewaDao.tampil_pembayaran(sewa_id);
			Mobil mobil = mobilDao.tampil_mobil(sewa.getMobil_id());
			session.setAttribute("sewa", sewa);
			session.setAttribute("pembayaran", pembayaran);
			session.setAttribute("mobil",mobil);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/admindetailsewa.jsp");
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
