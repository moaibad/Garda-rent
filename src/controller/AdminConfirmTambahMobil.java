package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.MobilDao;
import model.Mobil;

/**
 * Servlet implementation class adminconfirmtambahmobil
 */
@WebServlet("/adminconfirmtambahmobil")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AdminConfirmTambahMobil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MobilDao mobilDao = new MobilDao();
	
	String mobil_id;
       
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
			mobil_id = mobilDao.getMobilId();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Part filePart = request.getPart("gambar");
	    String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	      part.write("D:\\eclipse workspace\\Garda-rent\\WebContent\\assets\\image\\mobil\\" + mobil_id + ".jpg");
	    }
	    
	    response.sendRedirect("/Garda-rent/adminmobil");
	  }

}

