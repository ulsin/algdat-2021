package kap1.eksempelklasser;

@FunctionalInterface                // legges i mappen eksempelklasser
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T x, T y);            // en abstrakt metode

    public static <T extends Comparable<? super T>> Komparator<T> naturligOrden()
    {
        return (x, y) -> x.compareTo(y);
    }


    public static <T extends Comparable<? super T>> Komparator<T> omvendtOrden()
    {
        return (x, y) -> y.compareTo(x);
    }

    public static <T, R extends Comparable<? super R>>
    Komparator<T> orden(Funksjon<? super T, ? extends R> velger)
    {
        return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }
//    Programkode 1.4.7 g)

    public static <T, R> Komparator<T> orden
            (Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }
//    Programkode 1.4.7 k)

    default Komparator<T> deretter(Komparator<? super T> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(x, y);
        };
    }
//    Programkode 1.4.8 c)

    default <R extends Comparable<? super R>>  // tilhører grensesnittet Komparator
    Komparator<T> deretter(Funksjon<? super T, ? extends R> velger)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
        };
    }
//    Programkode 1.4.8 f)

    default <R> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }
//    Programkode 1.4.8 l)

//    En komparator som «snur» en ordning, kan også lages som en default metode:

    default Komparator<T> omvendt()
    {
        return (x, y) -> compare(y, x);  // bytter x og y
    }
//    Programkode 1.4.8 m)
}
//                Programkode 1.4.6 a)
// er ikke skumlere enn at dette er en interface som tvinger andre metoder til å lage compare metoden