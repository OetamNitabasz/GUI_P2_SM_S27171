package Projekt;

public class Portfel {
    private double budzet;

    public Portfel(double budzet) {
        this.budzet = budzet;
    }

    public void przyjmij(double kwota) {
        budzet += kwota;
    }

    public void zaplac(SposobPlatnosci sposob, Koszyk koszyk) {
        if (budzet <= 0) {
            return;
        }
        var zamowienie = koszyk.getZawartosc();
        if (koszyk.sumaKoszyka() > budzet) {
            zamowienie.sort((o1, o2) ->
                    o1.getKoszt().sredniKosztKM().compareTo(o2.getKoszt().sredniKosztKM()));
        }

        for (Samochod s : zamowienie) {
            var koszt = s.getKoszt();
            budzet = koszt.zaplac(budzet, sposob);
            if (budzet <= 0)
                break;
        }
    }

    public String toString() {
        var wynik = String.format("%.2f", budzet);
        return wynik;
    }

}
