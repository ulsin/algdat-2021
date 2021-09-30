package oblig1Lokal.main.java.no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import kap1.Tabell;

import java.util.*;

public class Oblig1 {
    private Oblig1() {}

    //Bare en test

    ///// Oppgave 1 //////////////////////////////////////
    // tar inn array and returns max value
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException();
        }

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                uRepo.bytt(a,i,i+1);
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException();
        }

        int ombyttinger = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                uRepo.bytt(a,i,i+1);
                ombyttinger++;
            }
        }
        return ombyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (!Tabell.erSortert(a)) {
            throw new IllegalStateException();
        }

        if (a.length == 0) {
            return 0;
        }

        int antUlike = 1; // needs to start on 1 because there is allways 1 unique number, and then increment when a new one is found

        for (int i = 1; i < a.length; i++) { // haha denne blockerjo faktisk for length = 1
            if (a[i-1] != a[i]) {
                antUlike++;
            }
        }

        return antUlike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    // Start with an element, then check all the previous ones if it exists already. If it doesn't, increment
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int antUlike = 1;
        /*
        Set<Integer> ulike = new HashSet<>();
        for(int n : a) ulike.add(n);
        return ulike.size();
         */

        for (int i = 1; i < a.length; i++) {
            boolean holder = true;
            for (int j = i-1; j >= 0; j--) {
                if (a[i] == a[j]) {
                    holder = false;
                    break;
                }
            }
            if (holder) {
                antUlike++;
            }
        }
        return antUlike;
       // return (int)Arrays.stream(a).distinct().count();
    }

    ///// Oppgave 4 //////////////////////////////////////
    // could start with counting odds and evens, and then giving indices for sorting??
    // Sort entire array, and then swap position of first even with first odd and so on.

