package eksempelklasser;

import java.util.Objects;

public class Klokkeslett implements Comparable<Klokkeslett> {
    private final String time;

    public Klokkeslett(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Klokkeslett klokkeslett) {
        int k = time.substring(0, 1).compareTo(klokkeslett.time.substring(0, 1));
        if (k == 0) {
            k = time.substring(3, 4).compareTo(klokkeslett.time.substring(3, 4));
        }
        return k;
    }

    public boolean equals(Object o)              // equals
    {
        if (o == this) return true;
        if (!(o instanceof Klokkeslett)) return false;
        return compareTo((Klokkeslett) o) == 0;
    }

    public String toString()                     // toString
    {
        return time;
    }

    public int hashCode()
    {
        return Objects.hash(time);
    }
}
