package kap3;

import eksempelklasser.Tabell;
import eksempelklasser.TabellListe;

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

        System.out.println(s.toString());

        s.nullstill();
        System.out.println("ToString etter nullstilll" + s.toString());

        String[] s2 = {"woooop", null};

        s = new TabellListe<>(s2);
        s.tom();
        System.out.println(s.hent(0));

    }

}
