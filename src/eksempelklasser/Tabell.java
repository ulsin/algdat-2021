package eksempelklasser;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell() {
        // privat konstruktør hindrer dannelsen av objekter av denne klassen
    }

    // From chapter 1.2
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void skriv(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static void skrivln(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void skrivln(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");
    }

    public static void skriv(char[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void skriv(char[] a) {
        System.out.print("[ ");
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.print("]");
    }

    public static void skrivln(char[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void skrivln(char[] a) {
        System.out.print("[ ");
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.print("]\n");
    }

    public static int[] naturligeTall(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        int[] retArr = new int[n];
        for (int i = 0; i < retArr.length; ) {
            retArr[i] = ++i;
        }
        return retArr;
    }

    public static int[] heleTall(int fra, int til) {
        if (til < fra) {
            throw new IllegalArgumentException();
        }
        if (fra == til) {
            return new int[0];
        }

        int[] retArr = new int[til - fra];
        for (int i = 0; i < retArr.length; ) {
            retArr[i] = i++ + fra;
        }
        return retArr;
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    public static int maks(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a == null) {
            throw new IllegalArgumentException("Array er null");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    // overloader så man kan kjøre med bare en input
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a, 0, a.length);     // kaller metoden over
    }

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int index = fra;
        int minverdi = a[fra];

        for (int i = fra; i < til; i++) {
            if (minverdi > a[i]) {
                index = i;
                minverdi = a[i];
            }
        }

        return index;
    }

    public static int min(int[] a) {
        return min(a, 0, a.length);
    }

    public static int maks3(int[] a, int fra, int til)  // versjon 3 av maks-metoden
    {
        int sist = til - 1;       // siste posisjon i tabellen
        int m = fra;                     // indeks til største verdi
        int maksverdi = a[fra];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                } else {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static int maks3(int[] a) {
        return maks3(a, 0, a.length);
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a, n - 1, m); // bytter m og 0

        nm = maks(a, 0, n - 1);                  // leter i a[1:n>

        if (nm == m) {
            nm = n - 1;
        }

        bytt(a, n - 1, m); // bytter tilbake

        return new int[]{m, nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    public static void sortering(int[] a) {
        for (int i = a.length; i >= 0; i--) {
            int m = maks(a, 0, i);  // m er posisjonen til tabellens største verdi
            bytt(a, i - 1, m); // bytter i-1 og m
        }
    }

    public static int[] nestMaksTurnering(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2 * n];          // turneringstreet
        System.arraycopy(a, 0, b, n, n);     // legger a bakerst i b

        for (int k = 2 * n - 2; k > 1; k -= 2)   // lager turneringstreet
            b[k / 2] = Math.max(b[k], b[k + 1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2 * n - 1, k = 2; k < m; k *= 2) {
            int tempverdi = b[k + 1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) {
                tempverdi = b[k];
                k++;
            }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        System.out.println(Arrays.toString(b));

        return new int[]{maksverdi, nestmaksverdi}; // størst og nest størst

    } // nestMaks

    // From chapter 1.3 instructions, just made it myself haha sorta works
    // Takes an array in and turns it into the lower permutation lexicographically
    public static void lowerPerm(int[] a) {
        int minIndex = a.length - 1;
        int minVal = a[minIndex];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < minVal) {
                minVal = a[i];
                minIndex = i;
            }
            if (a[i] > minVal) { // if a[i] is larger than the current minval, then it needs to be swapped
                bytt(a, minIndex, i);
                snu(a, i + 1);
                break;
            }
        }
    }

    //    Programkode 1.3.1 a)
    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    //     Programkode 1.3.1 b)
    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a, i, j);
        snu(a, i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static int antallMaks(int[] a)    // teller opp i a
    {
        int antall = 0;            // antall tall
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++)    // går gjennom tabellen a
        {
            if (a[i] > maksverdi)    // a[i] er større enn største foran
            {
                antall++;              // har funnet et nytt tall
                maksverdi = a[i];      // oppdaterer maksverdi
            }
        }

        return antall;    // de som er større enn det største foran
    }

    //    Programkode 1.3.4 a)
    public static void utvalgssortering(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));  // to hjelpemetoder
    }

    // wow this is just really bad
    public static void selectionSortNoHelp(int[] a, int from, int to) {
        fratilKontroll(a.length, from, to);
        if (from < to) {
            for (int i = from + 1; i < to; i++) {

                // starting with finding minvalue
                int index = from;
                int minverdi = a[from];

                for (int j = from; j < to; j++) {
                    if (minverdi > a[j]) {
                        index = j;
                        minverdi = a[j];
                    }
                }
                // testing the minimum value and swapping if it is smaller than current
                if (a[from] > minverdi) {
                    int temp = a[from];
                    a[from] = a[index];
                    a[index] = temp;
                    selectionSortNoHelp(a, from++, to);
                }
            }
        }
    }

    public static void selectionSortNoHelp(int[] a, int from) {
        selectionSortNoHelp(a, from, a.length);
    }

    public static void selectionSortNoHelp(int[] a) {
        selectionSortNoHelp(a, 0, a.length);
    }

    //     Programkode 1.3.5 b)
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i++) ;  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    //oppgave 1.3.5.4
    public static int lineærsøkReverse(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = a.length - 1;
        for (; i > 0; i--) ;  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    //oppgave 1.3.5.5a
    public static int lineærsøkHopp(int[] a, int k, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length - 1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i += k) {
            if (a[i] > verdi) {
                i -= k;
                for (; i < verdi; i++) ;
            }
        }
        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    //oppgave 1.3.5.5b
    public static int kvadratrotSøk(int[] a, int verdi) // legges i class Tabell
    {
        return lineærsøkHopp(a, (int) Math.floor(Math.sqrt(a.length)), verdi);
    }

    //     Programkode 1.3.6 a)
    public static int binærsøk1(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length, fra, til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h) / 2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk1(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a, 0, a.length, verdi);  // bruker metoden over
    }

    // 3. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk3(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length, fra, til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h) / 2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else return -(v + 2);                       // ikke funnet
    }

    public static int binærsøk3(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk3(a, 0, a.length, verdi);  // bruker metoden over
    }

    //    Programkode 1.3.8 c)
    public static void innsettingssortering(int[] a, int fra, int til) {
        for (int i = fra; i < til; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j + 1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }

    public static void innsettingssortering(int[] a) {
        innsettingssortering(a, 0, a.length);
    }

    // Programkode 1.3.8 f)
    public static void shell(int[] a, int k) {
        for (int i = k; i < a.length; i++) {
            int temp = a[i], j = i - k;
            for (; j >= 0 && temp < a[j]; j -= k) a[j + k] = a[j];
            a[j + k] = temp;
        }
    }

    //     Programkode 1.3.2 c)
    public static boolean erSortert(int[] a)  // legges i samleklassen Tabell
    {
        for (int i = 1; i < a.length; i++)      // starter med i = 1
            if (a[i - 1] > a[i]) return false;      // en inversjon

        return true;
    }

    // Programkode 1.3.9 a)
    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a, v++, h--);                 // bytter om a[v] og a[h]
            else return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static int parter(int a[], int fra, int til, int skilleverdi) {
        return parter0(a, fra, til - 1, skilleverdi);
    }

    public static int parter(int a[], int skilleverdi) {
        return parter0(a, 0, a.length - 1, skilleverdi);
    }


    //    Programkode 1.3.9 f)
    public static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    //    Programkode 1.3.9 h)
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h) / 2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    //     Programkode 1.4.1 a)
    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i] > maksverdi) {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdaters
            }
        return m;     // returnerer posisjonen til største verdi
    }

    //    public static int maks(String[] a)    // legges i class Tabell
