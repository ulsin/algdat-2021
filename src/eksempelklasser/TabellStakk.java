package eksempelklasser;

import java.util.*;

public class TabellStakk<T> implements Stakk<T>
{
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[])new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

    public void leggInn(T verdi)
    {
        if (antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall);   // dobler

        a[antall++] = verdi;
    }
//    Programkode 4.1.2 b)


    public T kikk()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien
    }

    public T taUt()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }
//    Programkode 4.1.2 c)

    public boolean tom() { return antall == 0; }

    public int antall() { return antall; }
    //    Programkode 4.1.2 d)


    @Override
    public void nullstill() {
        while (!tom()) {
            taUt();
        }
    }

    @Override
    public String toString() {
        if (tom()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (int i = antall-1; i > 0; i--) {
            sb.append(a[i].toString());
            sb.append(", ");
        }
        sb.append(a[0].toString());
        sb.append(']');

        return sb.toString();
    }

    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<>();
        Stakk<T> C = new TabellStakk<>();

        while (!A.tom()) {
            C.leggInn(A.taUt()); // C blir A snudd
        }

        while (!C.tom()) {
            B.leggInn(C.taUt()); // B blir A riktig vei
        }

        while (!B.tom()) {
            A.leggInn(B.taUt()); //A blir A snudd
        }
    }

    public static <T> void snu2(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<>();
        T temp;

        int length = A.antall();

        for (int i = 0; i < length; i++) {
            temp = A.taUt();
            // first takes all out, then all but one, then all but two and so on
            for (int j = 0; j < length - 1 - i; j++) {
                B.leggInn(A.taUt());
            }

            A.leggInn(temp);
            while(!B.tom()) A.leggInn(B.taUt());
        }
    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        Stakk<T> C = new TabellStakk<>();

        while (!A.tom()) {
            C.leggInn(A.taUt()); // C blir A snudd
        }

        while (!C.tom()) {
            T temp = C.taUt(); // B blir A riktig vei
            A.leggInn(temp);
            B.leggInn(temp);
        }
    }

    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        T temp;
        int length = A.antall();

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - 1 - i; j++) {
                B.leggInn(A.taUt());
            }

            // setting temp to A's last value
            temp = A.taUt();

            A.leggInn(temp);
            for (int j = 0; j < length - 1 - i; j++) {
                A.leggInn(B.taUt());
            }
            B.leggInn(temp);
        }
    }

    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) {
        Stakk<T> B = new TabellStakk<>();
        T temp;

        int n = A.antall();

        // attempted bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                temp = A.taUt();
                if (c.compare(temp, A.kikk()) > 0) {
                    B.leggInn(temp);
                } else {
                    B.leggInn(A.taUt());
                    A.leggInn(temp);
                }
            }
            while(!B.tom()) A.leggInn(B.taUt());
        }
        snu2(A);
    }

}  // class TabellStakk

//                Programkode 4.1.2 a)