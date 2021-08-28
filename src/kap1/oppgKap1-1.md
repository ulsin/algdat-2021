# Oppgaver til Avsnitt 1.1.1

1. Søk på internett med navnet al-Khwarizmi som søkeord. Hva finner du?
   Finner:
   Muḥammad ibn Mūsā al-Khwārizmī, or al-Khwarizmi and formerly Latinized as Algorithmi, was a Persian polymath who produced vastly influential works in mathematics, astronomy, and geography. Around 820 CE he was appointed as the astronomer and head of the library of the House of Wisdom in Baghdad.

2. Lag en norsk versjon av den engelske algoritme-definisjonen over!

   - En algoritme er en godt ordnet samling av tydlige og lettutførlige instruksjoner, som når utført produserer et resultat etter en begrenset mengde tid.
   - En algoritme er en velordnet samling av utvetydige og effektivt beregnbare operasjoner som ved eksekvering produserer et resultat etter en endelig tid.

3. Søk på internett etter alle sider som inneholder ordene data structure (eventuelt data structures) og algorithm (eventuelt algorithms). Hvor mange treff får du?
   - Data structure: About 1.410.000.000
   - Algorithm: About 533.000.000

# Oppgaver til Avsnitt 1.1.2

1. Anta at vi har en min-metode, dvs. en metode som finner (og returnerer) posisjonen til den minste verdien i en tabell. Hva ville metodekallet min(a) returnere med hvis a er tabellen i Figur 1.1.2?

   - 6

2. Lag en min-metode på samme måte som maks-metoden i Programkode 1.1.2, dvs. en metode som finner (og returnerer) posisjonen til den minste verdien i en tabell.

   - se algdat prosjekt

3. Hvis den største verdien forekommer flere ganger, vil maks-metoden returnere posisjonen til den første av dem. Hva må endres for at den skal returnere posisjonen til den siste?

   - if testen må ha `<=` istedenfor `<`

# Oppgaver itl Avsnitt 1.1.2

1.  Et eksempel på en oppgave som kan løses på mange forskjellige måter er det å sortere verdiene i en tabell. Hvor mange sorteringsalgoritmer kjenner du til? På Wikipedia finner du en oversikt over sorteringsalgoritmer.

- Ikke så mange

2. Gitt en tabell med verdiene 10, 5, 7, 2, 9, 1, 3, 8, 4, 6. Hvor mange grunnleggende operasjoner vil algoritmen i Programkode 1.1.2 utføre på denne tabellen. Se regnskapet over og Eksempel 1.1.3.

- 50 ganger (5n + x), 5\*10 + 1 siden det er 10 tall i tabellen og den setter den største bare i starten side nden starter ed første tall

3. Som oppgave 2, men med verdiene 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.

   - 59, 50 ganger plus 9 instillinger av m

4. Som oppgave 2, men med verdiene 1, 3, 2, 7, 5, 9, 6, 8, 10, 4.

- 54, 50 + 4 instillinger

5. Lag en metode public static int[] minmaks(int[] a). Den skal ved hjelp av en int-tabell med lengde 2 returnere posisjonene til minste og største verdi i tabellen a. Hvis du har funnet at m1 er posisjonen til den minste og m2 til den største, kan du returnere tabellen b definert ved: int[] b = {m1, m2}; Hvor mange sammenligninger bruker metoden din?

- Min er bad og bruker 1 + 3n + 2x + 5n + x = 8n + 3x + 1

6. Utrykket n! betyr n fakultet og er gitt ved n! = n · (n-1) · · · 2 · 1 . Lag en metode
   long fak(int n) som regner ut n! . Hvor mange multiplikasjoner utføres i metoden?

- n - 1 multiplikasjoner, (skipper den første?)

# Oppgaver til Avsnitt 1.1.4