//    {
//        int m = 0;                          // indeks til største verdi
//        String maksverdi = a[0];            // største verdi
//
//        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
//        {
//            maksverdi = a[i];  // største verdi oppdateres
//            m = i;             // indeks til største verdi oppdaters
//        }
//        return m;  // returnerer posisjonen til største verdi
//    }
////    Programkode 1.4.1 b)
//
    //     task 1.4.1.2
    public static int maks(char[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i] > maksverdi) {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdaters
            }
        return m;     // returnerer posisjonen til største verdi
    }
//
//    //     task 1.4.1.3
//    public static int maks(Integer[] a)     // legges i class Tabell
//    {
//        int m = 0;                           // indeks til største verdi
//        Integer maksverdi = a[0];             // største verdi
//
//        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
//        {
//            maksverdi = a[i];     // største verdi oppdateres
//            m = i;                // indeks til største verdi oppdaters
//        }
//        return m;     // returnerer posisjonen til største verdi
//    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        return m;  // returnerer posisjonen til største verdi
    } // maks
//    Programkode 1.4.2 b)

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0; j--) a[j + 1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
//    Programkode 1.4.2 e)

    // Task 1.4.3.5
    public static void skriv(Object[] a, int fra, int til) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void skriv(Object[] a) {
        skriv(a, 0, a.length);
    }

    public static void skrivln(Object[] a, int fra, int til) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }

    public static void skrivln(Object[] a) {
        skrivln(a, 0, a.length);
    }

