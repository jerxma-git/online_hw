package expression.generic;

import java.lang.ArithmeticException;
public class CheckedIntEval extends IntEval {

    public Integer add(Integer a, Integer b) {
		checkAdd(a, b);
		return super.add(a, b);
	}
	
	@Override
	public Integer sub(Integer a, Integer b) {
		checkSubtract(a, b);
		return super.sub(a, b);
	}
	
	@Override
	public Integer mul(Integer a, Integer b) {
		checkMultiply(a, b);
		return super.mul(a, b);
	}
	
	@Override
	public Integer div(Integer a, Integer b) {
		checkDivide(a, b);
		return super.div(a, b);
	}
	
	@Override
	public Integer neg(Integer a) {
		checkNegate(a);
		return super.neg(a);
	}
	
	private static void checkAdd(Integer x, Integer y) {
		if (x > 0 && Integer.MAX_VALUE - x < y || x < 0 && Integer.MIN_VALUE - x > y) {
			throw new ArithmeticException("Integer overflow");
		}
	}
	
	private void checkSubtract(Integer x, Integer y) {
		if ((y > 0 && Integer.MIN_VALUE + y > x) || (y < 0 && Integer.MAX_VALUE + y < x)) {
			throw new ArithmeticException("Integer overflow");
		}
	}
	
	private void checkMultiply(Integer x, Integer y) {
        if (((y != 0) && (x * y / y != x)) || (x == Integer.MIN_VALUE && y == -1)
                || (y == Integer.MIN_VALUE && x == -1)) {
            throw new ArithmeticException("Integer overflow");
        }
	}
	
	private void checkDivide(Integer x, Integer y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new ArithmeticException("Integer overflow");
        }
    }
    
    private void checkNegate(Integer x) {
		if (x == Integer.MIN_VALUE) {
			throw new ArithmeticException("Integer overflow");
		}
	}


}