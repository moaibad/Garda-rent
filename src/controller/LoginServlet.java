package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.relation.Role;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static java.lang.System.out;

import dao.CustomerDao;
import models.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDao customerDao = new CustomerDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setPassword(password);
		
		try {
			customer = customerDao.loginCustomer(customer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(customer.getRole());
		if(customer != null) {
			if(customer.getRole().equals("customer")) {
				HttpSession session = request.getSession();
				System.out.println("Sesi Login : " + session.getId());
				session.setAttribute("customer",customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
				dispatcher.forward(request, response);
			}else{
				HttpSession session = request.getSession();
				System.out.println("Sesi Login : " + session.getId());
				session.setAttribute("customer",customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/adminhome.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		else {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/loginfailed.jsp");
			dispatcher.forward(request, response);	
		}

	}

}
