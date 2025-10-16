package calculator.Exception;

public class parserException {
    public static void checkFirstCharacterIsDigit(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    public static int extractCustomIndex(String input) {
        int newLineStartIndex = input.indexOf("\\n");
        if (newLineStartIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식");
        }
        return newLineStartIndex;
    }

    public static void checkCustomIsOneCharacter(String customDelimeter) { //문자열이 한글자가 아니면 오류 발생시키고 종료
        if (customDelimeter.length() >= 2) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다.");
        }
    }
}
