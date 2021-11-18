package eksempelklasser;



////////////////// class SBinTre //////////////////////////////

import java.util.Comparator;

public class SBinTreII<T> // implements Beholder<T>
{
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi;                 // nodens verdi
        private Node<T> venstre, høyre;  // venstre og høyre barn

        private Node(T verdi, Node<T> v, Node<T> h)  // konstruktør
        {
            this.verdi = verdi; venstre = v; høyre = h;
        }

        private Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }
    } // class Node

    private Node<T> rot;                       // peker til rotnoden
    private int antall;                        // antall noder
    private final Comparator<? super T> comp;  // komparator

    public SBinTreII(Comparator<? super T> c)    // konstruktør
    {
        rot = null; antall = 0; comp = c;
    }

    public static <T extends Comparable<? super T>> SBinTreII<T> sbintre()
    {
        return new SBinTreII<>(Comparator.naturalOrder());
    }

    public static <T> SBinTreII<T> sbintre(Comparator<? super T> c)
    {
        return new SBinTreII<>(c);
    }

    public int antall()        // antall verdier i treet
    {
        return antall;
    }

    public boolean tom()       // er treet tomt?
    {
        return antall == 0;
    }

    public void nullstill()
    {
        rot = null; antall = 0;
    }
} // class SBinTre

