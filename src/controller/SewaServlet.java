package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mobil;

/**
 * Servlet implementation class SewaServlet
 */
@WebServlet("/sewa")
public class SewaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sewamobil.jsp");
		
		Mobil mobil = new Mobil();
		
		mobil.setId(request.getParameter("mobil_id"));
		mobil.setPlat(request.getParameter("mobil_plat"));
		mobil.setNama(request.getParameter("mobil_nama"));
		mobil.setTahun(request.getParameter("mobil_tahun"));
		mobil.setTipe(request.getParameter("mobil_tipe"));
		mobil.setMerek(request.getParameter("mobil_merek"));
		mobil.setKapasitas(Integer.parseInt(request.getParameter("mobil_kapasitas")));
		mobil.setHarga(Integer.parseInt(request.getParameter("mobil_harga")));
		
		HttpSession session = request.getSession();
		session.setAttribute("mobil",mobil);
		
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
