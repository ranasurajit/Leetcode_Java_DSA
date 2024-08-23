class Solution {
    public String fractionAddition(String expression) {
        int n = expression.length();
        int i = 0;
        int numerator = 0;
        int denominator = 1;
        while (i < n) {
            int currentNumerator = 0;
            int currentDenominator = 0;
            boolean isNeg = expression.charAt(i) == '-';
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                i++;
            }
            // process numerator
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currentNumerator = currentNumerator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            // negative conversion
            if (isNeg) {
                currentNumerator = currentNumerator * -1;
            }
            // skip divisor
            i++;
            // process denominator
            while (i < n && Character.isDigit(expression.charAt(i))) {
                currentDenominator = currentDenominator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            // calculation
            numerator = numerator * currentDenominator + denominator * currentNumerator;
            denominator = denominator * currentDenominator;
        }
        // gcd of negative number is negative so sending Math.abs(numerator)
        int gcd = getGCD(Math.abs(numerator), denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "/" + denominator;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
