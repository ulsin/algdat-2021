package kap1.del3;

import static kap1.Tabell.*;

import kap1.Tabell;
import oblig1Lokal.main.java.no.oslomet.cs.algdat.Oblig1.Oblig1;

import java.util.Arrays;

public class Kap1Del3 {
    public static void main(String[] args) {
//        int[] values2 = {10, 5, 7, 2, 9, 1, 3, 8, 4, 6};
//        System.out.println(Arrays.toString(values2));
//        lowerPerm(values2);
//        System.out.println(Arrays.toString(values2));
//        lowerPerm(values2);
//        System.out.println(Arrays.toString(values2));
//        lowerPerm(values2);
//        System.out.println(Arrays.toString(values2));
//
//        // Programkode 1.3.1 c)
//        System.out.println("Programkode 1.3.1 c)");
//        int[] a = {3,1,4,9,7,10,8,6,5,2};        // permutasjon av tallene fra 1 til 10
//        nestePermutasjon(a);              // lager neste permutasjon
//        System.out.println(Arrays.toString(a));  // [3, 1, 4, 9, 8, 2, 5, 6, 7, 10]
//
//        //        Programkode 1.3.1 d)
//        System.out.println("Programkode 1.3.1 d)");
//        int[] b = {1,2,3,4,5};                // første permutasjon
//        int sum = 0;                          // hjelpevariabel
//
//        do { sum += antallMaks(b); }          // se Programkode 1.1.9 a)
//        while (nestePermutasjon(b));   // lager neste permutasjon
//
//        System.out.println(sum);              // Utskrift: 154
//
//        int[] woop = {2, 3, 6, 1, 4, 5};
//        int[] woop2 = {2, 3, 1, 6, 5, 4};
//        nestePermutasjon(woop);
//        System.out.println(Arrays.toString(woop));
//        nestePermutasjon(woop);
//        System.out.println(Arrays.toString(woop));
//        nestePermutasjon(woop2);
//        System.out.println(Arrays.toString(woop2));

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

//        int[] woop5 = randPerm(10);
//        System.out.println(Arrays.toString(woop5));
//        selectionSortNoHelp(woop5, 0,5);
//        System.out.println(Arrays.toString(woop5));
//
//        //        Programkode 1.3.5 c)
//        System.out.println("Programkode 1.3.5 c)");
//        int[] c = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
//        int[] d = new int[0];
//        System.out.println(Tabell.lineærsøk(c,2));              // utskrift: -1
//        System.out.println(Tabell.lineærsøk(c,15));             // utskrift: -6
//        System.out.println(Tabell.lineærsøk(c,16));             // utskrift: 5
//        System.out.println(Tabell.lineærsøk(c,40));             // utskrift: 14
//        System.out.println(Tabell.lineærsøk(c,41));             // utskrift: -16
//        System.out.println(Tabell.lineærsøk(d,2));              // utskrift: -1
//        // ser ut som at ved negativ verdi så blir det
//
//        System.out.println("Oppgave 1.3.6");
//        int[] binArr = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
//        System.out.println("Binærsøk 1");
//        System.out.println(binærsøk1(binArr, 4));  // 3
//        System.out.println(binærsøk1(binArr, 7));  // 8
//        System.out.println(binærsøk1(binArr, 10)); // 12
//        System.out.println(binærsøk1(binArr, 15)); // 14
//        System.out.println("Binærsøk 3");
//        System.out.println(binærsøk3(binArr, 4));
//        System.out.println(binærsøk3(binArr, 7));
//        System.out.println(binærsøk3(binArr, 10));
//        System.out.println(binærsøk3(binArr, 15));

        //        Programkode 1.3.8 e)
//        int[] e = {13,11,10,20,15,5,3,2,14,10,12,6,7,4,16};
//        Tabell.innsettingssortering(e);
//        System.out.println(Arrays.toString(e));
        // Utskrift: [2, 3, 4, 5, 6, 7, 10, 10, 11, 12, 13, 14, 15, 16, 20]

        //        Programkode 1.3.8 h)
//        int[] gap = {1,4,10,23,57,132,301,701,1577,3548,7984,17965,40423,90952,204642};
//        int[] a = Tabell.randPerm(200_000);       // en tilfeldig tabell
//        System.out.println(Tabell.erSortert(a));  // sjekker tabellen
//
//        long tid = System.currentTimeMillis();    // starter klokken
//
////        Tabell.innsettingssortering(a);           // sorterer | 4350ms
////        for (int i = gap.length - 1; i >= 0; i--) Tabell.shell(a,gap[i]); // | 41ms
////        Arrays.sort(a); // | 107ms
//
//
//        System.out.println(System.currentTimeMillis() - tid);  // tiden
//        System.out.println(Tabell.erSortert(a));  // sjekker sorteringen

        int[] a = {13,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,1,20,19};
        // v stopper 13, h goes to 1, swaps
        // 1,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,13,20,19
        // v stops at 16, h to 6, swaps
        // 1,2,8,10,6,9,15,4,18,14,12,11,7,5,3,16,17,13,20,19
        // v tops at 15, h at 3
        // 1,2,8,10,6,9,3,4,18,14,12,11,7,5,15,16,17,13,20,19
        // 1,2,8,10,6,9,3,4,5,14,12,11,7,18,15,16,17,13,20,19
        // 1,2,8,10,6,9,3,4,5,7,12,11,14,18,15,16,17,13,20,19

        int pos = Tabell.parter(a, 11);   // bruker 11 som skilleverdi
        System.out.println(pos + "  " + Arrays.toString(a) + " " + a[pos]);



    }
}
