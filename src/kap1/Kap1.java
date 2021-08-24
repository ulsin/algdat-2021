package kap1;

import java.util.Arrays;

public class Kap1 {
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
        System.out.println(harmonisk(100000));
        System.out.println(euler(1000));
        System.out.println(avgStorreTall(100000));
        sortMaksForst(values, andreMaks(values,0, values.length));
    }

    // Bytte plass er lurt
    public static void sortMaksForst(int[] values, int maxindex) {
        for (int k = 0; ) // dette må inn i en for loop
        int temp = values[0]; // holder første plass
        values[0] = values[maxindex]; // setter størse verdi først
        values[maxindex] = temp; // setter første tall inn der høyeste var
        System.out.println(Arrays.toString(values));
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

    // Returnerer index til største tall i array
    public static int andreMaks(int[] values, int fra, int til) { // tar inn intervall for å søke
        int index = fra; // 1
        int maxvalue = values[0]; // 1 ??
        for (int i = fra+1; i < til; i++) { // 1 + 2(n-1)
            if (values[i] > maxvalue) { // 1 + 1 (arra access og sammenligning)
                maxvalue = values[i]; // x + x
                index = i; // x
            }
        }
        return index; // 1
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
