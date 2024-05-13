package Projekt;

abstract class Samochod {
    private String nazwaSamochodu;
    private int dystans;
    private int rodzaj;
    private IKosztPrzejazdu koszt;

    public Samochod(String nazwaSamochodu, int dystans, int rodzaj) {
        this.dystans = dystans;
        this.nazwaSamochodu = nazwaSamochodu;
        this.rodzaj = rodzaj;
    }

    public int getRodzaj() {
        return rodzaj;
    }
    public String getNazwaSamochodu() {
        return nazwaSamochodu;
    }

    public String toString() {
        var nazwaRodzaju = switch (rodzaj) {
            case 1 -> "zabytkowy";
            case 2 ->  "osobowy";
            case 3 -> "dostawczy";
            case 4 -> "darmowy";
            default -> "inny";
        };
        String wynik;
        if(koszt != null) {
             wynik = String.format("%s, typ: %s, %s", nazwaSamochodu, nazwaRodzaju, koszt);
        } else {
             wynik = String.format("%s, typ: %s, ile: %d, ceny brak", nazwaSamochodu, nazwaRodzaju, dystans);
        }
        return wynik;
    }
    public int getDystans() {
        return dystans;
    }
    public void setKoszt(IKosztPrzejazdu koszt) {
        this.koszt = koszt;
    }

    public IKosztPrzejazdu getKoszt() {
        return koszt;
    }

}
