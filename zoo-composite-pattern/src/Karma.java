public class Karma {
    private final String nazwa;
    private final String jednostka;
    private final String dlaGatunku;
    private final float iloscZapasu;
    private final float przelicznik;

    public Karma(String nazwa, String jednostka, String dlaGatunku, float iloscZapasu, float przelicznik) {
        this.nazwa = nazwa;
        this.jednostka = jednostka;
        this.dlaGatunku = dlaGatunku;
        this.iloscZapasu = iloscZapasu;
        this.przelicznik = przelicznik;
    }

    public String getJednostka() {
        return jednostka;
    }

    public float getPrzelicznik() {
        return przelicznik;
    }
}
