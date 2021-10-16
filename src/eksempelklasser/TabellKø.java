package eksempelklasser;

import java.util.NoSuchElementException;

public class TabellKø<T> implements Kø<T> {
    private T[] a;      // en tabell
    private int fra;    // posisjonen til den første i køen
    private int til;    // posisjonen til første ledige plass

    @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
    public TabellKø(int lengde) {
        if (lengde < 1)
            throw new IllegalArgumentException("Må ha positiv lengde!");

        a = (T[]) new Object[lengde];

        fra = til = 0;    // a[fra:til> er tom
    }

    public TabellKø()   // standardkonstruktør
    {
        this(8);
    }

    // Her skal resten av metodene settes inn


//    Programkode 4.2.2 b)

//    Metoden leggInn() skal legge verdien på første ledige plass, dvs. posisjon til, øke til med 1 og eventuelt sette den til 0 hvis den har blitt lik a.length. Videre skal tabellen utvides hvis den har blitt full etter innleggingen:

    public boolean leggInn(T verdi)   // null-verdier skal være tillatt
    {
        a[til] = verdi;                                 // ny verdi bakerst
        til++;                                          // øker til med 1
        if (til == a.length) til = 0;                   // hopper til 0
        if (fra == til) a = utvidTabell(2 * a.length);    // sjekker og dobler
        return true;                                    // vellykket innlegging
    }

    @Override
    public T kikk() {
        return a[fra];
    }
//    Programkode 4.2.2 c)

//    I Programkode 4.2.2 c) blir tabellen utvidet med en gang hvis en innlegging gjør at den blir full. Her kan vi ikke bruke noen av utvidelsesmetodene fra klassen Arrays siden det er nødvendig at kopieringen av den gamle tabellen over i den nye gir riktige verdier på variablene fra og til. Vi lager derfor en egen (privat) utvidelsesmetode for vår klasse:

    private T[] utvidTabell(int lengde) {
        @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
        T[] b = (T[]) new Object[lengde];  // ny tabell

        // kopierer intervallet a[fra:a.length> over i b
        System.arraycopy(a, fra, b, 0, a.length - fra);

        // kopierer intervallet a[0:fra> over i b
        System.arraycopy(a, 0, b, a.length - fra, fra);

        fra = 0;
        til = a.length;
        return b;
    }
//    Programkode 4.2.2 d)

//    Metoden taUt() er nå rett frem. Metoden leggInn() sørger for (utvider) at tabellen aldri er full. Det betyr her at den er tom hvis og bare hvis fra og til er like:

    public T taUt() {
        if (fra == til) throw new         // sjekker om køen er tom
                NoSuchElementException("Køen er tom!");

        T temp = a[fra];                  // tar vare på den første i køen
        a[fra] = null;                    // nuller innholdet
        fra++;                            // øker fra med 1
        if (fra == a.length) fra = 0;     // hopper til 0
        return temp;                      // returnerer den første
    }

    @Override
    public int antall() {
        return fra <= til ? til - fra : a.length + til - fra;
    }

    @Override
    public boolean tom() {
        return fra == til;
    }

    @Override
    public void nullstill() {
        for (int i = 0; i < antall(); i++) {
            a[fra] = null;                    // nuller innholdet
            fra++;                            // øker fra med 1
            if (fra == a.length) fra = 0;
        }
        fra = 0;
        til = 0;
    }

    @Override
    public String toString() {
        if (tom()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int fraTemp = fra;

        for (int i = antall(); i > 1; i--) {
            sb.append(a[fraTemp++].toString());
            sb.append(", ");

            if(fraTemp == a.length) fraTemp = 0;
        }

        sb.append(a[fraTemp]);
        sb.append(']');

        return sb.toString();
    }

    public int indeksTil(T verdi) {
        int count = 0;

        int fraTemp = fra;

        for (int i = antall(); i > 0; i--) {
            if (a[fraTemp++] == verdi) {
                return count;
            }
            count++;

            if(fraTemp == a.length) fraTemp = 0;
        }
        return -1;
    }

    public static <T> void snu(Kø<T> A) {
        TabellStakk<T> B = new TabellStakk<>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) A.leggInn(B.taUt());
    }

    //    Programkode 4.2.2 e)
} // class TabellKø
