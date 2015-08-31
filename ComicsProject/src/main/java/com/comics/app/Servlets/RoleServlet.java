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
	private static String INSERT_OR_EDIT = "/EditarRol.jsp";
	private static String LIST_COMIC = "/ListaRoles.jsp";
	private RoleController dao;

	/**
	 * Default constructor.
	 */
	public RoleServlet() {
		dao = new RoleController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		boolean Redir=false;

		if (action.equalsIgnoreCase("delete")) {
			try {
				int RoleId = Integer.parseInt(request.getParameter("RoleId"));
				if(dao.delete(RoleId)){
					forward = LIST_COMIC;
					request.setAttribute("roles", dao.getAll());
				}else{
					Redir=true;
				}
			} catch (Exception e) {
				Redir=true;
			}
		} else if (action.equalsIgnoreCase("edit")) {
			try {
				forward = INSERT_OR_EDIT;
				int RoleId = Integer.parseInt(request.getParameter("RoleId"));
				Role rol = dao.get(RoleId);
				if(rol.getIdRole()>0){
					request.setAttribute("role", rol);
				}else{
					Redir=true;
				}
			} catch (Exception e) {
				Redir=true;
			}
		} else if (action.equalsIgnoreCase("listRole")) {
			forward = LIST_COMIC;
			request.setAttribute("roles", dao.getAll());
		} else {
			forward = INSERT_OR_EDIT;
		}
		if(Redir==false){
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}else{
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Role rol = new Role();
		String messages = "";
		String Nombre = request.getParameter("Nombre");
		boolean ComicAdd=true;
		if(request.getParameter("ComicAdd")==null){
			ComicAdd=false;
		}
		boolean ComicEdit=true;
		if(request.getParameter("ComicEdit")==null){
			ComicEdit=false;
		}
		boolean ComicDelete=true;
		if(request.getParameter("ComicDelete")==null){
			ComicDelete=false;
		}
		boolean PersonAdd=true;
		if(request.getParameter("PersonAdd")==null){
			PersonAdd=false;
		}
		boolean PersonEdit=true;
		if(request.getParameter("PersonEdit")==null){
			PersonEdit=false;
		}
		boolean PersonDelete=true;
		if(request.getParameter("PersonDelete")==null){
			PersonDelete=false;
		}
		boolean LoanAdd=true;
		if(request.getParameter("LoanAdd")==null){
			LoanAdd=false;
		}
		boolean LoanEdit=true;
		if(request.getParameter("LoanEdit")==null){
			LoanEdit=false;
		}
		boolean LoanDelete=true;
		if(request.getParameter("LoanDelete")==null){
			LoanDelete=false;
		}
		
		if (Nombre.equalsIgnoreCase("ADMIN")) {
			messages = "No puede agregar otro administrador";
		}
		rol.setNameRole(Nombre);
		rol.setComicAdd(ComicAdd);
		rol.setComicEdit(ComicEdit);
		rol.setComicDelete(ComicDelete);
		rol.setPersonAdd(PersonAdd);
		rol.setPersonEdit(PersonEdit);
		rol.setPersonDelete(PersonDelete);
		rol.setLoanAdd(LoanAdd);
		rol.setLoanEdit(LoanEdit);
		rol.setLoanDelete(LoanDelete);
		Integer Roleid = Integer.parseInt(request.getParameter("RoleId"));
		if (messages.isEmpty()) {
			if (Roleid == null || Roleid == 0) {
				dao.addRole(rol);
			} else {
				rol.setIdRole(Roleid);
				dao.update(rol);
			}
			request.setAttribute("messages", messages);
			RequestDispatcher view = request.getRequestDispatcher(LIST_COMIC);
			request.setAttribute("roles", dao.getAll());
			view.forward(request, response);
		} else {
			rol.setIdRole(Roleid);
			request.setAttribute("role", rol);
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("EditarRol.jsp?RoleId=" + Roleid).forward(request, response);
		}
	}
}
