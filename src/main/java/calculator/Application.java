package calculator;

import calculator.adder.Stringadder;
import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] parsedString = Parser.parse(input); //구분자를 통해 나눠진 문자열
        if (parsedString.length == 0) {
            System.out.println("결과 : " + 0);
            return;
        }
        long sum = Stringadder.stringCalculator(parsedString);
        System.out.println("결과 : " + sum);
    }
}
