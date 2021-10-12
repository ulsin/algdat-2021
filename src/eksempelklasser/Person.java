package eksempelklasser;

import java.util.Objects;

public class Person implements Comparable<Person>
{
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        if (fornavn == null) {
            throw new NullPointerException("Fornvn kan ikke være null");
        }
        if (etternavn == null) {
            throw new NullPointerException("Etternavn kan ikke være null");
        }

        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Person p) {
        if (p == this) {
            return true;
        }
        if (p == null) {
            return false;
        }

        return fornavn().equals(p.fornavn()) && etternavn().equals(p.etternavn);
    }

//    public boolean equals(Object o)      // vår versjon av equals
//    {
//        if (o == this) return true;
//        if (!(o instanceof Person)) return false;
//        return compareTo((Person)o) == 0;
//    }

    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    public String toString() { return String.join(" ", fornavn, etternavn); }

} // class Person

//              Programkode 1.4.4 d)