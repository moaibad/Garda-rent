package controller;

import dao.SewaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Akun;
import model.Mobil;
import model.Sewa;
import model.Supir;

/**
 * Servlet implementation class ConfirmSewa
 */
@WebServlet("/confirmSewa")
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

    int harga = mobil.getHarga();
    String mobil_id = mobil.getId();
    String customer_id = akun.getId();
    String alamat = request.getParameter("alamat");
    String ktp = request.getParameter("ktp");
    String nama = request.getParameter("nama");
    String telepon = request.getParameter("no_tlp");
    String denganSupir = request.getParameter("supir");
    int valid = 0;
    
    int lama_sewa = (Integer.parseInt(request.getParameter("lama_sewa")));
    
    java.util.Date date = null;
	try {
		date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("tanggal"));
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
    java.sql.Date tanggal_sewa = new java.sql.Date(date.getTime());
    
    Sewa sewa = new Sewa();

    sewa.setHarga(harga);
    sewa.setMobil_id(mobil_id);
    sewa.setCustomer_id(customer_id);
    sewa.setLama_sewa(lama_sewa);
    sewa.setAlamat(alamat);
    sewa.setKtp(ktp);
    sewa.setNama(nama);
    sewa.setTelepon(telepon);
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
    	PrintWriter out = response.getWriter();
    	session.setAttribute("tanggal", "tanggal");
    	response.sendRedirect("/Garda-rent/sewa?id="+mobil.getId());
    }
    else {
    	response.sendRedirect("/Garda-rent/detailsewa?id="+sewa.getId());
    }
    
  }
  
}
