package expression;

public class Variable<T> implements TripleExpression<T> {
    String varName;
    public Variable(String varName) {
        this.varName = varName;
    }
    
    @Override
    public T evaluate(T x, T y, T z) {
        switch (varName) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new IllegalArgumentException("Variable '" + varName + 
                        "' is not supported. Failed to evaluate");
        }
    }
}