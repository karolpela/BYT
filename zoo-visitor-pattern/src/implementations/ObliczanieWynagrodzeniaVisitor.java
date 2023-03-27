package implementations;

import employees.*;
import interfaces.Visitor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ObliczanieWynagrodzeniaVisitor implements Visitor<Float> {
    private static float wynagrodzeniePodstawowe;

    public ObliczanieWynagrodzeniaVisitor() {
        wynagrodzeniePodstawowe = Pracownik.getWynagrodzenie();
    }

    @Override
    public Float visit(Ksiegowy k) {
        float przelicznik = 1.1f;
        float premia = k.getWystawioneFaktury(1).size() * 25f;
        return wynagrodzeniePodstawowe * przelicznik + premia;
    }

    @Override
    public Float visit(Przewodnik p) {
        float premia = p.znaPolski() ? 300 : 0;
        return wynagrodzeniePodstawowe + premia;
    }

    @Override
    public Float visit(Opiekun o) {
        float przelicznik = 1.2f;
        float premia = o.czyStudent() ? -750 : 0;
        return wynagrodzeniePodstawowe * przelicznik + premia;
    }

    @Override
    public Float visit(Kierownik k) {
        float przelicznik = 2.0f;
        return wynagrodzeniePodstawowe * przelicznik;
    }

    @Override
    public Float visit(AsystentKierownika a) {
        float przelicznik = 1.5f;
        return wynagrodzeniePodstawowe * przelicznik;
    }

    @Override
    public Float visit(Weterynarz w) {
        float przelicznik = 1.3f;
        float premiaStaz = w.getStazPracyPozaZoo() * 150f;
        float premiaStopien = switch (w.getStopienNaukowy()) {
            case "Lekarz weterynarii" -> 0;
            case "Doktor" -> 250;
            case "Doktor habilitowany" -> 350;
            case "Profesor" -> 500;
            default -> 0;
        };
        float premiaSpecjalizacje =
                w.getSpecjalizacjeZoologiczne().size() * 150f;
        return wynagrodzeniePodstawowe * przelicznik
                + premiaStaz
                + premiaStopien
                + premiaSpecjalizacje;
    }

    @Override
    public Float visit(Magazynier m) {
        float premiaStaz = ChronoUnit.YEARS.between(
                m.getDataZatrudnienia(),
                LocalDate.now()
        ) * 150f;
        return wynagrodzeniePodstawowe + premiaStaz;
    }
}
