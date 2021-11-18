package kap5;

import eksempelklasser.BinTre;

import java.util.Comparator;

public class Main3 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};
        Integer[] verdi = {1,3,5,7,6,8,11,12,10,10,15,14,18,15,20};

        BinTre<Integer> tre = new BinTre<>(posisjon, verdi);  // Bruker en konstruktør

        System.out.println(tre);

        System.out.println(tre.minimumsGrenen(Comparator.naturalOrder()));
    }
}
