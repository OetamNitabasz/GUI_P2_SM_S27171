package Projekt;


enum SposobPlatnosci {
    KARTA,
    PRZELEW
}

public class Klient {
    private String nazwaKlienta;
    private boolean abonament;
    private Koszyk koszyk;
    private Portfel portfel;


    public Klient(String nazwaKlienta, double budzet, boolean abonament) {
        this.nazwaKlienta = nazwaKlienta;
        this.abonament = abonament;
        koszyk = new Koszyk(this);
        portfel = new Portfel(budzet);
    }

    ListaZyczen listaZyczen = new ListaZyczen(this);


    public void dodaj(Samochod samochod) {
        ustalKoszt(samochod);
        listaZyczen.dodaj(samochod);
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
        var zawartosc = listaZyczen.getListaZyczen();
        koszyk.wyczysc();
        zawartosc.stream()
                .forEach(s -> {
                    ustalKoszt(s);
                    if(s.getKoszt() != null)
                        koszyk.dodaj(s);
                });
        zawartosc.removeIf(s -> s.getKoszt() != null);
        return koszyk;
    }

    private void ustalKoszt(Samochod samochod) {
        var cennik = Cennik.pobierzCennik();
        var cena = cennik.cena(samochod);
        if(cena == null) {
            samochod.setKoszt(null);
            return;
        }
        var koszt = cena.kosztPrzejazdu(czyAbonamentowy(), samochod.getDystans());
        samochod.setKoszt(koszt);
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
        /*koszyk.getZawartosc()
                .stream()
                .filter(s -> s.getNazwaSamochodu().equals(nazwa) && s.getRodzaj() == typ)
                .findFirst()
                .ifPresent(s -> s.getKoszt().zwroc(km, portfel));*/
        var lista = koszyk.getZawartosc();
        for(int i = 0; i < lista.size(); i++) {
            var s = lista.get(i);
            if(s.getNazwaSamochodu().equals(nazwa) && s.getRodzaj() == typ) {
                s.getKoszt().zwroc(km, portfel);
                lista.remove(i);
                lista.add(s);
                break;
            }
        }
    }
}
