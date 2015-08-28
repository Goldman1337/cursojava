package com.comics.app.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comics.app.Controller.*;
import com.comics.app.Model.Comic;
import com.comics.app.Model.Usuario;

/**
 * Servlet implementation class ComicServlet
 */
@WebServlet("/ComicServlet")
public class ComicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/EditarComic.jsp";
	private static String LIST_COMIC = "/ListaComics.jsp";
	private comicController dao;

	/**
	 * Default constructor.
	 */
	public ComicServlet() {
		dao = new comicController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		HttpSession s = request.getSession();
		Usuario UsLog = (Usuario) s.getAttribute("UsuarioLog");
		boolean Redireccionar = false;
		
		if (action.equalsIgnoreCase("delete")) {
			if (UsLog != null && UsLog.getRole().getComicDelete()) {
				int ComicId = Integer.parseInt(request.getParameter("ComicId"));
				dao.delete(ComicId);
				forward = LIST_COMIC;
				request.setAttribute("comics", dao.getAll());
			} else {
				Redireccionar = true;
			}
		} else if (action.equalsIgnoreCase("edit")) {
			if (UsLog != null && UsLog.getRole().getComicEdit()) {
				forward = INSERT_OR_EDIT;
				int ComicId = Integer.parseInt(request.getParameter("ComicId"));
				Comic com = dao.get(ComicId);
				request.setAttribute("comic", com);
			} else {
				Redireccionar = true;
			}
		} else if (action.equalsIgnoreCase("listComic")) {
			forward = LIST_COMIC;
			request.setAttribute("comics", dao.getAll());
		} else {
			if (UsLog != null && UsLog.getRole().getComicAdd()) {
				forward = INSERT_OR_EDIT;
			} else {
				Redireccionar = true;
			}
		}
		if (Redireccionar == false) {
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			s.invalidate();
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String messages = "";
		Comic com = new Comic();
		Integer CantComic = Integer.parseInt(request.getParameter("Cantidad"));
		if (CantComic < 0) {
			messages = "La cantidad debe ser mayor a 0";
		}
		com.setNameComic(request.getParameter("Nombre"));
		com.setCompanyComic(request.getParameter("Comp"));
		com.setQuantityComic(CantComic);
		com.setReviewComic(request.getParameter("Review"));
		Integer Comicid = Integer.parseInt(request.getParameter("ComicId"));

		if (messages.isEmpty()) {
			if (Comicid == null || Comicid == 0) {
				dao.add(com);
			} else {
				com.setIdComic(Comicid);
				dao.update(com);
			}
			request.setAttribute("messages", messages);
			RequestDispatcher view = request.getRequestDispatcher(LIST_COMIC);
			request.setAttribute("comics", dao.getAll());
			view.forward(request, response);
		} else {
			com.setIdComic(Comicid);
			request.setAttribute("comic", com);
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("EditarComic.jsp?ComicId=" + Comicid).forward(request, response);
		}

	}

}
