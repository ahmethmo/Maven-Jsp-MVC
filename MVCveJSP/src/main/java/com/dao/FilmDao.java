package com.dao;

import com.entity.Filmler;
import com.entity.Turler;
import com.entity.Yonetmenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class FilmDao {
    
    public boolean YeniFilmKayet(Filmler YeniFilm){
        
        Connection con=ConnectionManager.Getconnection();
        try {   
            
            String Sorgu="insert into filmler (Adi,Yili,YId,TId) values (?,?,?,?)";
            PreparedStatement stmt= con.prepareStatement(Sorgu);      
            stmt.setString(1, YeniFilm.getAdi());           
            stmt.setString(2, YeniFilm.getYili());
            stmt.setInt(3, YeniFilm.getYonetmen().getYId());
            stmt.setInt(4, YeniFilm.getTur().getTId());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public ArrayList<Filmler> TümFilmleriGetir(){
        ArrayList<Filmler> filmler=new ArrayList<>();
        Connection con=ConnectionManager.Getconnection();
        try {   
            String Sorgu="select f.FId, f.Adi, f.Yili, y.YId,Y.Adi as YAdi, t.TId,t.Adi as TAdi from filmler f \n" +
            "inner join yonetmenler y on f.YId=y.YId \n" +
            "inner join turler t on f.TId=t.TId";
            Statement stmt= con.createStatement();
            ResultSet rs = stmt.executeQuery(Sorgu);

            while (rs.next()) {    
                Yonetmenler y=new Yonetmenler(rs.getInt("YId"), rs.getString("YAdi"));
                Turler t=new Turler(rs.getInt("TId"), rs.getString("TAdi"));
                Filmler f = new Filmler(rs.getInt("Fıd"), rs.getString("Adi"),rs.getString("Yili"), y, t);
                filmler.add(f);
            }  
        } catch (Exception ex) {}
      return filmler;
    }

        public Filmler FilmGetir(int FId){
        Filmler f = null;
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="select f.FId, f.Adi, f.Yili, y.YId,Y.Adi as YAdi, t.TId,t.Adi as TAdi from filmler f \n" +
            "inner join yonetmenler y on f.YId=y.YId \n" +
            "inner join turler t on f.TId=t.TId where f.FId=?";
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            psmt.setInt(1, FId);
            ResultSet rs=psmt.executeQuery();
            rs.next();    
            Yonetmenler y=new Yonetmenler(rs.getInt("YId"), rs.getString("YAdi"));
            Turler t=new Turler(rs.getInt("TId"), rs.getString("TAdi"));
            f = new Filmler(rs.getInt("Fıd"), rs.getString("Adi"),rs.getString("Yili"), y, t);
        } catch (Exception ex) {
        }
        return f;
    }
    
    public ArrayList<Filmler> TureAitFilmleriGetir(int TId){
        ArrayList<Filmler> filmler=new ArrayList<>();
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="select f.FId, f.Adi, f.Yili, y.YId,Y.Adi as YAdi, t.TId,t.Adi as TAdi from filmler f \n" +
            "inner join yonetmenler y on f.YId=y.YId \n" +
            "inner join turler t on f.TId=t.TId where f.TId=?";
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            psmt.setInt(1, TId);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()) {    
                Yonetmenler y=new Yonetmenler(rs.getInt("YId"), rs.getString("YAdi"));
                Turler t=new Turler(rs.getInt("TId"), rs.getString("TAdi"));
                Filmler f = new Filmler(rs.getInt("Fıd"), rs.getString("Adi"),rs.getString("Yili"), y, t);
                filmler.add(f);
            } 
        } catch (Exception ex) {
        }
        return filmler;
    }
}
