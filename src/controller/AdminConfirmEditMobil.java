package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MobilDao;
import model.Mobil;

/**
 * Servlet implementation class AdminConfrimEditMobil
 */
@WebServlet("/adminconfirmeditmobil")
public class AdminConfirmEditMobil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MobilDao mobilDao = new MobilDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConfirmEditMobil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Mobil mobil = new Mobil();
		
		mobil.setId(request.getParameter("mobil_id"));
		mobil.setPlat(request.getParameter("no_plat"));
		mobil.setMerek(request.getParameter("merk"));
		mobil.setWarna(request.getParameter("warna"));
		mobil.setTahun(request.getParameter("tahun"));
		mobil.setHarga(Integer.parseInt(request.getParameter("harga")));
		mobil.setKapasitas(Integer.parseInt(request.getParameter("kapasitas")));
		mobil.setKm(Integer.parseInt(request.getParameter("km")));
		mobil.setStatus(request.getParameter("status"));
		
		try {
			mobilDao.update_mobil(mobil);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/Garda-rent/admineditmobil?id=" + mobil.getId());
		
	}

}
