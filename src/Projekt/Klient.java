package Projekt;

public class Klient {
    private String nazwaKlienta;
    private double budzet;
    private boolean abonament;
    private Koszyk koszyk;
    //private List<Cena> ceny = new ArrayList<>();

    public Klient(String nazwaKlienta, double budzet, boolean abonament) {
        this.nazwaKlienta = nazwaKlienta;
        this.budzet = budzet;
        this.abonament = abonament;
        koszyk = new Koszyk(this);
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
}
