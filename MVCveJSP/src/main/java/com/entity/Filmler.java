package com.entity;

public class Filmler {
    private int FId;
    private String Adi;
    private String Yili;
    private Yonetmenler Yonetmen;
    private Turler Tur;

    public Filmler() {
    }
    
     public Filmler(int FId, String Adi, String Yili) {
        this.FId = FId;
        this.Adi = Adi;
        this.Yili = Yili;
    }
    
    public Filmler(String Adi, String Yili, Yonetmenler Yonetmen, Turler Tur) {
        this.Adi = Adi;
        this.Yili = Yili;
        this.Yonetmen = Yonetmen;
        this.Tur=Tur;
    }
        
     
    public Filmler(int FId, String Adi, String Yili, Yonetmenler Yonetmen, Turler Tur) {
        this.FId = FId;
        this.Adi = Adi;
        this.Yili = Yili;
        this.Yonetmen = Yonetmen;
        this.Tur = Tur;
    }

    public int getFId() {
        return FId;
    }

    public void setFId(int FId) {
        this.FId = FId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    public String getYili() {
        return Yili;
    }

    public void setYili(String Yili) {
        this.Yili = Yili;
    }

    public Yonetmenler getYonetmen() {
        return Yonetmen;
    }

    public void setYonetmen(Yonetmenler Yonetmen) {
        this.Yonetmen = Yonetmen;
    }

    public Turler getTur() {
        return Tur;
    }

    public void setTur(Turler Tur) {
        this.Tur = Tur;
    }

    @Override
    public String toString() {
        return FId+"   "+Adi+"   "+Yili+"   "+Yonetmen.getAdi()+"   "+Tur.getAdi();
    }
    
    
}
