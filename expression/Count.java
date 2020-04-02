package expression;

import expression.generic.*;

public class Count<T> extends AbstractUnOperation<T> {
    public Count(TripleExpression<T> exp, Biba<T> changeMe) {
        super(exp, changeMe);
    }

    protected String getSign() {
        return "count";
    }

    @Override
    protected T calculate(T exp) {
        return changeMe.cnt(exp);
    }

    

}