//    public static void bytt(Object[] a, int i, int j) {
//        Object temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

    public static Integer[] randPermInteger(int n) {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
//    Programkode 1.4.3 d)

    // Task 1.4.3.7
    public static Double[] convertetPrimDouble(double[] d) {

        Double[] b = new Double[d.length];             // en tom Integer-tabell

        for (int i = 0; i < b.length; i++) b[i] = d[i];  // fyller tabellen (autoboksing)

        return b;
    }

    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
//    Programkode 1.4.6 b)

    public static <T> void innsettingssorteringC(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
//    Oppgavce 1.4.9.1

    // oppgave 1.4.6.4
    public static <T> int maks(T[] a, Komparator<? super T> c) {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++)
            if (c.compare(a[i], (maksverdi)) > 0) { // comparer basert på insatt comparator
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        return m;  // returnerer posisjonen til største verdi
    }

    // oppgave 1.4.6.4
    public static <T> int maksC(T[] a, Comparator<? super T> c) {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++)
            if (c.compare(a[i], (maksverdi)) > 0) { // comparer basert på insatt comparator
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        return m;  // returnerer posisjonen til største verdi
    }
    // oppgave 1.4.9.1

    public static <T> void bytt(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> int min(T[] a, int from, int to, Comparator<T> c) {
        fratilKontroll(a.length, from, to);

        int index = from;
        T minverdi = a[from];

        for (int i = from; i < to; i++) {
            if (c.compare(a[i], minverdi) < 0) { // if a[i] is less than minverdi
                index = i;
                minverdi = a[i];
            }
        }

        return index;
    }

    public static <T> void utvalgsSortering(T[] a, int from, int to, Comparator<T> c) {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }

    public static <T> int binærsøk(T[] a, int from, int to, T value, Comparator<T> c) {
        Tabell.fratilKontroll(a.length, from, to);  // se Programkode 1.2.3 a)
        int v = from, h = to - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h) / 2;  // heltallsdivisjon - finner midten

            if (c.compare(value, a[m]) > 0) v = m + 1;   // value må ligge i a[m+1:h]
            else h = m;                   // value må ligge i a[v:m]
        }
        if (h < v || c.compare(value, a[v]) < 0) return -(v + 1);  // ikke funnet
        else if (value == a[v]) return v;            // funnet
        else return -(v + 2);                       // ikke funnet
    }

    public static <T> int binærsøk(T[] a, T value, Comparator<T> c) {
        return binærsøk(a, 0, a.length - 1, value, c);
    }

    private static <T> int parter0T(T[] a, int v, int h, T skilleverdi, Comparator<T> c) {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && c.compare(a[v], skilleverdi) < 0) v++;   // h er stoppverdi for v
            while (v <= h && c.compare(a[h], skilleverdi) >= 0) h--;  // v er stoppverdi for h

            if (v < h) bytt(a, v++, h--);                 // bytter om a[v] og a[h]
            else return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static <T> int parterT(T[] a, int fra, int til, T skilleverdi, Comparator<T> c) {
        return parter0T(a, fra, til - 1, skilleverdi, c);
    }

    public static <T> int parterT(T[] a, T skilleverdi, Comparator<T> c) {
        return parter0T(a, 0, a.length - 1, skilleverdi, c);
    }


    //    Programkode 1.3.9 f)
    private static <T> int sParter0T(T[] a, int v, int h, int indeks, Comparator<T> c) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0T(a, v, h - 1, a[h], c);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    //    Programkode 1.3.9 h)
    private static <T> void kvikksortering0(T[] a, int v, int h, Comparator<T> c)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0T(a, v, h, (v + h) / 2, c);  // bruker midtverdien
        kvikksortering0(a, v, k - 1, c);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h, c);     // sorterer intervallet a[k+1:h]
    }

    public static <T> void kvikksortering(T[] a, int fra, int til, Comparator<T> c) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1, c);  // v = fra, h = til - 1
    }

    public static <T> void kvikksortering(T[] a, Comparator<T> c)   // sorterer hele tabellen
    {
        kvikksortering0(a, 0, a.length - 1, c);
    }



    private static <T> void flett(T[] a, T[] b, int fra, int m, int til, Comparator<T> c)
    {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // løkkevariabler og indekser

        while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = c.compare(b[i], a[j]) <= 0 ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }
//    Programkode 1.3.11 f)

//            Flg. rekursive (og private) metode benytter flett-metoden i Programkode 1.3.11 f):

    private static <T> void flettesortering(T[] a, T[] b, int fra, int til, Comparator<T> c)
    {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering(a,b,fra,m, c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til, c);   // sorterer a[m:til>

        if (c.compare(a[m-1], a[m]) > 0) flett(a,b,fra,m,til,c);  // fletter a[fra:m> og a[m:til>
    }
//    Programkode 1.3.11 g)

//    I koden over deles a[fra:til> på midten og metoden kalles (rekursjon) først på a[fra:m> og så på a[m:til>. Etterpå vil de være sortert og kan flettes sammen. Legg merke til setningen: if (a[m-1] > a[m]). Intervallet a[fra:til> er allerede sortert hvis den siste i a[fra:m> er mindre enn eller lik den første i a[m:til>. Midtdelingen gjør at dette blir av orden n log2(n) og dermed en effektiv metode. Flg. offentlige metode sorterer en hel tabell:

    public static <T> void flettesortering(T[] a, Comparator<T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length, c);          // kaller metoden over
    }
//    Programkode 1.3.11 h)


    }
