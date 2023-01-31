import java.time.LocalDate;
import java.util.List;

public class Zwierze {
    private final String imie;
    private final String krajPochodzenia;
    private final LocalDate dataUrodzenia;
    private final LocalDate dataSmierci;
    private final String gromada;
    private final String gatunek;

    private ZasadyKarmienia zasadyKarmienia;

    public Zwierze(String imie, String krajPochodzenia, LocalDate dataUrodzenia, LocalDate dataSmierci, String gromada, String gatunek, ZasadyKarmienia zasadyKarmienia) {
        this.imie = imie;
        this.krajPochodzenia = krajPochodzenia;
        this.dataUrodzenia = dataUrodzenia;
        this.dataSmierci = dataSmierci;
        this.gromada = gromada;
        this.gatunek = gatunek;
        this.zasadyKarmienia = zasadyKarmienia;
    }

    public float getIloscKarmyNaDzien() {
        return zasadyKarmienia.getPrzeliczonaIloscNaDzien();
    }

    public ZasadyKarmienia getZasadyKarmienia() {
        return zasadyKarmienia;
    }
    public void setZasadyKarmienia(ZasadyKarmienia zasadyKarmienia) {
        this.zasadyKarmienia = zasadyKarmienia;
    }

    // metody niezwiązane z implementacją wzorca Composite
    public void wyswietlInformacje() {}
    public List<Raport> wyswietlKarteZwierzecia() { return null; }
    public List<Raport> wyswietlPodsumowanieKartyZwierzecia() { return null; }
    public void dodajRaport() {}
}
