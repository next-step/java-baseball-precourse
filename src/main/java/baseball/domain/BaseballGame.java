package baseball.domain;

import baseball.utils.BaseballUtils;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;

public class BaseballGame {

    private String target;
    private int strikeCount;
    private int ballCount;

    /**
     * 생성자
     */
    public BaseballGame() {
        makeNewGame();
    }

    /**
     * 볼카운트 초기화 메소드
     */
    private void initBallCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    /**
     * 새로운 게임을 시작하는 메소드
     */
    private void makeNewGame(){
        do {
            target = createTarget();
//            System.out.println(target);
        } while (!BaseballUtils.isValidInput(target));
    }

    /**
     * 컴퓨터가 생성하는 랜덤 3자리를 생성한다.
     * @return String Target
     */
    private String createTarget(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++){
            stringBuilder.append(Randoms.pickNumberInRange(1,9));
        }
        return stringBuilder.toString();
    }


    /**
     * Stike, Ball을 판별하는 메소드
     * @param targetCharacter
     * @param inputCharacter
     */
    private void matching(char targetCharacter, char inputCharacter) {
        if (targetCharacter == inputCharacter) {  // 같다면, Strike
            strikeCount++;
            return;
        }
        if (target.contains(String.valueOf(inputCharacter))){  // Stike가 아니라면, Ball인지 체크
            ballCount++;
        }
    }

    /**
     * 입력 값과 타겟 값과 비교.
     * @param input
     */
    private void matchTarget(String input) {
        initBallCount();  // 객체의 볼 카운트 초기화
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

    /**
     * 결과 값에 대한 응답 메시지 구현 메소드
     * @return String Answer
     */
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
     * 게임 플레이 메소드
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

    /**
     * 게임 시작 메소드
     * @return
     */
    public Boolean start() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
        } while (play(Console.readLine()));
        return Boolean.FALSE;
    }

}
