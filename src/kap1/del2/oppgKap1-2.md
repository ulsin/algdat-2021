# Oppgaver til Avsnitt 1.2.1
1. Lag to min-metoder (metoder som finner posisjonen til den minste verdien) tilsvarende de to maks-metodene i Programkode 1.2.1 b) og 1.2.1 c). Legg dem i samleklassen Tabell. Se Avsnitt 1.2.2.
```java
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int index = fra;
        int minverdi = a[fra];

        for (int i = fra; i < til; i++) {
            if (minverdi > a[i]) {
                index = i;
                minverdi = a[i];
            }
        }

        return index;
    }

    public static int min(int[] a) {
        return min(a, 0, a.length);
    }
```
2. Lag en maks-metode med samme signatur som den i Programkode 1.2.1 b), men som bruker idéen fra Programkode 1.1.5.

```java
    public static int maks3(int[] a, int fra, int til)  // versjon 3 av maks-metoden
    {
        int sist = til - 1;       // siste posisjon i tabellen
        int m = fra;                     // indeks til største verdi
        int maksverdi = a[fra];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static int maks3(int[] a) {
        return maks3(a, 0, a.length);
    }
```
3. Hva skjer hvis siste parameter (to) i copyOfRange i Programkode 1.2.1 d) er større en lengden på tabellen c?
Får dette:

```java
E F G H I J 0 //null er placeholder for en rar empty char
```

4. Finn hvilke metoder i class Arrays som arbeider med tabellintervaller (from/to eller fromIndex/toIndex).

Veldig mange, se [Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)

- binarySearch
- compare
- compareUnsigned
- copyOfRange
- equals
- fill
- mismatch
- paralellPrefix
- paralellSetAll
- paralellSort
- sort

6. I Java 1.5 ble det innført en ny type for-løkke - en såkalt for-alle-løkke. Se Programkode 1.2.1 d). Den må du lære deg hvis du ikke allerede kan den. Se f.eks. Vedlegg E.

# Oppgaver til Avsnitt 1.2.2
1. Bygg opp class Tabell slik som beskrevet i Programkode 1.2.2 a).
- Done
2. Kjør programmet i Programkode 1.2.2 b).

```java
1 9 18 6 10 16 8 20 15 5 13 11 14 12 7 4 19 2 3 17 
Største verdi ligger på plass 7
```
3. Lag metoden public static void bytt(char[] c, int i, int j). Den skal bytte om innholdet i posisjon i og j  i char-tabellen c. Legg metoden i samleklassen Tabell.

```java
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
```

4. Lag metoden public static void skriv(int[] a, int fra, int til). Den skal skrive ut tallene i intervallet a[fra:til> til konsollet - alle på én linje og et mellomrom mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi. Lag så metoden public static void skriv(int[] a). Den skal skrive ut hele tabellen - alle på én linje, en blank mellom hvert tall. Ikke mellomrom og ikke linjeskift etter siste verdi. Legg begge metodene i samleklassen Tabell.

```java
    public static void skriv(int[] a, int fra, int til) {
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void skriv(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
        System.out.print(i + " ");
        }
        System.out.print("]");
        }
```
5. Lag to skrivln-metoder. De skal ha samme signatur og fungere på samme måte som de to skriv-metodene i Oppgave 4 , men utskriften skal avsluttes med et linjeskift. Legg begge metodene i samleklassen Tabell.
```java

    public static void skrivln(int[] a, int fra, int til) {
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void skrivln(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");
    }

```

7. Som i Oppgave 4 og 5, men med en tabell c av typen char[].

```java
    public static void skriv(char[] a, int fra, int til) {
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }

    public static void skriv(char[] a) {
        System.out.print("[ ");
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.print("]");
    }

    public static void skrivln(char[] a, int fra, int til) {
        System.out.print("[ ");
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void skrivln(char[] a) {
        System.out.print("[ ");
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.print("]\n");
    }
```

8. Lag metoden public static int[] naturligeTall(int n). Den skal returnere en heltallstabell som inneholder tallene 1, 2, . . . , n. Hvis n er mindre enn 1 skal det kastes et unntak.  
  Lag også den mer generelle metoden public static int[] heleTall(int fra, int til). Den skal returnere en heltallstabell som inneholder tallene fra og med fra og til, men ikke med, tallet til. For eksempel skal kallet heleTall(1,6) gi tabellen {1, 2, 3, 4, 5}. Hvis fra er større enn til kastes et unntak. Hvis fra er lik til returneres en tom tabell. Legg metodene i samleklassen Tabell. 

```java
    public static int[] naturligeTall(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("maa ha positiv n)");
        }

        int[] retArr = new int[n];
        for (int i = 0; i < retArr.length;) {
            retArr[i] = ++i;
        }
        return retArr;
    }

    public static int[] heleTall(int fra, int til) {
        if (til < fra) {
            throw new IllegalArgumentException("Fra er for liten i forhold til til");
        }
        if (fra == til) {
            return new int[0];
        }

        int[] retArr = new int[til-fra];
        for (int i = 0; i < retArr.length;) {
            retArr[i] = i++ + fra;
        }
        return retArr;
    }
```

# Oppgaver til Avsnitt 1.2.3
1. Legg metodene Programkode 1.2.3 a) og 1.2.3 d), inn i samleklassen Tabell.
- Done
2. Sett deg inn i (se kildekoden) metoden rangeCheck() i Arrays.

