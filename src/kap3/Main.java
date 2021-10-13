package kap3;

import eksempelklasser.EnkeltLenketListe;
import eksempelklasser.Liste;
import eksempelklasser.Tabell;
import eksempelklasser.TabellListe;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        int[] a = {-1, 2, -19, 3};
        int count = 0;
        for (int i : a) if (i >= 0) count++;
        System.out.println(count);

        TabellListe<String> s = new TabellListe<>();
        s.leggInn("Hey");
//        s.leggInn(null);
        s.leggInn("Woop");
        s.leggInn("Woop");
        System.out.println(s.tom());
        System.out.println(s.hent(2));

        for (String ss : s) System.out.println(ss);

        s.fjern(2);
        System.out.println(s.antall());
        s.leggInn(1,"Legger inn index 1");
        System.out.println(s.hent(1));

        s.leggInn("Woop");
        s.leggInn("Woop");
        s.leggInn("Woop");

        System.out.println("ToString: " +s.toString());

        s.forEach(s1 -> System.out.println(s1));

        s.fjernHvis(s1 -> s1.equals("Woop"));

        System.out.println(s);

        s.nullstill();
        System.out.println("ToString etter nullstilll" + s.toString());

        String[] s2 = {"woooop", null};

        s = new TabellListe<>(s2);
        s.tom();
        System.out.println(s.hent(0));

//       String[] s = {"Per","Kari","Ole"};
//
//        Liste<String> liste = new TabellListe<>();
//
//        for (String navn : s) liste.leggInn(navn);
//
//        System.out.println(liste);

        // Utskrift: [Per, Kari, Ole]
//        Programkode 3.2.5 a)

//        Iterator<String> i = liste.iterator();     // oppretter en iterator
//        System.out.println(i.next());              // den første i listen

//        liste.fjern("Per");                        // fjerner den første
//        System.out.println(i.next());              // den neste i listen

//        Programkode 3.2.5 b)
//
//        Iterator<String> i = liste.iterator();     // oppretter en iterator i
//        Iterator<String> j = liste.iterator();     // oppretter en iterator j
//
//        System.out.println(i.next());              // den første i listen
//        i.remove();                                // fjerner den første
//        System.out.println(j.next());              // den første i listen

//        Programkode 3.2.5 c)
/*

        EnkeltLenketListe<Integer> liste = new EnkeltLenketListe<>();
        liste.leggInn(1);
        liste.leggInn(1);
        liste.leggInn(1);

        System.out.println(liste);

        String[] sArray = {"Woop", "Waap", "Snoot"};
        EnkeltLenketListe<String> sListe = new EnkeltLenketListe<>(sArray);

        sListe.fjern("Snoot");
        sListe.fjern("Snaaaaat");

        System.out.println(sListe);

        sListe.nullstill();
        System.out.println(sListe.tom());
        System.out.println(sListe);

        EnkeltLenketListe<Integer> liste2 = new EnkeltLenketListe<>();

        liste2.leggInn(10);
        liste2.leggInn(0, 11);
        liste2.leggInn(0, 15);

        System.out.println(liste2.antall());
        System.out.println(liste2);

        System.out.println(liste2.indeksTil(11));


        liste2.nullstill();

        System.out.println(liste2);
*/

    }


}
