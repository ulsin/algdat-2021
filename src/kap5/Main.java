package kap5;

import eksempelklasser.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,17,18,19,21,23,26,27,29};
        Character[] verdi = {'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V'};

        BinTre<Character> tre = new BinTre<>(posisjon, verdi);  // den nye konstruktøren

//        Programkode 5.1.5 d)

        int[] posisjon2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,17,18,19,21,23,26,27,29};
        String[] verdi2 = {"A","B","C","D","E","F","G","H","I","J","K",
                "L","M","N","O","P","Q","R","S","T","U","V"};

        BinTre<String> tre2 = new BinTre<>(posisjon2, verdi2);  // den nye konstruktøren

//        Programkode 5.1.5 e)

        int[] posisjon3 = {1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 20, 24, 25, 40, 41};
        Character[] verdi3 = {'D', 'I', 'H', 'L', 'O', 'B', 'A', 'E', 'N', 'G', 'K', 'M', 'J', 'F', 'C'};

        BinTre<Character> tre3 = new BinTre<>(posisjon3, verdi3);

        //Oppgave

        int[] posisjon4 =  {1, 2, 3, 5, 10, 11, 22, 23, 44, 47};
        Integer[] verdi4 = {1, 2, 3, 4,  5,  6,  7,  8,  9, 10};

        BinTre<Integer> tre4 = new BinTre<>(posisjon4, verdi4);

        //Oppgave

        int[] posisjon5 = new int[15];
        Integer[] verdi5 = new Integer[15];

        for (int i = 1; i < 16; i++) {
            posisjon5[i-1] = i;
            verdi5[i-1] = i;
        }

        BinTre<Integer> tre5 = new BinTre<>(posisjon5, verdi5);

        //Oppgave


        int[] posisjon6 = new int[15];
        Integer[] verdi6 = new Integer[15];

        posisjon6[0] = 1;
        verdi[0] = 1;

        for (int j = 1; j < 15; j++) {
            posisjon6[j] = 2*posisjon6[j-1] + 1;
            verdi6[j] = j+1;
        }

        BinTre<Integer> tre6 = new BinTre<>(posisjon6, verdi6);

        //Oppgave


        BinTre<Integer> tre7 = new BinTre<>();

        tre7.leggInn(1, 1);

        int v = 2, h = 3;

        for (int l = 2; l < 8; l+= 2) {
            tre7.leggInn(v,l);
            tre7.leggInn(h,l+1);

            v *= 2;
            h = h * 2 + 1;
        }

        // Oppgave

        int[] pos8 = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] ver8 = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre8 = new BinTre<>(pos8, ver8);        // en konstruktør
//        tre8.nivåorden();  // Utskrift: E I B G A H K L O D N M C J F
        tre8.nivåorden(c -> System.out.print(c + " "));  // lambda-uttrykk som argument

//        Programkode 5.1.6 f)

        System.out.println(" ");

//        Programkode 5.1.6 b)

        Liste<Character> liste = new TabellListe<>();  // en liste
        tre.nivåorden(c -> liste.leggInn(c));          // lambda-uttrykk som argument
        System.out.println(liste);                     // skriver ut listen

//        Programkode 5.1.6 g)

        tre.nivåorden(Oppgave.konsollutskrift().deretter(c -> System.out.print(' ')));

//        Programkode 5.1.6 j)

        System.out.println(" ");

        BinTre<Character> tre9 = new BinTre<>();             // et tomt tre

        int[] p = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner i nivåorden
        String v1 = "EIBGAHKLODNMCJF";                       // verdier i nivåorden

        StringJoiner sj = new StringJoiner(", ", "[", "]");
        StringJoiner sj1 = new StringJoiner(", ", "[", "]");

        for (int z = 0; z < p.length; z++) {
            tre9.leggInn(p[z], v1.charAt(z));

        }

        tre9.nivåorden(c -> sj.add(c.toString()));
        tre9.nivåorden(c -> {
            if (c.toString().compareTo("D") > 0) {
                sj1.add(c.toString());
            }
        });


        System.out.println(sj);
        System.out.println(sj1);

        // Oppgave

        String[] maks = {""};
        tre8.nivåorden(c -> {
            if (c.toString().compareTo(maks[0]) > 0) {
                maks[0] = c.toString();
            }
        });  // lambda-uttrykk som argument

        System.out.println(maks[0]);

        // Oppgave

        int[] posisjon11 = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // nodeposisjoner
        String[] verdi11 = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre11 = new BinTre<>(posisjon11, verdi11);        // en konstruktør

        int[] nivåer = tre11.nivåer();  // bruker Programkode 5.1.6 k)

        System.out.print("Nivåer: " + Arrays.toString(nivåer));
        System.out.print(" Treets bredde: " + nivåer[Tabell.maks(nivåer)]);
        System.out.println(" Treets høyde: " + (nivåer.length - 1));

        // Utskrift: Nivåer: [1, 2, 4, 4, 4] Treets bredde: 4 Treets høyde: 4

//        Programkode 5.1.6 l)

        int[] posisjon12 = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og

        // preorden
        String[] verdi12 = "ABICDJLEFKMGHNO".split("");              // verdier i preorden

        // posorden
        String[] verdi13 = "OGNAFIMBEHLCDJK".split("");              // verdier i nivåorden

        BinTre<String> tre12 = new BinTre<>(posisjon12, verdi12);        // en konstruktør
        BinTre<String> tre13 = new BinTre<>(posisjon12, verdi13);        // en konstruktør

        StringJoiner s = new StringJoiner(", " ,"[", "]");         // StringJoiner
        StringJoiner s2 = new StringJoiner(", " ,"[", "]");         // StringJoiner

        tre12.preorden(tegn -> s.add(tegn));                         // tegn = String
        tre13.postordenLoop(tegn -> s2.add(tegn));                         // tegn = String


        System.out.println(s);
        System.out.println(s2);
        // Utskrift: [E, I, G, A, L, O, M, C, B, H, D, K, N, J, F]

        StringJoiner s3 = new StringJoiner(", " ,"[", "]");
        tre13.nullstill();

        tre13.postorden(tegn -> s3.add(tegn));                         // tegn = String

        System.out.println(s3);




//        Programkode 5.1.7 b) Oppgave

        int[] posisjon15 = {1,2,3,4,5,6,7,8,9,10};             // posisjoner og
        String[] verdi15 = "ABCDEFGHIJ".split("");             // verdier i nivåorden

        BinTre<String> tre15 = new BinTre<>(posisjon15, verdi15);  // konstruktør

        for (String s15 : tre15) {
            if (s15.equals("F")) {
                break;
            }
            System.out.print(s15 + " ");      // for-alle-løkke
        }
        // Utskrift: H D I B J E A F C G

        System.out.println(" ");

        Iterator<String> tre15om = tre15.omvendtIterator();

        while (tre15om.hasNext()) {
            System.out.print(tre15om.next() + " ");
        }

        System.out.println("preiterator: \n");

        Iterator<String> tre15pre = tre15.preIterator();

        while (tre15pre.hasNext()) {
            System.out.print(tre15pre.next() + " ");
        }

//        Programkode 5.1.11 f)

        System.out.println(" ");

        System.out.println(tre15.antallBladnoder());
        System.out.println(tre15.maksPos());

    }
}
