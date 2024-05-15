package Projekt;

import java.util.ArrayList;
import java.util.List;

enum SposobPlatnosci {
    KARTA,
    PRZELEW
}

public class Klient {
    private String nazwaKlienta;
    private boolean abonament;
    private Koszyk koszyk;
    private Cennik cennik;
    private Portfel portfel;


    public Klient(String nazwaKlienta, double budzet, boolean abonament) {
        this.nazwaKlienta = nazwaKlienta;
        this.abonament = abonament;
        koszyk = new Koszyk(this);
        this.cennik = Cennik.pobierzCennik();
        portfel = new Portfel(budzet);
    }

    ListaZyczen listaZyczen = new ListaZyczen(this);


    public void dodaj(Samochod samochod) {
        listaZyczen.dodaj(samochod);
        // nie dodawac dwa razy tych samych samochodow?
    }

    public ListaZyczen pobierzListeZyczen() {
        return listaZyczen;
    }


    public String getNazwaKlienta() {
        return nazwaKlienta;
    }

    public Koszyk pobierzKoszyk() {
        return koszyk;
    }

    public Koszyk przepakuj() {
        koszyk.przepakuj(listaZyczen);
        return koszyk;
    }
    public boolean czyAbonamentowy() {
        return abonament;
    }

    public void zaplac(SposobPlatnosci sposob) {
        portfel.zaplac(sposob, koszyk);
    }

    public Portfel pobierzPortfel() {
        return portfel;
    }

    public void zwroc(int typ, String nazwa, int km) {
        koszyk.getZawartosc()
                .stream()
                .filter(s -> s.getNazwaSamochodu().equals(nazwa) && s.getRodzaj() == typ)
                .findFirst()
                .ifPresent(s -> s.getKoszt().zwroc(km, portfel));
    }

}
