package calculator.Exception;

public class AdderException {
    public static void checkOverflow(long sum, long temp) {
        if (sum > Long.MAX_VALUE - temp) {
            throw new IllegalArgumentException("합이 long의 최댓값을 초과했습니다.");
        }
    }

    public static void checkPositive(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0 이하의 숫자가 입력되었습니다.");
        }
    }

    public static void checkValidNumberFormat(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 분리자가 사용되었습니다.");
        }
    }
}
