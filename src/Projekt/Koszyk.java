package Projekt;

import java.sql.ClientInfoStatus;
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
        //System.out.println(koszyk.size());
        listaZyczen.getListaZyczen()
                .removeIf(s -> s.getKoszt() != null);
    }

    public double sumaKoszyka() {
        var suma = koszyk.stream()
                .mapToDouble(s -> s.getKoszt().getCena())
                .sum();
        return suma;
    }

    /*var suma = koszyk.stream()
            .map(s -> s.getKoszt().getCena())
            .reduce(0.0, Double::sum);*/

   /* public void wyczysc() {
        koszyk.removeIf(s -> s.getKoszt().nieoplaconyDystans() <= 0);
    }*/

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
        boolean pusto = true;
        for (Samochod samochod : koszyk) {
            if(samochod.getKoszt().nieoplaconyDystans() > 0) {
                wynik.append("\n").append(samochod);
                pusto = false;
            }
        }
        if(pusto) {
            wynik.append("-- pusto");
        }
        return wynik.append("\n").toString();
    }
}

