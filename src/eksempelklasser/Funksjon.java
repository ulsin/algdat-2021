package eksempelklasser;

@FunctionalInterface
public interface Funksjon<T,R>    // T for argumenttype, R for returtype
{
    R anvend(T t);
}
//              Programkode 1.4.7 f)