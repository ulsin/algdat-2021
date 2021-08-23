package timeThurUke33;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Kap1 {
    public static void main(String[] args) {
        int[] values = {9, 13, 5, 10, 13};
        int[] values2 = {10, 5, 7, 2, 9, 1, 3, 8, 4, 6};
        System.out.println(findMin(values));
        System.out.println(maks(values));
        System.out.println(Arrays.toString(minMaks(values2)));
        System.out.println(fakul(4));
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
            if (a[i] >= a[m]) m = i;  // indeksen oppdateres // oppdateres også til siste nå siden >= istedenfor > // O 3(n - 1) + x
        }

        return m;  // returnerer indeksen/posisjonen til største verdi // O 1

    } // maks

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    } // maks

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
}
