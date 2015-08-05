package com.dao;

import com.entity.Filmler;
import com.entity.Kullanici;
import com.entity.Turler;
import com.entity.Yonetmenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GirisDao {
    
    public Kullanici GirisYap(String KAdi,String Sifre){
        Connection con=ConnectionManager.Getconnection();
        String sorgu="SELECT * FROM kullanici where KAdi=? and Sifre=?";  
        Kullanici kullanici=null;
        try {
            PreparedStatement psmt=con.prepareStatement(sorgu);
            psmt.setString(1,KAdi);
            psmt.setString(2,Sifre);
            ResultSet rs=psmt.executeQuery();
            rs.next();    
            kullanici=new Kullanici(
                    rs.getInt("KId"),
                    rs.getString("KAdi"),
                    "",
                    rs.getString("Adi"),
                    rs.getString("Soyadi"));
        } catch (Exception e) {
        }
        return kullanici;
    }
}
