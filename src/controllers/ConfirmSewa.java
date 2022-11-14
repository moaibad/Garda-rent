package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SewaDao;
import models.Customer;
import models.Mobil;
import models.Sewa;

/**
 * Servlet implementation class ConfirmSewa
 */
@WebServlet("/Sewa")
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
		
		
		HttpSession session = request.getSession();
		System.out.println("Sesi Login 3: " + session.getId());
		
		Mobil mobil = new Mobil();
		mobil = (Mobil) session.getAttribute("mobil");
		Customer customer = new Customer();
		customer = (Customer) session.getAttribute("customer");
		
		int harga = mobil.getHarga();
		String mobil_id = mobil.getId();
		String customer_id = customer.getId();
		int lama_sewa = (Integer.parseInt(request.getParameter("lama_sewa")));
		
		Sewa sewa = new Sewa();
		
		sewa.setHarga(harga);
		sewa.setMobil_id(mobil_id);
		sewa.setCustomer_id(customer_id);
		sewa.setLama_sewa(lama_sewa);
		
		try {
			sewaDao.tambahSewa(sewa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sewa.getCustomer_id());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerhome.jsp");
		dispatcher.forward(request, response);
	}

}
