package com.servlet;

import com.dao.FavoriDao;
import com.dao.FilmDao;
import com.entity.Filmler;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filmcikar")
public class FilmCıkarServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int FId=Integer.parseInt(req.getParameter("FId"));
        int KId=(int) req.getSession().getAttribute("KId");
        if (new FavoriDao().FavoriSil(KId, FId)){
             ArrayList<Filmler> FavFilmler=new FavoriDao().FavoriFilmlerGetir(KId);
            req.getSession().setAttribute("favfilmler", FavFilmler);  
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }  
    }
    
}
