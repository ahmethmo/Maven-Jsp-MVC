package com.entity;

public class Yonetmenler {
    private int YId;
    private String Adi;

    public Yonetmenler() {
    }

    public Yonetmenler(int YId, String Adi) {
        this.YId = YId;
        this.Adi = Adi;
    }

    public int getYId() {
        return YId;
    }

    public void setYId(int YId) {
        this.YId = YId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }
    
    
}
