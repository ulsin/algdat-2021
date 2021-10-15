package kap4;

import eksempelklasser.Stakk;
import eksempelklasser.Tabell;
import eksempelklasser.TabellStakk;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        TabellStakk<String> sStakk = new TabellStakk<>();

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
    }
}
