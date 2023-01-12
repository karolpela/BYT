import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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
                140,
                false,
                "Step"
        );
        var wybiegPawianow = new Wybieg(
                "Wybieg pawianów",
                90,
                false,
                "Dżungla"
        );
        var wybiegMakakow = new Wybieg(
                "Wybieg makaków",
                80,
                false,
                "Dżungla"
        );
        var wybiegi = List.of(wybiegBobrow, wybiegZebry, wybiegZyrafy, wybiegPawianow, wybiegMakakow);

        // Alejki
        var alejkaZebr = new ZbiorEkspozycji(
                20,
                RodzajZbioru.Alejka,
                "Alejka zebr");
        alejkaZebr.dodaj(wybiegZebry); // Interface Ekspozycja

        var alejkaMalp = new ZbiorEkspozycji(
                35,
                RodzajZbioru.Alejka,
                "Alejka małp");
        alejkaMalp.dodaj(wybiegPawianow);
        alejkaMalp.dodaj(wybiegMakakow);
        var alejki = List.of(alejkaMalp, alejkaZebr);

        // Pawilony
        var pawilonStepowy = new ZbiorEkspozycji(
                40,
                RodzajZbioru.Pawilon,
                "Pawilon stepowy"
        );
        pawilonStepowy.dodaj(alejkaZebr); // Interface Ekspozycja
        pawilonStepowy.dodaj(wybiegZyrafy); // Interface Ekspozycja

        // Strefy
        var strefaAfrykanska = new ZbiorEkspozycji(
                300,
                RodzajZbioru.Strefa,
                "Strefa afrykańska"
        );
        strefaAfrykanska.dodaj(pawilonStepowy); // Interface Ekspozycja
        strefaAfrykanska.dodaj(alejkaMalp); // Interface Ekspozycja

        // Ogród zoologiczny
        var ogrodZoologiczny = new ZbiorEkspozycji(     // W praktyce raczej Singleton
                3000,
                RodzajZbioru.OgrodZoologiczny,
                "Ogród zoologiczny"
        );

        ogrodZoologiczny.dodaj(strefaAfrykanska); // Interface Ekspozycja
        ogrodZoologiczny.dodaj(wybiegBobrow); // Interface Ekspozycja

        System.out.println("=== Schemat ogrodu zoologicznego ===");
        ogrodZoologiczny.print(0);
        System.out.println();

        var wszystkieEkspozycje = new ArrayList<Ekspozycja>();
        wszystkieEkspozycje.addAll(wybiegi);
        wszystkieEkspozycje.addAll(alejki);
        wszystkieEkspozycje.add(pawilonStepowy);
        wszystkieEkspozycje.add(strefaAfrykanska);
        wszystkieEkspozycje.add(ogrodZoologiczny);

        for (Ekspozycja e : wszystkieEkspozycje) {
            if (e instanceof  Wybieg) {
                System.out.println(((Wybieg) e).getNazwa() + "\t-> Powierzchnia całkowita:\t" +  e.obliczPowierzchnieCalkowita());
            } else {
                System.out.println(((ZbiorEkspozycji)e).getOpis() + "\t-> Powierzchnia całkowita:\t" +  e.obliczPowierzchnieCalkowita()
                        + "\t (Poza wybiegami: " + ((ZbiorEkspozycji) e).getPowierzchniaPozaWybiegami() + ")");
            }
        }
    }
}