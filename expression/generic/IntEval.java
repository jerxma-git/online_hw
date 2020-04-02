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

    public Integer parse(int val) {
        return val;
    }
}