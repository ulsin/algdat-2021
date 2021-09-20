# Oppgaver til Avsnitt 1.4.1
1. Legg de to maks-metodene fra Programkode 1.4.1 a) og b) inn i samleklassen Tabell og lag et program som utfører Programkode 1.4.1 c).
- Done
2. Lag en maks-metode som finner posisjonen til den «største» verdien i en char-tabell. Hvor mange endringer må du gjøre hvis du tar utgangspunkt i maks-metoden for datatypen double, dvs. Programkode 1.4.1 a). Test metoden din ved å legge inn en char-tabell i Programkode 1.4.1 c). Hint: En char-tabell c som for eksempel inneholder tegnene J, A, S, M, I og N, kan lages slik: char[] c = "JASMIN".toCharArray();

Doesn't need to many changes, only changing the type in input and array type.
```java
    public static int maks(char[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

        // in main method
        System.out.println(Tabell.maks(new char[] {'a','f','z','b'}));

        // console printout
        2
```


3. Lag en maks-metode som finner posisjonen til den største verdien i en Integer-tabell. Hvor mange endringer må du gjøre hvis du tar utgangspunkt i maks-metoden for tegnstrenger, dvs. Programkode 1.4.1 b). Test metoden. En testtabell kan du opprette slik: Integer[] a = {5,2,7,3,9,1,8,4,6};

```java
    //     task 1.4.1.3
    public static int maks(Integer[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        Integer maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }
    
    
```

4. La a og b være ta variabler av typen Integer. Finn ut f.eks. ved å eksperimentere, hva a.compareTo(b) returnerer. Sett så opp den regelen som metoden er kodet etter.
- Returns 1 if a is biggger, -1 if a is smaller, 0 if equal size

5. Finn ut, ved å eksperimentere, hva metoden compareTo i class String returnerer. Du kan f.eks. lage et program som inneholder:

  String s = "A", t = "B";
  System.out.println(s.compareTo(t));
  


Se hvilket tall utskriften gir. Bytt så ut A og B med andre bokstaver, og se om du finner et mønster. Hva blir det hvis s = "A" og t = "a" ? Hvilket tall gir utskriften hvis s = "Æ" og t = "Å" ? Hva hvis s = "Ø" og t = "Å" ? (Se også Avsnitt 1.4.10). Bruk så ord istedenfor enkelttegn. Se spesielt på situasjonen der s utgjør første del av t eller t første del av s, for eksempel s = "Karianne" og t = "Kari". Kildekoden til class String vil gi deg fasiten.

- Seems to give a number outside of the -1, 0, 1 range, that is dependend on the value of the strings


6. 	Ulikhetstegn gjelder ikke for boolean. F.eks. er false < true ulovlig. Men Boolean har metoden public static int compare(boolean x,boolean y) og ved hjelp av den kan vi finne hva som regnes som «minst» og «størst» av false og true. Hva blir utskriften:

  System.out.println(Boolean.compare(false, true));
  
- The compiler find that true is greater than false.

# Oppgaver til Avsnitt 1.4.2
1. Legg inn maks-metoden fra Programkode 1.4.2 b) i klassen Tabell (legg også inn, hvis du ikke gjorde det i forrige avsnitt, maks-metoden fra 1.4.1 b). Lag et program som utfører Programkode 1.4.2 d). Hvilken metode velges? Fjern så maks-metoden for String (dvs. Programkode 1.4.1 b) fra Tabell og utfør Programkode 1.4.2 d) på nytt.
- Done, works well


2. Legg Programkode 1.4.2 e) i klassen Tabell og sjekk at Programkode 1.4.2 f) virker. 
```java
[Ali, Anne, Eva, Kari, Ole, Per]
```

# Oppgaver til Avsnitt 1.4.3
2. 	Omtrent hver gang Java kommer i ny versjon er det noen nye ting i klassen Integer. I API-en vil en se i hvilken versjon det har kommet nye ting. Ta en rask gjennomgang av API-en og se om det er konstanter og metoder der som kan være nyttige. Noen viktige nyheter i Java 8 er metoder for å kunne arbeide uten fortegn. Her er noen eksempler på metoder: toUnsignedString, parseUnsignedInt, compareUnsigned, remainderUnsigned og divideUnsigned. Hva tror du flg. metodekall returnerer: Integer.compare(-1, 1); ? Hva med: Integer.compareUnsigned(-1, 1); ?

- ???

5. 	Lag metoden public static void skriv(Object[] a, int fra, int til). Den skal skrive elementene (mellomrom mellom hvert) fra a[fra:til> på én linje (uten mellomrom til slutt). Lag så en skriv-metode som skriver ut hele a. Lag også tilsvarende metoder med navn skrivln (de skal avslutte med linjeskift). Lag også metoden public static void bytt(Object[] a, int i, int j). Den skal bytte om elementene på plassene i og j i tabellen a. Legg alle metodene i samleklassen Tabell.

```java
    // Task 1.4.3.5
    public static void skriv(Object[] a, int fra, int til) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void skriv(Object[] a) {
        skriv(a, 0, a.length);
    }

    public static void skrivln(Object[] a, int fra, int til) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }

    public static void skrivln(Object[] a) {
        skrivln(a, 0, a.length);
    }
```

6. 	Legg bytt og randPermInteger fra Programkode 1.4.3 d) inn i samleklassen Tabell og sjekk at Programkode 1.4.3 e) virker. Lag større tabeller, f.eks. med 20 verdier.

