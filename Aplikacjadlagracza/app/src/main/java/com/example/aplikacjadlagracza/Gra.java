package com.example.aplikacjadlagracza;

public class Gra {
    private int id;
    private String nazwa;
    private int liczbaPartii;
    private int liczbaWygranych;
    private double procentWygranych;

    public Gra(int id, String nazwa, int liczbaPartii, int liczbaWygranych, double procentWygranych) {
        this.id = id;
        this.nazwa = nazwa;
        this.liczbaPartii = liczbaPartii;
        this.liczbaWygranych = liczbaWygranych;
        this.procentWygranych = procentWygranych;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczbaPartii() {
        return liczbaPartii;
    }

    public void setLiczbaPartii(int liczbaPartii) {
        this.liczbaPartii = liczbaPartii;
    }

    public int getLiczbaWygranych() {
        return liczbaWygranych;
    }

    public void setLiczbaWygranych(int liczbaWygranych) {
        this.liczbaWygranych = liczbaWygranych;
    }

    public double getProcentWygranych() {
        return procentWygranych;
    }

    public void setProcentWygranych(double procentWygranych) {
        this.procentWygranych = procentWygranych;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
