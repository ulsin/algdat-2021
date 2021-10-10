package kap1.eksempelklasser;

import java.util.Comparator;
import java.util.Objects;

public class Tid implements Comparable<Tid> {
    private final Dato dato;
    private final Klokkeslett klokkeslett;

    public Tid(Dato dato, Klokkeslett klokkeslett) {
        this.dato = dato;
        this.klokkeslett = klokkeslett;
    }

    public Tid(int dag, int mnd, int year, String tid) {
        this.dato = new Dato(dag, mnd, year);
        this.klokkeslett = new Klokkeslett(tid);
    }

    @Override
    public int compareTo(Tid t) {
        int k = this.dato.compareTo(t.dato);
        if (k == 0) {
            k = this.klokkeslett.compareTo(t.klokkeslett);
        }
        return k;
    }

    public boolean equals(Object o)              // equals
    {
        if (o == this) return true;
        if (!(o instanceof Tid)) return false;
        return compareTo((Tid)o) == 0;
    }

    public String toString()                     // toString
    {
        return dato.toString() + " " + klokkeslett.toString();
    }

    public int hashCode()
    {
        return Objects.hash(dato.hashCode(),klokkeslett.hashCode());
    }
}
