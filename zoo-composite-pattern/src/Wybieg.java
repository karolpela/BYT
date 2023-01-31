import java.util.ArrayList;
import java.util.List;

public class Wybieg implements Sekcja {
    private final String nazwa;
    private final float powierzchnia;
    private final boolean zakryty;
    private final String typSrodowiska;
    private final List<Zwierze> zwierzeta;

    public Wybieg(String nazwa, float powierzchnia, boolean zakryty, String typSrodowiska) {
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.zakryty = zakryty;
        this.typSrodowiska = typSrodowiska;

        this.zwierzeta = new ArrayList<>();
    }

    public void addZwierze(Zwierze zwierze) {
        this.zwierzeta.add(zwierze);
    }

    @Override
    public float obliczIloscKarmy(int dni) {
        float iloscNaDzien = 0;
        for (Zwierze z : zwierzeta) {
            iloscNaDzien += z.getIloscKarmyNaDzien();
        }
        return  iloscNaDzien * dni;
    }

    // metody niezwiązane z implementacją wzorca Composite
    public void przydzielOpiekuna(Opiekun opiekun) {}
    public void usunOpiekuna(Opiekun opiekun) {}

    // do celów demonstracyjnych
    public void print(int level) {
        System.out.println("|" + "---".repeat(level) + this.nazwa);
    }

    @Override
    public void wypiszIloscKarmy(int dni) {
        System.out.println(this.nazwa + "\t-> Ilość karmy na " + dni + " dni:\t" +  this.obliczIloscKarmy(dni) + " kg");
    }

    public RodzajSekcji getRodzaj() {
        return RodzajSekcji.Wybieg;
    }
}