1. Hvor mange grunnleggende operasjoner utfører Programkode 1.1.4 hvis tabellen a inneholder  
   i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6  
   ii) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  
   iii) 1, 3, 2, 7, 5, 9, 6, 8, 10, 4  
   Sammenlign med svarene i oppgave 2, 3 og 4 fra Avsnitt 1.1.3.

   - Blir 4n + 3x + 2  
     i) 40 + 0 + 2 = 42  
     ii) 40 + 9*3 + 2 = 67 + 2 = 69  
     iii) 40 + 4*3 + 2 = 54

# Oppgaver til Avsnitt 1.1.5

1. Sjekk at Programkode 1.1.5 gir korrekte resultater. Hva skjer hvis a har lengde 1 og hva hvis a er tom (lengde 0). Se også Avsnitt 1.1.7.

- tom : `java: variable empty might not have been initialized`
- lengde 1 : `0`

2. Gjør om Programkode 1.1.5 slik at posisjonen til den første av dem returneres hvis den største verdien ligger flere steder.

- `return temp >= maksverdi ? sist : m;` må bli til `return temp > maksverdi ? sist : m;`

3. En vaktpostverdi må være større enn eller lik alle mulige tabellverdier. Men ikke alle typer har en maksverdi slik som int har. Vi kan isteden la tabellens siste posisjon hele tiden inneholde det samme som hjelpevariablen maksverdi. Dermed vil a[i] >= maksverdi helt sikker bli sann når i blir lik sist. Innfør denne idéen i Programkode 1.1.5.

# Oppgaver til Avsnitt 1.1.6

1. Vis at Setning 1.1.6 a) stemmer for n = 5. Se på alle de 120 forskjellige permutasjonene av tallene 1, 2, 3, 4 og 5. Flg. observasjon kan forenkle arbeidet: De 24 permutasjonene der 5 står først, inneholder ingen tall som er større enn alle foran. Blant de 24 der 5 står som nr 2, vil det være nøyaktig ett tall (5 selv) som er større enn de foran. Osv.
2. La a(n,k) være antallet permutasjoner av 1, . . , n som har nøyaktig k tall som er større enn det største foran. F.eks. er a(3,1) = 3 fordi de tre permutasjonene (1,3,2), (2,1,3) og (2,3,1) (og ingen andre) har nøyaktig ett tall som er større enn alle foran. Finn a(3,0), a(3,2), a(4,0), a(4,1), a(4,2) og a(4,3).

- a(3,0) = 2, siden (3,2,1) og (3,1,2)
- a(3,2) = 1, [1, 2, 3]
- a(4,0) = 6, [4, 2, 3, 1] [4, 2, 1, 3] [4, 3, 2, 1] [4, 3, 1, 2] [4, 1, 3, 2] [4, 1, 2, 3]
- a(4,1) = 11, [1, 4, 3, 2] [1, 4, 2, 3] [2, 4, 3, 1] [2, 4, 1, 3] [3, 4, 1, 2] [3, 4, 2, 1] [2, 1, 4, 3] [3, 2, 1, 4] [3, 2, 4, 1] [3, 1, 2, 4] [3, 1, 4, 2]
- a(4,2) = 6, [1, 2, 4, 3] [1, 3, 2, 4] [1, 3, 4, 2] [2, 1, 3, 4] [2, 3, 1, 4] [2, 3, 4, 1]
- a(4,3) = 1 [1, 2, 3, 4]

3. Lag metoden public static double harmonisk(int n). Metoden skal ved hjelp av en løkke regne ut (og returnere) det n-te harmoniske tallet.

- se intellij
```java
    public static double harmonisk(int a) {
        double utTall = 0;
        for (int i = 1; i <= a; i++) {
            utTall += 1.0 / i; // bruker 1.0 istedenfor å caste double
        }
        return utTall;
    }
```

4. Lag metoden public static double euler(int n). Den skal returnere differansen mellom Hn og log(n). I Java gir Math.log(n) oss den naturlige logaritmen til n. Hvor stor må n være for at euler(n) skal returnere et tall som starter med 0,577 som de tre første desimalene?

- 1000 er nok, 100 er for lite
```java
    public static double euler(int a) {
        return harmonisk(a) - Math.log(a);
    }
```



