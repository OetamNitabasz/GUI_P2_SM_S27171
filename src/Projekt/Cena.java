package Projekt;

public class Cena {
    int rodzaj;
    public String nazwa;

    double cenaZAbonamentem = -1;
    double cenaPrzedProgiem = -1;
    double cenaZaProgiem = -1;
    double cenaStala = -1;
    int progKilometrow = -1;
    public Cena(int rodzaj, String nazwa, double cenaZAbonamentem, double cenaPrzedProgiem,
                double cenaZaProgiem, int progKilometrow) {
        this(rodzaj, nazwa);
        this.cenaZAbonamentem = cenaZAbonamentem;
        this.cenaPrzedProgiem = cenaPrzedProgiem;
        this.cenaZaProgiem = cenaZaProgiem;
        this.progKilometrow = progKilometrow;



    }
    public Cena(int rodzaj, String nazwa, int progKilometrow) {
        this(rodzaj, nazwa);
        this.progKilometrow = progKilometrow;
    }
    private Cena(int rodzaj, String nazwa) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }
    public Cena(int rodzaj, String nazwa, double cenaStala) {
        this(rodzaj, nazwa);
        this.cenaStala = cenaStala;
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }
    public Cena(int rodzaj, String nazwa, double cenaPrzedProgiem, double cenaZaProgiem, int progKilometrow) {
        this(rodzaj, nazwa);
        this.cenaPrzedProgiem = cenaPrzedProgiem;
        this.cenaZaProgiem = cenaZaProgiem;
        this.progKilometrow = progKilometrow;
    }
}
