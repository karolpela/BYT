package implementations;

import employees.*;
import interfaces.Visitor;
import misc.Urlop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TypUrlopuVisitor implements Visitor<Urlop> {

    private static final int podstawowaDlugosc = 14;

    public static int getStazWLatach(Pracownik p) {
        return (int) ChronoUnit.YEARS.between(
                p.getDataZatrudnienia(),
                LocalDate.now()
        );
    }

    @Override
    public Urlop visit(Ksiegowy k) {
        int bonus = getStazWLatach(k) / 2;
        return new Urlop(podstawowaDlugosc + bonus, "Pracowniczy");
    }

    @Override
    public Urlop visit(Przewodnik p) {
        int bonus = getStazWLatach(p) / 2;
        return new Urlop(podstawowaDlugosc + bonus, "Pracowniczy");
    }

    @Override
    public Urlop visit(Opiekun o) {
        int bonus = o.czyStudent() ? 14 : 0;
        return new Urlop(podstawowaDlugosc + bonus, "Opiekuna");
    }

    @Override
    public Urlop visit(Kierownik k) {
        // Kierownik nie potrzebuje składać podania o urlop,
        // przysługuje mu dowolna ilość dni wolnych od pracy
        return null;
    }

    @Override
    public Urlop visit(AsystentKierownika a) {
        int bonus = getStazWLatach(a) / 2 + 5;
        return new Urlop(podstawowaDlugosc + bonus, "Asystencki");
    }

    @Override
    public Urlop visit(Weterynarz w) {
        int bonus = w.getStazPracyPozaZoo()
                + switch (w.getStopienNaukowy()) {
            case "Lekarz weterynarii" -> 0;
            case "Doktor" -> 2;
            case "Doktor habilitowany" -> 3;
            case "Profesor" -> 4;
            default -> 0;
        };
        return new Urlop(podstawowaDlugosc + bonus, "Weterynarza");
    }

    @Override
    public Urlop visit(Magazynier m) {
        return new Urlop(podstawowaDlugosc, "Nieuprzywilejowany");
    }
}
