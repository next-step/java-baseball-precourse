package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Model {
    private String answer;
    private char[] answerList;
    private String input;
    private char[] inputList;
    private int ballCnt;
    private int strikeCnt;


    public Model() {
        this.answer = makeAnswer();
        this.answerList = this.answer.toCharArray();
    }

    public Model(String answer) {
        this.answer = answer;
        this.answerList = this.answer.toCharArray();
    }

    private String makeAnswer() {
        List intList = new ArrayList<>();
        while (intList.size() < 3) {
            int number = pickNumberInRange(1, 9);
            addNumberIfNotContains(intList, number);
        }
        return intList.toString().replaceAll("\\D","");
    }

    private void addNumberIfNotContains(List intList, int number) {
        if (!intList.contains(number)) {
            intList.add(number);
        }
    }

    public void setInput(String input) {
        this.input = input;
        this.inputList = this.input.toCharArray();
        initCnt();
    }

    private void initCnt() {
        this.ballCnt = 0;
        this.strikeCnt = 0;
    }

    public String getHint() {
        calculateCnt();

        return makeHintString();
    }

    private void calculateCnt() {
        for (int i = 0; i < inputList.length; i++) {
            plusStrikeOrBall(i);
        }
    }

    private void plusStrikeOrBall(int i) {
        if (answerList[i] == inputList[i]) {
            strikeCnt++;
        } else if (isBall(inputList[i])) {
            ballCnt++;
        }
    }

    private boolean isBall(char ch) {
        boolean isBall = false;
        for (int i = 0; !isBall && i < answerList.length; i++) {
            isBall = hasSameCharacter(ch, i);
        }
        return isBall;
    }

    private boolean hasSameCharacter(char ch, int i) {
        return ch == answerList[i] ? true : false;
    }

    private String makeHintString() {
        String hint = ballCnt + "볼 " + strikeCnt + "스트라이크";
        if (ballCnt != 0 && strikeCnt == 0 || ballCnt == 0 && strikeCnt != 0) {
            int index = strikeCnt == 0 ? 0 : 1;
            hint = hint.split(" ")[index];
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            hint = "낫싱";
        }
        return hint;
    }
}
