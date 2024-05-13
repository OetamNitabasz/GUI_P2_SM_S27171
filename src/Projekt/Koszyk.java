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
        listaZyczen.getListaZyczen()
                .stream()
                .filter(s -> s.getKoszt() != null)
                .forEach(s -> koszyk.add(s));
        listaZyczen.getListaZyczen()
                .removeIf(s -> s.getKoszt() != null);
    }

    public List<Samochod> getZawartosc() {
        return koszyk;
    }
    /*
    for (Samochod s : listaZyczen.getListaZyczen()) {
            if(cennik.cena(s) != null)
                koszyk.add(s);
        }
     */


    public String toString() {
            var wynik = new StringBuilder();
            wynik.append(klient.getNazwaKlienta()).append(": ");
            for(Samochod samochod : koszyk) {
                wynik.append("\n").append(samochod);

            }
            return wynik.append("\n").toString();
    }
}

