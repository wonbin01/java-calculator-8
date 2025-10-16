package calculator.adder;

import static calculator.Exception.AdderException.checkOverflow;
import static calculator.Exception.AdderException.checkPositive;
import static calculator.Exception.AdderException.checkValidNumberFormat;

public class StringAdder {
    public static long stringCalculator(String[] parsedString) {
        long sum = 0;
        for (String longCandidate : parsedString) {
            checkValidNumberFormat(longCandidate);
            long number = Long.parseLong(longCandidate);
            checkPositive(number);
            checkOverflow(sum, number);
            sum += number;
        }
        return sum;
    }

}
