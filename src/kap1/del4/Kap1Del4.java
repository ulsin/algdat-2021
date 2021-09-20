package kap1.del4;

import kap1.Tabell;
import kap1.eksempelklasser.Heltall;
import kap1.eksempelklasser.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Kap1Del4 {
    public static void main(String[] args) {
        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        int k = Tabell.maks(a);     // posisjonen til den største i a
        int l = Tabell.maks(d);     // posisjonen til den største i d
        int m = Tabell.maks(s);     // posisjonen til den største i s

        System.out.println(a[k] + "  " + d[l] + "  " + s[m]);

        // Utskrift:  9  7.12  Thanh

//        Programkode 1.4.1 c)

        System.out.println(Tabell.maks(new char[] {'a','f','z','b'}));
        System.out.println(Tabell.maks(new Integer[]{9, 3, 5, 23}));

        Integer iA = 232;
        Integer iB = 232;

        System.out.println(iA.compareTo(iB));

        String s1 = "Karianne", t = "Kari";
        System.out.println(s1.compareTo(t));

        System.out.println(Boolean.compare(false, true));

        String[] sArr = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(sArr);
        System.out.println(Arrays.toString(sArr));  // [Ali, Anne, Eva, Kari, Ole, Per]

        Tabell.skrivln(sArr);

//        Programkode 1.4.2 f)

        Integer[] iArr = Tabell.randPermInteger(10);
        System.out.println(Arrays.toString(iArr));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(iArr);
        System.out.println(Arrays.toString(iArr));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

//        Programkode 1.4.3 e)


        double[] dArr = {5.7, 3.14, 7.12, 3.9, 6.5, 7.1, 7.11};
        Double[] dDArr = Tabell.convertetPrimDouble(dArr);

        Tabell.skrivln(dDArr);

        System.out.println("Programkode 1.4.4 c)");

        int[] aArr = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[aArr.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new Heltall(aArr[i]);
        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

//        Programkode 1.4.4 c)

        System.out.println("d");
        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));

        System.out.println("e");
        Heltall xWhat = new Heltall(3), yWow = new Heltall(3);  // x og y er like
        System.out.println(xWhat.hashCode() + "  " + yWow.hashCode());

        System.out.println("1.4.4.2.b");
        Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        int m2 = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m2] + " er størst");      // skriver ut den største

//        Tabell.innsettingssortering(p);               // generisk sortering
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        // Utskrift:

        // Boris Zukanovic er størst
        // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]

//        Programkode 1.4.4 e)

        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println);

//        Programkode 1.4.4 f)
    }
}
