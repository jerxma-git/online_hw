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

    public BigInteger parse(int val) {
        return BigInteger.valueOf(val);
    }
}