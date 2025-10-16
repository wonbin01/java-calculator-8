package calculator.parser;

import static calculator.Exception.ParserException.checkCustomIsOneCharacter;
import static calculator.Exception.ParserException.checkFirstCharacterIsDigit;
import static calculator.Exception.ParserException.extractCustomIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final ArrayList<String> defaultDelimeters = new ArrayList<>(List.of(",", ":"));

    public static String[] parse(String input) {
        List<String> delimeters = new ArrayList<>(defaultDelimeters);
        if (hasCustomerDelimeter(input)) { //으로 시작하는 단어 예외 처리
            int lastCustomIndex = extractCustomIndex(input);
            String customDelimeter = input.substring(2, lastCustomIndex); //문자열이 2글자 이상이면 오류
            checkCustomIsOneCharacter(customDelimeter); // 문자열이 한글자인지 확인하는 메서드
            delimeters.add(customDelimeter);
            input = input.substring(lastCustomIndex + 2); //입력 문자열 재설정
        }
        input = input.trim();
        if (isNullString(input)) { //비어있는 문자열인 경우
            return new String[0];
        }
        checkFirstCharacterIsDigit(input);
        String regex = createRegex(delimeters);
        String[] tokens = input.split(regex);
        return removeBlank(tokens);
    }

    private static String createRegex(List<String> delimeters) {
        return delimeters.stream()
                .map(Pattern::quote) // 특수문자 처리
                .collect(Collectors.joining("|"));
    }

    private static boolean isNullString(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean hasCustomerDelimeter(String input) {
        return input.startsWith("//");
    }

    public static String[] removeBlank(String[] tokens) { //빈칸 제거하는 메서드
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replace(" ", "");
        }
        return tokens;
    }
}
