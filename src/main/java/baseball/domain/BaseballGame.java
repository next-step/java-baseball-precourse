package baseball.domain;

import baseball.utils.BaseballUtils;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;

public class BaseballGame {

    private String target;
    private int strikeCount;
    private int ballCount;

    public BaseballGame() {
        makeNewGame();
    }

    private void initBallCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    private void makeNewGame(){
        do {
            target = createTarget();
//            System.out.println(target);
        } while (!BaseballUtils.isValidInput(target));
    }

    private String createTarget(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++){
            stringBuilder.append(Randoms.pickNumberInRange(1,9));
        }
        return stringBuilder.toString();
    }


    private void matching(char targetCharacter, char inputCharacter) {
        if (targetCharacter == inputCharacter) {
            strikeCount++;
            return;
        }
        if (target.contains(String.valueOf(inputCharacter))){
            ballCount++;
        }
    }

    private void matchTarget(String input) {
        initBallCount();
        if (target.equals(input)) {
            strikeCount = 3;
            System.out.println(getResultAnswer());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            matching(target.charAt(i), input.charAt(i));
        }
        System.out.println(getResultAnswer());
    }

    private String getResultAnswer() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder answer = new StringBuilder();
        if (strikeCount > 0) {
            answer.append(strikeCount).append("스트라이크 ");
        }
        if (ballCount > 0) {
            answer.append(ballCount).append("볼");
        }
        return answer.toString();
    }


    /**
     * 재시작 여부를 확인하는 메소드
     * @param input
     * @return
     */
    private Boolean restartGame(String input){
        if (!Arrays.asList("1","2").contains(input)){
            System.out.println("인풋 데이터 오류입니다.\n게임을 종료 합니다.");
            return Boolean.FALSE;
        }
        if (input.equals("1")){ // 재시작
            makeNewGame();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     *
     * @param input
     * @return
     */
    private Boolean play(String input) {
        if (!BaseballUtils.isValidInput(input)) {
            System.out.println("인풋 데이터 오류입니다.");
            return Boolean.TRUE;
        }
        matchTarget(input);
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return restartGame(Console.readLine());
        }
        return Boolean.TRUE;
    }

    public Boolean start() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
        } while (play(Console.readLine()));
        return Boolean.FALSE;
    }

}