5. Lag en programbit som gir resultatene i Tabell 1.1.6.

# Oppgaver til Avsnitt 1.1.7
1. Lag et main-program med metoden makstest der Programkode 1.1.2 testes. Hva skjer?

- Ingen ting, metoden består testen

2. Utvid metoden makstest. Bruk tabeller der den 
- største er først
- største er sist
- største forekommer flere steder
- en tabell med kun én verdi
- kun to verdier som er ulike og 
- kun to verdier som er like. 
- Lag en test for en null-tabell. 
- La også makstest returnere antall feil.
```java
    public static int makstestFlere()
    {
        int antallFeil = 0;

        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (maks(a) != 6) {  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks(a);  // kaller maks-metoden
        }
        catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)) {
                antallFeil++;
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
            }
        }

        if (!unntak) {
            antallFeil++;
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
        }

        // største er først
        a = new int[]{10, 6, 4, 5};
        if (maks(a) != 0) {
            System.out.println("Kodefeil i størst først");
            antallFeil++;
        }

        // største er sist
        a = new int[]{1, 4, 6, 10};
        if (maks(a) != 3) {
            System.out.println("Kodefeil i størst sist");
            antallFeil++;
        }

        // største forekommer flere steder. Tester for at den gir indexen til første forekomst, og ikke siste.
        a = new int[]{1, 10, 6, 10};
        if (maks(a) != 1) {
            System.out.println("Kodefeil i flere steder");
            antallFeil++;
        }

        // - en tabell med kun én verdi
        a = new int[]{2};
        if (maks(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        // - kun to verdier som er ulike og
        a = new int[]{2,3};
        if (maks(a) != 1) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- kun to verdier som er like.
        a = new int[]{2,2};
        if (maks(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- Lag en test for en null-tabell.
        a = new int[0];
        boolean exeptionEmpty = false;

        try {
            maks(a);
        } catch (Exception e) {
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Kaster feil for tom array");
                antallFeil++;
            }
            exeptionEmpty = true;
        }

        if (!exeptionEmpty) {
            System.out.println("Skal kastes unntak for tom tabell");
            antallFeil++;
        }

        //- La også makstest returnere antall feil.
        return antallFeil;
    }
```


3. Bruk makstest på de to versjonene i Programkode 1.1.4 og 1.1.5. 
Da vil det bl.a. komme melding om at det kastes feil unntak for en tom tabell. 
Hvilket unntak kastes? 
Gjør om koden slik at rett unntak kastes. 
Programkode 1.1.5 gir feil svar hvis den største verdien ligger flere steder. 
Rett opp koden! Se også Oppgave 2 i Avsnitt 1.1.5.

- Kaster unntak for at de ikke tar tomme arrays  
```
Kodefeil: Feil unntak for en tom tabell!
Kaster feil for tom array
Antall feil: 2
Kodefeil: Feil unntak for en tom tabell!
Kaster feil for tom array
Antall feil: 2
```
- Satte inn if testen i første linje i maks2 og 3, og endret >= situasjonen i maks 3


4. Sett deg inn i begrepet assert i Java.

- [Link til Stackoverflow](https://stackoverflow.com/questions/2758224/what-does-the-java-assert-keyword-do-and-when-should-it-be-used)  
```Assertions (by way of the assert keyword) were added in Java 1.4. They are used to verify the correctness of an invariant in the code. They should never be triggered in production code, and are indicative of a bug or misuse of a code path. They can be activated at run-time by way of the -ea option on the java command, but are not turned on by default.```

5. Lag et program som kjører Programkode 1.1.7 c). Gjør om koden slik at resultatet fanges, dvs. bruk koden: OptionalInt m = maks(a); Sjekk deretter om resultat har innhold (isPresent) og hvis den har det, skriv ut verdien ved å bruke getAsInt. Finn ut hvilke andre metoder klassen OptionalInt har. 

```java
    OptionalInt m = maks4(values2);
    if (m.isPresent()) {
        System.out.println(m.getAsInt());
    }
```

# Oppgaver til Avsnitt 1.1.8

