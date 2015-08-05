package com.dao;

import com.entity.Turler;
import com.entity.Yonetmenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TurDao {
    
    public String TurAdiGetir(int TId){
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="SELECT Adi FROM turler where TId=?"; 
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            psmt.setInt(1, TId);
            ResultSet rs=psmt.executeQuery();
            rs.next();    
            return (rs.getString("Adi"));
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Turler> ButunTurleriGetir(){
        
        ArrayList<Turler> turler=new ArrayList<>();
        Connection con=ConnectionManager.Getconnection();
        String Sorgu="select * from Turler";
        
        try {
            PreparedStatement psmt=con.prepareStatement(Sorgu);
            ResultSet rs=psmt.executeQuery();
            
            while (rs.next()) {                
                Turler t=new Turler(rs.getInt("TId"), rs.getString("Adi"));
                turler.add(t);
            }

        } catch (Exception ex) {
        } 
        return turler;
    }
}
