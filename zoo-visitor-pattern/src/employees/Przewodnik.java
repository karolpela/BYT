package employees;

import interfaces.Visitor;

import java.time.LocalDate;

public class Przewodnik extends Pracownik {
    private final boolean znaPolski;

    public Przewodnik(String imie, String nazwisko, char plec, String pesel,
                      LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                      LocalDate dataZwolnienia, String numerTelefonu,
                      String email,
                      String numerKonta,
                      boolean znaPolski) {
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

    @Override
    public String toString() {
        return "Przewodnik{" +
                "znaPolski=" + znaPolski +
                '}';
    }
}
