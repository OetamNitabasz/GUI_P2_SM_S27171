package Projekt;

//1. lublin null. Ma wypisac dystans i cena
//2. Wyliczyc koszt w Cena.
//3. Koszt odpowiednio wypisac.

public class CarshareTest {
    static final int ZABYTKOWY = 1;
    static final int OSOBOWY = 2;
    static final int DOSTAWCZY = 3;
    static final int DARMO = 4;
   /* static int cena(Koszyk k, String markaSamochodu){
    }
    */

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
    }
}


