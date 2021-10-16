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

# Oppgaver til Avsnitt 4.2.1
1. 	Wikipedia har en artikkel om Queue. Les hva som står der.
- Done


2. 	Det er enkelt å snu innholdet av en kø hvis en kan bruke en stakk som hjelpemiddel. Da er det bare å legge alle verdiene fra køen over på stakken og så ta dem fra stakken og legge dem tilbake i køen. Dvs. slik:

  while (!kø.tom()) stakk.leggInn(kø.taUt());     // fra kø til stakk
  while (!stakk.tom()) kø.leggInn(stakk.taUt());  // fra stakk til kø

Men er det mulig å snu innholdet i en kø:
  	a) Ved å bruke to hjelpekøer? Se også Oppgave 11 i Avsnitt 4.2.2.
      - Anntar ja? Du kan bytte på hvem du bruker som holder og hvem du har som kø som tar imot
  	b) Ved å bruke én hjelpekø og noen hjelpevariabler? Se også Oppgave 12 i Avsnitt 4.2.2.
      - Ja blir samme som over
  	c) Ved å bruke kun hjelpevariabler? Se også Oppgave 13 i Avsnitt 4.2.2. 
      - Anntar ja siden det er en oppgave

# Oppgaver til Avsnitt 4.2.2
1. 	Tegn en sirkulær tabell med plass til 16 verdier. Sett på indeksene/posisjonene slik som i Figur 4.2.2 f). Fra starten av er både fra og til lik 0.

a) Legg inn fortløpende A, B, C, D, E, F, G, H, I og J i tabellen du har tegnet. Ta så ut fortløpende fem verdier. Hva blir nå fra og til? Sjekk ved hjelp av tegningen at koden for metoden antall() regner ut rett svar for antallet.
- fra =5 , til = 10, antall = 10 - 5 = 5

b) Fortsett fra a) og legg inn fortløpende K, L, M, N, O, P, Q, R, S og T i tabellen. Ta så ut fortløpende tre verdier. Hva blir nå fra og til? Sjekk ved hjelp av tegningen at koden for metoden antall() fortsatt regner ut rett svar for antallet.
- til = 5, tabellen utvides med lengde lik 32, øverste index lik 31, og til = 15 og fra = 0
- tar ut 3, til = 15, fra =  3
- antall = 15 - 3 = 12
    
c) Fortsett fra b). Ta ut fortløpende alle verdiene. Hva blir nå fra og til?
til = fra = 15

1. 	Tegn en sirkulær tabell med plass til 8 verdier. Sett på indekser fra 0 til 7. Sett både fra og til lik 0. Legg inn forløpende A, B, C, D, E, F, G og H. Hva blir fra og til?
tabellen utvides, fra = 0 og til = 8, antall = 16


2. 	Fortsett fra Oppgave 2. Ta ut fortløpende tre verdier. Legg så inn I, J og K. Hva blir fra og til? Ta ut fortløpende alle verdiene. Hva blir fra og til? Poenget er at fra lik til kan bety at køen er tom eller at den er full. Men hvis vi sørger for at den aldri er full, så betyr likhet mellom fra og til at køen er tom.
fra = 3, til = 11, så fra = til = 11

3. 	Flytt grensesnittet Kø over i ditt prosjekt (f.eks. under hjelpeklasser).
- Done

4. 	Flytt klassen TabellKø over i ditt prosjekt (f.eks. under hjelpeklasser). Legg inn de ferdige metodene antall(), leggInn(), utvidTabell() og taUt() inn i klassen
- Done

5. 	Lag kode for metodene kikk(), tom() og nullstill() i TabellKø. Se grensesnittet Kø.
```java
    public T kikk() {
        return a[fra];
    }
```

```java
    public boolean tom() {
        return fra == til;
    }
```

```java
    public void nullstill() {
        for (int i = 0; i < antall(); i++) {
            a[fra] = null;                    // nuller innholdet
            fra++;                            // øker fra med 1
            if (fra == a.length) fra = 0;
        }
        fra = 0;
        til = 0;
    }
```


6. 	Lag kode for metoden toString i TabellKø. Hvis køen er tom skal den returnere tegnstrengen "[]". Hvis den f.eks. inneholder A, B og C skal den returnere "[A, B, C]".
```java
    public String toString() {
        if (tom()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int fraTemp = fra;

        for (int i = antall(); i > 1; i--) {
            sb.append(a[fraTemp++].toString());
            sb.append(", ");

            if(fraTemp == a.length) fraTemp = 0;
        }

        sb.append(a[fraTemp]);
        sb.append(']');

        return sb.toString();
    }
```

7. 	Det kan være aktuelt å kjenne til hvor langt ut i køen en bestemt verdi ligger. Legg inn metoden public int indeksTil(T verdi) som en ekstra metode i TabellKø. Den skal returnere posisjonen til første forekomst av verdi i køen. Ligger verdi først er posisjonen 0, nest først 1, osv. Hvis verdi ikke ligger i køen, skal metoden returnere -1.
```java
    public int indeksTil(T verdi) {
        int count = 0;

        int fraTemp = fra;

        for (int i = antall(); i > 0; i--) {
            if (a[fraTemp++] == verdi) {
                return count;
            }
            count++;

            if(fraTemp == a.length) fraTemp = 0;
        }
        return -1;
    }
```


8. 	Lag metoden public static <T> void snu(Stakk<T> A). Den skal snu rekkefølgen av verdiene på stakken A. Bruk en kø som hjelpemiddel i kodingen.
```java
    public static <T> void snu3(Stakk<T> A) {
        TabellKø<T> queue = new TabellKø<T>();

        while (!A.tom()) queue.leggInn(A.taUt());
        while (!queue.tom()) A.leggInn(queue.taUt());
    }
```

9.  Lag metoden public static <T> void snu(Kø<T> A). Den skal snu rekkefølgen av verdiene i køen A. Bruk en stakk som hjelpemiddel i kodingen. 
```java
    public void snu(Kø<T> A) {
        TabellStakk<T> B = new TabellStakk<>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) A.leggInn(B.taUt());
    }
```

# Oppgaver til Avsnitt 4.2.4
1. 	La klassen EnkeltLenketListe implementere Kø. Se Programkode 4.2.4 a). Legg så inn de to metodene kikk() og taUt(). Sjekk at Programkode 4.2.4 c) virker.
- Done

4. 	Metoden public static <T> void sorter(Kø<T> kø, Stakk<T> stakk, Comparator<? super T> c) skal sortere kø, mens stakk kun skal fungere som hjelpestruktur. Metoden skal kodes uten bruk av andre hjelpestrukturer. Sjekk så at metoden virker uansett hva slags kø eller stakk vi bruker: TabellKø, EnkeltLenketListe (se oppgave 1), LenketKø, TabellStakk eller LenketStakk. F.eks. skal flg. kode virke: 
```java
    public static <T> void sorter(Kø<T> kø, Stakk<T> stakk, Comparator<? super T> c) {

        int n = kø.antall();
        
        for (int i = n; i > 0; i--) {
            stakk.leggInn(kø.taUt());
            
            for (int j = 1; j < i; j++) {
                T temp = kø.taUt();
                
                if (c.compare(temp, stakk.kikk()) > 0) {
                    kø.leggInn(stakk.taUt());
                    stakk.leggInn(temp);
                } else {
                    kø.leggInn(temp);
                }
            }
        }
        while (!stakk.tom()) kø.leggInn(stakk.taUt());
    }
```

TODO:
Seksjon 4.2.4: oppgave 1, 4