1. Kjør den kodebiten som kommer rett etter Programkode 1.1.8 b) flere ganger og sjekk at det hele tiden kommer ut permutasjoner av tallene fra 1 til 10.

- Done

2. Flg. kodebit viser hvor lang tid det tar å generere en tilfeldig permutasjon av tallene fra 1 til n ved å bruke Programkode 1.1.8 b):  

```java
  int n = 10000;
  long tid = System.currentTimeMillis();
  int[] a = randPerm(n);
  tid = System.currentTimeMillis() - tid;
  System.out.println(tid);
```

Hvor mange millisekunder bruker denne kodebiten på din maskin? Øk verdien på n slik at kodebiten bruker ca. 5 sekunder (5000 millisekunder).

- Ved n = 5 * 10000 så tok det 4562 ms

3. Vis at metoden i Programkode 1.1.8 b) er av orden n2 log(n) i gjennomsnitt.

```java
  public static int[] randPerm(int n)  // virker, men er svært ineffektiv
  {
    Random r = new Random();      // 1
    int[] a = new int[n];         // 1

    for (int i = 0; i < n; )      // 1 + n 
    {
      int k = r.nextInt(n) + 1;   // n-1

      int j = 0; // n-1
      for ( ; j < i; j++)         // n-1 * n-1 + n-1
      {
        if (a[j] == k) break;     //  n^2
      }
      if (i == j) a[i++] = k;     // 1 + 2
    }
    return a;                     // tabellen returneres
  }
```
- Var ikke helt klart

4. Sjekk at randPerm-versjonen i Programkode 1.1.8 c) virker som den skal. Se Oppgave 1. Du kan f.eks. omdøpe den første til randPerm1 og den andre til randPerm2.

- Funker!

5. Gjør som i Oppgave 2, men bruk randPerm-versjonen i Programkode 1.1.8 c). Er det stor forskjell på de to versjonene?

Koden:
```java
        int n = 10000*5;
        long tid = System.currentTimeMillis();
        int[] a = randPerm2(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
        long tid2 = System.currentTimeMillis();
        int[] b = randPerm3(n);
        tid2 = System.currentTimeMillis() - tid2;
        System.out.println(tid2);
```
Resultat:
```
4544
11
```

- Vi ser at randPerm3 er mye raskere

6. Vis at randPerm-versjonen i Programkode 1.1.8 c) er av orden n log(n) i gjennomsnitt.

- Fasit hjalp ikke så mye her

7. I randPerm-versjonen i Programkode 1.1.8 c) brukes det en boolsk hjelpetabell. Gjør om metoden slik at den bruker samme idé, men uten hjelpetabellen. Første kall på nextInt(n) gir en indeks k. Vi legger så inn 1 i a[k]. Neste kall på nextInt(n) gir en ny indeks k. Hvis a[k] ikke er 0, kaller vi nextInt(n) på nytt. Hvis derimot a[k] er 0, legger vi inn 2 i a[k]. Osv. til hele a er fylt opp.

```java
    public static int[] randPerm4(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 1; i <= n; ) {
            int k = r.nextInt(n);
            if (a[k] == 0) {
                a[k] = i++;
            }
        }
        return a;
    }
```

8. Sjekk at den versjonen av randPerm som står i Programkode 1.1.8 e) virker som den skal. Se Oppgave 1. Du kan f.eks. omdøpe den første versjonen til randPerm1, den andre til randPerm2 og denne til randPerm3.

- Funker som den skal

9. Gjør som i Oppgave 2, men bruk randPerm-versjonen i Programkode 1.1.8 e). Er det stor forskjell på de tre versjonene? Hvilken av dem bør vi ta vare på og bruke senere når vi trenger en slik metode?

- Versjonen med bytt er den raskerete, og er den vi burde bruke videre


10. I Programkode 1.1.8 e) blir tallene som «fjernes» fra «beholderen» (tabellens «hvite» del) isteden lagt over i den «grå» delen. Lag en versjon av metoden der den «grå» delen er den venstre delen av tabellen og den «hvite» delen den høyre delen.

