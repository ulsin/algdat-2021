package eksempelklasser;



////////////////// class SBinTre2 //////////////////////////////

import java.util.*;
import java.util.stream.Stream;

public class SBinTre<T> //implements Beholder<T>
{
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi;                 // nodens verdi
        private Node<T> venstre, høyre;  // venstre og høyre barn

        private Node(T verdi, Node<T> v, Node<T> h)  // konstruktør
        {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
        }

        private Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }


//    Programkode 5.2.5 a)

    } // class Node

    private Node<T> rot;                       // peker til rotnoden
    private int antall;                        // antall noder
    private int endringer;                     // endringer
    private final Comparator<? super T> comp;  // komparator

    private static <T> Node<T> balansert(T[] a, int v, int h)  // en rekursiv metode
    {
        if (v > h) return null;                       // tomt intervall -> tomt tre

        int m = (v + h)/2;                            // midten
        T verdi = a[m];                               // midtverdien

        while (v < m && verdi.equals(a[m-1])) m--;    // til venstre

        Node<T> p = balansert(a, v, m - 1);           // venstre subtre
        Node<T> q = balansert(a, m + 1, h);           // høyre subtre

        return new Node<>(verdi, p, q);               // rotnoden
    }

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        endringer = 0;
        comp = c;
    }

    public static <T> SBinTre<T> sbintre(Comparator<? super T> c)
    {
        return new SBinTre<>(c);
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre(Stream<T> s)
    {
        return sbintre(s, Comparator.naturalOrder());  // naturlig ordning
    }

    public static <T> SBinTre<T> sbintre(Stream<T> s, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);             // komparatoren c
        s.forEach(tre::leggInn);                       // bygger opp treet
        return tre;                                    // treet returneres
    }

    public static <T extends Comparable<? super T>> SBinTre<T> sbintre()
    {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> balansert(T[] a, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);          // oppretter et tomt tre
        tre.rot = balansert(a, 0, a.length - 1);    // bruker den rekursive metoden
        tre.antall = a.length;                      // setter antallet
        tre.endringer = 0;
        return tre;                                 // returnerer treet
    }

    public static <T extends Comparable<? super T>> SBinTre<T> balansert(T[] a)
    {
        return balansert(a, Comparator.naturalOrder());
    }
//    Programkode 5.2.5 b)

    public static <T extends Comparable<? super T>> SBinTre<T> naturligOrdenTre()
    {
        return new SBinTre<>(Comparator.naturalOrder());
    }

    public static <T> SBinTre<T> komparatorTre(Comparator<? super T> c)
    {
        return new SBinTre<>(c);
    }

    public static <T> SBinTre<T> komparatorTre(T[] a, Comparator<? super T> c)
    {
        SBinTre<T> tre = new SBinTre<>(c);          // komparatoren c
        for (T verdi : a) tre.leggInn(verdi);       // bygger opp treet
        return tre;                                 // treet returneres
    }

    public static <T extends Comparable<? super T>> SBinTre<T> naturligOrdenTre(T[] a)
    {
        return komparatorTre(a, Comparator.naturalOrder());  // naturlig ordning
    }

    public int antall()        // antall verdier i treet
    {
        return antall;
    }

    public boolean tom()       // er treet tomt?
    {
        return antall == 0;
    }

    public boolean leggInn(T verdi)    // skal ligge i class SBinTre2
    {
        if (verdi == null) throw new NullPointerException("Ulovlig nullverdi!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        endringer++;
        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    private static int høyde(Node<?> p)  // ? betyr vilkårlig type
    {
        if (p == null) return -1;          // et tomt tre har høyde -1

        return 1 + Math.max(høyde(p.venstre), høyde(p.høyre));
    }

    public int høyde()
    {
        return høyde(rot);                 // kaller hjelpemetoden
    }

    public String toString()                   // hører til SBinTre2
    {
        StringBuilder s = new StringBuilder();   // StringBuilder
        s.append('[');                           // starter med [
        if (!tom()) toString(rot,s);             // den rekursive metoden
        s.append(']');                           // avslutter med ]
        return s.toString();                     // returnerer
    }

    private static <T> void toString(Node<T> p, StringBuilder s)
    {
        if (p.venstre != null)                   // p har et venstre subtre
        {
            toString(p.venstre, s);                // komma og mellomrom etter
            s.append(',').append(' ');             // den siste i det venstre
        }                                        // subtreet til p

        s.append(p.verdi);                       // verdien i p

        if (p.høyre != null)                     // p har et høyre subtre
        {
            s.append(',').append(' ');             // komma og mellomrom etter
            toString(p.høyre, s);                  // p siden p ikke er den
        }                                        // siste noden i inorden
    }

    private static <T> int antall(Node<T> node, T verdi) {
        int count = 0;

        if (node == null) {
            return count;
        }

        if (node.verdi.equals(verdi)) {
            count++;
        }

        return count + antall(node.venstre, verdi) + antall(node.høyre, verdi);


    }

    public int antall(T verdi)
    {
        return antall(rot, verdi);
    }

    public Liste<T> intervallsøk(T fraverdi, T tilverdi) {
        Liste<T> liste = new TabellListe<>();

        intervallsøk(liste, rot, comp, fraverdi, tilverdi);

        return liste;
    }

    private static <T> void intervallsøk(Liste<T> liste, Node<T> node, Comparator<? super T> c, T fraverdi, T tilverdi) {
        if (node == null) {
            return;
        }

        // legger til i innordern
        intervallsøk(liste, node.venstre, c, fraverdi, tilverdi);
        if (c.compare(node.verdi, fraverdi) >= 0 && c.compare(node.verdi, tilverdi) < 0) {
            liste.leggInn(node.verdi);
        }
        intervallsøk(liste, node.høyre, c, fraverdi, tilverdi);
    }

    public T maks() {
        Node<T> p = rot;

        while (p.høyre != null) {
            p = p.høyre;
        }

        return p.verdi;
    }

    public T maks2() {
        Node<T> p = rot;

        while (p.venstre != null) {
            p = p.venstre;
        }

        maks2(rot, comp, p);
        return p.verdi;
    }

    private static <T> void maks2(Node<T> node, Comparator<? super T> c, Node<T> cNode) {
        if (node == null) {
            return;
        }

        maks2(node.venstre, c, cNode);
        if (c.compare(node.verdi, cNode.verdi) > 0) {
            cNode.verdi = node.verdi;
        }
        maks2(node.høyre, c, cNode);

    }

    public T gulv(T verdi)
    {
        Objects.requireNonNull(verdi, "Treet har ingen nullverdier!");
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot; T gulv = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) p = p.venstre;  // gulvet ligger til venstre
            else
            {
                gulv = p.verdi;            // nodeverdien er en kandidat
                p = p.høyre;
            }
//            return p.verdi;         // verdi ligger i treet
        }
        return gulv;
    }

