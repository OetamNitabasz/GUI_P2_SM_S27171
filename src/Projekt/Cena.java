package Projekt;


public class Cena {
    int rodzaj;
    public String nazwa;
    public double cenaZAbonamentem = -1;
    public double cenaPrzedProgiem = -1;
    public double cenaZaProgiem = -1;
    public double cenaStala = -1;
    public int progKilometrow = -1;
    public boolean darmowy = false;



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
        darmowy = true;
    }
    private Cena(int rodzaj, String nazwa) {
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }
    public Cena(int rodzaj, String nazwa, double cena) {
        this(rodzaj, nazwa);
        this.cenaStala = cena;
        this.rodzaj = rodzaj;
        this.nazwa = nazwa;
    }
    public Cena(int rodzaj, String nazwa, double cenaPrzedProgiem, double cenaZaProgiem, int progKilometrow) {
        this(rodzaj, nazwa);
        this.cenaPrzedProgiem = cenaPrzedProgiem;
        this.cenaZaProgiem = cenaZaProgiem;
        this.progKilometrow = progKilometrow;
    }


    public IKosztPrzejazdu kosztPrzejazdu(boolean abonament, int dystans) {
        //wylicz koszt

        if(abonament && cenaZAbonamentem > -1) {
             return new KosztPrzejazdu(dystans, cenaZAbonamentem);
        }
        if(cenaStala > -1) {
            return new KosztPrzejazdu(dystans, cenaStala);
        }
        if(darmowy) {
         return new KosztPrzejazdu(Math.min(dystans, progKilometrow));
        }
        return new KosztPrzejazdu(dystans, cenaPrzedProgiem, progKilometrow, cenaZaProgiem);
    }
}
/*if(abonament == false && dystans > progKilometrow) {
            var wynik = dystans * cenaZaProgiem;
        } else if(abonament == true) {
            var wynik = dystans * cenaZAbonamentem;
        } else if(abonament == false && dystans < progKilometrow) {
            var wynik = dystans * cenaPrzedProgiem;
        }
         */