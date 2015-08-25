package com.comics.app.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.*;
import com.comics.app.Dao.*;
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
		Loan loan = new Loan();
		loan.setComic(new comicController().get(Integer.parseInt(request.getParameter("ComicId"))));
		loan.setPerson(new personController().get( Integer.parseInt(request.getParameter("PersonId"))));
		loan.setDate(request.getParameter("Date"));
		String Loanid = request.getParameter("LoanId");
		if(Loanid==null||Loanid.isEmpty()){
			dao.addLoan(loan.getComic(), loan.getPerson(), loan.getDate());
		}
		else
		{
			loan.setIdLoan(Integer.parseInt(Loanid));
			dao.update(loan);
		}
		RequestDispatcher view =request.getRequestDispatcher(LIST_LOAN);
		request.setAttribute("loans",dao.getAll());
		view.forward(request,response);
	}

}
