package kap5;

import eksempelklasser.SBinTreII;
import eksempelklasser.SBinTre;

import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        SBinTreII<Integer> tre1 = SBinTreII.sbintre();          // 1. konstruksjonsmetode

        Comparator<Integer> c = Comparator.naturalOrder();
        SBinTreII<Integer> tre2 = SBinTreII.sbintre(c);         // 2. konstruksjonsmetode

        System.out.println(tre1.antall() + " " + tre2.antall());

        // Utskrift: 0 0

//        Programkode 5.2.2 d)

        // Oppgave

        System.out.println("Oppgave 524");

        SBinTre<Character> tre21 = SBinTre.naturligOrdenTre();

        char[] charArr = "IEOAGMCFHKNBDJL".toCharArray();

        for (char ci : charArr) {
            tre21.leggInn(ci);
        }

        System.out.println(tre21.antall());
        System.out.println(tre21.høyde());
        System.out.println(tre21);

        Integer[] intArr = {8, 2, 10, 1, 6, 9, 14, 4, 7, 12, 15, 3, 5, 11, 13};

        SBinTre<Integer> tre22 = SBinTre.naturligOrdenTre(intArr);

        System.out.println(tre22.antall());
        System.out.println(tre22.høyde());
        System.out.println(tre22);


        System.out.println("Oppgave 525");

        SBinTre<String> tre = SBinTre.balansert("ABCDDEFFGH".split(""));
        System.out.println(tre.antall() + " " + tre.høyde() + " " + tre);

//        System.out.println("526");
//        System.out.println(tre.antall("D"));
////        Programkode 5.2.5 c)
//
//        System.out.println("Liste oppgave");
//
//        System.out.println(tre.intervallsøk("B","E"));
//
//        System.out.println(tre.maks());
//
//        System.out.println(tre.maks2());
//
//        System.out.println(tre.gulv("J"));
//
//        System.out.println(tre.mindre("A"));;
//
//        System.out.println(tre.fjernAlle("D"));
//
//        tre.fjernMaks();
//
//        System.out.println(tre);
//
//        tre.leggInn("Z");
//        tre.leggInn("Z");
//        tre.leggInn("Z");
//
//        System.out.println(tre);
//
//        tre.fjernAlleMaks();
//
//        System.out.println(tre);

//        tre.nullstill();

        System.out.println(tre);

        Iterator<String> iterator = tre.iterator("F");


        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println(" ");

        System.out.println(tre);

        Iterator<String> riterator = tre.ritetator();

        while (riterator.hasNext()) {
            System.out.print(riterator.next() + " ");
        }

        System.out.println(" ");

        Iterator<String> riterator2 = tre.ritetator("D");

        while (riterator2.hasNext()) {
            System.out.print(riterator2.next() + " ");
        }



/*

//        Hvis alt dette er lagt inn i klassen SBinTre (og i den lokale klassen InordenIterator ), vil flg. kodebit vise hvilken effekt dette får:

        Integer[] a = {2,8,6,1,7,4,3,9,5,10};                  // verdier
        SBinTre<Integer> tre23 = SBinTre.sbintre(Stream.of(a));  // Programkode 5.2.3 c)

        Iterator<Integer> i = tre23.iterator();      // en iterator er opprettet

//        tre23.leggInn(6);  // en innlegging er en endring
        i.next();        // kaster en ConcurrentModificationException
*/

//        Programkode 5.2.9 h)
    }
}