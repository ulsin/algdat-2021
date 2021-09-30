package oblig2lokal.main.java.no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    public static void main(String[] args) {
        /*
        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());
*/

        /*
        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();
        System.out.println(liste.toString() + " " + liste.omvendtString());
        for (int i = 1; i <= 3; i++) {
            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
        }
        */



    }

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
//        throw new UnsupportedOperationException();
        hode = new Node<T>(null);

        hode.forrige = null;
        hode.neste = null;

        hale = hode;

        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
//        throw new UnsupportedOperationException();
        if (a == null) {
            throw new NullPointerException("A er null");
        }

        hode = new Node<T>(null);
        hale = new Node<T>(null);
        antall = 0;
        endringer = 0;

        // setting this variable outside the if test to be used even if length is zero.
        int j = 0;

        if (a.length > 0) {
            // finding the first value in the array that isn't null, and starting from there.
            for (; j < a.length;j++) {
                if (a[j] != null) {
//                    hode = new Node<T>(a[j]);
//                    hale = new Node<T>(a[j]); // hale contains the value of the last element in the array
                    hode.verdi = a[j++]; // increments here as the for loop will not do so after the break line
                    antall++;
                    break;
                }
            }
        }

        if (a.length == 1) {
            hale = hode;
            hode.forrige = null;
            hode.neste = null;
        }

        if (a.length > 1) {
            hode.forrige = null;
            hode.neste = hale;

            hale.forrige = hode;
            hale.neste = null;

            // making j the second non null value
            for (; j < a.length; j++) {
                if (a[j] != null) {
                    hale.verdi = a[j++]; // need to put these ++ behind to make it increment before the break
                    antall++;
                    break;
                }
            }

            for (; j < a.length; j++) {
                if (a[j] != null) {
                    Node<T> temp = new Node<T>(a[j]); // just placeholderp
                    hale.neste = temp;
                    temp.forrige = hale;
                    temp.neste = null;
                    hale = temp;

                    antall++;

//                    endringer++; // tolker det som at endringer bare skal incrementes etter at listen er konstruert
                }
            }
        }
    }

    // hjelpemetode
    private Node<T> finnNode(int indeks)
    {
        if (indeks == 0) {
            return hode;
        }

        if (indeks < antall / 2) {
            Node<T> temp = hode.neste;
            int counter = 1;
            while (counter < indeks) {
                temp = temp.neste;
                counter++;
            }
            return temp;
        } else {
            Node<T> temp = hale;
            int counter = antall - 1;
            while (counter > indeks) {
                temp = temp.forrige;
                counter--;
            }
            return temp;
        }
    }

    public void setEndringer(int endringer) {
        endringer = this.endringer;
    }

    //               Programkode 1.2.3 a)
    // Link: http://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#kode.1.2.3.a
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public Liste<T> subliste(int fra, int til) {
        //TODO perhaps do this via making an array first, and then doing array to sublist to avoid iteratring endringer

        // @ Oppgave 3ø: Skal ha IndexOutOfBoundsException her! && Oppgave 3å2: Skal ha IndexOutOfBoundsException her!
        if (til > antall || fra < 0) {
            throw new IndexOutOfBoundsException("The interval can't be outside of the list");
        }

        // passed without this, but the task text asks for it so leaving it in
        fratilKontroll(antall,fra,til);

        Node<T> temp = finnNode(fra);
        Liste<T> retList = new DobbeltLenketListe<>();

        for (int i = fra; i < til; i++) {
            retList.leggInn(temp.verdi);
            temp = temp.neste;
        }
//        retList.setEndringer(0);
        return retList;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Can't add null object");

        if (hode.verdi == null) {
            hode.verdi = verdi;
            antall++;
            endringer++;
            return true;
        } else {
            Node<T> temp = new Node<T>(verdi);
            hale.neste = temp;
            temp.forrige = hale;
            hale = temp;
            antall++;
            endringer++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "verdi can't be null");
        if (indeks > antall || indeks < 0) {
            throw new IndexOutOfBoundsException("Index has to be within the length of the list");
        }

        // 1 and 3, if list is empty or index is last value
        if (antall == 0 || indeks == antall) {
            leggInn(verdi);
            // not incrementing antall and endringer here as that happens within the method above
            return;
        }

        Node<T> temp = new Node<T>(verdi);

        // if adding at head
        if (indeks == 0) {
            temp.neste = hode;
            temp.forrige = null;
            hode.forrige = temp;
            hode = temp;
            antall++;
            endringer++;
            return;
        }

        // if adding in the middle of the list
        Node<T> before = finnNode(indeks - 1);
        Node<T> after = before.neste;
        temp.forrige = before;
        temp.neste = after;
        before.neste = temp;
        after.forrige = temp;
        antall++;
        endringer++;
//        return;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        int count = 0;
        Node<T> temp = hode;
        for (; count < antall; count++) {
            if (temp == null) {
                return -1;
            }
            if (temp.verdi.equals(verdi)) {
                return count;
            }
            temp = temp.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "new value can't be null");
        indeksKontroll(indeks, false);
        Node<T> temp = finnNode(indeks);
        T oldVal = temp.verdi;
        temp.verdi = nyverdi;
        endringer++;
        return oldVal;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        if (hode == null) {
            Objects.requireNonNull("List cannot be empty");
            return null;
        }

        Node<T> temp = hode;
        StringBuilder ut = new StringBuilder();
        ut.append("[");

        while (true) {
            if (temp != null && temp.verdi != null) {
                ut.append(temp.verdi);
                if (temp.neste != null) {
                    ut.append(", ");
                }
                temp = temp.neste;
            } else {
                break;
            }
        }
        ut.append("]");

        return ut.toString();
    }

    public String omvendtString() {
        if (hale == null) {
            Objects.requireNonNull("List cannot be empty");
            return null;
        }

        Node<T> temp = hale;
        StringBuilder ut = new StringBuilder();
        ut.append("[");

        while (true) {
            if (temp != null && temp.verdi != null) {
                ut.append(temp.verdi);
                if (temp.forrige != null) {
                    ut.append(", ");
                }
                temp = temp.forrige;
            } else {
                break;
            }
        }
        ut.append("]");

        return ut.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


