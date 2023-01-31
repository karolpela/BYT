import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Zwierzeta //
        var bobr1 = new Zwierze("John",
                "Wielka Brytania",
                LocalDate.parse("2012-01-02"),
                null,
                "ssaki",
                "Bóbr europejski",
                null);
        var bobr2 = new Zwierze("Jack",
                "Wielka Brytania",
                LocalDate.parse("2012-01-02"),
                null,
                "ssaki",
                "Bóbr europejski",
                null);
        var bobr3 = new Zwierze("Jerry",
                "Wielka Brytania",
                LocalDate.parse("2012-01-02"),
                null,
                "ssaki",
                "Bóbr europejski",
                null);

        var zebra = new Zwierze("Marty",
                "Stany Zjednoczone",
                LocalDate.parse("2008-07-14"),
                null,
                "ssaki",
                "Zebra stepowa",
                null);

        var zyrafa = new Zwierze("Melman",
                "Stany Zjednoczone",
                LocalDate.parse("2006-03-11"),
                null,
                "ssaki",
                "Żyrafa masajska",
                null);

        var pawian = new Zwierze("Borys",
                "Gwinea",
                LocalDate.parse("2006-03-11"),
                null,
                "ssaki",
                "Pawian gwinejski",
                null);

        var makak = new Zwierze("Bartosz",
                "Stany Zjednoczone",
                LocalDate.parse("2006-03-11"),
                null,
                "ssaki",
                "Żyrafa masajska",
                null);

        // Listy zwierzat //

        var zwierzeta = new ArrayList<Zwierze>();
        Collections.addAll(zwierzeta, bobr1, bobr2, bobr3, zebra, zyrafa);

        // Karma //
        var karmaDlaBobrow = new Karma(
                "Karma dla bobrów europejskich",
                "kg",
                "Bóbr europejski",
                40,
                1.5f);
        var karmaDlaZebr = new Karma(
                "Karma dla zebr stepowych",
                "kg",
                "Zebra stepowa",
                40,
                1.5f); // ilosc 2
         var karmaDlaZyraf = new Karma(
                "Karma dla żyraf masajskich",
                "kg",
                "Żyrafa masajska",
                80,
                7.0f); // ilosc 5
        var karmaDlaPawianow = new Karma(
                "Karma dla pawianów gwinejskich",
                "kg",
                "Pawian gwinejski",
                70,
                0.5f); // ilosc 4
        var karmaDlaMakakow = new Karma(
                "Karma dla makaków orientalnych",
                "kg",
                "Makak orientalny",
                75,
                0.5f); // ilosc 3
        // Zasady karmienia //

        bobr1.setZasadyKarmienia(new ZasadyKarmienia(
                bobr1,
                karmaDlaBobrow,
                LocalTime.parse("08:40:00"),
                1
        ));
        bobr2.setZasadyKarmienia(new ZasadyKarmienia(
                bobr1,
                karmaDlaBobrow,
                LocalTime.parse("08:40:00"),
                1
        ));
        bobr3.setZasadyKarmienia(new ZasadyKarmienia(
                bobr1,
                karmaDlaBobrow,
                LocalTime.parse("08:40:00"),
                1
        ));
        zebra.setZasadyKarmienia(new ZasadyKarmienia(
                zebra,
                karmaDlaZebr,
                LocalTime.parse("12:40:00"),
                2
        ));
        zyrafa.setZasadyKarmienia(new ZasadyKarmienia(
                zyrafa,
                karmaDlaZyraf,
                LocalTime.parse("09:00:00"),
                5
        ));
        pawian.setZasadyKarmienia(new ZasadyKarmienia(
                pawian,
                karmaDlaPawianow,
                LocalTime.parse("09:30:00"),
                4
        ));
        makak.setZasadyKarmienia(new ZasadyKarmienia(
                makak,
                karmaDlaMakakow,
                LocalTime.parse("09:15:00"),
                3
        ));


        ZasadyKarmienia.ListaZasad.addAll(zwierzeta
                .stream()
                .map(Zwierze::getZasadyKarmienia)
                .toList()
        );

        // -- Ekspozycje -- //

        // Wybiegi
        var wybiegBobrow = new Wybieg(
                "Wybieg bobrów",
                80,
                false,
                "Wodno-lądowe"
        );
        var wybiegZebry = new Wybieg(
                "Wybieg zebry",
                100,
                false,
                "Step"
        );
        var wybiegZyrafy = new Wybieg(
                "Wybieg żyrafy",
                120,
                false,
                "Step"
        );
        var wybiegPawiana = new Wybieg(
                "Wybieg pawiana",
                60,
                true,
                "Dżungla"
        );
        var wybiegMakaka= new Wybieg(
                "Wybieg makaka",
                70,
                true,
                "Dżungla"
        );

        wybiegBobrow.addZwierze(bobr1);
        wybiegBobrow.addZwierze(bobr2);
        wybiegBobrow.addZwierze(bobr3);
        wybiegZebry.addZwierze(zebra);
        wybiegZyrafy.addZwierze(zyrafa);
        wybiegPawiana.addZwierze(pawian);
        wybiegMakaka.addZwierze(makak);

        var wybiegi = List.of(wybiegBobrow, wybiegZebry, wybiegZyrafy, wybiegPawiana, wybiegMakaka);


        // Alejki
        var alejkaZebr = new Ekspozycja(
                20,
                RodzajSekcji.Alejka,
                "Alejka zebr");
        alejkaZebr.dodaj(wybiegZebry);

        var alejkaMalp = new Ekspozycja(
                50,
                RodzajSekcji.Alejka,
                "Alejka małp"
        );
        alejkaMalp.dodaj(wybiegPawiana);
        alejkaMalp.dodaj(wybiegMakaka);

        var alejki = List.of(alejkaMalp, alejkaZebr);

        // Pawilony
        var pawilonStepowy = new Ekspozycja(
                40,
                RodzajSekcji.Pawilon,
                "Pawilon stepowy"
        );
        pawilonStepowy.dodaj(alejkaZebr);
        pawilonStepowy.dodaj(wybiegZyrafy);

        // Strefy
        var strefaAfrykanska = new Ekspozycja(
                300,
                RodzajSekcji.Strefa,
                "Strefa afrykańska"
        );
        strefaAfrykanska.dodaj(pawilonStepowy);
        strefaAfrykanska.dodaj(alejkaMalp);

        // Ogród zoologiczny
        var ogrodZoologiczny = new Ekspozycja(
                3500,
                RodzajSekcji.OgrodZoologiczny,
                "Ogród zoologiczny"
        );

        ogrodZoologiczny.dodaj(strefaAfrykanska);
        ogrodZoologiczny.dodaj(wybiegBobrow);


        var wszystkieSekcje = new ArrayList<Sekcja>();
        wszystkieSekcje.addAll(wybiegi);
        wszystkieSekcje.addAll(alejki);
        wszystkieSekcje.add(pawilonStepowy);
        wszystkieSekcje.add(strefaAfrykanska);
        wszystkieSekcje.add(ogrodZoologiczny);

        // -- Demonstracja -- //

        System.out.println();
        System.out.println("=== Schemat ogrodu zoologicznego ===");
        ogrodZoologiczny.print(0);
        System.out.println();

        System.out.println("=== Przykład: ilość karmy na 4 dni ===");

        wszystkieSekcje.forEach(
                sekcja -> sekcja.wypiszIloscKarmy(4)
        );

    }
}