import java.util.Objects;

// Monomial class representing a single term in a polynomial
class Monomial {
    private int coefficient;
    private int exponent;

    public Monomial(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    // Add another monomial to this monomial
    public Monomial add(Monomial other) {
        if (this.exponent != other.exponent) {
            throw new IllegalArgumentException("Exponents must be equal for addition.");
        }
        return new Monomial(this.coefficient + other.coefficient, this.exponent);
    }

    // Subtract another monomial from this monomial
    public Monomial subtract(Monomial other) {
        if (this.exponent != other.exponent) {
            throw new IllegalArgumentException("Exponents must be equal for subtraction.");
        }
        return new Monomial(this.coefficient - other.coefficient, this.exponent);
    }

    // Multiply this monomial with another monomial
    public Monomial multiply(Monomial other) {
        return new Monomial(this.coefficient * other.coefficient, this.exponent + other.exponent);
    }

    // Divide this monomial by another monomial
    public Monomial divide(Monomial divisor) {
        if (this.exponent < divisor.exponent || this.coefficient % divisor.coefficient != 0) {
            throw new IllegalArgumentException("Cannot perform exact division.");
        }
        return new Monomial(this.coefficient / divisor.coefficient, this.exponent - divisor.exponent);
    }

    // Compute the derivative of this monomial
    public Monomial derivative() {
        if (this.exponent == 0) {
            return new Monomial(0, 0);
        }
        return new Monomial(this.coefficient * this.exponent, this.exponent - 1);
    }

    // Compute the indefinite integral of this monomial
    public Monomial integrate() {
        int newExponent = exponent + 1;
        int newCoefficient = coefficient / newExponent;
        return new Monomial(newCoefficient, newExponent);
    }


    // Override toString method to get string representation of monomial
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (coefficient != 0) {
            if (Math.abs(coefficient) != 1 || exponent == 0) {
                result.append(Math.abs(coefficient));
            }
            if (exponent > 0) {
                result.append("x");
                if (exponent > 1) {
                    result.append("^").append(exponent);
                }
            }
        } else {
            result.append("0");
        }
        return result.toString();
    }

    // Override equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return coefficient == monomial.coefficient && exponent == monomial.exponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, exponent);
    }
}

