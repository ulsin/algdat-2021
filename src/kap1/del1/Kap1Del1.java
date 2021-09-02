package kap1.del1;

import java.util.*;
import java.util.stream.IntStream;

public class Kap1Del1 {
    public static void main(String[] args) {
        int[] values = {9, 13, 5, 10, 13};
        int[] values2 = {10, 5, 7, 2, 9, 1, 3, 8, 4, 6};
        int[] empty;
        int[] oneArr = {1};
//        System.out.println(findMin(values));
//        System.out.println(maks(values));
//        System.out.println(Arrays.toString(minMaks(values2)));
//        System.out.println(fakul(4));
//        System.out.println(maks3(values));
//        System.out.println(harmonisk(100000));
//        System.out.println(euler(1000));
//        System.out.println(avgStorreTall(100000));
//        sortMaksForst(values2);
//        Tester.makstest();
//        System.out.println("Antall feil: " + Tester.makstestFlere1());
//        System.out.println("Antall feil: " + Tester.makstestFlere2());
//        System.out.println("Antall feil: " + Tester.makstestFlere3());

//        OptionalInt m = maks4(values2);
//        if (m.isPresent()) {
//            System.out.println(m.getAsInt());
//        }

/*
        int[] a = new int[10];            // en tabell med plass til n tall
        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n
        randPermOmstokkIntervall(a,0,4);
        System.out.println(Arrays.toString(a));
*/

//        randPermTimer();

//        System.out.println(Arrays.toString(randPermIntervall(5,9)));
//        System.out.println(Arrays.toString(oneToNShuffle(5)));

//        System.out.println(antallMaks(randPerm5(100000)));

//        int sum = 0;
//        int[] randArr = randPerm5(500000);
//        for (int i = 0; i < 10; i++) {
//            randPermOmstokk(randArr);
//            sum += antallMaks(randArr);
//        }
//        System.out.println((double) sum / 10.0);

//        maksTimer();
        int[] a = {8,3,5,7,9,6,10,2,1,4};  // en heltallstabell
//        int[] a = new int[0]; // gir ingen verdi!!
        IntStream s = Arrays.stream(a);    // fra int-tabell til IntStream
        IntStream sMin = Arrays.stream(a);
        IntStream sSum = Arrays.stream(a);
        IntStream sAvg = Arrays.stream(a);
        IntStream sStat = Arrays.stream(a);

        OptionalInt resultat = s.max();    // kaller max-metoden
        OptionalInt min = sMin.min();

        int intSum = sSum.sum();

        OptionalDouble dblAvg = sAvg.average();

        IntSummaryStatistics stat = sStat.summaryStatistics();

        System.out.println(stat);

        if (resultat.isPresent() && min.isPresent()) System.out.println("maks: " + resultat.getAsInt() + " min: " + min.getAsInt() + " sum: " + intSum + " avg: " + dblAvg.toString());
        else System.out.println("Ingen verdi!");
    }


    public static void maksTimer() {
        int n = 200_000, antall = 2_000; // tabellstørrelse og gjentagelser
        long tid = 0;                    // for tidsmåling
        int a[] = randPerm5(n);           // en permutasjon av 1, . .  n

//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks4(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks4-metoden: " + tid + " millisek");
    }

