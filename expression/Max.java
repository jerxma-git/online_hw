package expression;

import expression.generic.*;

public class Max<T> extends AbstractBinOperation<T> {
    public Max(TripleExpression<T> first, TripleExpression<T> second, Biba<T> changeMe) {
        super(first, second, changeMe);
    }

    protected String getSign() {
        return "+";
    }

    @Override
    protected T calculate(T first, T second) {
        return changeMe.max(first, second);
    }

    

}