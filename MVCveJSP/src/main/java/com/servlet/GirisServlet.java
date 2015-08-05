package com.servlet;

import com.dao.FavoriDao;
import com.dao.GirisDao;
import com.entity.Filmler;
import com.entity.Kullanici;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/giris")
public class GirisServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String KAdi=req.getParameter("kullaniciadi");
        String Sifre=req.getParameter("sifre");
        
        Kullanici kullanici=new GirisDao().GirisYap(KAdi, Sifre);
        
        
        
        
        if (kullanici != null) {
            ArrayList<Filmler> FavFilmler=new FavoriDao().FavoriFilmlerGetir(kullanici.getKId());
            req.getSession().setAttribute("KId", kullanici.getKId());
            req.getSession().setAttribute("KAdi", kullanici.getKAdi());
            req.getSession().setAttribute("Adi", kullanici.getAdi());
            req.getSession().setAttribute("Soyadi", kullanici.getSoyadı());
            req.getSession().setAttribute("favfilmler", FavFilmler);  
            //System.out.println(FavFilmler.get(1).getAdi());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            String mesaj="Kullanıcı adı yada şifre yanlış";
            req.setAttribute("mesaj", mesaj);
            req.getRequestDispatcher("giris.jsp").forward(req, resp);
        }
        
    }
    
}
