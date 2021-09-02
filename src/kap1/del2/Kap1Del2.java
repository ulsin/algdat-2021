package kap1.del2;

import java.util.Arrays;

public class Kap1Del2 {
    public static void main(String[] args) {
        char[] c = {'A','B','C','D','E','F','G','H','I','J'};  // 10 bokstaver

        char[] d = Arrays.copyOfRange(c,4,c.length+1);           // en kopi av c[4:8>
        for (char k : d) System.out.print(k + " ");     // kopien d skrives ut


        System.out.println("\n Oppgave 1222:");
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);
        Tabell.skrivln(a);
        Tabell.skrivln(a,4,9);
        Tabell.skrivln(Tabell.heleTall(5,10));
        Tabell.skrivln(Tabell.naturligeTall(10));

        a = Tabell.randPerm(10);
        int[] c1 = null;

//        Tabell.maks(a,-1,10);
        //Tabell.maks(a,0,11);
        //Tabell.maks(a,10,0);
        //Tabell.maks(a,0,0);
        //Tabell.maks(1,0,0);
    }
}
