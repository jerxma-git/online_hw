package expression.generic;

public class IntEval implements Biba<Integer> {
    public Integer parse(String valStr) {
        return Integer.parseInt(valStr);
    }

    public Integer add(Integer a,  Integer b) {
        return a + b;
    }

    public Integer sub(Integer a, Integer b) {
        return a - b;
    }

    public Integer mul(Integer a, Integer b) {
        return a * b;
    }

    public Integer div(Integer a, Integer b) {
        return a / b;
    }

    public Integer neg(Integer a) {
        return -a;
    }

    public Integer min(Integer a, Integer b) {
        return Integer.min(a, b);
    }

    public Integer max(Integer a, Integer b) {
        return Integer.max(a, b);
    }

    public Integer cnt(Integer a) {
        return Integer.bitCount(a);
    }

    public Integer parse(int val) {
        return val;
    }

    public String toString(Integer val) {
        return val.toString();
    }
}