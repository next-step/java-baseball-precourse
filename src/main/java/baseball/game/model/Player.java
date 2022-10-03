package baseball.game.model;

import baseball.game.model.GameNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    public Set<Integer> number;
    public boolean isAnswer;
    public boolean keepPlaying;

    public Player() {
        this.keepPlaying = true;
    }



    public void playGame() {
        GameNumber gameNumbers = new GameNumber();
        System.out.println(gameNumbers.answer);

        while(!isAnswer) {
            String text = enterNumber();
            validateNumber(text);
            parsingNumber(text);

            if (compare(gameNumbers.answer)) {
                break;
            }

            showResults();
        }
    }

    public String enterNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String text = Console.readLine();
        return text;
    }

    public boolean compare(List<Integer> answer) {
        if (Arrays.equals(answer.toArray(), this.number.toArray())) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private Pattern formatPattern = Pattern.compile("^[1-9]{3}$");

    private void parsingNumber(String number) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        this.number = numbers;
    }

    private void validateNumber(String number) {
        validateFormat(number);
        validateDuplicatedNumber(number);
    }

    private void validateFormat(String number) {
        Matcher matcher = formatPattern.matcher(number);
        boolean isMatched = matcher.matches();
        if (!isMatched) {
            throw new IllegalArgumentException("1과 9사이의 숫자로 이루어진 3자리 정수를 입력해주세요.");
        }
    }

    private void validateDuplicatedNumber(String number) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        if (numbers.size() != number.length()) {
            throw new IllegalArgumentException("1과 9사이의 서로 다른 숫자를 입력해주세요.");
        }
    }

    private void showResults() {
        String nothing = "낫싱";
        int ball = gameNumbers.countBall();
        int strike = gameNumbers.countStrike();
        if (ball + strike == 0) {
            System.out.println(nothing);
        }
        String ballCount = Integer.toString(ball) + "볼";
        String strikeCount = Integer.toString(strike) + "스트라이크";
        String something[] = {ballCount, strikeCount};
        System.out.println(ballCount + strikeCount);
    }

}
