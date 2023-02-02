package documents;

import employees.Pracownik;
import implementations.ObliczanieWynagrodzeniaVisitor;

import java.time.LocalDate;

public class Faktura {
    private LocalDate dataWystawienia;
    private float wynagrodzenieBrutto;
    private String numerKonta;
    private String status;
    private Pracownik pracownik;

    private Faktura() {
    }

    private Faktura(LocalDate dataWystawienia, float wynagrodzenieBrutto,
                    String numerKonta, Pracownik pracownik) {
        this.dataWystawienia = dataWystawienia;
        this.wynagrodzenieBrutto = wynagrodzenieBrutto;
        this.numerKonta = numerKonta;
        this.status = "Niezaksegowana";
        this.pracownik = pracownik;
    }

    public static Faktura dodaj(Pracownik p) {
        var obliczanieWynagrodzeniaVisitor =
                new ObliczanieWynagrodzeniaVisitor();
        var faktura = new Faktura(
                LocalDate.now(),
                p.accept(obliczanieWynagrodzeniaVisitor),
                p.getNumerKonta(),
                p
        );
        p.dodajFakture(faktura);
        return faktura;
    }

    public LocalDate getDataWystawienia() {
        return dataWystawienia;
    }

    public void zaksieguj() {
    }

    public void edytuj() {
    }

    @Override
    public String toString() {
        return "Faktura{" +
                "\n\tpracownik=" + pracownik +
                ",\n\tdataWystawienia=" + dataWystawienia +
                ",\n\twynagrodzenieBrutto=" + wynagrodzenieBrutto +
                ",\n\tnumerKonta='" + numerKonta + '\'' +
                ",\n\tstatus='" + status + '\'' +
                "\n}";
    }
}