```java
    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
```
[Source](https://www.tabnine.com/web/assistant/code/rs/5c659b341095a5000166252f#L375)

3. Gjør om maks-metoden i Programkode 1.2.1 b), som du nå skal ha lagt inn i class Tabell, slik at parameterverditesten blir erstattet med Programkode 1.2.3 b) og c).   
  
  Lag så et testprogram der maks-metoden inngår (bruk main i class Program), men med parameterverdier som du vet vil føre til at unntak kastes. Velg verdier slik at du får frem alle de mulige feilmeldingstypene.
```java
    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
```
4. Gå videre fra Oppgave 3. Dvs. lag også kode som tester parameteren a og som gir en fornuftig feilmelding hvis a er null.

```java
        if (a == null) {
            throw new IllegalArgumentException("Array er null");
        }
```
5. I Oppgave 5, 6 og 7 i Avsnitt 1.2.2 skulle det lages metoder som arbeidet i et halvåpent intervall. Bruk metoden fratilKontroll() til å sjekke at intervallene er lovlige.
- Done

6. Lag metoden public static void snu(int[] a, int v, int h). 

Metoden skal snu rekkefølgen på verdiene i intervallet a[v:h]. 

Hvis intervallet f.eks. inneholder verdiene 4, 2, 13, 7, skal intervallet etter et kall på metodene inneholde 7, 13, 2, 4. Bruk metoden vhKontroll() til å sjekke lovligheten av intervallet. Lag også en metode som snur en hel tabell. Legg metodene i samleklassen Tabell.


7. Gjør som i Oppgave 6, men med en char-tabell. Lag først, hvis du ikke har gjort det tidligere, en bytt-metode som bytter om to elementer i en char-tabell.
8. Sett deg mer inn i bruk av unntak (exceptions). Se f.eks. Vedlegg D. 

## Ble igjen noen siden ukesoppg ikke ber om dem.

# Oppgaver til Avsnitt 1.2.4
1. Legg nestMaks-metoden fra Programkode 1.2.4 a) i samleklassen Tabell. Legg så Programkode 1.2.4 b) inn i main-metoden i klassen Program og sjekk at du får rett svar. Obs. Du får andre svar enn det som eksempelutskriften i Programkode 1.2.4 b) viser siden metoden randPerm gir nye permutasjoner hver gang den kalles.
- Done
2. Lag en versjon av nestmaks-metoden der du bytter om slik at den største kommer forrest. Dermed kan letingen etter den nest største starte i posisjon 1. Pass på og bytt tilbake før metoden avslutter slik at tabellen kommer tilbake i sin originale tilstand. Obs. Det blir et spesialtilfelle her når den nest største verdien ligger forrest i tabellen. Pass på at det tilfellet behandles rett.

