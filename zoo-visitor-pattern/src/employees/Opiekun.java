package employees;

import interfaces.Visitor;

import java.time.LocalDate;

public class Opiekun extends Pracownik {
    private final boolean czyStudent;
    private final String kierunekStudiow;
    private final LocalDate dataUkonczeniaStudiow;

    public Opiekun(String imie, String nazwisko, char plec, String pesel,
                   LocalDate dataUrodzenia, LocalDate dataZatrudnienia, LocalDate dataZwolnienia,
                   String numerTelefonu, String email, String numerKonta, boolean czyStudent,
                   String kierunekStudiow, LocalDate dataUkonczeniaStudiow) {
        super(imie, nazwisko, plec, pesel, dataUrodzenia, dataZatrudnienia,
                dataZwolnienia,
                numerTelefonu, email, numerKonta);
        this.czyStudent = czyStudent;
        this.kierunekStudiow = kierunekStudiow;
        this.dataUkonczeniaStudiow = dataUkonczeniaStudiow;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    public boolean czyStudent() {
        return czyStudent;
    }

    @Override
    public String toString() {
        return "Opiekun{" +
                "czyStudent=" + czyStudent +
                ", kierunekStudiow='" + kierunekStudiow + '\'' +
                ", dataUkonczeniaStudiow=" + dataUkonczeniaStudiow +
                '}';
    }
}
