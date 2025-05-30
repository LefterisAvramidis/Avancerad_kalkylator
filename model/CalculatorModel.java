package model;

public class CalculatorModel {
    public double add(double a, double b) { return a + b; }

    public double subtract(double a, double b) { return a - b; }

    public double multiply(double a, double b) { return a * b; }

    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    public double squareRoot(double a) { return Math.sqrt(a); }

    public double percent(double a) { return a / 100.0; }

    public double power(double a, double b) { return Math.pow(a, b); }
}