    public static void randPermTimer() {
        int n = 10000*5;
        long tid = System.currentTimeMillis();
        int[] a = randPerm2(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
        tid = System.currentTimeMillis();
        int[] b = randPerm3(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
        tid = System.currentTimeMillis();
        int[] c = randPerm4(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
        tid = System.currentTimeMillis();
        int[] d = randPerm4(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
    }

    public static int kostnader(int[] a)  // legges i class Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}  // en tom blokk
        return m;
    }

    // Bytte plass er lurt
    public static void sortMaksForst(int[] values) {
        int ceil = values.length;
        for (int k = 0; k < ceil; k++) {
            int temp = values[k]; // holder første plass
            int maks = andreMaks(values, k, ceil);
            values[k] = values[maks]; // setter størse verdi først
            values[maks] = temp; // setter første tall inn der høyeste var
        } // dette må inn i en for loop
        System.out.println(Arrays.toString(values));
    }

    // Returnerer index til største tall i array
    public static int andreMaks(int[] values, int fra, int til) { // tar inn intervall for å søke
        int index = fra; // 1
        int maxvalue = values[fra]; // 1 ??
        for (int i = fra+1; i < til; i++) { // 1 + 2(n-1)
            if (values[i] > maxvalue) { // 1 + 1 (arra access og sammenligning)
                maxvalue = values[i]; // x + x
                index = i; // x
            }
        }
        return index; // 1
    }

    public static int findMin(int[] innArr) { // O 1 + 3n + 2x
        int index = 0; // O 1
        int minVal = innArr[0]; // O 1

        for (int i = 1; i < innArr.length; i++) { // O 1 + n + n-1 = 2n
            if (innArr[i] < minVal) { // O n-1
                minVal = innArr[i]; // x
                index = i; // x
            }
        }

        return index;
    }

    public static int maks(int[] a)  // a er en heltallstabell // O 5n + x
    {
        if (a.length < 1) // O 1
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks) // O 1

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1 // O 1 + n + n - 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres // oppdateres også til siste nå siden >= istedenfor > // O 3(n - 1) + x
        }

        return m;  // returnerer indeksen/posisjonen til største verdi // O 1

    } // maks

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        if (a.length < 1) // O 1
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;               // indeks til største verdi // O1
        int maksverdi = a[0];    // største verdi // O2

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi) //1 + n + n-1 + 2(n-1)
        {
            maksverdi = a[i];     // største verdi oppdateres / x + x
            m = i;                // indeks til største verdi oppdateres / x
        }
        return m;   // returnerer indeks/posisjonen til største verdi / 1

    } // maks // 1 + 2 + 1 + n + n-1 + 2(n-1) + x + x + 1 = (4n + 2x + 2)

    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        if (a.length < 1) // O 1
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = maksverdi;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp > maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    a[sist] = maksverdi;
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static OptionalInt maks4(int[] a)           // indeks til største verdi
    {
        if (a.length < 1) return OptionalInt.empty();   // en konstruksjonsmetode

        int m = 0, maksverdi = a[0];                    // startindeks og verdi

        for (int i = 1; i < a.length; i++)              // starter med i = 1
        {
            if (a[i] > maksverdi)
            {
                m = i; maksverdi = a[i];                    // oppdaterer
            }
        }

        return OptionalInt.of(m);                       // en konstruksjonsmetode
    }

    public static int[] randPerm2(int n)  // virker, men er svært ineffektiv
    {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; )      // vi skal legge inn n tall
        {
            int k = r.nextInt(n) + 1;   // trekker et nytt tall k

            int j = 0;
            for ( ; j < i; j++)         // leter i intervallet a[0:i>
            {
                if (a[j] == k) break;     // stopper hvis vi har k fra før
            }
            if (i == j) a[i++] = k;     // legger inn k og øker i
        }
        return a;                     // tabellen returneres
    }

    public static int[] randPerm3(int n)  // virker, men er ineffektiv
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        boolean[] har = new boolean[n];  // en boolsk tabell

        for (int i = 0; i < n; )         // vi skal legge inn n tall
        {
            int k = r.nextInt(n);          // trekker en indeks k
            if (har[k] == false)           // sjekker
            {
                har[k] = true;               // oppdaterer den boolske tabellen
                a[i++] = k + 1;              // legger inn k + 1 i a
            }
        }
        return a;                        // tabellen returneres
    }

    public static int[] randPerm4(int n) { // skrev denne selv yo
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 1; i <= n; ) {
            int k = r.nextInt(n);
            if (a[k] == 0) {
                a[k] = i++;
            }
        }
        return a;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm5(int n)  // en effektiv versjon
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

    public static int[] randPerm5Venstre(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        for (int i = 0; i < n; i++) { // var kanskje ikke nodvendig
            a[i] = n - i;
        }

        System.out.println(Arrays.toString(a));

        for (int k = 0; k < n; k++)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,i,k); // bytter om fra venstre
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPermOmstokk(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static void randPermOmstokkIntervall(int[] a, int start, int slutt)
    {
        Random r = new Random();

        for (int k = start; k < slutt; k++)
        {
            int i = r.nextInt(slutt-start);
            bytt(a,k,i+start);
        }
    }

    public static int[] randPermIntervall(int n, int k) { // lagde ogsa denne selv
        Random r = new Random();
        int[] a = new int[k - n + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = n + i;
        }

        randPermOmstokk(a);

        return a;
    }

    public static int[] oneToNShuffle(int n) {
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            intList.add(i);
        }

        Collections.shuffle(intList);

        int[] intArr = new int[n];

        for (int i = 0; i < n; i++) {
            intArr[i] = intList.get(i);
        }

        return intArr;
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


    public static int[] minMaks(int[] a) {
        return new int[] {findMin(a), maks(a)};
    }

    public static long fakul(int a) {
        long fak = 1;
        for (int i = 2; i <= a; i++) { // starting on two to skip multiplying with 1, also skipping 0 since then it would never be done
            fak *= i;
        }
        return fak;
    }

    public static double harmonisk(int a) {
        double utTall = 0;
        for (int i = 1; i <= a; i++) {
            utTall += 1.0 / i; // bruker 1.0 istedenfor å caste double
        }
        return utTall;
    }

    public static double euler(int a) {
        return harmonisk(a) - Math.log(a);
    }

    public static double avgStorreTall(int a) {
                return Math.log(a) - 0.423;
    }

}