```java
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a, 0, m); // bytter m og 0

        nm = maks(a, 1, n);                  // leter i a[1:n>
        
        if (nm == m) {
            nm = 0;
        }

        bytt(a, 0, m); // bytter tilbake
        
        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks
```
3. Som i Oppgave 2, men bytt om slik at den største havner bakerst. Obs. Det blir et spesialtilfelle her når den nest største verdien ligger bakerst i tabellen. Pass på at det tilfellet behandles rett.

```java
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a, n - 1, m); // bytter m og 0

        nm = maks(a, 0, n - 1);                  // leter i a[1:n>

        if (nm == m) {
            nm = n - 1;
        }

        bytt(a, n - 1, m); // bytter tilbake

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks
```
4. Idéen i Oppgave 3 kan utvides til å bli en sorteringsalgoritme. Finn først den største og bytt om slik at den kommer bakerst. Finn så den største i det intervallet som ikke har med den siste og bytt om slik at den kommer nest bakerst. Finn så den største i intervallet som ikke har med de to siste og bytt om slik at den kommer på tredje bakerst. Osv. Lag metoden public static void sortering(int[] a) med dette som idé.

```java
    public static void sortering(int[] a) {
        for (int i = a.length; i >= 0; i--) {
            int m = maks(a, 0, i);  // m er posisjonen til tabellens største verdi
            bytt(a, i - 1, m); // bytter i-1 og m
        }
    }
```


> 5. Hvis du har en min-metode (se Oppgave 1 i Avsnitt 1.2.1) kan du gjøre som i Oppgave 4, men motsatt vei. Finn den minste og bytt om slik at den kommer først. Finn så den minste i det intervallet som starter i posisjon 1 og bytt om slik at den kommer nest først (i posisjon 1), osv. 

## Gjorde ikke 1.2.5 Siden ukesoppg ikke ba om det

# Oppgaver til Avsnitt 1.2.6
1. Sjekk at versjonen av nestMaks-metoden i Programkode 1.2.5 a) utfører nøyaktig 2n − 3 sammenligninger når tabellen er sortert.

```java
  public static int[] nestMaks(int[] a) // ny versjon
  {
    int n = a.length;     // 1
    if (n < 2) throw      // 1
      new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

    int m = 0;      // 1
    int nm = 1;     // 1

    // bytter om m og nm hvis a[1] er større enn a[0]
    if (a[1] > a[0]) { m = 1; nm = 0; } // 1 + 1 + 1, x + x

    int maksverdi = a[m];                // 1
    int nestmaksverdi = a[nm];           // 1

    for (int i = 2; i < n; i++)
    {
      if (a[i] > nestmaksverdi)
      {
        if (a[i] > maksverdi)
        {
          nm = m;
          nestmaksverdi = maksverdi;     // ny nest størst

          m = i;
          maksverdi = a[m];              // ny størst
        }
        else
        {
          nm = i;
          nestmaksverdi = a[nm];         // ny nest størst
        }
      }
    }

    return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

  } // nestMaks
```
????

2. For hvilke tabeller bruker metoden færrest mulig sammenligninger?
- When the two largest numbers are in the front of the array.

3. Er det noen forskjell på gjennomsnittlig effektivitet, effektiviteten i det mest ugunstige tilfellet og effektiviteten i det beste tilfellet for maks-metoden, dvs. for den metoden som finner posisjonen til den største verdien i en tabell?
- Koster minst when maks er first, mest when maks er sist

# Oppgaver til Avsnitt 1.2.8
1. Et «møte» er det samme som en sammenligning. Hvor mange sammenligninger trengs for å gjennomføre en turnering med 16 deltagere slik som i Figur 1.2.8 a)? Hva med 8 deltagere? Hva med 2k deltagere der k er et positivt heltall.
- 15 in the first one, so 2^k - 1 
2. Tegn et turneringstre slik som i Figur 1.2.8 a) for tilfellene: a) 3, 15, 8, 11, 13, 9, 10, 5 og b) 10, 17, 13, 16, 17, 8, 12, 15, 9, 15, 16, 15, 10, 13, 14, 17.

