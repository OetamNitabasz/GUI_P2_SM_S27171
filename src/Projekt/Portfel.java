package Projekt;

public class Portfel {
    double budzet;

    public Portfel(double budzet) {
        this.budzet = budzet;
    }
    //budzet na czesc kwoty do zaplaty
    //przerwac petle jak budzet = 0
    //czesc kwoty, zaplac tyle ile mozesz za dane auto
    //czy mozna zmodyfikowac koszyk w forEach
    public void zaplac(SposobPlatnosci sposob, Koszyk koszyk) {
        if(budzet <= 0) {
            return;
        }
        for (Samochod s : koszyk.getZawartosc()) {
            var koszt = s.getKoszt();
            var kwotaDoZaplaty = sposob == SposobPlatnosci.KARTA
                    ? koszt.getCena() * 1.01
                    : koszt.getCena();
            if(budzet >= kwotaDoZaplaty) {
                budzet -= kwotaDoZaplaty;
                koszt.zaplacone();
            }
        }
    }

    public String toString() {
        var wynik = String.format("%.2f", budzet);
        return wynik;
    }

}
