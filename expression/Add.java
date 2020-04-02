package expression;
import expression.generic.*;

public class Add<T> extends AbstractBinOperation<T> {
    public Add(TripleExpression<T> first, TripleExpression<T> second, Biba<T> changeMe) {
        super(first, second, changeMe);
    }

    @Override
    protected T calculate(T first, T second) {
        return changeMe.add(first, second);
    }

    

}