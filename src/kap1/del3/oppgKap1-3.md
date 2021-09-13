# Ukeoppgaver uke 36

##Seksjon 1.3.1:
1. Legg metodene fra Programkode 1.3.1 a) og Programkode 1.3.1 b) i samleklassen Tabell.
- Done
2. Gitt flg. permutasjoner av tallene fra 1 til 6: 

a) 2 3 6 1 4 5
- 236154
- [2, 3, 6, 1, 5, 4]

b) 2 3 6 1 5 4
- 236415
- [2, 3, 6, 4, 1, 5]

c) 2 3 1 6 5 4
- 234156
- [2, 3, 4, 1, 5, 6]

d) 2 3 6 5 4 1
- 241356

e) 2 6 5 4 3 1
- 312456

Finn, for hver av dem, den neste i leksikografisk rekkefølge. Bruk så metoden nestePermutasjon som fasit.


3. Skriv opp de 10 første permutasjonene som kommer etter 3 1 4 9 7 10 8 6 5 2 leksikografisk. Bruk metoden nestePermutasjon som fasit.
- 3 1 4 9 7 10 8 6 5 2


1. 3 1 4 9 8 2  5 6 7 10
1. 3 1 4 9 8 2  5 6 10 7
1. 3 1 4 9 8 2  5 7 6 10
1. 3 1 4 9 8 2  5 7 10 6
1. 3 1 4 9 8 2  5 10 6 7
1. 3 1 4 9 8 2  5 10 7 6
1. 3 1 4 9 8 2  6 5 7 10
1. 3 1 4 9 8 2  6 5 10 7
1. 3 1 4 9 8 2  6 7 5 10
1. 3 1 4 9 8 2  6 7 10 5


##Seksjon 1.3.2: 
1. Hvor mange inversjoner har premutasjonen 3 5 4 7 6 8 1 2 9 10 ?
- 31 32 
- 54 51 52
- 41 42
- 76 71 72
- 61 62
- 81 82
- 14 inversjoner totalt

##Seksjon 1.3.4: 
oppgave 1, 3, 5, 9, 10, 11
1. I Figur 1.3.4 d) er det gjort tre iterasjoner. Hva blir det etter i) 5 og ii) 7 iterasjoner.
5: 3 	4 	5	6 	7 	19 	21 	23 	10	14 	15 	11 	16 	17	8
7: 3 	4 	5	6 	7 	8 	10 	23 	21	14 	15 	11 	16 	17	19

2. Legg metoden i Programkode 1.3.4 a) inn i samleklassen Tabell. Pass på at du da allerede har metodene bytt() og min() der. Se også Oppgave 1 i Avsnitt 1.2.1. Sjekk så at Programkode 1.3.4 b) virker.
- Done


5. utvalgssortering i Programkode 1.3.4 a) bruker to hjelpemetoder. Det er mest vanlig å kode den uten hjelpemetoder. Søk på internett. Bruk «selection sort» som søkeord. Lag så din egen versjon (uten hjelpemetoder)! Hvor lang tid bruker den for en tilfeldig tabell med 100000 verdier? Er den bedre enn den fra Programkode 1.3.4 a)?
- Compendums 1853
- Mine       1755

9. Lag metoden public static void utvalgssortering(int[] a, int fra, int til). Den skal sortere intervallet a[fra:til>. Pass på at du tester lovligheten til intervallet!
```java
    // wow this is just really bad
    public static void selectionSortNoHelp(int[] a, int from, int to) {
        fratilKontroll(a.length, from, to);
        if (from < to) {
            for (int i = from + 1; i < to; i++) {

                // starting with finding minvalue
                int index = from;
                int minverdi = a[from];

                for (int j = from; j < to; j++) {
                    if (minverdi > a[j]) {
                        index = j;
                        minverdi = a[j];
                    }
                }
                // testing the minimum value and swapping if it is smaller than current
                if (a[from] > minverdi) {
                    int temp = a[from];
                    a[from] = a[index];
                    a[index] = temp;
                    selectionSortNoHelp(a, from++, to);
                }
            }
        }
    }
```



10. En sorteringsalgoritme kalles stabil hvis like verdier har samme innbyrdes rekkefølge etter sorteringen som de hadde før. Er utvalgssortering stabil?
- Nei, tallene flyttes jo rundt


11. Ta utgangspunkt i den versjonen av utvalgssortering som står i Programkode 1.3.4 a). Men gjør ingen ombytting i det tilfellet samme verdi vil bli byttet med seg selv. Det vil påføre algoritmen en ekstra kostnad siden det må gjøres en sammenligning hver gang, men spare arbeidet med unødvendige ombyttinger. Finn ut, ved å bruke tilfeldige permutsajoner, hvor mange ganger det skjer at en verdi ville ha blitt byttet med seg selv. Spesielt hvis tabellen allerede er sortert, byttes en verdi med seg i hver iterasjon. Kanskje du klarer å finne en formel for det gjennomsnittlige antall ganger en verdi vil bli byttet med seg selv? Vil det lønne seg å ha denne ekstra testen?
- Yikes



