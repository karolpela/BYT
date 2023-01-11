import java.util.List;
public class ZbiorEkspozycji implements Ekspozycja {
    private List<Ekspozycja> ekspozycje;
    private float powierzchniaPozaWybiegami;
    private float getPowierzchniaCalkowita() {return 0;};
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


    @Override
    public float obliczIloscKarmy(int dni) {
        var iloscKarmy = 0;
        for (Ekspozycja e : this.ekspozycje) {
            iloscKarmy += e.obliczIloscKarmy(dni);
        }
        return iloscKarmy;
    }
}
