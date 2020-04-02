package expression;
import expression.generic.*;

public class Divide<T> extends AbstractBinOperation<T> {
    public Divide(TripleExpression<T> first, TripleExpression<T> second, Biba<T> changeMe) {
        super(first, second, changeMe);
    }

    @Override
    protected T calculate(T first, T second) {
        return changeMe.div(first, second);
    }

    

}