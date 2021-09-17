package kap1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {
    private Tabell() {
        // privat konstruktør hindrer dannelsen av objekter av denne klassen
    }

    // From chapter 1.2
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(char[] c, int i, int j)
    {
        char temp = c[i]; c[i] = c[j]; c[j] = temp;
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
        for (int i = 0; i < retArr.length;) {
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

        int[] retArr = new int[til-fra];
        for (int i = 0; i < retArr.length;) {
            retArr[i] = i++ + fra;
        }
        return retArr;
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
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

    public static void vhKontroll(int tablengde, int v, int h)
    {
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
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a == null) {
            throw new IllegalArgumentException("Array er null");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    // overloader så man kan kjøre med bare en input
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
        {
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
                }
                else
                {
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

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

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

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        System.out.println(Arrays.toString(b));

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks

    // From chapter 1.3 instructions, just made it myself haha sorta works
    // Takes an array in and turns it into the lower permutation lexicographically
    public static void lowerPerm(int[] a){
        int minIndex = a.length - 1;
        int minVal = a[minIndex];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < minVal) {
                minVal = a[i];
                minIndex = i;
            }
            if (a[i] > minVal) { // if a[i] is larger than the current minval, then it needs to be swapped
                bytt(a, minIndex, i);
                snu(a, i+1);
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
    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

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
    public static void utvalgssortering(int[] a)
    {
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
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    //oppgave 1.3.5.4
    public static int lineærsøkReverse(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = a.length - 1; for( ; i > 0; i--);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    //oppgave 1.3.5.5a
    public static int lineærsøkHopp(int[] a, int k, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i += k) {
            if (a[i] > verdi) {
                i -= k;
                for (; i < verdi; i++);
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
    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk1(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a,0,a.length,verdi);  // bruker metoden over
    }

    // 3. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk3(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }

    public static int binærsøk3(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk3(a,0,a.length,verdi);  // bruker metoden over
    }

    //    Programkode 1.3.8 c)
    public static void innsettingssortering(int[] a, int fra, int til)
    {
        for (int i = fra; i < til; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j+1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }

    public static void innsettingssortering(int[] a) {
        innsettingssortering(a,0, a.length);
    }

    // Programkode 1.3.8 f)
    public static void shell(int[] a, int k)
    {
        for (int i = k; i < a.length; i++)
        {
            int temp = a[i], j = i - k;
            for ( ; j >= 0 && temp < a[j]; j -= k) a[j + k] = a[j];
            a[j + k] = temp;
        }
    }

    //     Programkode 1.3.2 c)
    public static boolean erSortert(int[] a)  // legges i samleklassen Tabell
    {
        for (int i = 1; i < a.length; i++)      // starter med i = 1
            if (a[i-1] > a[i]) return false;      // en inversjon

        return true;
    }

    // Programkode 1.3.9 a)
    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static int parter(int a[], int fra, int til, int skilleverdi) {
        return parter0(a, fra, til - 1, skilleverdi);
    }

    public static int parter(int a[], int skilleverdi) {
        return parter0(a, 0, a.length - 1, skilleverdi);
    }


    //    Programkode 1.3.9 f)
    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    //    Programkode 1.3.9 h)
    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
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


}
