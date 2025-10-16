package calculator.adder;

public class StringAdder {
    public static long stringCalculator(String[] parsedString) {
        long sum = 0;
        for (String longCandidate : parsedString) {
            try {
                long temp = Long.parseLong(longCandidate);
                boolean checker = longValidator(temp);
                if (!checker) {
                    throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다");
                }
                if (sum > Long.MAX_VALUE - temp) {
                    throw new IllegalArgumentException("합이 long의 최댓값을 초과했습니다.");
                }
                sum += temp;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 분리자가 사용되었습니다.");
            }
        }
        return sum;
    }

    public static boolean longValidator(long temp) {
        if (temp <= 0) {
            return false;
        }
        return true;
    }
}
