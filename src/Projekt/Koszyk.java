package Projekt;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Koszyk {

    private List<Samochod> koszyk = new ArrayList<>();
    private Klient klient;


    public Koszyk(Klient klient) {
        this.klient = klient;
    }

    public void przepakuj(ListaZyczen listaZyczen) {
        koszyk.clear();
        for (Samochod s : listaZyczen.getListaZyczen()) {
            koszyk.add(s);
        }
    }

    public String toString() {
        var wynik = new StringBuilder();
        for(Samochod samochod : koszyk) {
            wynik.append(samochod).append("\n");
        }
        return wynik.toString();
    }
}

