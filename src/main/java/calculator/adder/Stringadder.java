package calculator.adder;

public class Stringadder {
    public static long stringCalculator(String[] parsedString) {
        long sum = 0;
        for (int i = 0; i < parsedString.length; i++) {
            try {
                long temp = Long.parseLong(parsedString[i]);
                boolean checker = longValidator(temp);
                if (!checker) {
                    throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다");
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
