package kap1.del4;

import kap1.Tabell;
import kap1.eksempelklasser.*;

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

        Student[] s23 = new Student[5];                             // en studenttabell
        s23[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s23[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s23[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s23[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s23[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen

        Tabell.innsettingssortering(s23, (s11,s2) -> s11.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s23));

//        Programkode 1.4.6 g)

    }
//    Programkode 1.4.6 c)
}

