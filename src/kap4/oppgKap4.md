# Oppgaver til Avsnitt 4.1.1
1. 	Utfør flg. seks operasjoner på en stakk: legg inn 5, legg inn 7, ta ut, legg inn 3, legg inn 7 og ta ut. Hvilket tall ligger nå øverst på stakken?
3 ligger øverst på stacken

2. 	Hva ligger øverst på stakken A etter at flg. kode er utført:
   A.leggInn(2);
   A.leggInn(5);
   A.leggInn(1);
   A.kikk();
   A.taUt()

- 5 Ligger øverst

3. 	Eksempel 2 over inneholder kode som sørger for at verdiene på en stakk A får omvendt rekkefølge ved at de først flyttes fra A til B, så fra B til C og til slutt tilbake til A. Gjør om koden slik at alle verdiene i A blir flyttet til B og at de der får samme rekkefølge som de hadde på A.
```java
  while (!A.tom()) C.leggInn(A.taUt());  // verdiene flyttes fra A til C
  while (!C.tom()) B.leggInn(C.taUt());  // verdiene flyttes fra C til B
```

4. 	Er det mulig å snu rekkefølgen av verdiene på en stakk ved kun å bruke én hjelpestakk og én hjelpevariabel?
- anntar ja

5. 	Er det mulig å flytte verdiene fra en stakk A til en stakk B slik at rekkefølgen på B blir som den var på A, ved kun å bruke én hjelpevariabel og ikke noe annet?
- anntar ja

6. 	Er det mulig å få verdiene på en stakk sortert kun ved å bruke én hjelpestakk og noen enkelte hjelpevariabler?
- anntar ja



# Oppgaver til Avsnitt 4.1.2
1. 	TabellStakk<T> skal ha metoden nullstill() - se Programkode 4.1.2 a). Den skal «tømme» stakken. Dvs. alle referanser skal «nulles» og antall settes til 0. Lag metoden.
```java
    public void nullstill() {
        while (!tom()) {
            taUt();
        }
    }
```

2. 	Lag en toString-metode i klassen TabellStakk<T>. Hvis stakken inneholder (fra toppen og nedover) verdiene 1, 2 og 3, skal metoden returnere strengen "[1, 2, 3]".
```java
    public String toString() {
        if (tom()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (int i = antall-1; i > 0; i--) {
            sb.append(a[i].toString());
            sb.append(", ");
        }
        sb.append(a[0].toString());
        sb.append(']');

        return sb.toString();
    }

```

3. 	Lag public static <T> void snu(Stakk<T> A). Den skal snu rekkefølgen på stakken A. Bruk to TabellStakker som hjelpestakker. Se Figur 4.1.1 c). Parametertypen til A er Stakk<T>. Da er det kun metodene i grensesnitt Stakk<T> som kan brukes.
```java
    public static <T> void snu(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<>();
        Stakk<T> C = new TabellStakk<>();

        while (!A.tom()) {
            C.leggInn(A.taUt()); // C blir A snudd
        }

        while (!C.tom()) {
            B.leggInn(C.taUt()); // B blir A riktig vei
        }

        while (!B.tom()) {
            A.leggInn(B.taUt()); //A blir A snudd
        }
    }
```

4. 	Lag public static <T> void kopier(Stakk<T> A, Stakk<T> B). Den skal kopiere innholdet av A over i B, dvs. A skal ha samme innhold som før etter kopieringen og B skal inneholde de samme verdiene i samme rekkefølge som A. Det antas at B er tom før kopieringen starter. Bruk kun én TabellStakk og en enkelt T-variabel som hjelpemiddel. Typen til A og B er Stakk<T>. Da er det kun metodene i grensesnitt Stakk<T> som kan brukes.
```java
    public static <T> void kopier(Stakk<T> A, Stakk<T> B) {
        Stakk<T> C = new TabellStakk<>();

        while (!A.tom()) {
            C.leggInn(A.taUt()); // C blir A snudd
        }

        while (!C.tom()) {
            T temp = C.taUt(); // B blir A riktig vei
            A.leggInn(temp);
            B.leggInn(temp);
        }
    }
```

5. 	Som Oppgave 3, men én TabellStakk og en enkelt T-variabel som hjelpemiddel.
```java
    public static <T> void snu2(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<>();
        T temp;

        int length = A.antall();

        for (int i = 0; i < length; i++) {
            temp = A.taUt();
            // first takes all out, then all but one, then all but two and so on
            for (int j = 0; j < length - 1 - i; j++) {
                B.leggInn(A.taUt());
            }

            A.leggInn(temp);
            while(!B.tom()) A.leggInn(B.taUt());
        }
    }

```

6. 	Som Oppgave 4, men bruk kun én enkelt hjelpevariabel av typen T.
```java
    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        T temp;
        int length = A.antall();

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - 1 - i; j++) {
                B.leggInn(A.taUt());
            }

            // setting temp to A's last value
            temp = A.taUt();

            A.leggInn(temp);
            for (int j = 0; j < length - 1 - i; j++) {
                A.leggInn(B.taUt());
            }
            B.leggInn(temp);
        }
    }

```

7. 	Metoden public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) skal sortere objektene på A vha. komparatoren c. Lag metoden. Du skal kun bruke én hjelpestakk og noen enkelte hjelpevariabler i kodingen.
```java
    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c) {
        Stakk<T> B = new TabellStakk<>();
        T temp;

        int n = A.antall();

        // attempted bubblesort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                temp = A.taUt();
                if (c.compare(temp, A.kikk()) > 0) {
                    B.leggInn(temp);
                } else {
                    B.leggInn(A.taUt());
                    A.leggInn(temp);
                }
            }
            while(!B.tom()) A.leggInn(B.taUt());
        }
        snu2(A);
    }
```