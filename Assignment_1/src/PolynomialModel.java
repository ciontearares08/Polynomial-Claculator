import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PolynomialModel {
    private Polynomial firstPolynomial;
    private Polynomial secondPolynomial;

    public PolynomialModel() {
        firstPolynomial = new Polynomial();
        secondPolynomial = new Polynomial();
    }

    // Parse the polynomial expression and set it as the first polynomial
    public void parseFirst(String input) {
        firstPolynomial = parsePolynomial(input);
    }

    // Parse the polynomial expression and set it as the second polynomial
    public void parseSecond(String input) {
        secondPolynomial = parsePolynomial(input);
    }

    // Add another polynomial to the first polynomial
    public void add(Polynomial other) {
        firstPolynomial.add(other);
    }

    // Subtract another polynomial from the first polynomial
    public void subtract(Polynomial other) {
        firstPolynomial.subtract(other);
    }

    // Multiply the first polynomial by another polynomial
    public void multiply(Polynomial other) {
        firstPolynomial.multiply(other);
    }

    // Divide the first polynomial by another polynomial
    public String divide(Polynomial divisor) {
        Polynomial quotient = firstPolynomial.divide(divisor);
        return quotient.toString();
    }

    // Compute the derivative of the first polynomial
    public PolynomialModel derivative() {
        Polynomial derivative = firstPolynomial.derivative();
        PolynomialModel derivativeModel = new PolynomialModel();
        derivativeModel.parseFirst(derivative.toString());
        return derivativeModel;
    }

    // Compute the indefinite integral of the first polynomial
    public PolynomialModel integrate() {
        Polynomial integral = firstPolynomial.integrate();
        PolynomialModel integralModel = new PolynomialModel();
        integralModel.parseFirst(integral.toString());
        return integralModel;
    }


    // Convert the first polynomial to a string representation
    public String toString() {
        return firstPolynomial.toString();
    }

    // Get the second polynomial
    public Polynomial getSecondPolynomial() {
        return secondPolynomial;
    }

    private Polynomial parsePolynomial(String input) {
        Polynomial polynomial = new Polynomial();
        // Split the input string by '+' and '-' signs to separate monomials
        String[] monomials = input.split("(?=[+-])");
        System.out.println("Monomials:");
        for (String monomial : monomials) {
            // Trim leading and trailing spaces
            monomial = monomial.trim();
            System.out.println(monomial);
            // Skip empty monomials
            if (monomial.isEmpty()) continue;
            // Parse the coefficient and exponent
            int coefficient = 0;
            int exponent = 0;
            // Separate coefficient and variable parts
            String[] parts = monomial.split("x", 2);
            // Parse coefficient
            if (!parts[0].isEmpty()) {
                coefficient = parts[0].equals("+") ? 1 : parts[0].equals("-") ? -1 : Integer.parseInt(parts[0]);
            } else {
                coefficient = 1;
            }
            // Parse exponent
            if (parts.length > 1 && parts[1].contains("^")) {
                exponent = Integer.parseInt(parts[1].substring(parts[1].indexOf('^') + 1));
            } else {
                exponent = parts.length > 1 ? 1 : 0;
            }
            // Add the parsed monomial to the polynomial
            polynomial.addMonomial(new Monomial(coefficient, exponent));
        }
        return polynomial;
    }

}
