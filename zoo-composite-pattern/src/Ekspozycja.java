import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Ekspozycja implements FragmentZoo {
    private List<FragmentZoo> ekspozycje;
    private float powierzchniaPozaWybiegami;
    private float getPowierzchniaCalkowita() {return 0;}
    private RodzajEkspozycji rodzaj;
    private String opis;

    public void dodaj(FragmentZoo wezel) {
        ekspozycje.add(wezel);
    }

    public void usun(FragmentZoo wezel) {
        ekspozycje.remove(wezel);
    }

    public List<FragmentZoo> getEkspozycje() {
        return this.ekspozycje;
    }

    public Ekspozycja(float powierzchniaPozaWybiegami, RodzajEkspozycji rodzaj, String opis) {
        this.ekspozycje = new ArrayList<>();
        this.powierzchniaPozaWybiegami = powierzchniaPozaWybiegami;
        this.rodzaj = rodzaj;
        this.opis = opis;
    }

    @Override
    public float obliczIloscKarmy(int dni) {
        var iloscKarmy = 0f;
        for (FragmentZoo e : this.ekspozycje) {
            iloscKarmy += e.obliczIloscKarmy(dni);
        }
        return iloscKarmy;
    }

    // Do celów demonstracyjnych
    public void print(int level) {
        System.out.println("|" + "---".repeat(level) + this.opis);
        level++;
        this.ekspozycje.sort(Comparator.comparing(FragmentZoo::getRodzaj));
        for (FragmentZoo f : this.ekspozycje) {
            f.print(level);
        }
    }

    @Override
    public void wypiszIloscKarmy(int dni) {
        System.out.println(this.opis + "\t-> Ilość karmy na " + dni + " dni:\t" +  this.obliczIloscKarmy(dni) + " kg");
    }

    @Override
    public RodzajEkspozycji getRodzaj() {
        return this.rodzaj;
    }

}
