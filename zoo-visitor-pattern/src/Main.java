import documents.Faktura;
import employees.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ksiegowy = new Ksiegowy("Jan", "Kowalski", 'm', "32250959814",
                LocalDate.parse(
                        "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01983564428677113089075451", new File(
                "dyplom.pdf"));

        var przewodnik = new Przewodnik("Jan", "Kowalski", 'm', "32250959814"
                , LocalDate.parse(
                "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01356544472739530893230471", true);

        var opiekun = new Opiekun("Jan", "Kowalski", 'm', "32250959814",
                LocalDate.parse(
                        "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01466879193541054089317606", true,
                "zoologia", null);

        var kierownik = new Kierownik("Jan", "Kowalski", 'm', "32250959814",
                LocalDate.parse(
                        "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01674870511861974284728240");

        var asystent = new AsystentKierownika("Jan", "Kowalski", 'm',
                "32250959814",
                LocalDate.parse(
                        "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01820513706516531750049738");


        var specjalizacje = new ArrayList<String>();
        specjalizacje.add("ssaki");

        var weterynarz = new Weterynarz("Jan", "Kowalski", 'm', "32250959814"
                , LocalDate.parse(
                "1991-09-20"), LocalDate.parse("2011-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01059552288634222536589016", 5, "Doktor",
                new File("dyplom.pdf"),
                specjalizacje);

        var magazynier = new Magazynier("Jan", "Kowalski", 'm', "32250959814"
                , LocalDate.parse(
                "1991-09-20"), LocalDate.parse("2020-05-23"), null,
                "885396297", "jankowalski@zoo.com",
                "01450951057316397613037600", new File(
                "licencja.pdf"));

        var wszyscyPracownicy = List.of(przewodnik, opiekun, kierownik,
                asystent,
                weterynarz, magazynier, ksiegowy);

        wszyscyPracownicy.forEach(ksiegowy::wystawFakture);

        for (Faktura f :
                ksiegowy.getWystawioneFaktury(1)) {
            System.out.println("\n" + f);
        }
    }
}