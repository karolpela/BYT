import java.time.LocalDate;
import java.util.List;

public class Zwierze {
    private String imie;
    private String krajPochodzenia;
    private LocalDate dataUrodzenia;
    private LocalDate dataSmierci;
    private String gromada;
    private String gatunek;

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
