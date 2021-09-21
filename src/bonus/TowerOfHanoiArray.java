package bonus;

import java.util.Arrays;

public class TowerOfHanoiArray {
    public static void main(String[] args) {

        towerOfHanoi(5);
    }

    /**
     * Solves tower of hanoi puzzle
     * @param a => pinnen vi starter med brikker på
     * @param b => hjelpepinnen
     * @param c => pinnen vi slutter på
     */
    public static void towerOfHanoi(int nivåer) {

        // initializing value and start array
        int[] a = new int[nivåer];
        int[] b = new int[nivåer];
        int[] c = new int[nivåer];

        for (int i = a.length-1; i >= 0; i--) {
            a[i] = a.length - i;
        }


        // moving everything but the last one from A to B
        hanoiMove(a, b, c, nivåer - 1);

        // printing the arrays as they stand
        for (int j = nivåer-1; j >= 0; j--) {
            System.out.println(a[j] + " | " + b[j] + " | " + c[j]);
        }
        System.out.println("---------\nA | B | C ");

//        if (brikkenr == 0) {
//            return;
//        }
//
//        //Flytt alle unntatt nederste fra A til B (hjelpepinnen)
//        towerOfHanoi(a, c, b, brikkenr-1);
//
//        //Flytt nederste fra A til C
//        System.out.println("Flytter brikke " + brikkenr + " fra " + a + " til " + c);
//
//        //Flytt alle fra B til C
//        towerOfHanoi(b, a, c, brikkenr-1);
    }

    public static void hanoiMove(int[] from, int[] to, int[] helper, int nivå) {
        for (int i = 0; i < from.length; i++) {
            if (to[i] == 0) {
                to[i] = from[nivå];
                from[nivå] = 0;
                break;
            }

        }

    }
}
