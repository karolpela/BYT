package employees;

import interfaces.Visitor;

import java.time.LocalDate;

public class Kierownik extends Pracownik {
    public Kierownik(String imie, String nazwisko, char plec, String pesel,
                     LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                     LocalDate dataZwolnienia, String numerTelefonu,
                     String email, String numerKonta) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "Kierownik{}";
    }
}
