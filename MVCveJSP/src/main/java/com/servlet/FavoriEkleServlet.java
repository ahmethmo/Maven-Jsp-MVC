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

@WebServlet("/favoriekle")
public class FavoriEkleServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int FId=Integer.parseInt(req.getParameter("FId"));
        Filmler f=new FilmDao().FilmGetir(FId);
        int KId=(Integer) req.getSession().getAttribute("KId");
        if (new FavoriDao().FavoriFilmEkle(KId, FId)){
            ArrayList<Filmler> FavFilmler=new FavoriDao().FavoriFilmlerGetir(KId);
            req.getSession().setAttribute("favfilmler", FavFilmler);  
            req.setAttribute("film", f);
            req.getRequestDispatcher("filmdetay.jsp").forward(req, resp);
        }

        
        /*
        Filmler f=new FilmDao().FilmGetir(Fid);
        ArrayList<Filmler> favoriler=new ArrayList<>();
        if (req.getSession().getAttribute("favoriler")!=null){
            favoriler=(ArrayList<Filmler>) req.getSession().getAttribute("favoriler");
        }
        favoriler.add(f);
        req.getSession().setAttribute("favoriler", favoriler);
        req.setAttribute("film", f);
        req.getRequestDispatcher("filmdetay.jsp").forward(req, resp);*/
    }
    
    
}
