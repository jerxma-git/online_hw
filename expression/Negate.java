package expression;
import expression.generic.*;


public class Negate<T> extends AbstractUnOperation<T> {

    public Negate(TripleExpression<T> expression, Biba<T> changeMe) {
        super(expression, changeMe);
    }


    protected String getSign() {
        return "-";
    }

    @Override
    protected T calculate(T val) {
        return changeMe.mul(changeMe.parse("-1"), val);
    }


    
}