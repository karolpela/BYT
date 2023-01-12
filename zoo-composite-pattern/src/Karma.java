public class Karma {
    private String nazwa;
    private String jednostka;
    private String dlaGatunku;
    private float iloscZapasu;
    private float przelicznik;

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
