package baseball.score;

import baseball.message.MessageController;
import baseball.model.Ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static baseball.score.Score.*;
import static nextstep.utils.Console.readLine;
import static nextstep.utils.Randoms.pickNumberInRange;

public class ScoreServiceImpl implements ScoreService {
    MessageController messageController = new MessageController();
    ArrayList<String> ballCount;

    @Override
    public void start() {
        ballCount = createBallCount(new ArrayList<>());
        startCompare();
    }

    @Override
    public ArrayList<String> createBallCount(ArrayList<String> ballCount) {

        if (ballCount.size() == SELECT.num) return ballCount;

        String ball = String.valueOf(pickNumberInRange(START.num, END.num));
        if (!ballCount.contains(ball)) {
            ballCount.add(ball);
        }
        return createBallCount(ballCount);
    }

    @Override
    public ArrayList<String> submit() {
        messageController.start();
        return validationSelectBalls(readLine());
    }

    @Override
    public ArrayList<String> validationSelectBalls(String inputBalls) {
        if (!isNumber(inputBalls) || !isCheckLength(SELECT.num, inputBalls)) {
            messageController.error();
            submit();
        }

        return new ArrayList<>(Arrays.asList(inputBalls.split("")));
    }

    @Override
    public Ball compareValue(Ball ball, ArrayList<String> arr, ArrayList<String> anotherArr) {
        if (arr.size() != anotherArr.size()) return ball;

        for (int index = 0; index < SELECT.num; index++) {
            ball = isBallAndStrike(ball, arr.get(index), anotherArr, index);
        }

        return ball;
    }

    @Override
    public void restart() {
        start();
    }

    @Override
    public void finish() {
        messageController.finish(SELECT.num);
        if (readLine().equals("1")) {
            restart();
        }
    }

    /**
     * 문자 값이 숫자인지 확인
     *
     * @param str 문자 값
     * @return 숫자 여부
     */
    public boolean isNumber(String str) {
        return Pattern.matches("^[0-9]*$", str);
    }

    /**
     * 문자 길이가 원하는 값과 같은지 확인
     *
     * @param len 비교할 길이
     * @param str 비교할 문자
     * @return 비교 결과
     */
    private boolean isCheckLength(int len, String str) {
        return str.length() == len;
    }

    /**
     * 입력 받은 공을 비교함
     *
     * @param str        비교할 공
     * @param anotherArr 비교될 공의 목록
     * @param index      비교할 공의 순서
     * @return 볼/스트라이크 여부
     */
    private Ball isBallAndStrike(Ball ball, String str, ArrayList<String> anotherArr, int index) {
        return isContain(ball, str, anotherArr, index);
    }

    /**
     * 공이 포함되어 있는지 확인
     *
     * @param str   확인할 공
     * @param arr   확인할 공 목록
     * @param index 확인할 공의 순서
     * @return 포함 여부
     */
    private Ball isContain(Ball ball, String str, ArrayList<String> arr, int index) {
        if (!arr.contains(str)) return ball;

        return checkBallAndStrike(ball, str, arr, index);
    }

    /**
     * 볼인지 스트라이크인지 확인
     *
     * @param str        비교할 공
     * @param anotherArr 비교될 공의 목록
     * @param index      비교할 공의 순서
     * @return 볼/스트라이크 여부
     */
    private Ball checkBallAndStrike(Ball ball, String str, ArrayList<String> anotherArr, int index) {
        if (anotherArr.get(index).equals(str)) {
            ball.setStrike(ball.getStrike() + 1);
            return ball;
        }

        ball.setBall(ball.getBall() + 1);
        return ball;
    }

    private void checkResult(Ball ball) {
        messageController.result(ball.getBall(), ball.getStrike());
        if (ball.getStrike() == SELECT.num) {
            finish();
            System.exit(0);
        }
        startCompare();
    }

    private void startCompare() {
        ArrayList<String> selectBalls = submit();
        Ball ball = compareValue(new Ball(), ballCount, selectBalls);
        checkResult(ball);
    }

}
