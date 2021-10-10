package kap1.del4;

import kap1.Tabell;
import kap1.eksempelklasser.*;

import java.awt.*;
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

        for (Studium stud : Studium.values())
        {
            System.out.println(stud.toString() + " (" + stud.name() + ")");
        }
        // Ingeniørfag - data (Data)
        // Informasjonsteknologi (IT)
        // Anvendt datateknologi (Anvendt)
        // Enkeltemnestudent (Enkeltemne)

//        Programkode 1.4.5 b)

        Student[] st = new Student[6];  // en Studenttabell

        st[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        st[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        st[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        st[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        st[4] = new Student("Azra", "Zukanovic", Studium.Elektro);     // Azra Zukanovic
        st[5] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

        Tabell.innsettingssortering(st);                     // Programkode 1.4.2 e)
        for (Student tt : st) System.out.println(tt);

        // Utskrift:
        // Ali Kahn Anvendt
        // Kari Pettersen Data
        // Kari Svendsen Data
        // Azra Zukanovic IT
        // Boris Zukanovic IT

//        Programkode 1.4.5 d)

        Person[] p5 = new Person[5];                       // en persontabell
        p5[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p5[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p5[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p5[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p5[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        class FornavnKomparator implements Komparator<Person>
        {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p5, c);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p5));           // Utskrift av tabellen p
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

        Komparator<Person> c22 = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, c22);                // se Programkode 1.4.6 b)
        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p

//        Programkode 1.4.6 e)

        Tabell.innsettingssortering(p, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p));

//        Programkode 1.4.6 f)

        Student[] s23 = new Student[8];                             // en studenttabell
        s23[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s23[1] = new Student("Kari","Aldra", Studium.Data);      // Kari Svendsen
        s23[2] = new Student("Kari","Aldra", Studium.Anvendt);      // Kari Svendsen
        s23[3] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s23[4] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s23[5] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s23[6] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s23[7] = new Student("Alva","Yikes", Studium.Data);     // Kari Pettersen

        Tabell.innsettingssortering(s23, (s11,s2) -> {
            // setter k til å være return verdi fra comparison
            int kk = s11.studium().toString().compareTo(s2.studium().toString());
            // om kk er 0, så var studimene like, da sorterer vi heller på fornavn
            if (kk == 0) {
                kk = s11.fornavn().compareTo(s2.fornavn());
            }
            // om kk fortsatt er null, sorter på etternavn
            if (kk == 0) {
                kk = s11.etternavn().compareTo(s2.etternavn());
            }
            // til slutt returner vi kk, som enten da har verdi fra studium, fornavn eller etternavn
            return kk;
        });
        System.out.println(Arrays.toString(s23));

//        Programkode 1.4.6 g)

        System.out.println("146i\n\n");

        String[] s146i = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s146i, (s146i1, s146i2) -> {
            int kk = s146i1.length() - s146i2.length();
            if (kk == 0) {
                kk = s146i1.compareTo(s146i2);
            }
            return kk;
        });

        System.out.println(Arrays.toString(s146i));
        // Utskrift: [Per, Lars, Kari, Bodil, Berit, Anders]

//        Programkode 1.4.6 i)

        String[] s3 = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s3, Komparator.orden(String::length));

        System.out.println(Arrays.toString(s3));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

//        Programkode 1.4.7 i)

        Integer[] aa = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
        Tabell.innsettingssortering(aa, Komparator.orden(xx -> xx.toString()));
        System.out.println(Arrays.toString(aa)); // [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]

//        Programkode 1.4.7 j)

//        System.out.println("\n\n Oppgave 1.4.7.2 \n");
        oppgave("Oppgave 1.4.7.2");
        Double[] dd = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(dd, Komparator.naturligOrden());
        System.out.println(Arrays.toString(dd));
        Tabell.innsettingssortering(dd, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(dd));
        // oppgave 1.4.7.2

        oppgave("Oppgave 1.4.7.3");
        Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b, Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));

        oppgave("1.4.7.4");
        p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Komparator.naturligOrden());                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p));           // Utskrift av tabellen p
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

        oppgave("1.4.7.5");
        s = new String[] {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, (z,zz) -> zz.length() - z.length());

        System.out.println(Arrays.toString(s));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        oppgave("1.4.8.4");
        s = new String[] {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(s, Komparator.orden(String::length).deretter(Komparator.naturligOrden()));
        System.out.println(Arrays.toString(s));

        oppgave("1.4.9.1");

        s = new String[] {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> cc =  Comparator.comparing(String::length);  // etter lengde
        Tabell.innsettingssorteringC(s, cc.thenComparing(x9 -> x9));       // vanlig orden
        System.out.println(Arrays.toString(s));                        // skriver ut

//        Programkode 1.4.9 c)

        oppgave("1.4.9.3");

        Comparator<Point> c9 = (p1, p2) ->
        {
            int d9 = p1.x - p2.x;    // forskjellen mellom x-koordinatene
            if (d9 != 0) return d9;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };
//        Programkode 1.4.9 d)

        int[] x9 = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y9 = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x9.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x9[i],y9[i]);

        for (Point p9 : punkt) System.out.print("(" + p9.x + "," + p9.y + ") ");
        System.out.println();                    // linjeskift

        // a)
//        Tabell.innsettingssorteringC(punkt, Comparator.comparing(Point::getX).thenComparing(Point::getY));
        // b)
//        Tabell.innsettingssorteringC(punkt, c9);
        // c)

//        Comparator.comparing((Point p9) -> p9.x).thenComparing(p9 -> p9.y);

//        eller mer effektivt slik:

//        Comparator.comparingInt((Point p9) -> p9.x).thenComparingInt(p9 -> p9.y);


        Tabell.innsettingssorteringC(punkt, Comparator.comparingDouble((Point p9) -> p9.x).thenComparingDouble(p9 -> p9.y));

        for (Point p9 : punkt) System.out.print("(" + p9.x + "," + p9.y + ") ");

        // Utskriften blir:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)

//        Programkode 1.4.9 f)

        oppgave("1.4.9.5");
        Dato[] d9 = new Dato[5];           // en datotabell
        d9[0] = new Dato(24,12,2014);      // 24/12-2014
        d9[1] = new Dato(24,12,2012);      // 24/12-2012
        d9[2] = new Dato(9,12,2013);       // 9/12-2013
        d9[3] = new Dato(25,12,2012);      // 25/12-2012
        d9[4] = new Dato(10,12,2013);      // 10/12-2013

        Tabell.innsettingssortering(d9);
        for (Dato x95 : d9) System.out.print(x95 + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014

//        Programkode 1.4.9 h)

        oppgave("1.4.9.5");

        Klokkeslett[] timeStamp = {
                new Klokkeslett("01:45"),
                new Klokkeslett("00:21"),
                new Klokkeslett("01:32")
        };

        Tabell.innsettingssortering(timeStamp);
        System.out.println(Arrays.toString(timeStamp));

        oppgave("1.4.9.9");


        Tid[] tider = new Tid[4];

        tider[0] = new Tid(24,12,2014,"15:30");
        tider[1] = new Tid(24,12,2014,"12:00");
        tider[2] = new Tid(23,12,2014,"12:00");
        tider[3] = new Tid(23,12,2014,"09:00");

        for (Tid tid : tider) System.out.println(tid);

        System.out.println("\n\nTider sortert\n");

        Tabell.innsettingssortering(tider);

        for (Tid tid : tider) System.out.println(tid);
    }


    public static void oppgave(String oppg) {
        System.out.println("\n\n Oppgave " + oppg + " \n");
    }
}

