package expression.generic;
public interface Biba<T> {
    T add(T f, T s);
    T sub(T f, T s);
    T mul(T f, T s);
    T div(T f, T s);
    T neg(T f);
    T cnt(T f); 
    T min(T f, T s);
    T max(T f, T s);
    T parse(String valStr);
    T parse(int val);
    String toString(T val);
}