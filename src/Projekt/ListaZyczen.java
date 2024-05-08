package Projekt;

import java.util.ArrayList;
import java.util.List;

public class ListaZyczen {
    private List<Samochod> lista = new ArrayList<>();
    private Klient klient;

    public ListaZyczen(Klient klient) {
        this.klient = klient;
    }

    void dodaj(Samochod samochod) {
        lista.add(samochod);
        var cennik = Cennik.pobierzCennik();
        var cena = cennik.cena(samochod);
        if(cena == null) {
            return;
        }
       var koszt = cena.kosztPrzejazdu(klient.czyAbonamentowy(), samochod.getDystans());
        samochod.setKoszt(koszt);

    }

    public List<Samochod> getListaZyczen() {
        return lista;
    }

    public String toString() {
        var wynik = new StringBuilder();
        wynik.append(klient.getNazwaKlienta()).append(": ");
        for(Samochod samochod : lista) {
            wynik.append("\n").append(samochod);

        }
        return wynik.append("\n").toString();
    }
}
