package controller;

import dao.SewaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Akun;
import model.Mobil;
import model.Sewa;
import model.Supir;

/**
 * Servlet implementation class ConfirmSewa
 */
@WebServlet("/confirmSewa")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class ConfirmSewa extends HttpServlet {

  private static final long serialVersionUID = 1L;
  SewaDao sewaDao = new SewaDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConfirmSewa() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);

    HttpSession session = request.getSession();
    System.out.println("Sesi Login 3: " + request.getSession().getId());

    Mobil mobil = new Mobil();
    mobil = (Mobil) session.getAttribute("mobil");
    Akun akun = new Akun();
    akun = (Akun) session.getAttribute("akun");
    Supir supir = new Supir();
    supir = (Supir) session.getAttribute("supir");
    String denganSupir = request.getParameter("supir");
    int valid = 0;
   
    
    java.util.Date date = null;
	try {
		date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("tanggal"));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
    java.sql.Date tanggal_sewa = new java.sql.Date(date.getTime());
    
    
    Sewa sewa = new Sewa();
    sewa.setHarga(mobil.getHarga());
    sewa.setMobil_id(mobil.getId());
    sewa.setCustomer_id(akun.getId());
    sewa.setLama_sewa(Integer.parseInt(request.getParameter("lama_sewa")));
    sewa.setAlamat(request.getParameter("alamat"));
    sewa.setNama(akun.getNama());
    sewa.setTelepon(request.getParameter("telp"));
    sewa.setTanggal_sewa(tanggal_sewa);
    sewa.setTgl_sewa(tanggal_sewa.toString());
    
    
    if(denganSupir != null) {
    	if(denganSupir.equals("iya")) {
        	sewa.setSupir_id(supir.getId());
        	System.out.println(supir.getId());
        }
        else {
        	sewa.setSupir_id(null);
        }
    }    
    
    
    try {
      valid = sewaDao.tambahSewa(sewa);
      sewa.setId(sewaDao.getSewaId());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    session.setAttribute("sewa", sewa);
    session.setAttribute("booking", "booking");
    
    
    if (valid == 0) {
    	
    	session.setAttribute("tanggal", "tanggal");
    	response.sendRedirect("/Garda-rent/sewa?id="+mobil.getId());
    	
    }
    else {
    	
    	Part ktp = request.getPart("ktp");
    	ktp.write("D:\\eclipse workspace\\Garda-rent\\WebContent\\assets\\image\\ktp\\" + sewa.getId() + "_KTP.jpg");
    	
    	Part sim = request.getPart("sim");
    	sim.write("D:\\eclipse workspace\\Garda-rent\\WebContent\\assets\\image\\sim\\" + sewa.getId() + "_SIM.jpg");

	    
	    
    	response.sendRedirect("/Garda-rent/detailsewa?id="+sewa.getId());
    }
    
    
  }
  
}
