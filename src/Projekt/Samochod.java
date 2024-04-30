package Projekt;

abstract class Samochod {
    private String nazwaSamochodu;
    private int dystans;
    private int rodzaj;

    public Samochod(String nazwaSamochodu, int dystans, int rodzaj) {
        this.dystans = dystans;
        this.nazwaSamochodu = nazwaSamochodu;
        this.rodzaj = rodzaj;
    }
    public String toString() {
        var nazwaRodzaju = switch (rodzaj) {
            case 1 -> "zabytkowy";
            case 2 ->  "osobowy";
            case 3 -> "dostawczy";
            case 4 -> "darmowy";
            default -> "inny";
        };
        String wynik = String.format("%s, typ: %s, ile: %d km", nazwaSamochodu, nazwaRodzaju, dystans);
        return wynik;
    }
}
