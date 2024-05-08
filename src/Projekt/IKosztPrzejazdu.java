package Projekt;

import java.util.ArrayList;
import java.util.List;

interface IKosztPrzejazdu {

}
class KosztPrzejazdu implements IKosztPrzejazdu {
    private int dystans = -1;
    int progKilometrow = -1;
    double cenaZaProgiem = -1;
    double cena = 0;


    public KosztPrzejazdu(int dystans, double cenaPrzedProgiem, int progKilometrow, double cenaZaProgiem) {
        this.dystans = dystans;
        this.cena = cenaPrzedProgiem;
        this.progKilometrow = progKilometrow;
        this.cenaZaProgiem = cenaZaProgiem;

    }

    public KosztPrzejazdu(int dystans, double cena) {
        this.dystans = dystans;
        this.cena = cena;
    }

    public KosztPrzejazdu(int dystans) {
        this.dystans = dystans;
    }

    /*public IKosztPrzejazdu kosztPrzejazdu(List<Cena> pozycja) {
        if(pozycja.indexOf(4) == 0) {
            return ;
        }
    }
     */

    public String toString() {
        var wynik = new StringBuilder();
        wynik.append("ile: ").append(dystans).append(" km, cena ").append(cena);
        if(progKilometrow > -1) {
            wynik.append(" (do ").append(progKilometrow).append("), ").append(cenaZaProgiem).append(" (od ")
                    .append(progKilometrow + 1).append(")");
        }
        return wynik.toString();
        //dopracowac formatowanie double (dwa miejsca po przecinku)
    }


}
