package Projekt;

import java.util.ArrayList;
import java.util.List;

public class Koszyk {

    private List<Samochod> koszyk = new ArrayList<>();
    private Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
    }

    public void wyczysc() {
        koszyk.clear();
    }

    public void dodaj(Samochod samochod) {
        koszyk.add(samochod);
    }

    public double sumaKoszyka() {
        var suma = koszyk.stream()
                .mapToDouble(s -> s.getKoszt().getCena())
                .sum();
        return suma;
    }

    public List<Samochod> getZawartosc() {
        return koszyk;
    }

    public String toString() {
        var wynik = new StringBuilder();
        wynik.append(klient.getNazwaKlienta()).append(": ");
        boolean pusto = true;
        for (Samochod samochod : koszyk) {
            if (samochod.getKoszt().nieoplaconyDystans() > 0) {
                wynik.append("\n").append(samochod);
                pusto = false;
            }
        }
        if (pusto) {
            wynik.append("-- pusto");
        }
        return wynik.append("\n").toString();
    }
}

