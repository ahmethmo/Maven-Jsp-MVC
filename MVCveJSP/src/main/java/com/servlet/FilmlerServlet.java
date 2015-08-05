package com.servlet;

import com.dao.FilmDao;
import com.dao.TurDao;
import com.entity.Filmler;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filmler")
public class FilmlerServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Tur=Integer.valueOf(req.getParameter("TId"));
        ArrayList<Filmler> filmler=new FilmDao().TureAitFilmleriGetir(Tur);
        req.setAttribute("filmler", filmler);
        req.setAttribute("tur", new TurDao().TurAdiGetir(Tur));
        req.getRequestDispatcher("filmler.jsp").forward(req, resp);
    }
  
}
