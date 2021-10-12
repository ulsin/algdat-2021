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

//TODO:
f. Seksjon 3.2.5: oppgave 1, 2, 3
g. Seksjon 3.3.2: oppgave 1, 2, 3, 4
h. Seksjon 3.3.3: oppgave 1, 2, 3, 4
i. Seksjon 3.3.4: oppgave 1, 2, 3, 4, 5