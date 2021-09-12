package oblig1Lokal.main.java.no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    //Bare en test

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        throw new UnsupportedOperationException();
    }

    public static int ombyttinger(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    /* A Method that Returns an array of same lenght as input, containing indices pointing at values in the
     * input array, in sorted order*/
    public static int[] indekssortering(int[] a) {

        int[] index = new int[a.length]; // creating the return array

        // retuning null array if the input array has no elements,
        if (a.length == 0) {
            return new int[0];
        }

        if (a.length == 1) {
            return new int[]{0};
        }

        // helper array
        int[] b = new int[a.length];
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
        throw new UnsupportedOperationException();
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
    }


}  // Oblig1
