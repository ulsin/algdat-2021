package kap1.eksempelklasser;

@FunctionalInterface                // legges i mappen eksempelklasser
public interface Komparator<T>      // et funksjonsgrensesnitt
{
    int compare(T x, T y);            // en abstrakt metode
}
//                Programkode 1.4.6 a)
// er ikke skumlere enn at dette er en interface som tvinger andre metoder til å lage compare metoden