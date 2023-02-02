package employees;

import documents.Faktura;
import interfaces.Visitor;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ksiegowy extends Pracownik {
    private final File dyplomUkonczeniaStudiow;
    private final List<Faktura> wystawioneFaktury;

    public Ksiegowy(String imie, String nazwisko, char plec, String pesel,
                    LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                    LocalDate dataZwolnienia
            , String numerTelefonu, String email, String numerKonta,
                    File dyplomUkonczeniaStudiow) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
        this.dyplomUkonczeniaStudiow = dyplomUkonczeniaStudiow;
        wystawioneFaktury = new ArrayList<>();
    }

    public List<Faktura> getWystawioneFaktury(int months) {
        return wystawioneFaktury
                .stream()
                .filter(f -> {
                    var monthsAgo = LocalDate.now().minusMonths(months);
                    return f.getDataWystawienia().isAfter(monthsAgo);
                })
                .toList();
    }

    public void wystawFakture(Pracownik p) {
        this.wystawioneFaktury.add(Faktura.dodaj(p));
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "Ksiegowy{" +
                "dyplomUkonczeniaStudiow=" + dyplomUkonczeniaStudiow +
                '}';
    }
}
