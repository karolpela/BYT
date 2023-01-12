import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ZbiorEkspozycji implements Ekspozycja {
    private final List<Ekspozycja> ekspozycje;
    private final float powierzchniaPozaWybiegami;
    private final RodzajZbioru rodzaj;
    private final String opis;

    public ZbiorEkspozycji(float powierzchniaPozaWybiegami, RodzajZbioru rodzaj, String opis) {
        this.ekspozycje = new ArrayList<>();
        this.powierzchniaPozaWybiegami = powierzchniaPozaWybiegami;
        this.rodzaj = rodzaj;
        this.opis = opis;
    }

    ///////// Composite ////////
    public void dodaj(Ekspozycja wezel) {
        ekspozycje.add(wezel);
    }
    public void usun(Ekspozycja wezel) {
        ekspozycje.remove(wezel);
    }

    public List<Ekspozycja> getEkspozycje() {
        return this.ekspozycje;
    }
    public String getOpis() {
        return opis;
    }

    @Override
    public float obliczPowierzchnieCalkowita() {
        var powierzchniaCalkowita = powierzchniaPozaWybiegami;
        for (Ekspozycja e : this.ekspozycje) {
            powierzchniaCalkowita += e.obliczPowierzchnieCalkowita();
        }
        return powierzchniaCalkowita;
    }
    ///////////////////////////

    public float getPowierzchniaPozaWybiegami() {
        return powierzchniaPozaWybiegami;
    }

    public RodzajZbioru getRodzaj() {
        return rodzaj;
    }

    // Do celów demonstracyjnych
    public void print(int level) {
        System.out.println("|" + "--".repeat(level) + this.opis);
        level++;
        this.ekspozycje.sort(Comparator.comparing(Ekspozycja::getRodzaj));
        for (Ekspozycja e : this.ekspozycje) {
            e.print(level);
        }
    }
}
