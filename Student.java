public class Student {
    private String imie;
    private String nazwisko;
    private int nrIndeksu;

    public Student(String imie, String nazwisko, int nrIndeksu, int ikonka) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        this.ikonka = ikonka;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }
    public int getIkonka() {
        return ikonka;
    }

    public void setIkonka(int ikonka) {
        this.ikonka = ikonka;
    }
}
