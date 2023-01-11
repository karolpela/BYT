import java.time.LocalTime;

public class ZasadyKarmienia {
    private Zwierze zwierze;
    private Karma karma;
    private LocalTime godzinaKarmienia;
    private int iloscKarmy;
    private String jednostka;

    public ZasadyKarmienia(Zwierze zwierze, Karma karma, LocalTime godzinaKarmienia, int iloscKarmy) {
        this.zwierze = zwierze;
        this.karma = karma;
        this.godzinaKarmienia = godzinaKarmienia;
        this.iloscKarmy = iloscKarmy;
        this.jednostka = karma.getJednostka();
    }
}
