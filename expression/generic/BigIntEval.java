package expression.generic;

import java.math.BigInteger;

public class BigIntEval implements Biba<BigInteger> {
    public BigInteger parse(String valStr) {
        return new BigInteger(valStr);
    }

    public BigInteger add(BigInteger a,  BigInteger b) {
        return a.add(b);
    }

    public BigInteger sub(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public BigInteger mul(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    public BigInteger div(BigInteger a, BigInteger b) {
        return a.divide(b);
    }
    
    public BigInteger neg(BigInteger a) {
        return a.negate();
    }

    public BigInteger min(BigInteger a, BigInteger b) {
        return a.min(b);
    }

    public BigInteger max(BigInteger a, BigInteger b) {
        return a.max(b);
    }

    public BigInteger cnt(BigInteger a) {
        return parse(a.bitCount());
    }

    public BigInteger parse(int val) {
        return BigInteger.valueOf(val);
    }

    public String toString(BigInteger val) {
        return val.toString();
    }
}