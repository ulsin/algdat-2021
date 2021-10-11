# Oppgaver til Avsnitt 1.5.1
1. 	Lag en iterativ versjon av metoden a i Programkode 1.5.1 a).k
- skrev av, fikk ikke helt til
```java
    public static int aIterative(int n)           // n må være et ikke-negativt tall
    {
        if (n < 0) {
            throw new IllegalArgumentException("n er negativ!");
        }

        int x = 0;
        int y = 1;
        int z = 1;

        for (int i = 0; i < n; i++)
        {
            z = 2*y + 3*x;
            x = y;
            y = z;
        }
        return z;
    }
```


3. 	Programkode 1.5.1 b) er rekursiv. Lag en iterativ løsning.
```java
    public static int tverrsum(int n)              // n må være >= 0
    {
        String k = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < k.length(); i++) {
            sum += Integer.parseInt("" + k.charAt(i));
        }
        return sum;
        
        // Fasit
/*        int sum = 0;

        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }

        return sum;*/
    }
```

4. 	Gjentatt tverrsum til et tall n får vi ved å ta tverrsummen til n, så tverrsummen av dette, osv. til vi står igjen med et tall med kun ett siffer. Vi bruker navnet sifferrot på dette istedenfor gjentatt tverrsum. Det svarer til det engelske navnet digital root. Ta tallet 956847 som eksempel: tverrsum(956847) = 39, tverrsum(39) = 12 og tverrsum(12) = 3. Dermed blir sifferrot(956847) = 3. Lag metoden public static int sifferrot(int n). Den skal returnere sifferroten til n.
```java
    public static int digitalRoot(int n) {
        int sum = n; // just setting it to not trigger the while condition wrongly
        while (sum >= 10) {
            sum = tverrsum(sum);
        }
        return sum;
    }
```

7. 	Lag en rekursiv metode som finner summen av kvadrattallene fra 1 til n, dvs. finner summen 12 + 22 + 32 + . . . + $n^2$. Kjenner du noen formel for den samme summen?
```java
    public static int kvardatTall(int n) {
        if (n == 1) {
            return 1;
        }
        return n * n + kvardatTall(n - 1);
    }
```
8. 	Summen av heltallene fra 1 til n er et spesialtilfelle av det å finne summen av heltallene fra k til n der k <= n. Lag en metode public static int sum(int k, int n) som finner denne summen, og gjør det ved å bruke «splitt og hersk».
```java
    public static int sum(int k, int n) {
        if (k > n) {
            return 0;
        }
        return n + sum(k, n - 1);
    }
```

9. 	Lag en rekursiv metode som returnerer posisjonen til den største blant de n første verdiene i en heltallstabell. Kan du få det til ved en «splitt og hersk»-teknikk?
```java
    public static int maxRecur(int[] a, int l, int r) {
        if (l == r) {
            return l;
        }
        int m = (r + l) / 2;
        int mv = maxRecur(a, l, m);
        int mh = maxRecur(a, m + 1, r);

        if (a[mv] > a[mh]) {
            return mv;
        }
        return mh;
    }

    public static int maxRecur(int[] a, int n) {
        return maxRecur(a, 0, n-1);
    }
```

10. Lag en rekursiv metode som finner n! (dvs. n fakultet) når n er parameterverdi.
```java
    public static int fakul(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fakul(n - 1);
    }
```

11. Bruk Programkode 1.5.1 h) til å finne Fibonacci-tall nr. 20, 30, 40 og 50. Hva skjer?
```java
        System.out.println(fib(20));
        System.out.println(fib(30));
        System.out.println(fib(40));
        System.out.println(fib(50));
```
Gir utskrift
```
6765
832040
102334155
-298632863
```
fib(50) blir for stort til at typen int kan holde det og vi får en overflow og tallet blir negativt.


# Oppgaver til Avsnitt 1.5.2
1. 	Kjør Programkode 1.5.2 d) med et tall som har flere siffer enn 7295, dvs. flere enn 4 siffer. Sjekk så utskriften.
```
main() starter!
tverrsum(72952) starter!
tverrsum(7295) starter!
tverrsum(729) starter!
tverrsum(72) starter!
tverrsum(7) starter!
tverrsum(7) er ferdig!
tverrsum(72) er ferdig!
tverrsum(729) er ferdig!
tverrsum(7295) er ferdig!
tverrsum(72952) er ferdig!
main() er ferdig!
```

2. 	Legg inn utskriftssetninger i den rekursive euklid-metoden i Programkode 1.5.1 c). Gjør omtrent som i tverrsum-metoden i Programkode 1.5.2 c). Kjør så euklid-metoden med et passelig valg av parameterverdier og se hva utskriften blir.
- okay

6. 	Figur 1.5.2 c) viser hva som skjer når fib(5) utføres. Hver gang fib-metoden kalles blir kallet lagt på programstakken. I denne prosessen blir metoden tilsammen kalt like mange ganger som rekursjonstreet får noder. Hvor mange noder har treet i Figur 1.5.2 c)? Tegn det rekursjonstreet du får når fib(6) utføres. Hvor mange noder får treet? 
- Alt kommer til å skje opp til 6. 
- På 6 sin venstre side er 5 med 15 noder, på 6 sin høyre side er 4 med 9 noder, til sammen 15 + 9 = 24 noder + øverst og 6. node = 25 noder

# Oppgaver til Avsnitt 1.5.3
1. 	Sjekk at sum-metoden i Programkode 1.5.1 e) oppfyller krav 1 og 2. Hva blir maksimal rekutsjonsdybde og hva blir det totale antallet kall?
2. 	Sjekk at sum-metoden i Programkode 1.5.1 f) oppfyller krav 1 og 2. Hva blir maksimal rekutsjonsdybde og hva blir det totale antallet kall?
3. 	Tegn rekursjonstreet til kallet sum(1,8) der sum er metoden i Programkode 1.5.3 b).

# Oppgaver til Avsnitt 1.5.7
1.  

a) Legg en utskriftssetning med teksten "Kallet med [" + v + ":" + h + "] starter!" først og en med "Kallet med [" + v + ":" + h + "] er ferdig!" sist i Programkode 1.5.7 a). Kjør så kvikksortering på en permutasjon av tallene fra 1 til 10. Hva blir utskriften?

b) Utskriften fra a) vil vise at både tomme intervaller (h < v) og intervaller med lengde 1 legges på stakken. Men de er allerede sortert. Legg inn kode i Programkode 1.5.7 a) slik at kun intervaller med lengde større enn 1 behandles. 