package kap4;

import eksempelklasser.*;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        /*TabellStakk<String> sStakk = new TabellStakk<>();

        sStakk.leggInn("Woop");
        sStakk.leggInn("Waaaaap");
        sStakk.leggInn("Snooooot");
        sStakk.leggInn("SnapSNAP");

        System.out.println(sStakk);
        TabellStakk.snu2(sStakk);
        System.out.println(sStakk);

        TabellStakk<String> sStakk2 = new TabellStakk<>();

        TabellStakk.kopier2(sStakk, sStakk2);

        System.out.println(sStakk + " " + sStakk2);

        Stakk<Integer> intStakk = new TabellStakk<>();
        intStakk.leggInn(1);
        intStakk.leggInn(2);
        intStakk.leggInn(5);
        intStakk.leggInn(11);
        intStakk.leggInn(-1);

        System.out.println(intStakk);

        TabellStakk.sorter(intStakk, Comparator.naturalOrder());

        System.out.println(intStakk);
        */

        TabellKø<String> queue = new TabellKø<String>();
        queue.leggInn("A");
        queue.leggInn("B");
        queue.leggInn("C");

        System.out.println(queue);
        System.out.println(queue.indeksTil("B"));
        System.out.println(queue.indeksTil("D"));
        System.out.println(queue.indeksTil("A"));

        TabellKø.snu(queue);
        System.out.println(queue);
        queue.nullstill();
        System.out.println(queue);

        Kø<Integer> kø = new EnkeltLenketListeKø<>();

        for (int i = 1; i <= 10; i++) kø.leggInn(i);

        while (!kø.tom())
        {
            System.out.print(kø.taUt() + " ");
        }

        System.out.println("\n\n\n");

        Kø<Integer> køRand = new EnkeltLenketListeKø<>(Tabell.randPermInteger(10));

        System.out.println(køRand);
        Kø.sorter(køRand, Comparator.naturalOrder());
        System.out.println(køRand);

    }
}