//    public T tak(T verdi) {
//
//        Node<T> p = rot;
//        T tak = null;
//        T temp = p.verdi;
//
//        while (p != null) {
//            int cmp = comp.compare(verdi, p.verdi);
//            int cmp2 = comp.compare(verdi, temp);
//
//            if (cmp > 0) {
//                p = p.høyre;
//            }
//            if (cmp < 0) {
//                p = p.venstre;
//            }
//        }
//    }

    // fra fasit
    public T tak(T verdi)
    {
        if (tom())
        {
            throw new NoSuchElementException("Treet er tomt!");
        }

        Node<T> p = rot;
        T tak = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0)
            {
                tak = p.verdi;
                p = p.venstre;
            }
            else if (cmp > 0)
            {
                p = p.høyre;
            }
            else
            {
                return p.verdi;
            }
        }

        return tak;
    }

    public T mindre(T verdi) {
        Objects.requireNonNull(verdi, "Treet har ingen nullverdier!");
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot; T mindre = null;

        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) p = p.venstre;  // gulvet ligger til venstre
            else if (cmp > 0)
            {
                mindre = p.verdi;            // nodeverdien er en kandidat
                p = p.høyre;
            }
        }
        return mindre;
    }

    public boolean fjern(T verdi)  // hører til klassen SBinTre
    {
        if (verdi == null) return false;  // treet har ingen nullverdier

        Node<T> p = rot, q = null;   // q skal være forelder til p

        while (p != null)            // leter etter verdi
        {
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
            else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
            else break;    // den søkte verdien ligger i p
        }
        if (p == null) return false;   // finner ikke verdi

        if (p.venstre == null || p.høyre == null)  // Tilfelle 1) og 2)
        {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b for barn
            if (p == rot) rot = b;
            else if (p == q.venstre) q.venstre = b;
            else q.høyre = b;
        }
        else  // Tilfelle 3)
        {
            Node<T> s = p, r = p.høyre;   // finner neste i inorden
            while (r.venstre != null)
            {
                s = r;    // s er forelder til r
                r = r.venstre;
            }

            p.verdi = r.verdi;   // kopierer verdien i r til p

            if (s != p) s.venstre = r.høyre;
            else s.høyre = r.høyre;
        }

        endringer++;
        antall--;   // det er nå én node mindre i treet
        return true;
    }
//    Programkode 5.2.8 d)

    public int fjernAlle(T verdi) {

        int count = 0;

        boolean more = true;

        while (more) {
            more = fjern(verdi);
            if (more) {
                count++;
            }
        }

        return count;
    }

    public void fjernMin()  // hører til klassen SBinTre
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        if (rot.venstre == null) rot = rot.høyre;  // rotverdien er minst
        else
        {
            Node<T> p = rot.venstre, q = rot;
            while (p.venstre != null)
            {
                q = p;  // q er forelder til p
                p = p.venstre;
            }
            // p er noden med minst verdi
            q.venstre = p.høyre;
        }
        endringer++;
        antall--;  // det er nå én node mindre i treet
    }
