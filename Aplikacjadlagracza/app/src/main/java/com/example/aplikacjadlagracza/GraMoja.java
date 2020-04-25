package com.example.aplikacjadlagracza;

public class GraMoja extends Gra {
    private double cena;
    private double cenaJednejPartii;

    public GraMoja(int id, String nazwa, int liczbaPartii, int liczbaWygranych, double procentWygranych, double cena, double cenaJednejPartii) {
        super(id, nazwa, liczbaPartii, liczbaWygranych, procentWygranych);
        this.cena = cena;
        this.cenaJednejPartii = cenaJednejPartii;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCenaJednejPartii() {
        return cenaJednejPartii;
    }

    public void setCenaJednejPartii(double cenaJednejPartii) {
        this.cenaJednejPartii = cenaJednejPartii;
    }
}
