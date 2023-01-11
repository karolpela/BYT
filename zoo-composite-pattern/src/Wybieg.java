public class Wybieg implements Ekspozycja {
    private int id;
    private String nazwa;
    private float powierzchnia;
    private boolean zakryty;
    private String typSrodowiska;

    public void przydzielOpiekuna(Opiekun opiekun) {}

    public void usunOpiekuna(Opiekun opiekun) {}

    @Override
    public float obliczIloscKarmy(int dni) {
        return 0;
    }
}
