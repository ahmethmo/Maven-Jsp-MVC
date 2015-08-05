package com.dao;

import com.entity.Filmler;
import com.entity.Kullanici;
import com.entity.Turler;
import com.entity.Yonetmenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FavoriDao {
    
    public boolean FavoriFilmEkle(int KId,int FId){
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="insert into favoriler (KId,FId) values (?,?)";
        try {
            PreparedStatement stmt= con.prepareStatement(Sorgu);      
            stmt.setInt(1, KId);
            stmt.setInt(2, FId);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean FavoriSil(int KId,int FId){
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="DELETE FROM favoriler WHERE KId=? and FId=?";
        try {
            PreparedStatement stmt= con.prepareStatement(Sorgu);
            stmt.setInt(1, KId);
            stmt.setInt(2, FId);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }  
    }
    
    public ArrayList<Filmler> FavoriFilmlerGetir(int KId){
        ArrayList<Filmler> filmler=new ArrayList<>();
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="select f.*,t.Adi as TAdi, y.Adi as YAdi from favoriler fav\n" +
                    "left join filmler f on f.FId=fav.FId\n" +
                    "inner join yonetmenler y on y.YId=f.YId\n" +
                    "inner join turler t on t.TId=f.TId\n" +
                    "where fav.KId=?";
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            psmt.setInt(1, KId);
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
    
        public boolean FavoriVarmiYokmu(int KId,int FId){
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="select count(*) as sayi from favoriler fav left join filmler f on f.FId=fav.FId where fav.KId=? and fav.FId=?";
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            psmt.setInt(1, KId);
            psmt.setInt(2, FId);
            ResultSet rs=psmt.executeQuery();  
            rs.next();
            if (rs.getInt("sayi")==1){
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
