# Oppgaver til Avsnitt 3.1.1
1. 	Legg Beholder fra Programkode 3.1.1 i) inn under hjelpeklasser i ditt prosjekt.
- Done

2. 	En forAlle-løkke kan iterere i en vanlig tabell og i en instans av en klasse som implementerer Iterable. Lag kode med en heltallstabell der noen tall er mindre enn og noen større enn 10. Bruk så en forAlle-løkke til å finne antallet som er større enn 10.
```java
    public static void main(String[] args) {
        int[] a = {-1, 2, -19, 3};
        int count = 0;
        for (int i : a) if (i >= 0) count++;
        System.out.println(count);
    }
```

# Oppgaver til Avsnitt 3.2.1
1. 	Legg grensesnittet Liste under biblioteket (package) hjelpeklasser.
- Done

# Oppgaver til Avsnitt 3.2.2
1. 	Legg inn klassen public class TabellListe<T> implements Liste<T> under package hjelpeklasser og legg inn de metodene som er laget i dette avsnittet.
- Done

2. 	Lag en String-tabell s, en instans av TabellListe med s som parameter og sjekk at aksessor-metodene virker som de skal. Sjekk at det virker hvis s har en eller flere null-er.
- Done

3. 	Lag metoden public String toString(). Hvis listen f.eks. inneholder 1, 2 og 3, skal tegnstrengen bli lik "[1, 2, 3]". Tom liste skal gi "[]". Bruk en StringBuilder eller en StringJoiner. Bruk metoden til å skrive ut skrive ut de tabellistene du laget i Oppgave 2.
```java
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < antall - 1; i++) {
            sb.append(a[i].toString());
            sb.append(' ');
        }
        sb.append(a[antall -1]);
        sb.append(']');
        return sb.toString();
    }
```

# Oppgaver til Avsnitt 3.2.3
1. 	Lag metoden public boolean fjern(T verdi). Se grensesnittet Liste. Metoden skal fjerne første forekomst av verdi og returnere true hvis fjerningen var vellykket og returnere false hvis verdi ikke finnes i listen.
```java
    public boolean fjern(T verdi) {
        return fjern(indeksTil(verdi)) != null;
    }
```

2. 	Lag metoden public void nullstill(). Se gresnesnittet Liste. Den skal «tømme» listen, dvs. «tømme» den interne tabellen og samtidig sørge for at de elementene som måtte ligge igjen går til «resirkulering». Hvis den interne tabellen har en lengde som er større enn 10, skal den erstattes med en som har lengde 10. 
```java
    public void nullstill() {
        for (int i = antall-1; i >= 0; i--) {
            fjern(i);
        }
        if (a.length > 10) {
            a = (T[])new Object[10];       // oppretter tabellen
        }
        antall = 0;                    // foreløpig ingen verdier
    }
```

# Oppgaver til Avsnitt 3.2.4
1. 	Legg iterator-klassen og metoden iterator() fra Avsnitt 3.2.4 inn i TabellListe. Pass på at det er de siste versjonene av next() og remove() (Programkode 3.2.4 c) du bruker.
- Done

2. 	Test metodene i TabellListe og de arvede metodene fjernHvis() og forEach().
- Done

3. 	Metoden fjernHvis() arves fra Beholder. Kod den i TabellListe og da direkte uten å bruke iteratorens remove-metode.
```java
    public boolean fjernHvis(Predicate<? super T> p) {
        boolean fjernet = false;
        for (int i = antall-1; i >= 0; i--) {
            fjernet = false;
            if (p.test(a[i])) {
                fjern(i);
                fjernet = true;
            }
        }
        return fjernet;
    }
```

4. 	Klassen TabellListe arver metoden forEach() fra Iterable. Kod den i TabellListe og da direkte uten å bruke iteratoren.
```java
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        for (int i = 0; i < antall-1; i++) {
            action.accept(a[i]);
        }
    }
```
5. 	Kod metoden forEachRemaining() direkte i TabellListeIterator. 
```java
aight tok bare fra fasit

    public void forEachRemaining(Consumer<? super T> action)
    {
        while (denne < antall)
        {
            action.accept(a[denne++]);
        }
    }
```

