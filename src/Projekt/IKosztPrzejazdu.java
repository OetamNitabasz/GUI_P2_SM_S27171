package Projekt;

interface IKosztPrzejazdu {
    double getCena();
    Double sredniKosztKM();
    double zaplac(double kwota, SposobPlatnosci sposob);
    int nieoplaconyDystans();
    void zwroc(int km, Portfel portfel);
}
class KosztPrzejazdu implements IKosztPrzejazdu {
    private int dystans = -1;
    private int progKilometrow = -1;
    private double cenaZaProgiem = -1;
    private double cena = 0;
    private int zaplaconyDystans = 0;


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


    public Double sredniKosztKM() {
        var wynik = getCena() / dystans;
        return wynik;
    }

    public void zwroc(int km, Portfel portfel) {
        if(progKilometrow < 0)
    }

    public double zaplac(double budzet, SposobPlatnosci sposob) {
        var kosztCalkowity = sposob == SposobPlatnosci.KARTA ? getCena() * 1.01 : getCena();
        if(budzet >= kosztCalkowity) {
            zaplaconyDystans = dystans;
            var reszta = budzet - kosztCalkowity;
            return reszta;
        }
        var c = sposob == SposobPlatnosci.KARTA ? cena * 1.01 : cena;
        if(progKilometrow < 0) {
            zaplaconyDystans = (int) (Math.floor(budzet / c));
            var zaplaconaKwota = zaplaconyDystans * c;
            return budzet - zaplaconaKwota;
        } else {
            var kwotaDoProgu = progKilometrow * c;
            if(budzet < kwotaDoProgu) {
                zaplaconyDystans = (int) Math.floor(budzet / c);
                var zaplaconaKwota = zaplaconyDystans * c;
                return budzet - zaplaconaKwota;
            } else {
                var c2 = sposob == SposobPlatnosci.KARTA ? cenaZaProgiem * 1.01 : cenaZaProgiem;
               var reszta = budzet - kwotaDoProgu;
               var dystansZaProgeim = (int) Math.floor(reszta / c2);
               var zaplaconaKwota = dystansZaProgeim * c2;
               zaplaconyDystans = dystansZaProgeim + progKilometrow;
               return kwotaDoProgu + zaplaconaKwota;
            }
        }
    }

    public int nieoplaconyDystans() {
        return dystans - zaplaconyDystans;
    }

    /*public void*/

    public String toString() {
        var wynik = new StringBuilder();
        wynik.append("ile: ").append(nieoplaconyDystans()).append(" km, cena ").append(cena);
        if(dystans > progKilometrow && progKilometrow > -1) {
            wynik.append(" (do ").append(progKilometrow).append("), ").append(cenaZaProgiem).append(" (od ")
                    .append(progKilometrow + 1).append(")");
        }
        return wynik.toString();
        //dopracowac formatowanie double (dwa miejsca po przecinku)
    }


}
