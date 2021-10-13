package eksempelklasser;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TabellListe<T> implements Liste<T>
{
    private T[] a;
    private int antall;
    private int endringer;

    // konstruktører og metoder kommer her
    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse)       // konstruktør
    {
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe()                    // standardkonstruktør
    {
        this(10);                             // startstørrelse på 10
    }
//    Programkode 3.2.2 b)

    public TabellListe(T[] b)                    // en T-tabell som parameter
    {
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b)
        {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }
//    Programkode 3.2.2 d)

    public int antall()
    {
        return antall;          // returnerer antallet
    }

    public boolean tom()
    {
        return antall == 0;     // listen er tom hvis antall er 0
    }
//    Programkode 3.2.2 e)

    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }
//    Programkode 3.2.2 f)

    public int indeksTil(T verdi)
    {
        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }
//    Programkode 3.2.2 g)

    public boolean leggInn(T verdi)  // inn bakerst
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        if (antall == a.length)  // En full tabell utvides med 50%
        {
            a = Arrays.copyOf(a,(3*antall)/2 + 1);
        }

        a[antall++] = verdi;    // setter inn ny verdi
        endringer++;
        return true;            // vellykket innlegging
    }

    public void leggInn(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, true);  // true: indeks = antall er lovlig

        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);

        // rydder plass til den nye verdien
        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;     // setter inn ny verdi
        antall++;              // vellykket innlegging
        endringer++;
    }
//    Programkode 3.2.3 b)

    public T oppdater(int indeks, T verdi)
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig

        T gammelverdi = a[indeks];      // tar vare på den gamle verdien
        a[indeks] = verdi;              // oppdaterer
        endringer++;
        return gammelverdi;             // returnerer den gamle verdien
    }

    public T fjern(int indeks)
    {
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
        T verdi = a[indeks];

        antall--; // sletter ved å flytte verdier mot venstre
        endringer++;
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        a[antall] = null;   // tilrettelegger for "søppeltømming"

        return verdi;
    }
    //    Programkode 3.2.3 c)


    @Override
    public boolean fjern(T verdi) {
        return fjern(indeksTil(verdi)) != null;
    }

    @Override
    public boolean fjernHvis(Predicate<? super T> p) {
        Objects.requireNonNull(p);

        boolean fjernet = false;
        for (int i = antall-1; i >= 0; i--) {
            fjernet = false;
            if (p.test(a[i])) {
                fjern(i);
                fjernet = true;
            }
        }
        return fjernet;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        for (int i = 0; i < antall-1; i++) {
            action.accept(a[i]);
        }
    }

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    @Override
    public void nullstill() {
        for (int i = antall-1; i >= 0; i--) {
            fjern(i);
        }
        if (a.length > 10) {
            a = (T[])new Object[10];       // oppretter tabellen
        }
        antall = 0;                    // foreløpig ingen verdier
        endringer = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new TabellListeIterator();
    }

    public String toString() {
        if (antall == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < antall - 1; i++) {
            sb.append(a[i].toString());
            sb.append(' ');
        }
        sb.append(a[antall -1]);
        sb.append(']');
        return sb.toString();
    }

    // Skal ligge som en indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T>
    {
        private int denne = 0;       // instansvariabel
        private int iteratorendringer = endringer;

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        public Iterator<T> iterator()
        {
            return new TabellListeIterator();
        }
//        Programkode 3.2.4 b)

        private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator

        public T next()
        {
          if (iteratorendringer != endringer)
          {
            throw new ConcurrentModificationException("Listen er endret!");
          }
      
          if (!hasNext())
          {
            throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
          }
      
          T denneVerdi = a[denne];   // henter aktuell verdi
          denne++;                   // flytter indeksen
          fjernOK = true;            // nå kan remove() kalles
          return denneVerdi;         // returnerer verdien
        }
      
        public void remove()
        {
          if (iteratorendringer != endringer) throw new
            ConcurrentModificationException("Listen er endret!");
      
          if (!fjernOK) throw
            new IllegalStateException("Ulovlig tilstand!");
      
          fjernOK = false;           // remove() kan ikke kalles på nytt
      
          // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
          // på next(), verdiene fra og med denne flyttes derfor en mot venstre
      
          antall--;           // en verdi vil bli fjernet
          denne--;            // denne må flyttes til venstre
      
          // tetter igjen
          System.arraycopy(a, denne + 1, a, denne, antall - denne);
      
          a[antall] = null;   // verdien som lå lengst til høyre nulles
      
          endringer++;
          iteratorendringer++;
        }
                    //   Programkode 3.2.5 e)

        // Think this is a method that works like foreach only that it doesn't go into null pointers, it stops at antall
        @Override
        public void forEachRemaining(Consumer<? super T> action)
        {
            while (denne < antall)
            {
                action.accept(a[denne++]);
            }
        }

    }  // TabellListeIterator

//    Programkode 3.2.4 a)

}
//                Programkode 3.2.2 a)