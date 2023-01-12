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

        // Listy zwierzat //

        var zwierzeta = new ArrayList<Zwierze>();
        Collections.addAll(zwierzeta, bobr1, bobr2, bobr3, zebra, zyrafa);

        // Karma //
        var karmaDlaBobrow = new Karma(
                "Karma dla bobrów europejskich",
                "kg",
                "Bóbr europejski",
                40,
                2);
        var karmaDlaZebr = new Karma(
                "Karma dla zebr stepowych",
                "kg",
                "Zebra stepowa",
                40,
                3.40f); // ilosc 2
        var karmaDlaZyraf = new Karma(
                "Karma dla żyraf masajskich",
                "kg",
                "Żyrafa masajska",
                80,
                7); // ilosc 5

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

        ZasadyKarmienia.ListaZasad.addAll(zwierzeta
                .stream()
                .map(Zwierze::getZasadyKarmienia)
                .toList()
        );

        // Ekspozycje //

        // Wybiegi
        var wybiegBobrow = new Wybieg(
                1,
                "Wybieg bobrów",
                80,
                false,
                "Wodno-lądowe"
        );
        var wybiegZebry = new Wybieg(
                2,
                "Wybieg zebry",
                100,
                false,
                "Step"
        );
        var wybiegZyrafy = new Wybieg(
                3,
                "Wybieg żyrafy",
                120,
                false,
                "Step"
        );

        wybiegBobrow.addZwierze(bobr1);
        wybiegBobrow.addZwierze(bobr2);
        wybiegBobrow.addZwierze(bobr3);
        wybiegZebry.addZwierze(zebra);
        wybiegZyrafy.addZwierze(zyrafa);

        // Alejki
        var alejkaZebr = new ZbiorEkspozycji(
                20,
                RodzajZbioru.Alejka,
                "Alejka zebr");
        alejkaZebr.dodaj(wybiegZebry); // Ekspozycja interface

        // Pawilony
        var pawilonStepowy = new ZbiorEkspozycji(
                40,
                RodzajZbioru.Pawilon,
                "Pawilon stepowy"
        );
        pawilonStepowy.dodaj(alejkaZebr); // Ekspozycja interface
        pawilonStepowy.dodaj(wybiegZyrafy); // Ekspozycja interface

        // Strefy
        var strefaAfrykanska = new ZbiorEkspozycji(
                300,
                RodzajZbioru.Strefa,
                "Strefa afrykańska"
        );
        strefaAfrykanska.dodaj(pawilonStepowy);

        // Ogród zoologiczny
        var ogrodZoologiczny = new ZbiorEkspozycji(     // normalnie raczej singleton
                3500,
                RodzajZbioru.OgrodZoologiczny,
                "Ogród zoologiczny"
        );

        ogrodZoologiczny.dodaj(strefaAfrykanska);
        ogrodZoologiczny.dodaj(wybiegBobrow);

        System.out.println("Ilość karmy dla wybiegu bobrów na 1 dzień: " + wybiegBobrow.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla wybiegu zebr na 1 dzień: " + wybiegZebry.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla wybiegu żyrafy na 1 dzień: " + wybiegZyrafy.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla alejki zebr na 1 dzień: " + alejkaZebr.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla pawilonu stepowego na 1 dzień: " + pawilonStepowy.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla strefy afrykańskiej na 1 dzień: " + strefaAfrykanska.obliczIloscKarmy(1));
        System.out.println("Ilość karmy dla ogrodu zoologicznego na 1 dzień: " + ogrodZoologiczny.obliczIloscKarmy(1));
    }
}