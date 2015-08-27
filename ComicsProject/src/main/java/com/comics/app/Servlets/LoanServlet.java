package com.comics.app.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.*;
import com.comics.app.Model.*;

/**
 * Servlet implementation class LoanServlet
 */
@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/EditarPrestamo.jsp";
	private static String LIST_LOAN="/ListaPrestamos.jsp";
	private loanController dao;
    /**
     * Default constructor. 
     */
    public LoanServlet() {
        dao=new loanController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int LoanId = Integer.parseInt(request.getParameter("LoanId"));
			dao.delete(LoanId);
			forward=LIST_LOAN;
			request.setAttribute("loans",dao.getAll());
		} else if (action.equalsIgnoreCase("edit")){
			forward=INSERT_OR_EDIT;
			int LoanId = Integer.parseInt(request.getParameter("LoanId"));
			Loan loan = dao.get(LoanId);
			request.setAttribute("loan",loan);
		} else if(action.equalsIgnoreCase("listLoan")){
			forward=LIST_LOAN;
			request.setAttribute("loans",dao.getAll());
		} else{
			forward=INSERT_OR_EDIT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messages = "";
		Loan loan = new Loan();
		Comic ComicLoan= new comicController().get(Integer.parseInt(request.getParameter("ComicId")));
		Person PersonLoan =new personController().get( Integer.parseInt(request.getParameter("PersonId")));
		String dateprestamo=request.getParameter("Date");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date FechaPrestamo= new Date();
		try {
			FechaPrestamo = sdf.parse(dateprestamo);
		} catch (ParseException e) {
			messages="error al inicializar la fecha de hoy";
			e.printStackTrace();
		}
		Date FechaHoy= new Date();
		try {
			FechaHoy = sdf.parse(new Date().toString());
		} catch (ParseException e) {
			messages="error al inicializar la fecha del prestamo";
			e.printStackTrace();
		}
		if(ComicLoan.getQuantityComic() < new loanController().getAll().stream()
				.filter(x->x.getComic().getIdComic()==ComicLoan.getIdComic()).count()){
			messages="el comic no tiene ejemplares disponibles para el prestamo";
		}
		if(FechaPrestamo.before(FechaHoy)){
			messages="no puede pedir un prestamo para una fecha anterior a la actual";
		}
		loan.setComic(ComicLoan);
		loan.setPerson(PersonLoan);
		loan.setDate(dateprestamo);
		String Loanid = request.getParameter("LoanId");
		if (messages.isEmpty()) {
			if(Loanid==null||Loanid.isEmpty()){
				dao.addLoan(loan.getComic(), loan.getPerson(), loan.getDate());
			}
			else
			{
				loan.setIdLoan(Integer.parseInt(Loanid));
				dao.update(loan);
			}
			request.setAttribute("messages", messages);
			RequestDispatcher view =request.getRequestDispatcher(LIST_LOAN);
			request.setAttribute("loans",dao.getAll());
			view.forward(request,response);
		}else{
			loan.setIdLoan(Integer.parseInt(Loanid));
			request.setAttribute("loan",loan);
	        request.setAttribute("messages", messages);
	        request.getRequestDispatcher("EditarPrestamo.jsp?PrestamoId="+Loanid).forward(request, response); 
		}
		
	}

}
