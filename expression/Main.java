package expression;

import expression.generic.Biba;
import expression.generic.IntEval;

import expression.parser.*;
public class Main {
    public static void main(String[] args) {
        ExpressionParser<Integer> parser = new ExpressionParser<>(new IntEval());
        TripleExpression<Integer> exp = parser.parse("10 min 4"); // / 2 - 7
        System.out.println(exp);
        Integer res = exp.evaluate(1, 2, 3);
        System.out.println(res);
    }
}