//    public static void delsortering(int[] a) {
//        if (a.length < 2) {
//            return;
//        }
//
//        int v = 0; // deklarerer venstre variabel
//        int h = a.length - 1; // deklarerer høyre variabel
//
//        while (v < h) { // Looper igjennom array så lenge venstre er mindre enn høyre
//            while (a[v] % 2 != 0 && v < h) // Sjekker om verdier fra venstre om det er oddetall.
//                v++; // Hvis det er oddetall økes v variabelen med 1
//
//            while (a[h] % 2 == 0 && v < h) { // sjekker om verdier fra venstre er partall.
//                h--; // hvis det er partall minsked h variabelen med 1
//            }
//            if (v < h) { //
//                int temp = a[v];
//                a[v] = a[h];
//                a[h] = temp;
//            }
//        }
//        // hvis venstre variabel har nådd høyre variabel og v er lik lengde på array eller om v er lik 0 så kjøres
//        // kvikksortering på alle tallene fra venstre
//        if (v == h && (v == a.length - 1 || v == 0)) {
//            Tabell.kvikksortering(a, 0, a.length);
//        } else {
//            //Hvis arrayet er delt i 2. til venstre for v variabel har man alle oddetall og til høyre for h variabel har man
//            //alle partall så kjøres kvikksortering på begge
//
//            //Kvikksotrering på venstre del(oddetall-del)
//            Tabell.kvikksortering(a, 0, v);
//            //kvikksortering på høyre del(partall-del)
//            Tabell.kvikksortering(a, h, a.length);
//        }
//
//
//    }

        public static void delsortering(int[] a) {
            if (a.length < 2) {
                return;
            }

            int v = 0;
            int h = a.length - 1;

            while (v < h) {
                while (a[v] % 2 != 0 && v < h) { // while v is odd, increment v | This needs to be != 0 and not == 1 for some reason, no idea
                    v++;
                }
                while (a[h] % 2 == 0 && v < h) { // while a[h] is even, dercrement h
                    h--;
                }
                if (v < h) { // hinders last v and h from being swapped, but swaps all other times
                    Tabell.bytt(a, v, h);
                }
            }

            if (v == h && (v == 0 || v == a.length - 1)) { // in case there are only odd, or only even numbers
                Tabell.kvikksortering(a);
                return;
            }

            // Sorts the array first only the odd partition, and then only the even partition
            Tabell.kvikksortering(a,0,v);
            Tabell.kvikksortering(a,h,a.length);


        }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length < 2) {
            return;
        }

        char temp = a[a.length - 1]; // holds the last element

        // pulls everything up one index
        for (int i = a.length-1; i > 0; i--) {
            a[i] = a[i-1];
        }

        // sets first value to be the initial last value
        a[0] = temp;
    }

    ///// Oppgave 6 //////////////////////////////////////

    // Will try to solve using strings and chars
    public static void rotasjon(char[] a, int k) {
        if (a.length < 2 || k == 0) {
            return;
        }

        if (k == 1) {
            rotasjon(a);
            return;
        }

        // If tests to set k to a more sensible value
        if (k != 0 && (k > a.length || k < - a.length)) {
            k = k % a.length; // sets k to just be the remainder of every rotation
        }

        if (k > a.length / 2) {
            k = -(a.length - k); // sets rotation to be backwards if it is more than half
        }

        if (k < -a.length / 2) { // sets negative rotation to be forwards if it more than half
            k = -(-a.length - k);
        }

        char[] holder = new char[Math.abs(k)];

        if (k > 0) {
            for (int i = 0; i < holder.length; i++) {
                holder[i] = a[a.length - holder.length + i]; //
            }

            //forward rotation with one big jump, then inserting holder string at begining
            // pulls everything up k index
            for (int j = a.length-1; j >= k; j--) {
                a[j] = a[j-k];
            }

            for (int l = 0; l < k; l++) {
                a[l] = holder[l];
            }

        } else {
            for (int i = 0; i < -k; i++) {
                holder[i] = a[i];
            }

            //backwards rotation with one big jump, then inserting holder string at the end
            for (int i = 0; i < -k; i++) {
                a[i] = a[i+(-k)];
            }

            for (int l = 0; l < holder.length; l++) {
                a[a.length-1 - l] = holder[l];
            }
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String ut = "";

        int i = 0;
        StringBuilder sb = new StringBuilder();

        // mergeges strings untill end of shortest string
        for (; i < s.length() && i < t.length(); i++) {
            sb.append(s.charAt(i)).append(t.charAt(i));
        }

        // appends the rest of the longest string, by carrying the i variable out of the for scope
        if (s.length() > t.length()) {
            sb.append(s.substring(i));
        } else if (s.length() < t.length()) {
            sb.append(t.substring(i));
        }
        return sb.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        //TODO
        // Find lenght of shortest string
        // use shortest length in for loop, then
        // or!!!!!!
        // Use if tests within a loop, to make them see if the counter is higher than length, then at last append the rest of the longest string
        // So do a max method thingy to find the length of the longest string an then use that one to append the last

        int maxLength = 0;
        String ut = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1;;i++) {
            boolean flag = false;
            for(String t : s) {
                if(t.length() < i) {
                    sb.append(t.charAt(i-1));
                    flag = true;
                }
            }
            if(!flag) break;
        }

        // finding length of longest string
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > maxLength) {
                maxLength = s[i].length();
            }
        }

        for (int j = 0; j < maxLength; j++) {
            for (int k = 0; k < s.length; k++) {
                if (s[k].length() > j) {
                    ut += s[k].charAt(j);
                }
            }
        }

        return ut;

    }

    ///// Oppgave 8 //////////////////////////////////////
    /* A Method that Returns an array of same lenght as input, containing indices pointing at values in the
     * input array, in sorted order*/
    public static int[] indekssortering(int[] a) {
        // retuning null array if the input array has no elements,
        if (a.length < 1) {
            return new int[0];
        }

        int[] index = new int[a.length]; // creating the return array
        int[] b = new int[a.length]; // helper array

        // array copy
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        uRepo.sortering(b);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    index[i] = j;
                }
            }
        }

        return index;
    } // Oppgave 8

    ///// Oppgave 9 //////////////////////////////////////
    /* a method that tries to return the indexes of the three largest numbers from a given array*/
    public static int[] tredjeMin(int[] a) {

        if (a.length < 3) {
            throw new NoSuchElementException("Array is too short, and cannot have any third smallest value");
        }

        int firstMin = 0, secondMin = 1, thirdMin = 2; // indexes of the initial min values

        // setting second and third min in order if they are not so
        if (a[secondMin] > a[thirdMin]) {
            secondMin = 2; // setting second min to third index
            thirdMin = 1; // setting third min to second index
        }

        // setting first and second index in order of they are not so
        if (a[firstMin] > a[secondMin]) {
            firstMin = secondMin; // setting first imin to second index, even if it was swapped or not
            secondMin = 0; // setting second min to first index
        }

        // doing this again, in case second and third now are out of order
        if (a[secondMin] > a[thirdMin]) {
            int temp = secondMin;
            secondMin = thirdMin; // setting second min to third index
            thirdMin = temp; // setting third min to second index
        }

        // The third first indexes should now be pointing at the right values, Setting min values
        int first = Math.min(a[0], Math.min(a[1], a[2]));
        int firstLeast = a[firstMin];
        int secondLeast = a[secondMin];
        int thirdLeast = a[thirdMin];

        /* Looping throudh the rest of the array to check if any values are smaller than
         * the ones at the beginning and then setting the right indices and valus for everthing
         * to work when it comes around for the next loop, untill the array has been run through all the way.
         */
        for (int i = 3; i < a.length; i++){
            if (a[i] < thirdLeast) {
                if (a[i] < secondLeast) {
                    if (a[i] < firstLeast) {
                        thirdLeast = secondLeast;
                        secondLeast = firstLeast;
                        firstLeast = a[i];

                        thirdMin = secondMin;
                        secondMin = firstMin;
                        firstMin = i;
                    } else { // if current value is less than secondmin, but larger than firstmin
                        thirdLeast = secondLeast;
                        secondLeast = a[i];

                        thirdMin = secondMin;
                        secondMin = i;
                    }
                } else { // if current value is less than thirdmin but larger than second min
                    thirdLeast = a[i];

                    thirdMin = i;
                }
            }
        }
        return new int[] {firstMin,secondMin,thirdMin};
    }// Oppaave 9

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        if (a.length() == 0) {
            return true;
        } else if (b.length() == 0) { // if a isn't zero and b is, then it has to be false
            return false;
        }
        HashMap<Character, Integer> mapA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapB = new HashMap<Character, Integer>();

        // counting up all the chars in first string
        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
        }

        // counting up the letters in the b string
        for (int j = 0; j < b.length(); j++) {
            mapB.put(b.charAt(j), mapB.getOrDefault(b.charAt(j), 0) + 1);
        }

        boolean holder = true;
        for (char c : mapA.keySet()) {
            int x = mapA.getOrDefault(c, 0);
            int y = mapB.getOrDefault(c, 0);

            holder = x <= y;

            if (!holder) {
                return false;
            }
        }

        return holder;
    }

    /* This code was taken from the compendium chapter 1.1 - 1.3 by Ulrik for reuse in task 8 */
    static class uRepo {
        // I made this per instruction from Task 1.2.4.4, not sure if that counts as copying or not.
        // Linking both the task, and the answer sheet, not that mine ended up looking like that
        // but not taking any chances
        // Task Link: https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#oppg.1.2.4
        // Answer Link: https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/fasit124.html
        public static void sortering(int[] a) {
            for (int i = a.length; i > 0; i--) { // this was >= but that did not make sense as maks() does not want to recieve equal indices
                int m = uRepo.maks(a, 0, i);  // m er posisjonen til tabellens største verdi
                uRepo.bytt(a, i - 1, m); // bytter i-1 og m
            }
        }

        // Maks metode fra Programkode 1.2.1 modifisert etter oppskrift fra 1.2.3 3.
        // Link: https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#kode.1.2.1.a
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

        // Same source as the method it references.
        public static int maks(int[] a)  // bruker hele tabellen
        {
            return uRepo.maks(a,0,a.length);     // kaller metoden over
        }

        // Programkode 1.2.3 a) from the compendium
        // Link: https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#kode.1.2.3.a
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
        // Programmkode 1.1.8.d
        // Link https://www.cs.hioa.no/~ulfu/appolonius/kap1/1/kap11.html#kode.1.1.8.d
        public static void bytt(int[] a, int i, int j)
        {
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
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
    }


}  // Oblig1
