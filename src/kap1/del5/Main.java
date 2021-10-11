package kap1.del5;

import kap1.Tabell;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(digitalRoot(555));
        System.out.println(kvardatTall(3));
        System.out.println(sum(10,15));

        int[] a = Tabell.randPerm(7);
        System.out.println(Arrays.toString(a));
        System.out.println("Index: " + maxRecur(a, 5) + " Value : " + a[maxRecur(a,5)]);
        System.out.println(fakul(12));
         */
//        System.out.println(fib(20));
//        System.out.println(fib(30));
//        System.out.println(fib(40));
//        System.out.println(fib(50));

//        System.out.println("main() starter!");
//        int sum = tverrsumKom(72952);
//        System.out.println("main() er ferdig!");

        System.out.println("main() starter!");
        int sum = euklid(72952,123);
        System.out.println("main() er ferdig!");
    }

    public static int a(int n)           // n må være et ikke-negativt tall
    {
        if (n == 0) return 1;              // a0 = 1
        else if (n == 1) return 2;         // a1 = 2
        else return 2*a(n-1) + 3*a(n-2);   // to rekursive kall
    }
//    Programkode 1.5.1 a)


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
//    Programkode 1.5.1 b)

    public static int tverrsumKom(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsumKom(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }
    // Programkode 1.5.2 c)

    public static int digitalRoot(int n) {
        int sum = n; // just setting it to not trigger the while condition wrongly
        while (sum >= 10) {
            sum = tverrsum(sum);
        }
        return sum;
    }

    public static int kvardatTall(int n) {
        if (n == 1) {
            return 1;
        }
        return n * n + kvardatTall(n - 1);
    }

    public static int sum(int k, int n) {
        if (k > n) {
            return 0;
        }
        return n + sum(k, n - 1);
    }


    public static int sumFasit(int n, int k)
    {
        if (n == k) return n;
        int m = (n + k)/2;
        return sum(n,m) + sum(m+1,k);
    }

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

    public static int fakul(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fakul(n - 1);
    }

    public static int fib(int n)         // det n-te Fibonacci-tallet
    {
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    //    Programkode 1.5.1 h)
    public static int euklid(int a, int b) {

        if (b == 0) return a;
        int r = a % b;            // r er resten
        System.out.println("Euklid " + r + " starter!");
        return euklid(b, r);       // rekursivt kall

    }
//    Programkode 1.5.1 c)
}