- Done

7. 	Gitt tabellen: double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};  Lag kode som lager en Double-tabell ved hjelp av den gitte double-tabellen og som så bruker den generiske innsettingssorteringen. Se Programkode 1.4.3 c).

```java
    public static Double[] convertetPrimDouble(double[] d) {

        Double[] b = new Double[d.length];             // en tom Integer-tabell

        for (int i = 0; i < b.length; i++) b[i] = d[i];  // fyller tabellen (autoboksing)

        return b;
    }
```

8. 	Det kan oppstå tvetydigheter hvis primitive typer og omslagsklasser blandes. Metoden public static void f(int a, Integer b) { } har først en int og så en Integer som argument. I metoden public static void f(Integer a, int b) { }  er det motsatt. Dermed er disse metodene forskjellige. Hva vil kompilatoren si til metodekallet f(1,1); Hva skjer hvis en av metodene kommenteres vekk? Hvis begge metodene finnes, hvordan kan en da endre i kallet f(1,1); for at en bestemt av dem skal brukes?

- The program throws an exception due to not knowing which method to choose. You can work aroud this by casting the types of the numbers instead of using ambgious numbers



# Oppgaver til Avsnitt 1.4.4
  1. 	Kopier class Heltall fra Programkode 1.4.4 a) over til deg selv. Opprett mappen (package) eksempelklasser og legg den der.
    	a) Lag og kjør et program med Programkode 1.4.4 c).
    	b) Bruk Programkode 1.4.4 b) i compareTo-metoden. Sjekk at alt virker som før!
    	c) La  return verdi - h.verdi;  være kode i compareTo-metoden. Matematisk sett blir det korrekt. Sjekk at alt virker som før. Det er imidlertid et problem her. Hva er det?


  d) Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
     System.out.println(x.compareTo(y) + "  " + x.equals(y));

  Lag et program som inneholder koden over. Hva blir utskriften? Kommenter så vekk equals-metoden i class Heltall. Da vil det bli den versjonen av equals som arves fra class Object, som brukes. Hva blir nå utskriften? Slå opp i kildekoden til class Object og se hvordan metoden equals er kodet der.


  e) Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
     System.out.println(x.hashCode() + "  " + y.hashCode());

  Lag et program som inneholder koden over. Hva blir utskriften? Kommenter så vekk hashCode-metoden i class Heltall. Da vil det bli den versjonen av hashCode som arves fra class Object, som brukes. Hva blir nå utskriften? Slå opp i kildekoden til class Object og se hva som står der om metoden hashCode.
  2. 	Kopier klassen Person fra Programkode 1.4.4 d) over til deg. Legg den under package eksempelklasser:
    	a) Legg inn flere personer i Person-tabellen i Programkode 1.4.4 e).
    	b) Kjør Programkode 1.4.4 e) etter at du har gjort som i a).
    	c) Bruk sort-metoden fra class Arrays i Programkode 1.4.4 e).
    	d) Legg inn kode i konstruktøren slik at det kastes en NullPointerException hvis fornavn eller etternavn er null. Ta med en tekst som forteller hvilket navn som er null.
    	e) Lag en mer direkte versjon av metoden equals(), dvs. uten å bruke compareTo(). Bruk også getClass() != o.getClass() istedenfor !(o instanceof Person). Men da må det først være kode som returnerer false hvis o er null. Hvis ikke, vil o.getClass() kaste en NullPointerException.
    	f) Lag metoden public boolean equals(Person p). Da trengs ingen typesjekking.
    	g) Metoden hashCode() i klassen Person kan kodes på mange måter. Hvis equals() er kodet, men ikke hashCode(), vil f.eks. NetBeans og Eclipse si ifra og samtidig komme med forslag om hvordan hashCode() skal kodes. Sjekk dette. Obs: I NetBeans er dette en del av standardoppsettet. I Eclipse må du selv sette det som en opsjon. Men du får tilbudet i menyvalget Source. Hash-teknikk blir tatt opp mer grundig i Kapittel 6.
    	h) I metoden toString i klassen Person skjøtes fornavn, et mellomrom og etternavn sammen. Dette kan også gjøres ved hjelp av metoden join i klassen String. Prøv på det!
    	i) Legg Programkode 1.4.4 f) bakerst i Programkode 1.4.4 e). Kjør programmet!
    	j) Programkode 1.4.4 f) inneholder tre programlinjer. Gjør det om slik at det blir kun én programlinje.