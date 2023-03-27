package employees;

import interfaces.Visitor;

import java.io.File;
import java.time.LocalDate;

public class Magazynier extends Pracownik {
    private final File licencjaNaWozekWidlowy;

    public Magazynier(String imie, String nazwisko, char plec, String pesel,
                      LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                      LocalDate dataZwolnienia, String numerTelefonu,
                      String email, String numerKonta, File licencjaNaWozekWidlowy) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
        this.licencjaNaWozekWidlowy = licencjaNaWozekWidlowy;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "Magazynier{" +
                "licencjaNaWozekWidlowy=" + licencjaNaWozekWidlowy +
                '}';
    }
}