```java
             15
      15            13
  15     11     13    10
3, 15, 8, 11, 13, 9, 10, 5 
         
        
                             17
              17                             17
       17             17             16            17
   17     13      17      15     15     16      13      17
10, 17, 13, 16, 17, 8, 12, 15, 9, 15, 16, 15, 10, 13, 14, 17
```
3. Bruk de samme 16 verdiene som i Figur 1.2.8 a). Lag en turnering for å finne minst verdi.

```java
                              5
              5                              10
      5              23              15             10
  9      5       23     26       15     19      16      10
9, 21, 5, 25, 27, 23, 26, 28, 17, 15, 19, 18, 16, 20, 14, 10
```

# Oppgaver til Avsnitt 1.2.9
1. Finn antall noder i Figur 1.2.8 a)? Hvor mange er bladnoder? Hvor mange er indre noder?
- 16 leaf nodes, 15 inner nodes, 31 in total
2. Hvor mange noder er det på nivå k (k = 0, 1, 2, . . ) i et turneringstre av den typen som Figur 1.2.8 a) viser?
- 2^k where the first level is k = 0
3. Anta at antall deltagere n i en turnering er på formen n = 2^k, dvs. n = 1, 2, 4, 8, osv. Finn svarene på flg. spørsmål uttrykt ved n: 
Hvor mange noder får turneringstreet? Hvilken høyde får treet? Hvor mange er bladnoder og hvor mange er indre noder? Hvor mange sammenligninger utføres i turneringen?
- n = 2^k
- Heigth is log_2(n)
- Leaf nodes are n
- Inner nodes are n - 1
- Comparisons are n - 1
- Total nodes are 2n-1

# Oppgaver til Avsnitt 1.2.10
1. Tegn et turneringstre, slik som i Figur 1.2.10 c), skriv opp de som vinneren har slått ut og finn den nest største verdien for flg. tre samlinger av tall:
      a) 10, 17, 13, 16, 17, 8, 12, 15, 9, 15 | 
- 10 tall totalt, 2n-1 = 19 noder totalt
- 10 blad noder
- 9 inner nodes
- log2(10) rundet opp er 4, 3 blir 8 noder og 4 blir 16, 16 - 10 gjør at 6 har walkover. Skal da fylle nest siste først, så siste 

Riktig forsøk, fylte først nest site rad left to right, så siste rad

```java
                     17
             17,             17, 
        15,      17,    16,     17
   15,    15, 10, 17, 13, 16, 17, 8,
12, 15, 9, 15
```
Vinneren er 17, har slått ut 17, 15, 10 (venstre vinner default når de er like, samle childen som ikke er lik og ikke til venstre)

Feil forsøk, fylte venstre til høyre
```java
                           17
               17                        15
       17             17           15         15
   17      16     17,    8,      12, 15,   9,    15
10, 17, 13, 16, 
```
Vinneren er 17, nest største er 17
Har slått ut 15, 17, 8, 16, 10

  b) 5, 11, 7, 13, 2, 9, 10, 8, 3, 14, 6, 12
12 noder totalt, 16 - 12 = 4 noder har walkover

Riktig forsøk

```java
                       14
              14,                 13
      10,           14,      11,    13
  9,     10,   14,    12,  5, 11, 7, 13,
2, 9, 10, 8, 3, 14, 6, 12
```
Vinneren er 14, har slått ut 13, 10, 12, 3

Feil forsøk, fylte ikke ut nest siste først
```java
                       14
            13                        14
      13            10         14         12
  11,    13,    9,    10,   3,   14,   6,   12
5, 11, 7, 13, 2, 9, 10, 8, 
```
Vinneren er 14, nest største er 13 (finner vest å skjekke childs til vinner nodes, og også uavgjort nodes?)
  c) 5, 11, 7, 13, 2, 9, 10, 8, 3, 14, 6, 12, 9, 13, 4, 7, 13, 1, 14
  19 tall totalt,32 - 19 = 13 har walkover
