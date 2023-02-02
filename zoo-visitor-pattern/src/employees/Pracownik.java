package employees;

import documents.Faktura;
import interfaces.Visitor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class Pracownik {
    private static final int dniUrlopowe = 20;
    private static final float wynagrodzenie = 4500;

    private final String imie;
    private final String nazwisko;
    private final char plec;
    private final String pesel;
    private final LocalDate dataUrodzenia;
    private final LocalDate dataZatrudnienia;
    private final LocalDate dataZwolnienia;
    private final String numerTelefonu;
    private final String email;
    private final String numerKonta;

    private final List<Faktura> faktury;

    public Pracownik(String imie, String nazwisko, char plec, String pesel,
                     LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                     LocalDate dataZwolnienia, String numerTelefonu,
                     String email,
                     String numerKonta) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.dataZatrudnienia = dataZatrudnienia;
        this.dataZwolnienia = dataZwolnienia;
        this.numerTelefonu = numerTelefonu;
        this.email = email;
        this.numerKonta = numerKonta;

        this.faktury = new ArrayList<>();
    }

    public static float getWynagrodzenie() {
        return wynagrodzenie;
    }

    public abstract <T> T accept(Visitor<T> v);

    public void dodajFakture(Faktura f) {
        this.faktury.add(f);
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public int obliczWiek() {
        return 0;
    }

    public int obliczPozostaleDniUrlopowe() {
        return 0;
    }

    public void dodajWniosekOUrlop() {
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec=" + plec +
                ", pesel='" + pesel + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", dataZwolnienia=" + dataZwolnienia +
                ", numerTelefonu='" + numerTelefonu + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
