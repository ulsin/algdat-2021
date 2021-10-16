package eksempelklasser;

import java.util.Comparator;

public interface Kø<T>              // eng: Queue
{
    public boolean leggInn(T verdi); // eng: offer/add/enqueue    inn bakerst
    public T kikk();                 // eng: peek/element/front   den første
    public T taUt();                 // eng: poll/remove/dequeue  tar ut den første
    public int antall();             // eng: size                 køens antall
    public boolean tom();            // eng: isEmpty              er køen tom?
    public void nullstill();         // eng: clear                tømmer køen

    public static <T> void sorter(Kø<T> kø, Stakk<T> stakk, Comparator<? super T> c) {

        int n = kø.antall();

        for (int i = n; i > 0; i--) {
            stakk.leggInn(kø.taUt());

            for (int j = 1; j < i; j++) {
                T temp = kø.taUt();

                if (c.compare(temp, stakk.kikk()) > 0) {
                    kø.leggInn(stakk.taUt());
                    stakk.leggInn(temp);
                } else {
                    kø.leggInn(temp);
                }
            }
        }
        while (!stakk.tom()) kø.leggInn(stakk.taUt());
    }

    public static <T> void sorter(Kø<T> kø, Comparator<? super T> c) {
        sorter(kø, new TabellStakk<>(), c);
    }

} // interface Kø

//              Programkode 4.2.1 a)