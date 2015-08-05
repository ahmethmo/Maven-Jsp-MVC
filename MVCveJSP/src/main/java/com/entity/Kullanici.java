package com.entity;

public class Kullanici {
    private int KId;
    private String KAdi;
    private String Sifre;
    private String Adi;
    private String Soyadı;

    public Kullanici() {
    }

    public Kullanici(int KId, String KAdi, String Sifre, String Adi, String Soyadı) {
        this.KId = KId;
        this.KAdi = KAdi;
        this.Sifre = Sifre;
        this.Adi = Adi;
        this.Soyadı = Soyadı;
    }

    public int getKId() {
        return KId;
    }

    public void setKId(int KId) {
        this.KId = KId;
    }

    public String getKAdi() {
        return KAdi;
    }

    public void setKAdi(String KAdi) {
        this.KAdi = KAdi;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String Sifre) {
        this.Sifre = Sifre;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    public String getSoyadı() {
        return Soyadı;
    }

    public void setSoyadı(String Soyadı) {
        this.Soyadı = Soyadı;
    }
    
    
}
