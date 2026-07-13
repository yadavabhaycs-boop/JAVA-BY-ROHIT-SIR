// Interface
interface MathOperations {

    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b);
}

// Implementing Interface
class Calculator implements MathOperations {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return a / b;
    }
}

// Main Class
public class MathInterfaceDemo {

    public static void main(String[] args) {

        MathOperations calculator = new Calculator();

        System.out.println("Addition = " + calculator.add(10, 5));
        System.out.println("Subtraction = " + calculator.subtract(10, 5));
        System.out.println("Multiplication = " + calculator.multiply(10, 5));
        System.out.println("Division = " + calculator.divide(10, 5));
    }
}
