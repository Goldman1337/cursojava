package com.comics.app.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.*;
import com.comics.app.Model.Role;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/EditarRol.jsp";
	private static String LIST_COMIC="/ListaRoles.jsp";
	private RoleController dao;
    /**
     * Default constructor. 
     */
    public RoleServlet() {
        dao=new RoleController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int RoleId = Integer.parseInt(request.getParameter("RoleId"));
			dao.delete(RoleId);
			forward=LIST_COMIC;
			request.setAttribute("roles",dao.getAll());
		} else if (action.equalsIgnoreCase("edit")){
			forward=INSERT_OR_EDIT;
			int RoleId = Integer.parseInt(request.getParameter("RoleId"));
			Role rol = dao.get(RoleId);
			request.setAttribute("role",rol);
		} else if(action.equalsIgnoreCase("listRole")){
			forward=LIST_COMIC;
			request.setAttribute("roles",dao.getAll());
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
		Role rol = new Role();
		
		rol.setNameRole(request.getParameter("Nombre"));
		rol.setComicAdd(Boolean.valueOf(request.getParameter("ComicAdd")));
		rol.setComicEdit(Boolean.valueOf(request.getParameter("ComicEdit")));
		rol.setComicDelete(Boolean.valueOf(request.getParameter("ComicDelete")));
		rol.setPersonAdd(Boolean.valueOf(request.getParameter("PersonAdd")));
		rol.setPersonEdit(Boolean.valueOf(request.getParameter("PersonEdit")));
		rol.setPersonDelete(Boolean.valueOf(request.getParameter("PersonDelete")));
		rol.setLoanAdd(Boolean.valueOf(request.getParameter("LoanAdd")));
		rol.setLoanEdit(Boolean.valueOf(request.getParameter("LoanEdit")));
		rol.setLoanDelete(Boolean.valueOf(request.getParameter("LoanDelete")));
		Integer Roleid = Integer.parseInt(request.getParameter("RoleId"));
		
			 if(Roleid==null||Roleid==0){
					dao.addRole(rol);
				}
				else
				{
					rol.setIdRole(Roleid);
					dao.update(rol);
				}
		        RequestDispatcher view =request.getRequestDispatcher(LIST_COMIC);
				request.setAttribute("roles",dao.getAll());
				view.forward(request,response);
		
	}

}
