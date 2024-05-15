package Projekt;

//1. lublin null. Ma wypisac dystans i cena
//2. Wyliczyc koszt w Cena.
//3. Koszt odpowiednio wypisac.
import static Projekt.SposobPlatnosci.*;

public class CarshareTest {
    static final int ZABYTKOWY = 1;
    static final int OSOBOWY = 2;
    static final int DOSTAWCZY = 3;
    static final int DARMO = 4;
    static double cena(Koszyk k, String markaSamochodu){
       var wartosc = k.getZawartosc()
                .stream()
                .filter(s -> s.getNazwaSamochodu() == markaSamochodu)
                .map(s -> s.getKoszt().getCena())
                .reduce(0.0, Double::sum);
       return wartosc;
    }

    public static void main(String[] args) {
        Cennik cennik = Cennik.pobierzCennik();
        cennik.dodaj(OSOBOWY, "Syrena", 1.5, 2.5, 1.85, 100);  // 1.5 zł za 1 km jeśli klient posiada abonament,
        // w przeciwnym przypadku: 2.5 zł za 1 km (do 100 km), 1.85 zł za 1 km (od 101-ego kilometra)

        cennik.dodaj(DOSTAWCZY, "Żuk", 3, 4, 150);	// 4 zł za 1 km (do 150 km),
        // 3 zł za 1 km (od 151-tego kilometra)

        cennik.dodaj(ZABYTKOWY, "Ford T", 10);		// 10 zł za 1 km


        cennik.dodaj(DARMO, 50, "Tuk-Tuk");		// darmowy przejazd tylko dla abonentów (do 50 km)

        Klient f1 = new Klient("f1", 900, true);

        f1.dodaj(new Osobowy("Syrena", 80));
        f1.dodaj(new Dostawczy("Żuk", 200));
        f1.dodaj(new Zabytkowy("Lublin", 30));
        f1.dodaj(new Darmo("Tuk-Tuk", 60));

        ListaZyczen listaF1 = f1.pobierzListeZyczen();

        System.out.println("Lista życzeń klienta " + listaF1);

        Koszyk koszykF1 = f1.pobierzKoszyk();
        f1.przepakuj();

        // Co jest na liście życzeń klienta f1
        System.out.println("Po przepakowaniu, lista życzeń klienta " + f1.pobierzListeZyczen());

        // Co jest w koszyku klienta f1
        System.out.println("Po przepakowaniu, koszyk klienta " + koszykF1);

        // Ile wynosi cena wszystkich samochodów typu osobowego w koszyku klienta f1
        System.out.println("Samochody Syrena w koszyku klienta f1 kosztowały:  " + cena(koszykF1, "Syrena"));

        // Klient zapłaci...
        f1.zaplac(KARTA);	// płaci kartą płatniczą, prowizja 1%

        // Ile klientowi f1 zostało pieniędzy?
        System.out.println("Po zapłaceniu, klientowi f1 zostało: " + f1.pobierzPortfel() + " zł");

        // Mogło klientowi zabraknąć srodków, wtedy, opcjonalnie, samochody/kilometry mogą być odkładane,
        // w przeciwnym przypadku, koszyk jest pusty po zapłaceniu
        System.out.println("Po zapłaceniu, koszyk klienta " + f1.pobierzKoszyk());
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykF1);

        // Teraz przychodzi klient dakar,
        // deklaruje 850 zł na zamówienia
        Klient dakar = new Klient("dakar", 850, false);

        // Zamówił za dużo jak na tę kwotę
        dakar.dodaj(new Dostawczy("Żuk", 100));
        dakar.dodaj(new Zabytkowy("Ford T", 50));

        // Co klient dakar ma na swojej liście życzeń
        System.out.println("Lista życzeń klienta " + dakar.pobierzListeZyczen());

        Koszyk koszykDakar = dakar.pobierzKoszyk();
        dakar.przepakuj();

        // Co jest na liście życzeń klienta dakar
        System.out.println("Po przepakowaniu, lista życzeń klienta " + dakar.pobierzListeZyczen());

        // A co jest w koszyku klienta dakar
        System.out.println("Po przepakowaniu, koszyk klienta " + dakar.pobierzKoszyk());

        // klient dakar płaci
        dakar.zaplac(PRZELEW);	// płaci przelewem, bez prowizji

        // Ile klientowi dakar zostało pieniędzy?
        System.out.println("Po zapłaceniu, klientowi dakar zostało: " + dakar.pobierzPortfel() + " zł");

        // Co zostało w koszyku klienta dakar (za mało pieniędzy miał)
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykDakar);

        dakar.zwroc(DOSTAWCZY, "Żuk", 50);	// zwrot (do koszyka) 50 km dostawczego "Żuka" z ostatniej transakcji

        // Ile klientowi dakar zostało pieniędzy?
        System.out.println("Po zwrocie, klientowi dakar zostało: " + dakar.pobierzPortfel() + " zł");

        // Co zostało w koszyku klienta dakar
        System.out.println("Po zwrocie, koszyk klienta " + koszykDakar);
    }
}


