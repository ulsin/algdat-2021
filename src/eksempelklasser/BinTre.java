package eksempelklasser;

import java.util.*;

public class BinTre<T> implements Iterable<T>           // et generisk binærtre
{
    private static final class Node<T>  // en indre nodeklasse
    {
        private T verdi;            // nodens verdi
        private Node<T> venstre;    // referanse til venstre barn/subtre
        private Node<T> høyre;      // referanse til høyre barn/subtre

        private Node(T verdi, Node<T> v, Node<T> h)    // konstruktør
        {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
        }

        private Node(T verdi) {
            this.verdi = verdi;
        }  // konstruktør

    } // class Node<T>

    private Node<T> rot;      // referanse til rotnoden
    private int antall;       // antall noder i treet
    private int endringer;

    public BinTre() { rot = null; antall = 0; endringer = 0;}          // konstruktør
    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i], verdi[i]);
    }
//    Programkode 5.1.5 c)

    public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0) {
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi);          // ny node

        if (q == null) rot = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.venstre = p;                // venstre barn til q
        else
            q.høyre = p;                  // høyre barn til q

        antall++;                       // en ny verdi i treet
        endringer++;
    }
    //    Programkode 5.1.5 b)

    private Node<T> finnNode(int posisjon)  // finner noden med gitt posisjon
    {
        if (posisjon < 1) return null;

        Node<T> p = rot;   // nodereferanse
        int filter = Integer.highestOneBit(posisjon >> 1);   // filter = 100...00

        for (; p != null && filter > 0; filter >>= 1)
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;

        return p;   // p blir null hvis posisjon ikke er i treet
    }

    public boolean finnes(int posisjon) {
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon) {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi) {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        endringer++;
        return gammelverdi;
    }
//    Programkode 5.1.5 j)

    private static int antall(Node<?> p)  // ? betyr vilkårlig type
    {
        if (p == null) return 0;            // et tomt tre har 0 noder

        return 1 + antall(p.venstre) + antall(p.høyre);
    }

    public int antall()
    {
        return antall(rot);                 // kaller hjelpemetoden
    }
//    Programkode 5.1.12 a)

    private static int antallBladnoder(Node<?> p) {

        if (p == null) {
            return 0;
        }

        int bladnode = 0;
        if (p.høyre == null && p.venstre == null) {
            bladnode++;
        }

        return bladnode + antallBladnoder(p.venstre) + antallBladnoder(p.høyre);
    }

    public int antallBladnoder() {
        return antallBladnoder(rot);
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
//    Programkode 5.1.12 b)

    private static void høyde(Node<?> p, int nivå, int[] maksnivå)
    {
        if (nivå > maksnivå[0]) maksnivå[0] = nivå;
        if (p.venstre != null) høyde(p.venstre, nivå + 1, maksnivå);
        if (p.høyre != null) høyde(p.høyre, nivå + 1, maksnivå);
    }

//    public int høyde()
//    {
//        int[] maksnivå = {-1};                // tabellen har lengde 1
//        if (!tom()) høyde(rot, 0, maksnivå);  // roten har nivå 0
//        return maksnivå[0];                   // inneholder høyden
//    }
//    Programkode 5.1.12 f)

    private static <T> boolean inneholder(Node<T> p, T verdi)
    {
        if (p == null) return false;    // kan ikke ligge i et tomt tre
        return verdi.equals(p.verdi) || inneholder(p.venstre,verdi)
                || inneholder(p.høyre,verdi);
    }

    public boolean inneholder(T verdi)
    {
        return inneholder(rot,verdi);   // kaller den private metoden
    }
//    Programkode 5.1.12 c)

    private static <T> int posisjon(Node<T> p, int k, T verdi)
    {
        if (p == null) return -1;                  // ligger ikke i et tomt tre
        if (verdi.equals(p.verdi)) return k;       // verdi ligger i p
        int i = posisjon(p.venstre,2*k,verdi);     // leter i venstre subtre
        if (i > 0) return i;                       // ligger i venstre subtre
        return posisjon(p.høyre,2*k+1,verdi);      // leter i høyre subtre
    }

    public int posisjon(T verdi)
    {
        return posisjon(rot,1,verdi);  // kaller den private metoden
    }
//    Programkode 5.1.12 d)

    private static int maksPos(Node p, int k) {
        if (p == null) {
            return -1;
        }

        if (p.venstre == null && p.høyre == null) {
            return k;
        }

        return Math.max(maksPos(p.venstre, 2 * k), maksPos(p.høyre, 2 * k + 1));
    }

    public int maksPos() {
        if (rot == null) {
            return  -1;
        }

        return maksPos(rot, 1);
    }

    public boolean tom() {
        return antall == 0;
    }         // tomt tre?

    public T fjern(int posisjon) {
        Node<T> temp = finnNode(posisjon);
        T verdi;


        if (temp == null || temp.venstre != null || temp.høyre != null) {
            throw new IllegalArgumentException("Finnes ikke noen node på denne posisjonen!");
        }

        verdi = temp.verdi;

        temp = finnNode(posisjon / 2); // rundes alltids ned tho

        if (posisjon % 2 == 1) {
            temp.høyre = null;
        } else {
            temp.venstre = null;
        }

        endringer++;
        return verdi;
    }

    public void nivåorden(Oppgave<? super T> oppgave)    // ny versjon
    {
        if (tom()) return;                   // tomt tre
        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.3
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            oppgave.utførOppgave(p.verdi);     // den generiske oppgaven

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.høyre != null) kø.leggInn(p.høyre);
        }
    }
