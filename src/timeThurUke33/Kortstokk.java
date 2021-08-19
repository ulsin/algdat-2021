package timeThurUke33;

public class Kortstokk {
    public static void main(String[] args) {
        int[] values = {9, 13, 5, 10, 13};
        System.out.println(findMin(values));
        System.out.println(maks(values));
    }

    static int findMin(int[] innArr) {
        int index = 0;
        int minVal = innArr[0];

        for (int i = 1; i < innArr.length; i++) {
            if (innArr[i] < minVal) {
                minVal = innArr[i];
                index = i;
            }
        }

        return index;
    }

    static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] >= a[m]) m = i;  // indeksen oppdateres // oppdateres også til siste nå siden >= istedenfor >
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks
}
