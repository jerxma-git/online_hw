package expression.generic;

public class DoubleEval implements Biba<Double> {
    public Double parse(String valStr) {
        return Double.parseDouble(valStr);
    }

    public Double add(Double a,  Double b) {
        return a + b;
    }

    public Double sub(Double a, Double b) {
        return a - b;
    }

    public Double mul(Double a, Double b) {
        return a * b;
    }

    public Double div(Double a, Double b) {
        return a / b;
    }

    public Double neg(Double a) {
        return -a;
    }

    public Double parse(int val) {
        return Double.valueOf(val);
    }
}