```java
    public static int[] randPerm5Venstre(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }

        System.out.println(Arrays.toString(a));

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,i,k);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }
```

11. Lag void randPerm(int[] a, int v, int h) slik at den stokker om intervallet a[v:h] i tabellen a. Resten av tabellen skal være uberørt. Se Programkode 1.1.8 f).

```java
    public static void randPermOmstokkIntervall(int[] a, int start, int slutt)
    {
        Random r = new Random();

        for (int k = start; k < slutt; k++)
        {
            int i = r.nextInt(slutt-start);
            bytt(a,k,i+start);
        }
    }
```

12. Tar vi ut fortløpende (uten tilbakelegging) k tilfeldige tall fra 1 til n får vi et ordnet k-utvalg (eller en k-permutasjon). Lag metoden int[] randPerm(int n, int k). Den skal returnere et tilfeldig ordnet k-utvalg (0 <= k <= n).

```java
    public static int[] randPermIntervall(int n, int k) {
        Random r = new Random();
        int[] a = new int[k - n + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = n + i;
        }

        randPermOmstokk(a);

        return a;
    }
```

13. Java har ingen ferdig metode som lager en tilfeldig heltallstabell. En omvei: Legg tallene fra 1 til n i en ArrayList<Integer>, bruk metoden shuffle i klassen Collections og hent så tallene fra listen og legg dem over i en int-tabell. Prøv dette!

```java
    public static int[] oneToNShuffle(int n) {
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            intList.add(i);
        }

        Collections.shuffle(intList);

        int[] intArr = new int[n];

        for (int i = 0; i < n; i++) {
            intArr[i] = intList.get(i);
        }

        return intArr;
    }
```


# Oppgaver til Avsnitt 1.1.9

1. Kjør programmet i Programkode 1.1.9 b) flere ganger. Hvilke resultater får du?

```java
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += antallMaks(randPerm5(100000));
        }
        System.out.println((double) sum / 10.0);
```

- Får ca. mellom 10 og 12 som snitt ved 100000

2. Istedenfor å kalle randPerm fra Programkode 1.1.8 e) flere ganger, kan vi la randPerm fra Programkode 1.1.8 f) omstokke en eksisterende permutasjon på nytt og på nytt. Bruk den ideen i Programkode 1.1.9 b). Kall f.eks. antallMaks 10 ganger (bruk for-løkke) og summér verdiene som den returnerer. Avslutt med å skrive ut gjennomsnittet. Kjør så programmet for flere n-verdier enn n = 100000. 

```java
        int sum = 0;
        int[] randArr = randPerm5(500000);
        for (int i = 0; i < 10; i++) {
            randPermOmstokk(randArr);
            sum += antallMaks(randArr);
        }
        System.out.println((double) sum / 10.0);
```

# Oppgaver til Avsnitt 1.1.10
1. Utvid class Program og gjør om main-metoden slik som det bes om i Programkode 1.1.10. Kjør programmet! Du kan endre tidsforbruket ved å endre tabellstørrelse og antall gjentagelser. Lag f.eks. tabellen være dobbelt så stor (n = 200_000).

```java
Faste kostnader: 3 millisek
Maks1-metoden: 305 millisek
Maks2-metoden: 192 millisek
Maks3-metoden: 171 millisek
Maks4-metoden: 192 millisek
```

2. Gjør om main-metoden slik at tabellen a inneholder tallene fra 1 til n i sortert rekkefølge. Hvordan går det da med tidsforbruket?

Med
```java
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
```
blir tiden
```java
Faste kostnader: 5 millisek
Maks1-metoden: 264 millisek
Maks2-metoden: 265 millisek
Maks3-metoden: 718 millisek
Maks4-metoden: 174 millisek
```

Maks 3 blir mye dyrere?


3. Har du tilgang til flere datamaskiner? Er tidsforbruket avhengig av hvilket miljø dette kompileres og kjøres i? 

- yikes guess jeg kan kjøre på desktop en gang.

