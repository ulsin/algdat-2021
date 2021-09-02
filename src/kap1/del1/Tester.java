package kap1.del1;

import java.util.NoSuchElementException;

import static kap1.del1.Kap1Del1.*;

public class Tester {
    // fra kompendie 1.1.7
    public static void makstest()
    {
        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (maks(a) != 6)  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks(a);  // kaller maks-metoden
        }
        catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException))
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
        }

        if (!unntak)
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
    }

    public static int makstestFlere1()
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

    public static int makstestFlere2()
    {
        int antallFeil = 0;

        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (maks2(a) != 6) {  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks2(a);  // kaller maks-metoden
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
        if (maks2(a) != 0) {
            System.out.println("Kodefeil i størst først");
            antallFeil++;
        }

        // største er sist
        a = new int[]{1, 4, 6, 10};
        if (maks2(a) != 3) {
            System.out.println("Kodefeil i størst sist");
            antallFeil++;
        }

        // største forekommer flere steder. Tester for at den gir indexen til første forekomst, og ikke siste.
        a = new int[]{1, 10, 6, 10};
        if (maks2(a) != 1) {
            System.out.println("Kodefeil i flere steder");
            antallFeil++;
        }

        // - en tabell med kun én verdi
        a = new int[]{2};
        if (maks2(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        // - kun to verdier som er ulike og
        a = new int[]{2,3};
        if (maks2(a) != 1) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- kun to verdier som er like.
        a = new int[]{2,2};
        if (maks2(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- Lag en test for en null-tabell.
        a = new int[0];
        boolean exeptionEmpty = false;

        try {
            maks2(a);
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

    public static int makstestFlere3()
    {
        int antallFeil = 0;

        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (maks3(a) != 6) {  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks3(a);  // kaller maks-metoden
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
        if (maks3(a) != 0) {
            System.out.println("Kodefeil i størst først");
            antallFeil++;
        }

        // største er sist
        a = new int[]{1, 4, 6, 10};
        if (maks3(a) != 3) {
            System.out.println("Kodefeil i størst sist");
            antallFeil++;
        }

        // største forekommer flere steder. Tester for at den gir indexen til første forekomst, og ikke siste.
        a = new int[]{1, 10, 6, 10};
        if (maks3(a) != 1) {
            System.out.println("Kodefeil i flere steder");
            antallFeil++;
        }

        // - en tabell med kun én verdi
        a = new int[]{2};
        if (maks3(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        // - kun to verdier som er ulike og
        a = new int[]{2,3};
        if (maks3(a) != 1) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- kun to verdier som er like.
        a = new int[]{2,2};
        if (maks3(a) != 0) {
            System.out.println("Kodefeil i kun en verdi");
            antallFeil++;
        }

        //- Lag en test for en null-tabell.
        a = new int[0];
        boolean exeptionEmpty = false;

        try {
            maks3(a);
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
}