//    Programkode 5.1.6 d)

    public int[] nivåer()   // returnerer en tabell som inneholder nivåantallene
    {
        if (tom()) return new int[0];       // en tom tabell for et tomt tre

        int[] a = new int[8];               // hjelpetabell
        Kø<Node<T>> kø = new TabellKø<>();  // hjelpekø
        int nivå = 0;                       // hjelpevariabel

        kø.leggInn(rot);    // legger roten i køen

        while (!kø.tom())   // så lenge som køen ikke er tom
        {
            // utvider a hvis det er nødvendig
            if (nivå == a.length) a = Arrays.copyOf(a,2*nivå);

            int k = a[nivå] = kø.antall();  // antallet på dette nivået

            for (int i = 0; i < k; i++)  // alle på nivået
            {
                Node<T> p = kø.taUt();

                if (p.venstre != null) kø.leggInn(p.venstre);
                if (p.høyre != null) kø.leggInn(p.høyre);
            }

            nivå++;  // fortsetter på neste nivå
        }

        return Arrays.copyOf(a, nivå);  // fjerner det overflødige
    }
//    Programkode 5.1.6 k)

    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        while (true) {
            oppgave.utførOppgave(p.verdi);                       // utfører oppgaven
            if (p.venstre != null) preorden(p.venstre,oppgave);  // til venstre barn
            if (p.høyre == null) {
                return;
            }
            p = p.høyre;
        }
    }

    public void preorden(Oppgave<? super T> oppgave)
    {
        if (!tom()) preorden(rot,oppgave);  // sjekker om treet er tomt
    }
//    Programkode 5.1.7 a)

    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave)
    {
        while (true) {
            if (p.venstre != null) inorden(p.venstre,oppgave);
            oppgave.utførOppgave(p.verdi);
            if (p.høyre == null) {
                return;
            }
            p = p.høyre;
        }
    }

    public void inorden(Oppgave <? super T> oppgave)
    {
        if (!tom()) inorden(rot,oppgave);
    }
//    Programkode 5.1.7 d)

    private static <T> void postorden(Node<T> p, Oppgave<? super T> oppgave) {
        if (p.venstre != null) postorden(p.venstre,oppgave);  // til venstre barn
        if (p.høyre != null) postorden(p.høyre,oppgave);

        // går til først første blad, så gjør oppgaven,
        oppgave.utførOppgave(p.verdi);                       // utfører oppgaven
    }

    public void postorden(Oppgave<? super T> oppgave)
    {
        if (!tom()) postorden(rot,oppgave);  // sjekker om treet er tomt
    }
    // Oppgave

    // iterativ versjon
    public void postordenLoop(Oppgave<? super T> oppgave) {
        if (tom()) return;   // tomt tre

        Stakk<Node<T>> log = new TabellStakk<>();  // en stakk
        Stakk<Node<T>> stakk = new TabellStakk<>();  // en stakk

        log.leggInn(rot);

        while (!log.tom()) {

            Node<T> p = log.taUt();
            stakk.leggInn(p);

            // går til mest venstre node og starter der
            if (p.venstre != null) {
                log.leggInn(p.venstre);
            }

            if (p.høyre != null) {
                log.leggInn(p.høyre);
            }
        }

        while (!stakk.tom()) {
            oppgave.utførOppgave(stakk.taUt().verdi);
        }
    }

    private static <T> void nullstill(Node<T> p) {
        if (p.venstre != null) nullstill(p.venstre);  // til venstre barn
        p.venstre = null;

        if (p.høyre != null) nullstill(p.høyre);
        p.høyre = null;
    }

    public void nullstill() {
        if (!tom()) nullstill(rot);
        // nullstill tar alle andre enn roten
        rot = null;
        antall = 0;
    }


    public Iterator<T> iterator()     // skal ligge i class BinTre
    {
        return new InordenIterator();
    }
//    Programkode 5.1.11 e)

    ////////////////// class InordenIterator //////////////////////////////

    private class InordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> s = new TabellStakk<>();
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

        @Override
        public T next()
        {
            if (iteratorEndringer != endringer) {
                throw new ConcurrentModificationException("Kan ikke endre treeet før man er ferdig med iteratoren");
            }

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

    public Iterator<T> omvendtIterator()     // skal ligge i class BinTre
    {
        return new OmvendtInordenIterator();
    }
//    Programkode 5.1.11 e)

    ////////////////// class OmvendtInordenIterator //////////////////////////////

    private class OmvendtInordenIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> s;
        private Node<T> p;

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
            s = new TabellStakk<>();
            if (tom()) return;               // treet er tomt
            p = sist(rot);                  // bruker hjelpemetoden
        }

        @Override
        public T next()
        {
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

    public Iterator<T> preIterator()     // skal ligge i class BinTre
    {
        return new PreIterator();
    }
//    Programkode 5.1.11 e)

    ////////////////// class OmvendtInordenIterator //////////////////////////////

    private class PreIterator implements Iterator<T>
    {
        private final Stakk<Node<T>> s;
        private Node<T> p;

        private PreIterator()          // konstruktør
        {
            s = new TabellStakk<>();
            if (tom()) return;               // treet er tomt
            p = rot;                  // bruker hjelpemetoden
        }

        @Override
        public T next()
        {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            s.leggInn(p);

            T verdi = p.verdi;                        // tar vare på verdien

            if (p.venstre != null) p = p.venstre;  // p har høyre subtre
            else if (p.høyre != null) p = p.høyre;               // stakken er tom
            else {
//                s.taUt(); // tar ut en eksra så vi kommer et nivå opp
                while (!s.tom() && s.kikk().høyre == null) s.taUt(); // tar ut til vi kommer til en som har høyre node
                if (s.tom()) p = null;
                else p = s.taUt().høyre;
            }

            return verdi;
        }

        @Override
        public boolean hasNext()
        {
            return p != null;
        }

    } // OmvendtInordenIterator




} // class BinTre<T>

//                Programkode 5.1.5 a)