//    Programkode 5.2.8 e)

    public void fjernMaks() {
        Node<T> maks = rot;

        // setter maks til å være minste node s
       while (maks.venstre != null) maks = maks.venstre;

       // setter maks noden til faktiske første instans av høyheste verdi
       fjernMaks(rot, maks);

       // fjerner første forekomst i inorden
       fjern(maks.verdi);
    }

    public void fjernAlleMaks() {
        Node<T> maks = rot;

        // setter maks til å være minste node s
        while (maks.venstre != null) maks = maks.venstre;

        // setter maks noden til faktiske første instans av høyheste verdi
        fjernMaks(rot, maks);

        int count = antall(maks.verdi);

        while (count > 0) {
            // fjerner første forekomst i inorden
            fjern(maks.verdi);
            count--;
        }
    }


    private void fjernMaks(Node<T> node, Node<T> maks) {
        if (node == null) {
            return;
        }

        fjernMaks(node.venstre, maks);
        // hvis noden er større men ikke lik, sett maks og holder den da på første
       if (comp.compare(node.verdi, maks.verdi) > 0) {
            maks = node;
        }
        fjernMaks(node.høyre, maks);
    }

    public void nullstill() {
        while (!tom()) {
            fjernMin();
        }

        endringer = 0;
    }
//    Programkode 5.2.7 b)

    public Iterator<T> iterator()  // returnerer en iterator
    {
        return new InordenIterator();
    }
//    Programkode 5.2.9 a)

    public Iterator<T> iterator(T verdi) {
        return new InordenIterator(verdi);
    }



    ////////////////// class InordenIterator //////////////////////////////

    private class InordenIterator implements Iterator<T>
    {
        private Stakk<Node<T>> s = new TabellStakk<>();
        private Node<T> p = null;
        private int iteratorEndringer;

        private Node<T> først(Node<T> q)   // en hjelpemetode
        {
            while (q.venstre != null)        // starter i q
            {
                s.leggInn(q);                  // legger q på stakken
                q = q.venstre;                 // går videre mot venstre
            }
            return q;                        // q er lengst ned til venstre
        }

        private InordenIterator()          // konstruktør
        {
            if (tom()) return;               // treet er tomt
            p = først(rot);                  // bruker hjelpemetoden
            iteratorEndringer = endringer;
        }

        private InordenIterator(T verdi) {
            if (tom()) {
                return;
            }

            iteratorEndringer = endringer;

            p = først(rot);

            while (hasNext() && comp.compare(tak(p.verdi), verdi) < 0) {
                next();
            }

        }

        @Override
        public T next()
        {
            if (iteratorEndringer != endringer) throw new ConcurrentModificationException();
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T verdi = p.verdi;                        // tar vare på verdien

            if (p.høyre != null) p = først(p.høyre);  // p har høyre subtre
            else if (s.tom()) p = null;               // stakken er tom
            else p = s.taUt();                        // tar fra stakken

            return verdi;                             // returnerer verdien
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

    } // InordenIterator

    public Iterator<T> ritetator() {
        return new OmvendtInordenIterator();
    }

    public Iterator<T> ritetator(T verdi) {
        return new OmvendtInordenIterator(verdi);
    }

    ////////////////// class OmvendtInordenIterator //////////////////////////////

    private class OmvendtInordenIterator implements Iterator<T>
    {
        private Stakk<Node<T>> s = new TabellStakk<>();
        private Node<T> p = null;
        private int iteratorEndringer;

        private Node<T> sist(Node<T> q)   // en hjelpemetode
        {
            while (q.høyre != null)        // starter i q
            {
                s.leggInn(q);                  // legger q på stakken
                q = q.høyre;                 // går videre mot venstre
            }
            return q;                        // q er lengst ned til venstre
        }

        private OmvendtInordenIterator()          // konstruktør
        {
            if (tom()) return;               // treet er tomt
            p = sist(rot);                  // bruker hjelpemetoden
            iteratorEndringer = endringer;
        }

        private OmvendtInordenIterator(T verdi) {
            if (tom()) {
                return;
            }

            iteratorEndringer = endringer;

            p = sist(rot);

            while (hasNext() && comp.compare(tak(p.verdi), verdi) > 0) {
                next();
            }

        }

        @Override
        public T next()
        {
            if (iteratorEndringer != endringer) throw new ConcurrentModificationException();
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            T verdi = p.verdi;                        // tar vare på verdien

            if (p.venstre != null) p = sist(p.venstre);  // p har høyre subtre
            else if (s.tom()) p = null;               // stakken er tom
            else p = s.taUt();                        // tar fra stakken

            return verdi;                             // returnerer verdien
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

    } // OmvendtInordenIterator

} // class SBinTre2

