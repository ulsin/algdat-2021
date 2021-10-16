package eksempelklasser;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EnkeltLenketListeKø<T> implements Kø<T>
{
    private static final class Node<T>       // en indre nodeklasse
    {
        private T verdi;                       // nodens verdi
        private Node<T> neste;                 // den neste noden

        private Node(T verdi,Node<T> neste)    // konstruktør
        {
            this.verdi = verdi;
            this.neste = neste;
        }
    }  // Node

    private Node<T> hode, hale;  // pekere til første og siste node

    private int antall;          // antall verdier/noder i listen

    public EnkeltLenketListeKø()   // standardkonstruktør
    {
        hode = hale = null;        // hode og hale til null
        antall = 0;                // ingen verdier - listen er tom
    }

    public EnkeltLenketListeKø(T[] a) {
        Objects.requireNonNull(a);

        hode = hale = new Node<>(a[0],null);

        for (int i = 1; i < a.length; i++) {
            hale.neste = new Node<>(a[i], null);
            hale = hale.neste;
        }
        antall = a.length;
    }

    @Override
    public boolean leggInn(T verdi)   // verdi legges bakerst
{
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        if (antall == 0)  hode = hale = new Node<>(verdi, null);  // tom liste
        else hale = hale.neste = new Node<>(verdi, null);         // legges bakerst

        antall++;        // en mer i listen
        return true;     // vellykket innlegging
    }

    @Override
    public T kikk() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return hent(0);    // henter den første
    }

    @Override
    public T taUt() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return fjern(0);   // returnerer (og fjerner) den første
    }

    public void leggInn(int indeks, T verdi)    // verdi til posisjon indeks
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, true);        // true: indeks = antall er lovlig

        if (indeks == 0)                     // ny verdi skal ligge først
        {
            hode = new Node<>(verdi, hode);    // legges først
            if (antall == 0) hale = hode;      // hode og hale peker på samme node
        }
        else if (indeks == antall)           // ny verdi skal ligge bakerst
        {
            hale = hale.neste = new Node<>(verdi, null);  // legges bakerst
        }
        else
        {
            Node<T> p = hode;                  // p flyttes indeks - 1 ganger
            for (int i = 1; i < indeks; i++) p = p.neste;

            p.neste = new Node<>(verdi, p.neste);  // verdi settes inn i listen
        }

        antall++;                            // listen har fått en ny verdi
    }

    public boolean inneholder(T t)
    {
        return indeksTil(t) != -1;
    }

    public int indeksTil(T t)
    {
        Objects.requireNonNull(t);

        Node<T> temp = hode;
        int index = 0;

        while (temp.verdi != t && temp.neste != null) {
            temp = temp.neste;
            index++;
        }

        if (temp.verdi == t) {
            return index;
        }
        return -1;
    }

    public T fjern(int indeks)
    {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        T temp;                              // hjelpevariabel

        if (indeks == 0)                     // skal første verdi fjernes?
        {
            temp = hode.verdi;                 // tar vare på verdien som skal fjernes
            hode = hode.neste;                 // hode flyttes til neste node
            if (antall == 1) hale = null;      // det var kun en verdi i listen
        }
        else
        {
            Node<T> p = finnNode(indeks - 1);  // p er noden foran den som skal fjernes
            Node<T> q = p.neste;               // q skal fjernes
            temp = q.verdi;                    // tar vare på verdien som skal fjernes

            if (q == hale) hale = p;           // q er siste node
            p.neste = q.neste;                 // "hopper over" q
        }

        antall--;                            // reduserer antallet
        return temp;                         // returner fjernet verdi
    }
//    Programkode 3.3.3 c)

    public boolean fjern(T t)
    {
        int index = indeksTil(t);
        if (index == -1) {
            return false;
        }

        fjern(index);
        return true;
    }

    @Override
    public int antall()
    {
        return antall;
    }

    @Override
    public boolean tom()
    {
        return antall == 0;
    }

    @Override
    public void nullstill()
    {
        for (int i = antall-1; i >= 0; i--) {
            fjern(i);
        }
        hode = hale = null;        // hode og hale til null
        antall = 0;                // ingen verdier - listen er tom
    }

    private Node<T> finnNode(int indeks)
    {
        Node<T> p = hode;
        for (int i = 0; i < indeks; i++) p = p.neste;
        return p;
    }
//    Programkode 3.3.3 a)

//    Metodene hent() og oppdater() kan nå enkelt kodes ved hjelp av metoden finnNode():

    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig
        return finnNode(indeks).verdi;
    }

    public T oppdater(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        Node<T> p = finnNode(indeks);
        T gammelVerdi = p.verdi;

        p.verdi = verdi;
        return gammelVerdi;
    }
//    Programkode 3.3.3 b)


    public boolean fjernHvis(Predicate<? super T> p) {
        Objects.requireNonNull(p);

        boolean fjernet = false;

        Node<T> temp = hode;

        while (temp != null) {
            fjernet = false;
            if (p.test(temp.verdi)) {
                fjern(temp.verdi);
                fjernet = true;
            }
            temp = temp.neste;
        }
        return fjernet;
    }

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        Node<T> temp = hode;

        while (temp != null) {
            action.accept(temp.verdi);
            temp = temp.neste;
        }
    }

    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString()
    {
        if (antall == 0) {
            return "[]";
        }

        Node<T> temp = hode;

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (temp.neste != null) { // while temp isn't hale
            sb.append(temp.verdi.toString());
            sb.append(", ");
            temp = temp.neste;
        }
        sb.append(temp.verdi.toString());
        sb.append(']');
        return sb.toString();
    }

    public void indeksKontroll(int indeks, boolean leggInn)
    {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall()))
            throw new IndexOutOfBoundsException(indeks);
    }

}  // EnkeltLenketListe

