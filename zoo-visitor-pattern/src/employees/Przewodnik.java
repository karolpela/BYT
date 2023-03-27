package employees;

import interfaces.Visitor;
import misc.Wycieczka;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Przewodnik extends Pracownik {
    private final boolean znaPolski;

    public Przewodnik(String imie, String nazwisko, char plec, String pesel,
                      LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                      LocalDate dataZwolnienia, String numerTelefonu,
                      String email, String numerKonta, boolean znaPolski) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
        this.znaPolski = znaPolski;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    public boolean znaPolski() {
        return znaPolski;
    }

    private List<Wycieczka> wyswietlWycieczki(Date data) {
        return null;
    }

    @Override
    public String toString() {
        return "Przewodnik{" +
                "znaPolski=" + znaPolski +
                '}';
    }
}
