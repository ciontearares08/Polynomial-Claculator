
import java.util.Map;
import java.util.TreeMap;

// Polynomial class representing a polynomial expression
class Polynomial {
    private final TreeMap<Integer, Integer> monomials; // TreeMap to automatically sort by keys (exponents)

    public Polynomial() {
        this.monomials = new TreeMap<>((a, b) -> Integer.compare(b, a)); // Descending order comparator
    }

    // Add a monomial to this polynomial
    public void addMonomial(Monomial monomial) {
        monomials.put(monomial.getExponent(), monomials.getOrDefault(monomial.getExponent(), 0) + monomial.getCoefficient());
    }

    // Add another polynomial to this polynomial
    public void add(Polynomial other) {
        for (Map.Entry<Integer, Integer> entry : other.monomials.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            monomials.put(exponent, monomials.getOrDefault(exponent, 0) + coefficient);
        }
    }

    // Subtract another polynomial from this polynomial
    public void subtract(Polynomial other) {
        for (Map.Entry<Integer, Integer> entry : other.monomials.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            monomials.put(exponent, monomials.getOrDefault(exponent, 0) - coefficient);
        }
    }

    // Multiply this polynomial by another polynomial
    public void multiply(Polynomial other) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Integer> thisEntry : this.monomials.entrySet()) {
            for (Map.Entry<Integer, Integer> otherEntry : other.monomials.entrySet()) {
                Monomial thisMonomial = new Monomial(thisEntry.getValue(), thisEntry.getKey());
                Monomial otherMonomial = new Monomial(otherEntry.getValue(), otherEntry.getKey());
                Monomial product = thisMonomial.multiply(otherMonomial);
                result.addMonomial(product);
            }
        }
        this.monomials.clear();
        this.monomials.putAll(result.monomials);
    }

    // Divide this polynomial by another polynomial using long division
    public Polynomial divide(Polynomial divisor) {
        // Implement polynomial division here
        return null; // Placeholder
    }

    // Compute the derivative of this polynomial
    public Polynomial derivative() {
        Polynomial derivative = new Polynomial();
        for (Map.Entry<Integer, Integer> entry : this.monomials.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            Monomial monomial = new Monomial(coefficient, exponent);
            Monomial derivativeMonomial = monomial.derivative();
            derivative.addMonomial(derivativeMonomial);
        }
        return derivative;
    }

    // Compute the indefinite integral of this polynomial
    public Polynomial integrate() {
        Polynomial integral = new Polynomial();
        for (Map.Entry<Integer, Integer> entry : this.monomials.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            double newCoefficient = (double) coefficient / (exponent + 1); // Compute the new coefficient
            integral.addMonomial(new Monomial((int) newCoefficient, exponent + 1)); // Create the integrated monomial
        }
        return integral;
    }



    // Convert the polynomial to a string representation
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean firstTerm = true;
        for (Map.Entry<Integer, Integer> entry : this.monomials.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            if (coefficient != 0) {
                if (!firstTerm) {
                    result.append(coefficient >= 0 ? " + " : " - ");
                } else {
                    result.append(coefficient < 0 ? "-" : "");
                }
                int absCoefficient = Math.abs(coefficient);
                if (absCoefficient != 1 || exponent == 0) { // Omit coefficient if it's 1 or -1, except for constant term
                    result.append(absCoefficient);
                }
                if (exponent > 0) {
                    result.append("x");
                    if (exponent > 1) {
                        result.append("^").append(exponent);
                    }
                }
                firstTerm = false;
            }
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }
}
