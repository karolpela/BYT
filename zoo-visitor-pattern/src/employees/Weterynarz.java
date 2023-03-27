package employees;

import interfaces.Visitor;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Weterynarz extends Pracownik {
    private final int stazPracyPozaZoo;
    private final String stopienNaukowy;
    private final File dyplomUkonczeniaStudiow;
    private final List<String> specjalizacjeZoologiczne;

    public Weterynarz(String imie, String nazwisko, char plec, String pesel,
                      LocalDate dataUrodzenia, LocalDate dataZatrudnienia,
                      LocalDate dataZwolnienia, String numerTelefonu,
                      String email, String numerKonta, int stazPracyPozaZoo,
                      String stopienNaukowy, File dyplomUkonczeniaStudiow,
                      List<String> specjalizacjeZoologiczne) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
        this.stazPracyPozaZoo = stazPracyPozaZoo;
        this.stopienNaukowy = stopienNaukowy;
        this.dyplomUkonczeniaStudiow = dyplomUkonczeniaStudiow;
        this.specjalizacjeZoologiczne = specjalizacjeZoologiczne;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    public int getStazPracyPozaZoo() {
        return stazPracyPozaZoo;
    }

    public String getStopienNaukowy() {
        return stopienNaukowy;
    }

    public List<String> getSpecjalizacjeZoologiczne() {
        return specjalizacjeZoologiczne;
    }

    @Override
    public String toString() {
        return "Weterynarz{" +
                "stazPracy=" + stazPracyPozaZoo +
                ", stopienNaukowy='" + stopienNaukowy + '\'' +
                ", dyplomUkonczeniaStudiow=" + dyplomUkonczeniaStudiow +
                ", specjalizacjeZoologiczne=" + specjalizacjeZoologiczne +
                '}';
    }
}
