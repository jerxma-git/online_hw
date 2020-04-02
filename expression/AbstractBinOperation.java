package expression;
import expression.generic.*;
public abstract class AbstractBinOperation<T> implements TripleExpression<T> {
    protected TripleExpression<T> first;
    protected TripleExpression<T> second;
    protected Biba<T> changeMe;

    protected abstract String getSign();

    protected AbstractBinOperation(TripleExpression<T> first, TripleExpression<T> second, Biba<T> changeMe) {
        this.first = first;
        this.second = second;
        this.changeMe = changeMe;
    }

    protected abstract T calculate(T first, T second);

    public String toString() {
        return "(" + first.toString() + " " + getSign() + " " + second.toString() + ")";
    }

    @Override
    public T evaluate(T x, T y, T z) {
            return calculate(first.evaluate(x, y, z), second.evaluate(x, y, z)); 
    }



}