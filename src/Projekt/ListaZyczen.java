package Projekt;

import java.util.ArrayList;
import java.util.List;

public class ListaZyczen {
    private List<Samochod> lista = new ArrayList<>();
    void dodaj(Samochod samochod) {
        lista.add(samochod);
    }
    public String toString() {
        var wynik = new StringBuilder();
        for(Samochod samochod : lista) {
            wynik.append(samochod).append("\n");
        }
        return wynik.toString();

    }
}
