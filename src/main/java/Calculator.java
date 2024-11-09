public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: division by zero is not possible.");
        }
        return a / b;
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new InvalidInputException("Error: the input value cannot be negative for a square root.");
        }
        return Math.sqrt(a);
    }
}
