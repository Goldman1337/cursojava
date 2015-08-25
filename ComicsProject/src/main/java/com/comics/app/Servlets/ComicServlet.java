package com.comics.app.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comics.app.Controller.*;
import com.comics.app.Model.Comic;

/**
 * Servlet implementation class ComicServlet
 */
@WebServlet("/ComicServlet")
public class ComicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/EditarComic.jsp";
	private static String LIST_COMIC="/ListaComics.jsp";
	private comicController dao;
    /**
     * Default constructor. 
     */
    public ComicServlet() {
        dao=new comicController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int ComicId = Integer.parseInt(request.getParameter("ComicId"));
			dao.delete(ComicId);
			forward=LIST_COMIC;
			request.setAttribute("comics",dao.getAll());
		} else if (action.equalsIgnoreCase("edit")){
			forward=INSERT_OR_EDIT;
			int ComicId = Integer.parseInt(request.getParameter("ComicId"));
			Comic com = dao.get(ComicId);
			request.setAttribute("comic",com);
		} else if(action.equalsIgnoreCase("listComic")){
			forward=LIST_COMIC;
			request.setAttribute("comics",dao.getAll());
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
		Comic com = new Comic();
		com.setNameComic(request.getParameter("Nombre"));
		com.setCompanyComic(request.getParameter("Comp"));
		com.setQuantityComic(Integer.parseInt(request.getParameter("Cantidad")));
		com.setReviewComic(request.getParameter("Review"));
		String Comicid = request.getParameter("ComicId");
		if(Comicid==null||Comicid.isEmpty()){
			dao.add(com);
		}
		else
		{
			com.setIdComic(Integer.parseInt(Comicid));
			dao.update(com);
		}
		RequestDispatcher view =request.getRequestDispatcher(LIST_COMIC);
		request.setAttribute("comics",dao.getAll());
		view.forward(request,response);
	}

}