# Oppgaver til Avsnitt 3.2.5
1. 	Legg instansvariabelen endringer i klassen TabellListe og instansvariabelen iteratorendringer (med startverdi) i den indre klassen TabellListeIterator. Se Programkode 3.2.5 d). Legg så inn de nye versjonene av next() og remove() i TabellListeIterator. Se Programkode 3.2.5 e).
- Done

2. 	Sørg for at variabelen endringer økes i alle mutatorene, dvs. i leggInn-metodene, i fjern-metodene, i metodene oppdater() og nullstill().
- Done

3. 	Sjekk hva resutatet nå blir for Programkode 3.2.5 a), b) og c).
- Nå crasher programmet hvis man prøver å gjøre ting basert på iterasjoner om endringer har skjedd



# Oppgaver til Avsnitt 3.3.2
1. 	EnkeltLenketListe inneholder den koden som til nå er diskutert i dette avsnittet. De metodene som mangler er satt opp med tom kode. Flytt dette over til deg f.eks. under mappen (package) hjelpeklasser.
- Done

2. 	Lag metodene antall(), tom(), nullstill() og toString() i EnkeltLenketListe. Se Oppgave 1. Metoden antall() skal returnere antallet verdier i listen, tom() skal returnere sann/true hvis listen er tom (antall er 0) og returnere usann/false ellers og nullstill() skal «tømme» listen slik at den blir tom. Metoden toString() skal lages slik at den returnerer [] hvis listen er tom, [3] hvis den kun inneholder verdien 3 og [1, 2, 3] hvis den f.eks. inneholder 1, 2 og 3.
```java
    public int antall()
    {
        return antall;
    }

    public boolean tom()
    {
        return antall == 0;
    }

    public void nullstill()
    {
        for (int i = antall-1; i >= 0; i--) {
            fjern(i);
        }
        hode = hale = null;        // hode og hale til null
        antall = 0;                // ingen verdier - listen er tom
    }

    public String toString()
    {
        if (antall == 0) {
            return "[]";
        }

        Node<T> temp = hode;

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (temp.neste != null) { // while temp isn't hale
            sb.append(temp.verdi.toString());
            sb.append(", ");
            temp = temp.neste;
        }
        sb.append(temp.verdi.toString());
        sb.append(']');
        return sb.toString();
    }
```

3. 	Lag konstruktøren public EnkeltLenketListe(T[] a). Den skal gjøre at verdiene får samme rekkefølge i listen som de har i tabellen. Dette skal kodes direkte uten bruk av noen av leggInn-metodene.
```java
    public EnkeltLenketListe(T[] a) {
        Objects.requireNonNull(a);

        hode = hale = new Node<>(a[0],null);

        for (int i = 1; i < a.length; i++) {
            hale.neste = new Node<>(a[i], null);
            hale = hale.neste;
        }
        antall = a.length;
    }
```


4. 	Lag et program (utenfor klassen EnkeltLenketListe) der det opprettes en instans av klassen med Integer som typeparameter. Legg så inn en del verdier (heltall). Bruk begge leggInn-metodene. Sjekk så ved å lage utskrifter at metodene antall() og tostring() gir rett svar. Se Oppgave 2. Bruk også metoden nullstill(). 
```java
        EnkeltLenketListe<Integer> liste2 = new EnkeltLenketListe<>();

        liste2.leggInn(10);
        liste2.leggInn(0, 11);

        System.out.println(liste2.antall());
        System.out.println(liste2);

        liste2.nullstill();

        System.out.println(liste2);
```

```
2
[11, 10]
[]
```



# Oppgaver til Avsnitt 3.3.3
1. 	Sjekk nøye at metoden fjern(int indeks) i Programkode 3.3.3 c) oppfører seg korrekt. Sjekk spesielt at hale får korrekt verdi hvis den bakerste noden fjernes, hode får korrekt verdi hvis den første noden fjernes og at både hode og hale får korrekte verdier hvis fjerningen fører til at listen blir tom. Lag tegninger!
- Done?

