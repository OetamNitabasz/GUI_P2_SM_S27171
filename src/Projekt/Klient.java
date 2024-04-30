package Projekt;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String id;
    private double budzet;
    private boolean abonament;

    public Klient(String id, double budzet, boolean abonament) {
        this.id = id;
        this.budzet = budzet;
        this.abonament = abonament;
    }
    ListaZyczen listaZyczen = new ListaZyczen();
    public void dodaj(Samochod samochod) {
        listaZyczen.dodaj(samochod);
                                    // nie dodawac dwa razy tych samych samochodow?
    }
    public ListaZyczen pobierzListeZyczen() {
        return listaZyczen;
    }
    public String getId() {
        return id;
    }
}
