import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class OperationTest {

    @Test
    void testFromStringAddition() {
        Operation operation = Operation.fromString("+");
        Assertions.assertEquals(Operation.ADD, operation, "Failed to parse addition operation.");
    }

    @Test
    void testFromStringSubtraction() {
        Operation operation = Operation.fromString("-");
        Assertions.assertEquals(Operation.SUBTRACT, operation, "Failed to parse subtraction operation.");
    }

    @Test
    void testFromStringMultiplication() {
        Operation operation = Operation.fromString("*");
        Assertions.assertEquals(Operation.MULTIPLY, operation, "Failed to parse multiplication operation.");
    }

    @Test
    void testFromStringDivision() {
        Operation operation = Operation.fromString("/");
        Assertions.assertEquals(Operation.DIVIDE, operation, "Failed to parse division operation.");
    }

    @Test
    void testFromStringSquareRoot() {
        Operation operation = Operation.fromString("sqrt");
        Assertions.assertEquals(Operation.SQRT, operation, "Failed to parse square root operation.");
    }

    @Test
    void testInvalidOperation() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Operation.fromString("invalid"),
                "Expected IllegalArgumentException for invalid operation"
        );
        Assertions.assertEquals("Incorrect operation: invalid", exception.getMessage());
    }
}
