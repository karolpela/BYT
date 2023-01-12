import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ZasadyKarmienia {
    public static List<ZasadyKarmienia> ListaZasad = new ArrayList<>();

    private Zwierze zwierze;
    private Karma karma;
    private LocalTime godzinaKarmienia;
    private int iloscKarmy;

    public ZasadyKarmienia(Zwierze zwierze, Karma karma, LocalTime godzinaKarmienia, int iloscKarmy) {
        this.zwierze = zwierze;
        this.karma = karma;
        this.godzinaKarmienia = godzinaKarmienia;
        this.iloscKarmy = iloscKarmy;
    }

    public float getPrzeliczonaIloscNaDzien() {
        float przelicznik = this.karma.getPrzelicznik();
        return this.iloscKarmy * przelicznik;
    }
}
