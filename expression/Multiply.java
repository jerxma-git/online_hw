package expression;
import expression.generic.*;

public class Multiply<T> extends AbstractBinOperation<T> {
    public Multiply(TripleExpression<T> first, TripleExpression<T> second, Biba<T> changeMe) {
        super(first, second, changeMe);
    }

    protected String getSign() {
        return "*";
    }

    @Override
    protected T calculate(T first, T second) {
        return changeMe.mul(first, second);
    }

    

}