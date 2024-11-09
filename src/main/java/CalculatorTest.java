import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        double result = calculator.add(5.0, 3.0);
        Assertions.assertEquals(8.0, result, "Addition test failed.");
    }

    @Test
    void testSubtraction() {
        double result = calculator.subtract(5.0, 3.0);
        Assertions.assertEquals(2.0, result, "Subtraction test failed.");
    }

    @Test
    void testMultiplication() {
        double result = calculator.multiply(5.0, 3.0);
        Assertions.assertEquals(15.0, result, "Multiplication test failed.");
    }

    @Test
    void testDivision() {
        double result = calculator.divide(6.0, 2.0);
        Assertions.assertEquals(3.0, result, "Division test failed.");
    }

    @Test
    void testDivisionByZero() {
        ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(6.0, 0),
                "Expected ArithmeticException for division by zero"
        );
        Assertions.assertEquals("Error: division by zero is not possible.", exception.getMessage());
    }

    @Test
    void testSquareRoot() {
        double result = calculator.sqrt(9.0);
        Assertions.assertEquals(3.0, result, "Square root test failed.");
    }

    @Test
    void testSquareRootOfNegative() {
        InvalidInputException exception = Assertions.assertThrows(
                InvalidInputException.class,
                () -> calculator.sqrt(-9.0),
                "Expected InvalidInputException for negative square root input"
        );
        Assertions.assertEquals("Error: the input value cannot be negative for a square root.", exception.getMessage());
    }
}
