package Projekt;

interface IKosztPrzejazdu {
    double getCena();
    void zaplacone();
}
class KosztPrzejazdu implements IKosztPrzejazdu {
    private int dystans = -1;
    private int progKilometrow = -1;
    private double cenaZaProgiem = -1;
    private double cena = 0;
    private boolean zaplacony = false;


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

    public double getCena() {
        var wartosc = dystans * cena;
        if(progKilometrow > -1) {
            if(dystans < progKilometrow) {
                return wartosc;
            }
            wartosc = progKilometrow * cena;
            wartosc += (dystans - progKilometrow) * cenaZaProgiem;
        }
        return wartosc;
        //zoptyamiluzj kod
    }

    public void zaplacone() {
        zaplacony = true;
    }

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
