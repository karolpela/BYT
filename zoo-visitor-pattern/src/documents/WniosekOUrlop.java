package documents;


import employees.Pracownik;
import implementations.TypUrlopuVisitor;
import misc.Urlop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class WniosekOUrlop {
    private final LocalDate dataPoczatku;
    private final LocalDate dataKonca;
    private final Urlop typUrlopu;

    public WniosekOUrlop(LocalDate dataPoczatku, LocalDate dataKonca, Urlop typUrlopu) {
        this.dataPoczatku = dataPoczatku;
        this.dataKonca = dataKonca;
        this.typUrlopu = typUrlopu;
    }

    public Urlop getTypUrlopu() {
        return typUrlopu;
    }

    public int obliczDlugoscUrlopu() {
        return (int) ChronoUnit.DAYS.between(dataPoczatku, dataKonca);
    }

    public static boolean dodajWniosekOUrlop(Pracownik p, LocalDate dataPoczatku,
                                             LocalDate dataKonca) {
        var typUrlopuVisitor = new TypUrlopuVisitor();
        var wniosekOUrlop = new WniosekOUrlop(
                dataPoczatku,
                dataKonca,
                p.accept(typUrlopuVisitor));

        if (wniosekOUrlop.getTypUrlopu() == null) {
            System.out.println("Nie można dodać wniosku: Brak przewidzianego typu urlopu.");
            return false;
        }

        if (wniosekOUrlop.obliczDlugoscUrlopu() > wniosekOUrlop.getMaksymalnaDlugosc()) {
            System.out.println("Nie można dodać wniosku: podana długość urlopu jest dłuższa od " +
                    "maksymalnej długości urlopu.");
            return false;
        }

        if (wniosekOUrlop.obliczDlugoscUrlopu() > p.getPozostaleDniUrlopu()) {
            System.out.println("Nie można dodać wniosku: podana długosć urlopu jest dłuższa niż " +
                    "pozostałe dni urlopu");
            return false;
        }

        p.dodajWniosekOUrlop(wniosekOUrlop);
        return true;
    }

    public int getMaksymalnaDlugosc() {
        return typUrlopu.getMaksymalnaDlugosc();
    }
}