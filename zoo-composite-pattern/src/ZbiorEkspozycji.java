import java.util.ArrayList;
import java.util.List;
public class ZbiorEkspozycji implements Ekspozycja {
    private List<Ekspozycja> ekspozycje;
    private float powierzchniaPozaWybiegami;
    private float getPowierzchniaCalkowita() {return 0;}
    private RodzajZbioru rodzaj;
    private String opis;

    public void dodaj(Ekspozycja wezel) {
        ekspozycje.add(wezel);
    }

    public void usun(Ekspozycja wezel) {
        ekspozycje.remove(wezel);
    }

    public List<Ekspozycja> getEkspozycje() {
        return this.ekspozycje;
    }

    public ZbiorEkspozycji(float powierzchniaPozaWybiegami, RodzajZbioru rodzaj, String opis) {
        this.ekspozycje = new ArrayList<>();
        this.powierzchniaPozaWybiegami = powierzchniaPozaWybiegami;
        this.rodzaj = rodzaj;
        this.opis = opis;
    }

    @Override
    public float obliczIloscKarmy(int dni) {
        var iloscKarmy = 0f;
        for (Ekspozycja e : this.ekspozycje) {
            iloscKarmy += e.obliczIloscKarmy(dni);
        }
        return iloscKarmy;
    }
}
