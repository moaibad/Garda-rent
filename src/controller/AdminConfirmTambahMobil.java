package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MobilDao;
import model.Mobil;

/**
 * Servlet implementation class adminconfirmtambahmobil
 */
@WebServlet("/adminconfirmtambahmobil")
public class AdminConfirmTambahMobil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MobilDao mobilDao = new MobilDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConfirmTambahMobil() {
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
	    mobil.setPlat(request.getParameter("plat"));
	    mobil.setNama(request.getParameter("nama"));
	    mobil.setTahun(request.getParameter("tahun"));
	    mobil.setTipe(request.getParameter("tipe"));
	    mobil.setMerek(request.getParameter("merek"));
	    mobil.setStatus(request.getParameter("status"));
	    mobil.setKapasitas(Integer.parseInt(request.getParameter("kapasitas")));
	    mobil.setHarga(Integer.parseInt(request.getParameter("harga")));
	    
	    try {
			mobilDao.tambah_sewa(mobil);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    response.sendRedirect("/Garda-rent/adminmobil");
	  }

}

