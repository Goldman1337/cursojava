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
import com.comics.app.Model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/EditarUsuario.jsp";
	private static String LIST_PERSON = "/ListaUsuarios.jsp";
	private UsuarioController dao;

	/**
	 * Default constructor.
	 */
	public UsuarioServlet() {
		dao = new UsuarioController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			int UsuarioId = Integer.parseInt(request.getParameter("UsuarioId"));
			dao.delete(UsuarioId);
			forward = LIST_PERSON;
			request.setAttribute("usuarios", dao.getAll());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int UsuarioId = Integer.parseInt(request.getParameter("UsuarioId"));
			Usuario us = dao.get(UsuarioId);
			request.setAttribute("usuario", us);
		} else if (action.equalsIgnoreCase("listUsuario")) {
			forward = LIST_PERSON;
			request.setAttribute("usuarios", dao.getAll());
		} else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String messages = "";
		Usuario us = new Usuario();
		String UsuarioNombre=request.getParameter("UserName");
		String Pass=request.getParameter("Pass");
		Role RoleLoan= new RoleController().get(Integer.parseInt(request.getParameter("RoleId")));

		us.setUserName(UsuarioNombre);
		us.setPassword(Pass);
		us.setRole(RoleLoan);
		Integer Usuarioid = Integer.parseInt(request.getParameter("UsuarioId"));
		if(new UsuarioController().getAll().stream()
				.anyMatch(x->x.getUserName().equals(UsuarioNombre) && x.getIdUser()!=Usuarioid)){
			messages="El nombre de usuario esta en uso, elija otro";
		}
		if (messages.isEmpty()) {
			if(Usuarioid==null||Usuarioid==0){
				dao.addUsuario(us);
			}
			else
			{
				us.setIdUser(Usuarioid);
				dao.update(us);
			}
			request.setAttribute("messages", messages);
			RequestDispatcher view =request.getRequestDispatcher(LIST_PERSON);
			request.setAttribute("usuarios",dao.getAll());
			view.forward(request,response);
		}else{
			us.setIdUser(Usuarioid);
			request.setAttribute("usuario",us);
	        request.setAttribute("messages", messages);
	        request.getRequestDispatcher("EditarUsuario.jsp?UsuarioId="+Usuarioid).forward(request, response); 
		}
	}

}
