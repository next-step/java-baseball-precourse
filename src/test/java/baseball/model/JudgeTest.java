package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    @DisplayName("Judge 인스턴스 생성시 strike, ball 카운트가 각각 0으로 초기화된다.")
    @Test
    void createJudgeInstance() {
        // given & when
        Judge judge = new Judge();

        int ballCount = judge.getBallCount();
        int strikeCount = judge.getStrikeCount();

        // then
        assertTrue(ballCount == 0);
        assertTrue(strikeCount == 0);
    }

    @DisplayName("컴퓨터가 생성한 숫자와 클라이언트가 입력한 숫자가 단 하나만 일치하고 인덱스가 같을경우 1스트라이크")
    @Test
    void increaseStrikeCount() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("1", "3", "5");
        List<String> userInputNumbers = Arrays.asList("1", "8", "9");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.getStrikeCount() == 1);
        assertTrue(judge.getBallCount() == 0);
    }

    @DisplayName("컴퓨터가 생성한 숫자와 클라이언트가 입력한 숫자가 두개가 일치하고 모두 인덱스가 같을경우 2스트라이크 출력")
    @Test
    void printStrikeCount() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("1", "3", "5");
        List<String> userInputNumbers = Arrays.asList("1", "8", "5");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.makeScore().startsWith("2스트라이크"));
    }

    @DisplayName("컴퓨터가 생성한 숫자와 클라이언트가 입력한 숫자가 두개 일치하고 인덱스 모두 다를 경우 2볼")
    @Test
    void increaseBallCount() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("2", "3", "5");
        List<String> userInputNumbers = Arrays.asList("5", "8", "2");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.getStrikeCount() == 0);
        assertTrue(judge.getBallCount() == 2);
    }

    @DisplayName("1개의 숫자가 같고 인덱스가 일치하며, 하나의 숫자가 양쪽 포함하지만 인덱스가 다르면 1볼 1스트라이크를 출력한다.")
    @Test
    void printBallCount() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("7", "1", "3");
        List<String> userInputNumbers = Arrays.asList("1", "2", "3");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.makeScore().startsWith("1볼 1스트라이크"));
    }

    @DisplayName("볼카운트가 증가하지 않을 경우, Judge는 낫싱임을 알린다.")
    @Test
    void printNothing() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("1", "2", "3");
        List<String> userInputNumbers = Arrays.asList("4", "5", "6");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.makeScore().contains("낫싱"));
    }

    @DisplayName("볼카운트 증가 후 resetBallCount로 초기화할 수 있다.")
    @Test
    void resetBallCount() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("2", "3", "5");
        List<String> userInputNumbers = Arrays.asList("5", "8", "2");
        judge.countBalls(computerNumbers, userInputNumbers);
        judge.resetBallCount();
        // then
        assertTrue(judge.getStrikeCount() == 0);
        assertTrue(judge.getBallCount() == 0);
    }

    @DisplayName("3-strike시 isStrikeOut 함수로 아웃 여부 판정할 수 있다.")
    @Test
    void strikeOut() {
        // given & when
        Judge judge = new Judge();
        List<String> computerNumbers = Arrays.asList("5", "8", "7");
        List<String> userInputNumbers = Arrays.asList("5", "8", "7");
        judge.countBalls(computerNumbers, userInputNumbers);

        // then
        assertTrue(judge.isStrikeOut() == true);
    }
}