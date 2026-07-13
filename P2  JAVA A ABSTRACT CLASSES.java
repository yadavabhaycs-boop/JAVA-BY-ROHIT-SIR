// Abstract Class
abstract class MathOperation {

    // Abstract Method
    abstract double calculate(double a, double b);

    // Concrete Method
    void displayResult(String operation, double result) {
        System.out.println(operation + " Result = " + result);
    }
}

// Addition Class
class Addition extends MathOperation {

    @Override
    double calculate(double a, double b) {
        return a + b;
    }
}

// Subtraction Class
class Subtraction extends MathOperation {

    @Override
    double calculate(double a, double b) {
        return a - b;
    }
}

// Multiplication Class
class Multiplication extends MathOperation {

    @Override
    double calculate(double a, double b) {
        return a * b;
    }
}

// Division Class
class Division extends MathOperation {

    @Override
    double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Main Class
public class AbstractMathDemo {

    public static void main(String[] args) {

        MathOperation add = new Addition();
        MathOperation sub = new Subtraction();
        MathOperation mul = new Multiplication();
        MathOperation div = new Division();

        double a = 20;
        double b = 10;

        add.displayResult("Addition", add.calculate(a, b));
        sub.displayResult("Subtraction", sub.calculate(a, b));
        mul.displayResult("Multiplication", mul.calculate(a, b));
        div.displayResult("Division", div.calculate(a, b));
    }
}

