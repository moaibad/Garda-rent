package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SewaDao;
import model.Akun;
import model.Pembayaran;
import model.Sewa;

/**
 * Servlet implementation class ConfirmBayarSewa
 */
@WebServlet("/confirmbayar")
public class ConfirmBayarSewa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SewaDao sewaDao = new SewaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBayarSewa() {
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
		
		
		Sewa sewa = new Sewa();
	    sewa = (Sewa) request.getSession().getAttribute("sewa");
	    
	    java.util.Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("tanggal_transfer"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	    java.sql.Date tanggal_transfer = new java.sql.Date(date.getTime());	    	    
	    
	    
		Pembayaran pembayaran = new Pembayaran();
		
		pembayaran.setRekening(request.getParameter("rekening"));
		pembayaran.setNama_rekening(request.getParameter("nama_rekening"));
		pembayaran.setNominal(Integer.parseInt(request.getParameter("nominal")));
		pembayaran.setSewa_id(sewa.getId());
		pembayaran.setTanggal_transfer(tanggal_transfer);
		
		System.out.println(pembayaran.getSewa_id());
		
		try {
			sewaDao.tambahPembayaran(pembayaran);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/Garda-rent/home");
	}

}
