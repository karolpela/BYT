import unimplemented.Opiekun;
import unimplemented.Zwierze;

import java.util.ArrayList;
import java.util.List;

public class Wybieg implements Ekspozycja {
    private final String nazwa;
    private final float powierzchnia;
    private final boolean zakryty;
    private final String typSrodowiska;
    private final List<Zwierze> zwierzeta;
    private final List<Opiekun> opiekunowie;



    public Wybieg(String nazwa, float powierzchnia, boolean zakryty, String typSrodowiska) {
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.zakryty = zakryty;
        this.typSrodowiska = typSrodowiska;

        this.zwierzeta = new ArrayList<>();
        this.opiekunowie = new ArrayList<>();
    }

    ///////// Composite ////////
    @Override
    public float obliczPowierzchnieCalkowita() {
        return powierzchnia;
    }
    ///////////////////////////

    public String getNazwa() {
        return nazwa;
    }

    // metody niezwiązane z wzorcem Composite
    public void przydzielOpiekuna(Opiekun opiekun) {
        this.opiekunowie.add(opiekun);
    }
    public void usunOpiekuna(Opiekun opiekun) {
        this.opiekunowie.remove(opiekun);
    }

    // do celów demonstracyjnych
    public void print(int level) {
        System.out.println("|" + "--".repeat(level) + this.nazwa);
    }
    public RodzajZbioru getRodzaj() {
        return RodzajZbioru.Wybieg;
    }
}
