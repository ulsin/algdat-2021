package eksempelklasser;

public enum Måned {
    JAN (1, "Januar"),
    FEG (2, "Februar"),
    MAR (3, "Mars"),
    APR (4, "April"),
    MAI (5, "Mai"),
    JUN (6, "Juni");

    private final int mndNr;
    private final String mndNavn;

    private Måned(int mndNr, String mndNavn) {
        this.mndNr = mndNr;
        this.mndNavn = mndNavn;
    }

    public int mndNr() {
        return mndNr;
    }

    @Override
    public String toString() {
        return mndNavn;
    }

    //TODO fullfør denne
}
