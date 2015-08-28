package com.comics.app.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comics.app.Controller.*;
import com.comics.app.Model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioController dao;
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        dao=new UsuarioController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession s = request.getSession();
		
		if(action!=null){
			if(action.equalsIgnoreCase("salir")){
				s.invalidate();
				response.sendRedirect("Index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MessageLogin="";
		List<Usuario> Usuarios=dao.getAll();
		String UsuarioNombre=request.getParameter("UserName");
		String Pass=request.getParameter("Pass");
		Usuario UserLog=new Usuario();
		HttpSession s = request.getSession();
		
		if(Usuarios.stream().anyMatch(x->x.getUserName().equals(UsuarioNombre) && x.getPassword().equals(Pass))){
			UserLog= Usuarios.stream().filter(x->x.getUserName().equals(UsuarioNombre) && x.getPassword().equals(Pass)).findFirst().get();
		}else{
			MessageLogin="Nombre de Usuario o Contraseña incorrecto";
		}
		
		if(UserLog.getIdUser()>0){
			s.setAttribute("UsuarioLog", UserLog);
		}
		
		if(MessageLogin.isEmpty()){
			request.setAttribute("messages", MessageLogin);
			RequestDispatcher view =request.getRequestDispatcher("Index.jsp");
			view.forward(request,response);
		}else{
			s.invalidate();
	        request.setAttribute("messages", MessageLogin);
	        request.getRequestDispatcher("Login.jsp").forward(request, response); 
		}
	}
	

}
