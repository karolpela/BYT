import java.util.ArrayList;
import java.util.List;

public class Wybieg implements Ekspozycja {
    private int id;
    private String nazwa;
    private float powierzchnia;
    private boolean zakryty;
    private String typSrodowiska;
    private List<Zwierze> zwierzeta;

    public Wybieg(int id, String nazwa, float powierzchnia, boolean zakryty, String typSrodowiska) {
        this.id = id;
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




    // methods unrelated to the Composite pattern implementation
    public void przydzielOpiekuna(Opiekun opiekun) {}
    public void usunOpiekuna(Opiekun opiekun) {}
}
