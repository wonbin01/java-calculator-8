package calculator.adder;

public class StringAdder {
    public static long stringCalculator(String[] parsedString) {
        long sum = 0;
        for (String longCandidate : parsedString) {
            try {
                long number = Long.parseLong(longCandidate);
                checkPositive(number);
                checkOverflow(sum, number);
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 분리자가 사용되었습니다.");
            }
        }
        return sum;
    }

    private static void checkOverflow(long sum, long temp) {
        if (sum > Long.MAX_VALUE - temp) {
            throw new IllegalArgumentException("합이 long의 최댓값을 초과했습니다.");
        }
    }

    private static void checkPositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0 이하의 숫자가 입력되었습니다.");
        }
    }

}
