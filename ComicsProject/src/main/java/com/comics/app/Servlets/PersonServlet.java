package com.comics.app.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.*;
import com.comics.app.Model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/EditarPersona.jsp";
	private static String LIST_PERSON="/ListaPersonas.jsp";
	private personController dao;
    /**
     * Default constructor. 
     */
    public PersonServlet() {
        dao=new personController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int PersonId = Integer.parseInt(request.getParameter("PersonId"));
			dao.delete(PersonId);
			forward=LIST_PERSON;
			request.setAttribute("persons",dao.getAll());
		} else if (action.equalsIgnoreCase("edit")){
			forward=INSERT_OR_EDIT;
			int PersonId = Integer.parseInt(request.getParameter("PersonId"));
			Person per = dao.get(PersonId);
			request.setAttribute("person",per);
		} else if(action.equalsIgnoreCase("listPerson")){
			forward=LIST_PERSON;
			request.setAttribute("persons",dao.getAll());
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
		Person per = new Person();
		per.setNamePerson(request.getParameter("Nombre"));
		per.setTelephonePerson(request.getParameter("Tel"));
		String Personid = request.getParameter("PersonId");
		if(Personid==null||Personid.isEmpty()){
			dao.add(per);
		}
		else
		{
			per.setIdPerson(Integer.parseInt(Personid));
			dao.update(per);
		}
		RequestDispatcher view =request.getRequestDispatcher(LIST_PERSON);
		request.setAttribute("persons",dao.getAll());
		view.forward(request,response);
	}

}
