import documents.Faktura;
import documents.WniosekOUrlop;
import employees.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ksiegowy = new Ksiegowy("Jan", "Kowalski", 'm', "91092059261",
                LocalDate.parse(
                        "1991-09-20"), LocalDate.parse("2011-02-11"), null,
                "885396297", "jankowalski@zoo.com",
                "01983564428677113089075451", new File(
                "dyplom.pdf"));

        var przewodnik = new Przewodnik("Adam", "Kowalski", 'm', "93092059621"
                , LocalDate.parse(
                "1993-09-20"), LocalDate.parse("2012-01-16"), null,
                "632723562", "adamkowalski@zoo.com",
                "01356544472739530893230471", true);

        var opiekun = new Opiekun("Wacława", "Kowalska", 'k', "96092059621",
                LocalDate.parse(
                        "1996-09-20"), LocalDate.parse("2013-03-07"), null,
                "346734121", "waclawakowalska@zoo.com",
                "01466879193541054089317606", true,
                "zoologia", null);

        var kierownik = new Kierownik("Piotr", "Kowalski", 'm', "92092059621",
                LocalDate.parse(
                        "1992-09-20"), LocalDate.parse("2015-08-15"), null,
                "623166121", "piotrkowalski@zoo.com",
                "01674870511861974284728240");

        var asystent = new AsystentKierownika("Małgorzata", "Kowalska", 'k',
                "90092059621",
                LocalDate.parse(
                        "1990-09-20"), LocalDate.parse("2017-02-15"), null,
                "672235161", "malgorzatakowalska@zoo.com",
                "01820513706516531750049738");

        var specjalizacje = new ArrayList<String>();
        specjalizacje.add("ssaki");

        var weterynarz = new Weterynarz("Maurycy", "Kowalski", 'm',
                "89092059621"
                , LocalDate.parse(
                "1989-09-20"), LocalDate.parse("2011-05-09"), null,
                "834563245", "maurycykowalski@zoo.com",
                "01059552288634222536589016", 5, "Doktor",
                new File("dyplom.pdf"),
                specjalizacje);

        var magazynier = new Magazynier("Bartosz", "Kowalski", 'm',
                "98092059621"
                , LocalDate.parse(
                "1998-09-20"), LocalDate.parse("2020-05-23"), null,
                "521512616", "bartoszkowalski@zoo.com",
                "01450951057316397613037600", new File(
                "licencja.pdf"));

        var wszyscyPracownicy = List.of(przewodnik, opiekun, kierownik,
                asystent,
                weterynarz, magazynier, ksiegowy);


        System.out.println("\n--------------------Faktury--------------------\n");

        wszyscyPracownicy.forEach(ksiegowy::wystawFakture);

        for (Faktura f :
                ksiegowy.getWystawioneFaktury(1)) {
            System.out.println("\n" + f);
        }


        System.out.println("\n--------------------Urlopy--------------------\n");

        wszyscyPracownicy.forEach(
                p -> {
                    System.out.println(p + ":" + (WniosekOUrlop.dodajWniosekOUrlop(p,
                            LocalDate.parse("2023-06-06"),
                            LocalDate.parse("2023-06-26")) ? "SUKCES" : "BŁĄD"));
                    System.out.println();
                }
        );

    }
}