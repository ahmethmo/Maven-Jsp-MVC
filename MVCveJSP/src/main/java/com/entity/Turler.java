package com.entity;

public class Turler {
    private int TId;
    private String Adi;

    public Turler() {
    }

    public Turler(int TId, String Adi) {
        this.TId = TId;
        this.Adi = Adi;
    }

    public int getTId() {
        return TId;
    }

    public void setTId(int TId) {
        this.TId = TId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    @Override
    public String toString() {
        return Adi;
    }
    
    
}
