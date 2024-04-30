package Projekt;

import java.util.ArrayList;
import java.util.List;

public class Cennik {

    private static Cennik cennik;

    private Cennik() {

    }

    static public Cennik pobierzCennik() {
        if(cennik == null) {
            cennik = new Cennik();
        }

        return cennik;
    }

    List<Cena> pozycje = new ArrayList<>();
     public void dodaj(int rodzaj, String nazwa, double cena) {
        dodaj(new Cena(rodzaj, nazwa, cena));
    }
    public void dodaj(int rodzaj, String nazwa, double cenaPrzedProgiem, double cenaZaProgiem, int progKilometrow) {
        // czemu robimy konstruktory a nie metodami zmieniamy cene
        dodaj(new Cena(rodzaj, nazwa, cenaPrzedProgiem, cenaZaProgiem, progKilometrow));

    }

    public void dodaj(int rodzaj, String nazwa, double cenaZAbonamentem, double cenaPrzedProgiem,
                      double cenaZaProgiem, int progKilometrow) {
         dodaj(new Cena(rodzaj, nazwa, cenaZAbonamentem, cenaPrzedProgiem, cenaZaProgiem, progKilometrow));
    }
    public void dodaj(int rodzaj, int progKilometrow, String nazwa) {
         dodaj(new Cena(rodzaj, nazwa, progKilometrow));
    }
    private void dodaj(Cena cena) {
        for(int i = 0; i < pozycje.size(); i++) {
            var temp = pozycje.get(i);
            if(temp.nazwa.compareTo(cena.nazwa) == 0 && temp.rodzaj == cena.rodzaj) {
                pozycje.set(i, cena);
                return;
            }
        }

        pozycje.add(cena);
    }

    // cennik mozna modyfikowac w dowolnym momemncie

}
