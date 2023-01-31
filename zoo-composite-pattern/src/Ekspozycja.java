import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Ekspozycja implements Sekcja {
    private final List<Sekcja> sekcje;
    private final float powierzchniaPozaWybiegami;
    private float getPowierzchniaCalkowita() {return 0;}
    private final RodzajSekcji rodzaj;
    private final String opis;

    public void dodaj(Sekcja wezel) {
        sekcje.add(wezel);
    }

    public void usun(Sekcja wezel) {
        sekcje.remove(wezel);
    }

    public List<Sekcja> getSekcje() {
        return this.sekcje;
    }

    public Ekspozycja(float powierzchniaPozaWybiegami, RodzajSekcji rodzaj, String opis) {
        this.sekcje = new ArrayList<>();
        this.powierzchniaPozaWybiegami = powierzchniaPozaWybiegami;
        this.rodzaj = rodzaj;
        this.opis = opis;
    }

    @Override
    public float obliczIloscKarmy(int dni) {
        var iloscKarmy = 0f;
        for (Sekcja e : this.sekcje) {
            iloscKarmy += e.obliczIloscKarmy(dni);
        }
        return iloscKarmy;
    }

    // Do celów demonstracyjnych
    public void print(int level) {
        System.out.println("|" + "---".repeat(level) + this.opis);
        level++;
        this.sekcje.sort(Comparator.comparing(Sekcja::getRodzaj));
        for (Sekcja f : this.sekcje) {
            f.print(level);
        }
    }

    @Override
    public void wypiszIloscKarmy(int dni) {
        System.out.println(this.opis + "\t-> Ilość karmy na " + dni + " dni:\t" +  this.obliczIloscKarmy(dni) + " kg");
    }

    @Override
    public RodzajSekcji getRodzaj() {
        return this.rodzaj;
    }

}
