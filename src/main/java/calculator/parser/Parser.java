package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final ArrayList<String> defaultDelimeters = new ArrayList<>(List.of(",", ":"));

    public static String[] parse(String input) {
        List<String> delimeters = new ArrayList<>(defaultDelimeters);
        if (input.startsWith("//")) { //으로 시작하는 단어 예외 처리
            int newLineStartIndex = input.indexOf("\\n");
            if (newLineStartIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
            String customDelimeter = input.substring(2, newLineStartIndex); //문자열이 2글자 이상이면 오류
            if (customDelimeter.length() >= 2) {
                throw new IllegalArgumentException("커스텀 구분자는 한 글자만 가능합니다.");
            }
            delimeters.add(customDelimeter);
            input = input.substring(newLineStartIndex + 2); //입력 문자열 재설정
        }
        input = input.trim();
        if (input.length() == 0) { //비어있는 경우
            return new String[0];
        }
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
        String regex = delimeters.stream()
                .map(Pattern::quote) // 특수문자 처리
                .collect(Collectors.joining("|"));
        String[] tokens = input.split(regex);
        tokens = removeBlank(tokens);
        return tokens;
    }

    public static String[] removeBlank(String[] tokens) { //빈칸 제거하는 메서드
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replace(" ", "");
        }
        return tokens;
    }
}