2. 	Lag metodene indeksTil() og inneholder(). Den første skal returnere indeksen til parameterverdien verdi. Hvis den ikke finnes i listen skal den returnere -1. Du må bruke metoden equals for å avgjøre om to verdier er like eller ulike. Metoden inneholder() skal returnere sann (true) hvis listen inneholder verdi og returnere usann (false) ellers. Den kan kodes ved hjelp av indeksTil().
```java
    @Override
    public int indeksTil(T t)
    {
        Objects.requireNonNull(t);

        Node<T> temp = hode;
        int index = 0;

        while (temp.verdi != t && temp.neste != null) {
            temp = temp.neste;
            index++;
        }

        if (temp.verdi == t) {
            return index;
        }
        return -1;
    }
```
```java

```

3. 	Lag metoden public fjern(T verdi). Den skal returnere sann (true) hvis et eksemplar av t har blitt fjernet og returnere usann (false) hvis verdi ikke finnes i listen. Her må en passe på at det blir korrekt for spesieltilfellene, dvs. at den første eller siste fjernes eller at listen blir tom etter fjerningen. Husk også at skal en verdi som ikke ligger først, fjernes, må vi ha tak i noden rett foran den som skal fjernes.
```java
    public boolean fjern(T t)
    {
        int index = indeksTil(t);
        if (index == -1) {
            return false;
        }

        fjern(index);
        return true;
    }
```

4. 	EnkeltLenketListe inneholder ferdig kode for de metodene som er diskutert i Avsnitt 3.3.3 og de som er satt opp som oppgaver. Lag et program der metodene brukes. 
- Yikes

//TODO:
# Oppgaver til Avsnitt 3.3.4
1. 	EnkeltLenketListe inneholder ferdig kode for hele klassen (inklusiv iteratoren). Lag et program der iteratoren brukes. Sjekk at det blir en ConcurrentModificationException hvis det skjer en endring etter at en iterator har startet.
```java
       String[] s = {"Per","Kari","Ole"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(navn);

        System.out.println(liste);

        Iterator<String> i = liste.iterator();     // oppretter en iterator i
        Iterator<String> j = liste.iterator();     // oppretter en iterator j

        System.out.println(i.next());              // den første i listen
        i.remove();                                // fjerner den første
        System.out.println(j.next());              // den første i listen
```

2. 	Sjekk at de arvede metodene fjernHvis() og forEach() virker.
```java
        TabellListe<String> s = new TabellListe<>();
        s.leggInn("Hey");
        s.leggInn("Woop");
        s.leggInn("Woop");
        System.out.println(s.tom());
        System.out.println(s.hent(2));

        for (String ss : s) System.out.println(ss);

        s.fjern(2);
        System.out.println(s.antall());
        s.leggInn(1,"Legger inn index 1");
        System.out.println(s.hent(1));

        s.leggInn("Woop");
        s.leggInn("Woop");
        s.leggInn("Woop");

        System.out.println("ToString: " +s.toString());

        s.forEach(s1 -> System.out.println(s1));

        s.fjernHvis(s1 -> s1.equals("Woop"));

        System.out.println(s);
```

3. 	Metoden fjernHvis() arves fra Beholder. Kod den direkte uten å bruke iteratoren.
```java
    @Override
    public boolean fjernHvis(Predicate<? super T> p) {
        Objects.requireNonNull(p);

        boolean fjernet = false;

        Node<T> temp = hode;

        while (temp != null) {
            fjernet = false;
            if (p.test(temp.verdi)) {
                fjern(temp.verdi);
                fjernet = true;
            }
            temp = temp.neste;
        }
        return fjernet;
    }
```

4. 	Klassen arver metoden forEach() fra Iterable. Kod den uten å bruke iteratoren.
```java
    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        Node<T> temp = hode;

        while (temp != null) {
            action.accept(temp.verdi);
            temp = temp.neste;
        }
    }
```

5. 	Kod metoden forEachRemaining() direkte i EnkeltLenketListeIterator. 
- Orker ikke æææææ må overskrive alt jeg lagdeeee