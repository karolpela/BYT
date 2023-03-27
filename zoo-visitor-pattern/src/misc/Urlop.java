package misc;

public class Urlop {
    private static final int standardowaDlugosc = 14;
    private final int maksymalnaDlugosc;
    private final String typ;

    public Urlop(int maksymalnaDlugosc, String typ) {
        this.maksymalnaDlugosc = maksymalnaDlugosc;
        this.typ = typ;
    }

    public int getMaksymalnaDlugosc() {
        return maksymalnaDlugosc;
    }
}
