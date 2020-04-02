package expression.generic;

import java.util.Map;

import expression.TripleExpression;
import expression.parser.ExpressionParser;

public class GenericTabulator implements Tabulator {

    private static final Map<String, Biba<?>> EVALUATORS = Map.of(
        "i", new IntEval(),
        "d", new DoubleEval(),
        "bi", new BigIntEval()
    );

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {//throws ExpressionException {
        Biba<?> evaluator = EVALUATORS.get(mode);

        return tabulate(evaluator, expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] tabulate(Biba<T> evaluator, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {//throws ExpressionException {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        ExpressionParser<T> parser = new ExpressionParser<>(evaluator);
        TripleExpression<T> exp = parser.parse(expression);

        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    // try {
                        result[i][j][k] = exp.evaluate(evaluator.parse(x1 + i), evaluator.parse(y1 + j), evaluator.parse(z1 + k));
                    // } catch(Exception e) {
                    //     result[i][j][k] = null;
                    // }
                }
            }   
        }
        return result;
    }

}
