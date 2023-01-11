import java.util.Date;
import java.util.List;

public class Zwierze {
    private String imie;
    private String krajPochodzenia;
    private Date dataUrodzenia;
    private Date dataSmierci;
    private String gromada;
    private String gatunek;

    public float getIloscKarmyNaDzien() {
        return 0;
    }




    // methods unrelated to the Composite pattern implementation
    public void wyswietlInformacje() {}
    public List<Raport> wyswietlKarteZwierzecia() { return null; }
    public List<Raport> wyswietlPodsumowanieKartyZwierzecia() { return null; }
    public void dodajRaport() {}
}
