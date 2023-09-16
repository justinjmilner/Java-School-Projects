/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

/**
 * Rational class represents a rational number.
 * It extends the Number class and implements the Serializable and Comparable interfaces.
 * It provides various mathematical operations and utility methods for rational numbers.
 */
public class Rational extends Number implements Serializable, Comparable<Rational> {

    private long num;
    private long den;
    private BigInteger bigNum;
    private BigInteger bigDen;

    /**
     * Constructs a Rational object with the specified numerator and denominator.
     *
     * @param n the numerator of the rational number.
     * @param d the denominator of the rational number.
     * @throws ArithmeticException if the denominator is zero.
     */
    public Rational(long n, long d) {
        if (d == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        this.num = n;
        this.den = d;
    }

    /**
     * Constructs a Rational object with the specified numerator and denominator.
     *
     * @param n the numerator of the rational number.
     * @param d the denominator of the rational number.
     * @throws ArithmeticException if the denominator is zero.
     * @throws NullPointerException if either the numerator or the denominator is null.
     */
    public Rational(BigInteger n, BigInteger d) {
        if (d.intValue() == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        if (n == null || d == null) {
            throw new NullPointerException("Parameter cannot be null");
        }
        this.bigNum = n;
        this.bigDen = d;
    }

    /**
     * Returns the absolute value of the rational number.
     *
     * @return the absolute value of the rational number.
     */
    public Rational abs() {
        if (bigNum != null) {
            BigInteger absNum = bigNum.abs();
            BigInteger absDen = bigDen.abs();
            return new Rational(absNum, absDen);
        } else {
            long absNum = Math.abs(num);
            long absDen = Math.abs(den);
            return new Rational(absNum, absDen);
        }
    }

    /**
     * Adds the specified double value to the rational number.
     *
     * @param addend the double value to be added.
     * @return the result of adding the double value to the rational number.
     */
    public Rational add(double addend) {
        return this.add(Rational.valueOf(addend));
    }

    /**
     * Adds the specified long value to the rational number.
     *
     * @param addend the long value to be added.
     * @return the result of adding the long value to the rational number.
     */
    public Rational add(long addend) {
        return this.add(Rational.valueOf(addend));
    }

    /**
     * Adds the specified rational number to the rational number.
     *
     * @param addend the rational number to be added.
     * @return the result of adding the rational number to the rational number.
     */
    public Rational add(Rational addend) {
        Rational thisCanonical = this.canonical();
        Rational addendCanonical = addend.canonical();

        if (thisCanonical.bigNum != null && addendCanonical.bigNum != null) {
            BigInteger multipliedNum1 = thisCanonical.bigNum.multiply(addendCanonical.bigDen);
            BigInteger multipliedNum2 = addendCanonical.bigNum.multiply(thisCanonical.bigDen);
            BigInteger addedNum = multipliedNum1.add(multipliedNum2);
            BigInteger commonDen = thisCanonical.bigDen.multiply(addendCanonical.bigDen);
            return new Rational(addedNum, commonDen);
        } else {
            long multipliedNum1 = thisCanonical.num * addendCanonical.den;
            long multipliedNum2 = addendCanonical.num * thisCanonical.den;
            long addedNum = multipliedNum1 + multipliedNum2;
            long commonDen = thisCanonical.den * addendCanonical.den;
            return new Rational(addedNum, commonDen);
        }
    }

    /**
     * Returns the canonical form of the rational number.
     *
     * @return the canonical form of the rational number.
     */
    public Rational canonical() {
        Rational temp;

        if (bigNum != null) {
            BigInteger gcd = bigNum.gcd(bigDen);
            if (gcd.compareTo(BigInteger.ONE) > 0) {
                BigInteger canonicalNum = bigNum.divide(gcd);
                BigInteger canonicalDen = bigDen.divide(gcd);
                temp = new Rational(canonicalNum, canonicalDen);
                return temp;
            }
            return new Rational(bigNum, bigDen);
        } else {
            BigInteger numBigInt = BigInteger.valueOf(num);
            BigInteger denBigInt = BigInteger.valueOf(den);
            BigInteger gcd = numBigInt.gcd(denBigInt);
            if (gcd.compareTo(BigInteger.ONE) > 0) {
                BigInteger canonicalNum = numBigInt.divide(gcd);
                BigInteger canonicalDen = denBigInt.divide(gcd);
                temp = new Rational(canonicalNum.longValueExact(), canonicalDen.longValueExact());
                return temp;
            }
            return new Rational(num, den);
        }
    }

    /**
     * Compares this rational number with the specified rational number for order.
     *
     * @param val the rational number to be compared.
     * @return a negative integer, zero, or a positive integer as this rational number is less than, equal to, or greater than the specified rational number.
     */
    @Override
    public int compareTo(Rational val) {
        Rational thisCanonical = this.canonical();
        Rational valCanonical = val.canonical();

        if (thisCanonical.bigNum != null && valCanonical.bigNum != null) {
            BigInteger multipliedNum1 = thisCanonical.bigNum.multiply(valCanonical.bigDen);
            BigInteger multipliedNum2 = valCanonical.bigNum.multiply(thisCanonical.bigDen);
            return multipliedNum1.compareTo(multipliedNum2);
        } else {
            BigInteger num1 = BigInteger.valueOf(thisCanonical.num).multiply(BigInteger.valueOf(valCanonical.den));
            BigInteger num2 = BigInteger.valueOf(valCanonical.num).multiply(BigInteger.valueOf(thisCanonical.den));
            return num1.compareTo(num2);
        }
    }

    /**
     * Returns the decimal value of the rational number.
     *
     * @return the decimal value of the rational number.
     * @throws ArithmeticException if the decimal expansion is non-terminating.
     */
    public BigDecimal decimalValue() {
        Rational canonical = this.canonical();

        if (canonical.bigNum != null) {
            BigDecimal numerator = new BigDecimal(canonical.bigNum);
            BigDecimal denominator = new BigDecimal(canonical.bigDen);
            BigDecimal result = numerator.divide(denominator, MathContext.DECIMAL128);

            if (result.scale() == 0 || result.stripTrailingZeros().scale() > 0) {
                throw new ArithmeticException("Non-terminating decimal expansion");
            }

            return result;
        } else {
            BigDecimal result = new BigDecimal(canonical.num).divide(new BigDecimal(canonical.den), MathContext.DECIMAL128);

            if (result.scale() == 0 || result.stripTrailingZeros().scale() > 0) {
                throw new ArithmeticException("Non-terminating decimal expansion");
            }

            return result;
        }
    }

    /**
     * Divides the rational number by the specified double divisor.
     *
     * @param divisor the double divisor.
     * @return the result of dividing the rational number by the double divisor.
     */
    public Rational divide(double divisor) {
        return this.divide(Rational.valueOf(divisor));
    }

    /**
     * Divides the rational number by the specified long divisor.
     *
     * @param divisor the long divisor.
     * @return the result of dividing the rational number by the long divisor.
     */
    public Rational divide(long divisor) {
        return this.divide(Rational.valueOf(divisor));
    }

    /**
     * Divides the rational number by the specified rational divisor.
     *
     * @param divisor the rational divisor.
     * @return the result of dividing the rational number by the rational divisor.
     * @throws ArithmeticException if the divisor is zero.
     */
    public Rational divide(Rational divisor) {
        BigInteger divisorDenominator = divisor.bigDen != null ? divisor.bigDen : BigInteger.valueOf(divisor.den);
        if (divisorDenominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }

        return this.multiply(divisor.reciprocal());
    }

    /**
     * Returns the double value of the rational number.
     *
     * @return the double value of the rational number.
     */
    @Override
    public double doubleValue() {
        Rational canonical = this.canonical();
        if (canonical.bigNum != null) {
            BigDecimal numerator = new BigDecimal(canonical.bigNum);
            BigDecimal denominator = new BigDecimal(canonical.bigDen);
            BigDecimal result = numerator.divide(denominator, MathContext.DECIMAL128);
            return result.doubleValue();
        } else {
            return (double) canonical.num / canonical.den;
        }
    }

    /**
     * Compares this rational number with the specified object for equality.
     *
     * @param other the object to compare.
     * @return true if the specified object is equal to this rational number, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Rational otherRational = (Rational) other;
        Rational thisCanonical = this.canonical();
        Rational otherCanonical = otherRational.canonical();

        if (thisCanonical.bigNum != null && otherCanonical.bigNum != null) {
            return thisCanonical.bigNum.multiply(otherCanonical.bigDen)
                    .equals(otherCanonical.bigNum.multiply(thisCanonical.bigDen));
        }

        return thisCanonical.num * thisCanonical.den == otherCanonical.num * otherCanonical.den;
    }

    /**
     * Returns the float value of the rational number.
     *
     * @return the float value of the rational number.
     */
    @Override
    public float floatValue() {
        if (bigNum != null) {
            BigDecimal numerator = new BigDecimal(bigNum);
            BigDecimal denominator = new BigDecimal(bigDen);
            BigDecimal result = numerator.divide(denominator, MathContext.DECIMAL128);
            return result.floatValue();
        } else {
            return (float) num / den;
        }
    }

    /**
     * Returns the denominator of the rational number.
     *
     * @return the denominator of the rational number.
     */
    public BigInteger getDenominator() {
        if (bigDen != null) {
            return bigDen;
        } else {
            return BigInteger.valueOf(den);
        }
    }

    /**
     * Returns the numerator of the rational number.
     *
     * @return the numerator of the rational number.
     */
    public BigInteger getNumerator() {
        if (bigNum != null) {
            return bigNum;
        } else {
            return BigInteger.valueOf(num);
        }
    }

    /**
     * Returns the hash code of the rational number.
     *
     * @return the hash code of the rational number.
     */
    @Override
    public int hashCode() {
        if (bigNum != null) {
            return Objects.hash(bigNum, bigDen);
        } else {
            return Objects.hash(num, den);
        }
    }

    /**
     * Returns the integer value of the rational number.
     *
     * @return the integer value of the rational number.
     */
    @Override
    public int intValue() {
        if (bigNum != null) {
            BigInteger result = bigNum.divide(bigDen);
            return result.intValue();
        } else {
            return (int) (num / den);
        }
    }

    /**
     * Checks if the rational number is a proper fraction.
     *
     * @return true if the rational number is a proper fraction, false otherwise.
     */
    public boolean isProper() {
        if (bigNum != null) {
            return bigNum.abs().compareTo(bigDen.abs()) < 0;
        } else {
            return Math.abs(num) < Math.abs(den);
        }
    }

    /**
     * Checks if the rational number is a repeating decimal.
     *
     * @return true if the rational number is a repeating decimal, false otherwise.
     */
    public boolean isRepeatingDecimal() {
        if (bigNum != null) {
            BigInteger remainder = bigNum.remainder(bigDen);
            return !remainder.equals(BigInteger.ZERO);
        } else {
            return false;
        }
    }

    /**
     * Returns the long value of the rational number.
     *
     * @return the long value of the rational number.
     */
    @Override
    public long longValue() {
        if (bigNum != null) {
            BigInteger result = bigNum.divide(bigDen);
            return result.longValue();
        } else {
            return num / den;
        }
    }

    /**
     * Multiplies the rational number by the specified double value.
     *
     * @param val the double value to be multiplied.
     * @return the result of multiplying the rational number by the double value.
     */
    public Rational multiply(double val) {
        Rational doubleRational = Rational.valueOf(val);
        return this.multiply(doubleRational);
    }

    /**
     * Multiplies the rational number by the specified long value.
     *
     * @param val the long value to be multiplied.
     * @return the result of multiplying the rational number by the long value.
     */
    public Rational multiply(long val) {
        Rational longRational = Rational.valueOf(val);
        return this.multiply(longRational);
    }

    /**
     * Multiplies the rational number by the specified rational value.
     *
     * @param val the rational value to be multiplied.
     * @return the result of multiplying the rational number by the rational value.
     */
    public Rational multiply(Rational val) {
        BigInteger thisNumerator = bigNum != null ? bigNum : BigInteger.valueOf(num);
        BigInteger thisDenominator = bigDen != null ? bigDen : BigInteger.valueOf(den);

        BigInteger otherNumerator = val.bigNum != null ? val.bigNum : BigInteger.valueOf(val.num);
        BigInteger otherDenominator = val.bigDen != null ? val.bigDen : BigInteger.valueOf(val.den);

        BigInteger resultNumerator = thisNumerator.multiply(otherNumerator);
        BigInteger resultDenominator = thisDenominator.multiply(otherDenominator);

        return new Rational(resultNumerator, resultDenominator);
    }

    /**
     * Negates the rational number.
     *
     * @return the negated rational number.
     */
    public Rational negate() {
        if (bigNum != null) {
            BigInteger negatedNum = bigNum.negate();
            return new Rational(negatedNum, bigDen);
        } else {
            return new Rational(-num, den);
        }
    }

    /**
     * Raises the rational number to the specified exponent.
     *
     * @param exponent the exponent to raise the rational number to.
     * @return the result of raising the rational number to the exponent.
     * @throws ArithmeticException if the base is zero and the exponent is negative.
     */
    public Rational pow(int exponent) {
        if (bigNum != null) {
            if (bigNum.signum() == 0 && exponent < 0) {
                throw new ArithmeticException("Cannot raise zero to a negative exponent.");
            }
            BigInteger powNum = bigNum.pow(Math.abs(exponent));
            BigInteger powDen = bigDen.pow(Math.abs(exponent));
            return new Rational(powNum, powDen);
        } else {
            if (num == 0 && exponent < 0) {
                throw new ArithmeticException("Cannot raise zero to a negative exponent.");
            }
            long powNum = (long) Math.pow(num, Math.abs(exponent));
            long powDen = (long) Math.pow(den, Math.abs(exponent));
            return new Rational(powNum, powDen);
        }
    }

    /**
     * Returns the reciprocal of the rational number.
     *
     * @return the reciprocal of the rational number.
     * @throws ArithmeticException if the rational number is zero.
     */
    public Rational reciprocal() {
        if (bigNum != null) {
            if (bigNum.signum() == 0) {
                throw new ArithmeticException("Cannot compute reciprocal. The value is zero.");
            }
            return new Rational(bigDen, bigNum);
        } else {
            if (num == 0) {
                throw new ArithmeticException("Cannot compute reciprocal. The value is zero.");
            }
            return new Rational(den, num);
        }
    }

    /**
     * Returns the signum function of the rational number.
     *
     * @return -1 if the rational number is negative, 0 if it is zero, or 1 if it is positive.
     */
    public int signum() {
        if (bigNum != null) {
            if (bigNum.signum() == 0) {
                return 0;
            } else if (bigNum.signum() < 0 && bigDen.signum() < 0) {
                return 1;
            } else if (bigNum.signum() >= 0 && bigDen.signum() > 0) {
                return bigNum.signum();
            } else {
                return -1 * bigNum.signum();
            }
        } else {
            if (num == 0) {
                return 0;
            } else if (num < 0 && den < 0) {
                return 1;
            } else if (num >= 0 && den > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    /**
     * Subtracts the specified double value from the rational number.
     *
     * @param subtrahend the double value to be subtracted.
     * @return the result of subtracting the double value from the rational number.
     */
    public Rational subtract(double subtrahend) {
        Rational subtrahendRational = Rational.valueOf(subtrahend);
        return this.subtract(subtrahendRational);
    }

    /**
     * Subtracts the specified long value from the rational number.
     *
     * @param subtrahend the long value to be subtracted.
     * @return the result of subtracting the long value from the rational number.
     */
    public Rational subtract(long subtrahend) {
        Rational subtrahendRational = Rational.valueOf(subtrahend);
        return this.subtract(subtrahendRational);
    }

    /**
     * Subtracts the specified rational number from the rational number.
     *
     * @param subtrahend the rational number to be subtracted.
     * @return the result of subtracting the rational number from the rational number.
     */
    public Rational subtract(Rational subtrahend) {
        BigInteger thisNumerator = BigInteger.valueOf(num);
        BigInteger thisDenominator = BigInteger.valueOf(den);

        BigInteger otherNumerator = subtrahend.bigNum != null ? subtrahend.bigNum : BigInteger.valueOf(subtrahend.num);
        BigInteger otherDenominator = subtrahend.bigDen != null ? subtrahend.bigDen : BigInteger.valueOf(subtrahend.den);

        BigInteger commonDenominator = thisDenominator.multiply(otherDenominator);

        BigInteger resultNumerator = thisNumerator.multiply(otherDenominator).subtract(otherNumerator.multiply(thisDenominator));

        return new Rational(resultNumerator, commonDenominator);
    }

    /**
     * Returns a string representation of the rational number.
     *
     * @return a string representation of the rational number.
     */
    @Override
    public String toString() {
        if (bigDen != null && bigDen.equals(BigInteger.ONE)) {
            return bigNum.toString();
        } else if (bigNum == null) {
            return num + "/" + den;
        } else {
            return bigNum + "/" + bigDen;
        }
    }

    /**
     * Returns a Rational object representing the specified double value.
     *
     * @param source the double value to be represented as a Rational object.
     * @return a Rational object representing the specified double value.
     * @throws IllegalArgumentException if the source is NaN or infinite.
     */
    public static Rational valueOf(double source) {
        if (Double.isNaN(source) || Double.isInfinite(source)) {
            throw new IllegalArgumentException("source is NaN or infinite");
        }

        BigDecimal bd = BigDecimal.valueOf(source);
        BigInteger unscaledValue = bd.unscaledValue();
        int scale = bd.scale();

        BigInteger numerator = unscaledValue;
        BigInteger denominator = BigInteger.TEN.pow(scale);

        return new Rational(numerator, denominator);
    }

        /**
     * Returns a Rational object representing the specified long value.
     *
     * @param source the long value to be represented as a Rational object.
     * @return a Rational object representing the specified long value.
     */
    public static Rational valueOf(long source) {
        BigInteger numerator = BigInteger.valueOf(source);
        BigInteger denominator = BigInteger.ONE;

        return new Rational(numerator, denominator);
    }

    /**
     * Returns a Rational object representing the specified string value.
     *
     * @param source the string value to be represented as a Rational object.
     * @return a Rational object representing the specified string value.
     * @throws NumberFormatException if the string is not a valid rational number.
     */
    public static Rational valueOf(String source) {
        if (source.contains("/")) {
            String[] parts = source.split("/");
            if (parts.length != 2) {
                throw new NumberFormatException("Invalid fractional format: " + source);
            }

            BigInteger numerator = new BigInteger(parts[0].trim());
            BigInteger denominator = new BigInteger(parts[1].trim());

            if (denominator.equals(BigInteger.ZERO)) {
                throw new NumberFormatException("Denominator cannot be zero: " + source);
            }

            return new Rational(numerator, denominator);
        } else {
            try {
                BigDecimal bd = new BigDecimal(source.trim());
                BigInteger unscaledValue = bd.unscaledValue();
                int scale = bd.scale();

                BigInteger numerator = unscaledValue;
                BigInteger denominator = BigInteger.TEN.pow(scale);

                return new Rational(numerator, denominator);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid numeric format: " + source);
            }
        }
    }
}
