package com.entity;

public class Favoriler {
    private int FaId;
    private Kullanici Kullanic;
    private Favoriler favori;

    public Favoriler() {
    }

    public Favoriler(int FaId, Kullanici Kullanic, Favoriler favori) {
        this.FaId = FaId;
        this.Kullanic = Kullanic;
        this.favori = favori;
    }

    public int getFaId() {
        return FaId;
    }

    public void setFaId(int FaId) {
        this.FaId = FaId;
    }

    public Kullanici getKullanic() {
        return Kullanic;
    }

    public void setKullanic(Kullanici Kullanic) {
        this.Kullanic = Kullanic;
    }

    public Favoriler getFavori() {
        return favori;
    }

    public void setFavori(Favoriler favori) {
        this.favori = favori;
    }

    
}
