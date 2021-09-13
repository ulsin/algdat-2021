package kap1.del3;

import static kap1.Tabell.*;

import kap1.Tabell;
import oblig1Lokal.main.java.no.oslomet.cs.algdat.Oblig1.Oblig1;

import java.util.Arrays;

public class Kap1Del3 {
    public static void main(String[] args) {
        int[] values2 = {10, 5, 7, 2, 9, 1, 3, 8, 4, 6};
        System.out.println(Arrays.toString(values2));
        lowerPerm(values2);
        System.out.println(Arrays.toString(values2));
        lowerPerm(values2);
        System.out.println(Arrays.toString(values2));
        lowerPerm(values2);
        System.out.println(Arrays.toString(values2));

        // Programkode 1.3.1 c)
        System.out.println("Programkode 1.3.1 c)");
        int[] a = {3,1,4,9,7,10,8,6,5,2};        // permutasjon av tallene fra 1 til 10
        nestePermutasjon(a);              // lager neste permutasjon
        System.out.println(Arrays.toString(a));  // [3, 1, 4, 9, 8, 2, 5, 6, 7, 10]

        //        Programkode 1.3.1 d)
        System.out.println("Programkode 1.3.1 d)");
        int[] b = {1,2,3,4,5};                // første permutasjon
        int sum = 0;                          // hjelpevariabel

        do { sum += antallMaks(b); }          // se Programkode 1.1.9 a)
        while (nestePermutasjon(b));   // lager neste permutasjon

        System.out.println(sum);              // Utskrift: 154

        int[] woop = {2, 3, 6, 1, 4, 5};
        int[] woop2 = {2, 3, 1, 6, 5, 4};
        nestePermutasjon(woop);
        System.out.println(Arrays.toString(woop));
        nestePermutasjon(woop);
        System.out.println(Arrays.toString(woop));
        nestePermutasjon(woop2);
        System.out.println(Arrays.toString(woop2));

/*

        System.out.println("Oppgave 1.3.4");
        int[] woop3 = randPerm(100000);           // en permutasjon av 1, . .  n

        int[] woop4 = Arrays.copyOf(woop3, woop3.length);
//        System.out.println(Arrays.toString(woop3));

        long tid = System.currentTimeMillis();    // leser av klokken
        utvalgssortering(woop3);
//        System.out.println(Arrays.toString(woop3));
        System.out.println(System.currentTimeMillis() - tid);

        tid = System.currentTimeMillis();
        utvalgssortering(woop4);
//        System.out.println(Arrays.toString(woop4));
        System.out.println(System.currentTimeMillis() - tid);
*/

        int[] woop5 = randPerm(10);
        System.out.println(Arrays.toString(woop5));
        selectionSortNoHelp(woop5, 0,5);
        System.out.println(Arrays.toString(woop5));

        //        Programkode 1.3.5 c)
        System.out.println("Programkode 1.3.5 c)");
        int[] c = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
        int[] d = new int[0];
        System.out.println(Tabell.lineærsøk(c,2));              // utskrift: -1
        System.out.println(Tabell.lineærsøk(c,15));             // utskrift: -6
        System.out.println(Tabell.lineærsøk(c,16));             // utskrift: 5
        System.out.println(Tabell.lineærsøk(c,40));             // utskrift: 14
        System.out.println(Tabell.lineærsøk(c,41));             // utskrift: -16
        System.out.println(Tabell.lineærsøk(d,2));              // utskrift: -1
        // ser ut som at ved negativ verdi så blir det

        int[] binArr = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};

    }
}
