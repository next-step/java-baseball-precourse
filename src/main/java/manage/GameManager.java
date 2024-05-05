package manage;

import config.ConfigurationObject;
import participant.Participant;
import problem.ValueChecker;
import problem.ValueMaker;

import java.util.HashSet;
import java.util.Set;

public class GameManager {
    private ConfigurationObject configurationObject = new ConfigurationObject();

    private String problemValue;

    private ValueMaker valueMaker = configurationObject.getValueMaker();
    private ValueChecker valueChecker;
    private Participant participant = configurationObject.getParticipant();


    public void readyGame() {
        System.out.println("⚾ 숫자 야구 시작~!");
        this.problemValue = valueMaker.makeNum();
        valueChecker = configurationObject.getValueChecker(this.problemValue);
    }

    public int playGame() {
        String input = proceedInput();
        return proceedOutput(input);
    }

    public String proceedInput() {
        String input = participant.inputValue();
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자가 세자리수가 아닙니다.");
        }

        // 입력값이 숫자 1~9 사이의 값인지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자가 범위안에 있지 않습니다.");
        }

        // 중복 없는 숫자인지 확인
        Set<Character> digits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!digits.add(c)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
        return input;

    }

    public int proceedOutput(String input) {
        int result = valueChecker.determineTheValue(input);
        if (result == 1){
            System.out.println("⚾ 숫자 야구를 맞추셨군요 대단합니다.~ 정답은 " +this.problemValue+ "입니다~!");
        }
        return result;
    }

}
