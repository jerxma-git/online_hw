package expression;

import expression.generic.*;
public abstract class AbstractUnOperation<T> implements TripleExpression<T> {
    protected TripleExpression<T> expression;
    protected Biba<T> changeMe;
    public AbstractUnOperation(TripleExpression<T> expression, Biba<T> changeMe) {
        this.expression = expression;
        this.changeMe = changeMe;
    }

    protected abstract String getSign();

    protected abstract T calculate(T val);

    @Override
    public String toString() {
        return getSign() + "(" + expression.toString() + ")";
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calculate(expression.evaluate(x,y,z));
    }

}