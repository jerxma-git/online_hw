package expression.parser;

import java.util.*;

import expression.*;
import expression.generic.Biba;

public class ExpressionParser<T> extends BaseParser implements Parser {
    private Operator currOperator = Operator.CLOSE_BRACKET;
    private static final int highestLevel = 4;
    private static final int lowestLevel = 0;


    private final Biba<T> changeMe;

    public ExpressionParser(Biba<T> changeMe) {
        this.changeMe = changeMe;
    }

    private static final Map<Operator, Integer> PRIORITIES = new HashMap<>(Map.of(
            Operator.CLOSE_BRACKET, highestLevel + 1,
            Operator.MUL, 1,
            Operator.DIV, 1,
            Operator.ADD, 2,
            Operator.SUB, 2,
            Operator.RIGHT_SHIFT, 3,
            Operator.LEFT_SHIFT, 3,
            Operator.MIN, 4,
            Operator.MAX, 4
    ));

    private static final Map<String, Operator> OPERATORS = new HashMap<>(Map.of(
            "*", Operator.MUL,
            "/", Operator.DIV,
            "+", Operator.ADD,
            "-", Operator.SUB,
            ">>", Operator.RIGHT_SHIFT,
            "<<", Operator.LEFT_SHIFT,
            ")", Operator.CLOSE_BRACKET,
            "in", Operator.MIN,
            "ax", Operator.MAX
    ));

    


    private static final Map<Character, String> CHAR_TO_STRING = new HashMap<>(Map.of(
            '*', "*",
            '/', "/",
            '+', "+",
            '-', "-",
            '<', "<<",
            '>', ">>",
            ')', ")",
            'i', "in",
            'a', "ax"
    ));

    @Override
    public TripleExpression<T> parse(String expression) {
        setSource(new StringSource(format(expression)));
        nextChar();
        return getExpression(highestLevel);
    }


    private TripleExpression<T> getExpression(int level) {
        if (level == lowestLevel) {
            return getPrimitiveExpression();
        }
        TripleExpression<T> expression = getExpression(level - 1);
        while (PRIORITIES.get(currOperator) == level) {
            expression = makeExpression(currOperator, expression, getExpression(level - 1));
        }
        if (level == highestLevel) {
            testOperator();
        }
        return expression;
    }

    private Const<T> getConst(boolean isNegative) {
        StringBuilder val = new StringBuilder(isNegative ? "-" : "");
        while (between('0', '9')) {
            val.append(curr);
            nextChar();

        }
        testOperator();

        try {
            return new Const<T>(changeMe.parse(val.toString()), changeMe);
        } catch (NumberFormatException e) {
            throw error("Illegal constant: '" + val.toString() + "'");
        }
    }

    private Variable getVariable() {
        StringBuilder var = new StringBuilder();
        while (!testOperator()) {
            var.append(curr);
            nextChar();
        }
        return new Variable(var.toString());
    }

    private TripleExpression<T> getPrimitiveExpression() {
        if (test('-')) {
            if (between('0', '9')) {
                return getConst(true);
            } else {
                // return Negate.getCompressedNegate(getExpression(lowestLevel));
                return new Negate<T>(getExpression(lowestLevel), changeMe);
            }
        } else if (test('c')) {
            expect("ount");
            return new Count<T>(getExpression(lowestLevel), changeMe);
        } else if (test('(')) {
            return getExpression(highestLevel);
        } else if (between('0', '9')) {
            return getConst(false);
        } else {
            return getVariable();
        }
    }

    private boolean testOperator() {
        if (CHAR_TO_STRING.containsKey(curr)) {
            getOperator();
            return true;
        }
        if (test('m')) {
            getOperator();
            return true;
        }
        return false;
    }

    private void getOperator() {
        String operator = CHAR_TO_STRING.get(curr);
        expect(operator);

        currOperator = OPERATORS.get(operator);
    }

    private TripleExpression<T> makeExpression(Operator operator, TripleExpression<T> first, TripleExpression<T> second) {
        switch (operator) {
            case ADD:
                return new Add<T>(first, second, changeMe);
            case MUL:
                return new Multiply<T>(first, second, changeMe);
            case SUB:
                return new Subtract<T>(first, second, changeMe);
            case DIV:
                return new Divide<T>(first, second, changeMe);
            case MIN:
                return new Min<T>(first, second, changeMe);
            case MAX:
                return new Max<T>(first, second, changeMe);
            default:
                throw new IllegalStateException("Unsupported operator" + operator);
        }
    }


    private static String format(String str) {
        StringBuilder formattedString = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                formattedString.append(ch);
            }
        }
        return formattedString.toString() + ")";
    }
}