##Seksjon 1.3.5: 
2. Sjekk at metoden lineærsøk gir korrekt returverdi hvis det søkes etter en verdi som er mindre enn den minste i tabellen. Hva skjer hvis tabellen er tom, dvs. a.length = 0? La a være tabellen i Figur 1.3.5 a). Hva blir returverdiene fra lineærsøk hvis vi søker etter 2, 15, 16, 40 og 41?
 - Gir -1 ved 2, er det riktig? Skal den ikke gi -0?
 - gir -1 ved 0 også

4. Hvis verdi forekommer flere ganger i tabellen a, vil posisjonen til den første av dem (fra venstre) bli returnert. Lag en versjon av lineærsøk der det er posisjonen til den siste av dem som returneres. Gjør det f.eks. ved å lete motsatt vei, dvs. fra høyre mot venstre.
    ```java
    //oppgave 1.3.5.4
    public static int lineærsøkReverse(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = a.length - 1; for( ; i > 0; i--);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }	
    ```

5. I lineærsøk sammenlignes én og én tabellverdi med verdi. Algoritmen stopper på verdi hvis den finnes og på den første som er større hvis den ikke finnes. Dette kan forbedres hvis vi «hopper» bortover i tabellen. La oss si at tabellen a har 100 verdier. Da kan vi f.eks. se på hver 10-ende verdi inntil vi har kommet langt nok (eller eventuelt havnet utenfor tabellen). Den søkte verdien må da, hvis den er i tabellen, ligge blant de 10 siste verdiene vi hoppet over.
      a)  I metoden public static int lineærsøk(int[] a, int k, int verdi) skal a og verdi være som i vanlig lineærsøk. Parameter k (et positivt heltall) er «hopplengden». I beskrivelsen over var k lik 10. Metoden skal returnere nøyaktig det samme som vanlig lineærsøk, også i det tilfellet den søkte verdien ikke finnes.
```java
    //oppgave 1.3.5.5a
    public static int lineærsøkHopp(int[] a, int k, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i += k) {
            if (a[i] > verdi) {
                i -= k;
                for (; i < verdi; i++);
            }
        }
        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
```

b)  Test metoden fra a) med ulike verdier på k (k = 1 gir vanlig lineærsøk).
c)  Hvis «hopplengden» k settes lik heltallsdelen av kvadratroten til tabellens lengde, får vi den beste utnyttelsen av metodens idé. Hvilken orden vil metoden da få? Bruk det til å lage metoden public static int kvadratrotsøk(int[] a, int verdi). 
```java
    public static int kvadratrotSøk(int[] a, int verdi) // legges i class Tabell
    {
        return lineærsøkHopp(a, (int) Math.floor(Math.sqrt(a.length)), verdi);
    }
```


## Seksjon 1.3.6: 
3. 	Gitt at søkeverdien har duplikater. Bruker vi 1. eller 2. versjon av binærsøk, vet vi ikke hvem av dem som den returnerte indeksen hører til. Gitt verdiene: 1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15. Bruk 1. versjon. Søk etter i) 4, ii) 7, iii) 10 og iv) 15. Hvilken av verdiene hører den returnerte indeksen til? Obs. Det er det samme om det er 1. eller 2. versjon. De gir alltid de samme returverdi.
4. 	3. versjon av binærsøk returnerer alltid indeksen til den første av dem hvis søkeverdien det søkes forekommer flere ganger. Sjekk at det stemmer for tallene i Oppgave 3.

##Seksjon 1.3.8: 
oppgave 3, 4, 5, 6, 7, 8