Riktig forsøk

```java
                                  14
                      14,                        14
              14,              13,          10,          14
       13,         14,     11,   13,    10,    8,    14,    12
   13,   13,    14,  5, 11, 7, 13, 2, 9, 10, 8, 3, 14, 6, 12, 9
13, 4, 7, 13, 1, 14
```
Vinneren er 14, har slått ut 14, 13, 13 5, 1


Feil forsøkkkk
  ```java
                                     14
                       14,                         14, 
              13,             14,           13,          14
        13,         10,    8,    14,    12,    13,    13,   14
    11,    13,    9, 10, 8, 3, 14, 6, 12, 9, 13, 4, 7, 13, 1, 14
  5, 11, 7, 13, 2, 9, 
  ```
Vinner er 14, nest største er 14

# Oppgaver til Avsnitt 1.2.11

Tre forskjellige trær

Tre forskjellige trær
1. Svar på flg. spørsmål for hvert av trærne A, B, C, D, E og F over: a) Er treet komplett? b) Er treet perfekt?  c) Er treet fullt?  d) Hva er treets høyde?  e) Hvor mange bladnoder har treet?  f) Er det et turneringstre?

A: Ikke Komplett, Ikke perfekt, Fult, Høydeen er 3, 6 Bladnoder, Ikke komplett og fult, ikke turnering

B: Ikke Komplett, Ikke perfekt, Fult, Hyden er 3, 6 bladnoder, Ikke komplett og fult, ikke turnering

C: Ikke Komplett, Ikke perfekt, Ikke Fult, Høyden er 3, 6 bladnoder, ikke komplett og fult, ikke turnering

D: Ikke komplett, Ikke perfekt, ikke fullt, høyden er 3, 4 bladnoder, ikke turnering

E:      Komplett, Ikke Perfekt, Fult, Høyde 3, 7 bladnoder, Turnering

F: Ikke komplett, Ikke perfekt, Ikke fult, Høyde 3, 4 blad, Ikke turnering

2. Tegn et perfekt binærtre med høyde 3. Tegn et komplett binærtre med 10 noder. Tegn et komplett 
binærtre med 20 noder.

Perfekt med høyde 3

```java
                x
         x              x 
   x        x       x       x
x     x   x   x   x   x   x   x
```
Komplett med 10 noder

```java
         x
     x      x
  x   x   x   x
x   x   x
```

Komplett med 20 Noder

```java
x
xx
xxxx
xxxxxxxx
xxxxx
```

3. Tegn et fullt binærtre med 5 noder? Hvor mange slike finnes det? Hvor mange fulle binærtrær med 7 noder finnes det? Vis at antallet noder i et fullt binærtre alltid er et odde tall.
Bare oddetall noder i første rad, ellers partal, 1 + n*2 blir alltids oddetall

Fult med 5

```java
      x
  x       x
x   x
```
også

```java
      x
  x       x
        x   x
```

Fult med 7

```java
      x
  x       x
x   x   x   x
```

> 4. Vis at ⌈log2(n+1)⌉ - 1 = ⌊log2(n)⌋ for n >= 1   Se forøvrig Setning 1.2.11. 

# Oppgaver til Avsnitt 1.2.13
1. Sjekk at Programkode 1.2.13 a) virker. Obs: metoden returnerer størst og nest størst verdi og ikke indeksene. Legg inn en setning som skriver ut tabellen b etter ut turneringen er gjennomført. Dermed kan en se resultatet av turneringen.

2. La Programkode 1.2.13 a) returnere indeksene til størst og nest størst verdi.

3. Metoden public static void kopier(int[] a, int i, int[] b, int j, int ant) skal virke som arraycopy() fra class System. Lag den!

4. Gitt tabeller int[] a og int[] b med a.length <= b.length. Lag kode, vha. arraycopy() eller vha. kopier() fra Oppgave 3, slik at 1) a kopieres inn først i b,  2) a kopieres inn bakerst i b og 3) a kopieres inn på midten av b (gitt at lengdeforskjellen er et partall). 
