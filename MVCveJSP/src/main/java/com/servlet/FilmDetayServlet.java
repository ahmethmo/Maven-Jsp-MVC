/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet("/filmdetay")
public class FilmDetayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        int FId=Integer.parseInt(request.getParameter("FId"));
        Filmler film=new FilmDao().FilmGetir(FId);
        Integer KId=(Integer) request.getSession().getAttribute("KId");
        if (KId!=null){
            if (new FavoriDao().FavoriVarmiYokmu(KId, FId))
               request.setAttribute("favvar",1);
            else
               request.setAttribute("favvar",0);
        }else{  
            request.setAttribute("favvar",2);
        }
        request.setAttribute("film", film);
        request.getRequestDispatcher("filmdetay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
