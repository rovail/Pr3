import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Calculator CALCULATOR = new Calculator();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1 = getDoubleInput(scanner, "Enter the first number: ");
            Optional<Double> num2 = Optional.empty();

            System.out.print("Select an operation (+, -, *, /, sqrt): ");
            Operation operation;
            try {
                operation = Operation.fromString(scanner.next());
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
                return;
            }

            if (operation != Operation.SQRT) {
                num2 = Optional.of(getDoubleInput(scanner, "Enter the second number: "));
            }

            double result = performOperation(operation, num1, num2);
            System.out.printf("Result: %.2f%n", result);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "There's been a mistake", e);
        } finally {
            System.out.println("The request is complete.");
        }
    }

    private static double getDoubleInput(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: Please enter a valid number.");
            System.out.print(message);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static double performOperation(Operation operation, double num1, Optional<Double> num2) {
        switch (operation) {
            case ADD:
                return CALCULATOR.add(num1, num2.orElse(0.0));
            case SUBTRACT:
                return CALCULATOR.subtract(num1, num2.orElse(0.0));
            case MULTIPLY:
                return CALCULATOR.multiply(num1, num2.orElse(0.0));
            case DIVIDE:
                return CALCULATOR.divide(num1, num2.orElseThrow(() -> new ArithmeticException("The second number is required for division.")));
            case SQRT:
                return CALCULATOR.sqrt(num1);
            default:
                throw new UnsupportedOperationException("Operation is not supported.");
        }
    }
}
