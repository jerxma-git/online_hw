package expression;

import expression.generic.*;
public class Const<T> implements TripleExpression<T> {

    private T val;
    private Biba<T> changeMe;

    public Const(T val, Biba<T> changeMe) {
        this.val = val;
        this.changeMe = changeMe;
    }
    
    public T evaluate(T x, T y, T z) {
        return val;
    }    

    public String toString() {
        return changeMe.toString(val);
    }

}