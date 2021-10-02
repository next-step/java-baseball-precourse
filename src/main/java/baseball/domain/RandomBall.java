package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

public class RandomBall {

    private static final int BASEBALL_SIZE = 3;
    private static final int BASEBALL_MIN_NUM = 1;
    private static final int BASEBALL_MAX_NUM = 9;

    private List<Ball> randomBalls = new LinkedList<>();
    private Match match = new Match();
    private boolean success;

    /**
     * 랜덤 번호와 입력 받은 번호를 매치하여 Math 객체를 얻음.
     * */
    public void matchBalls(List<Ball> inputBalls) {
        this.match.of(this.randomBalls, inputBalls);
        if (this.match.isThreeStrike()) {
            this.success = true;
        }
    }

    /**
     * 랜덤 번호와 입력 받은 번호를 매치된 결과 메세지를 얻음.
     * */
    public String getMatchMessage() {
        if (this.match.getStrike() == 3) {
            return  "3스트라이크";
        }
        if (this.match.getBall() == 0 && this.match.getStrike() == 0) {
            return  "낫싱";
        }
        String message = "";
        message += this.match.getStrike() > 0 ? this.match.getStrike() + "스트라이크 " : "";
        message += this.match.getBall() > 0 ? this.match.getBall() + "볼" : "";
        return message;
    }

    public Boolean isSuccess() {
        return this.success;
    }


    /**
     * 신규 랜덤 번호 생성
     * 기존의 랜덤 번호 리스트를 초기화 후 재 생성한다.
     */
    public void initializeRandomNumbers() {
        clearRandomBall();
        ArrayList<Integer> generateRandomNumbers = generateRandomNumbers();
        for (int i = 0; i < generateRandomNumbers.size(); i++) {
            this.randomBalls.add(new Ball (i, generateRandomNumbers.get(i)));
        }
    }

    /**
     * 신규 랜덤 번호 임의 생성
     * 기존의 랜덤 번호 리스트를 초기화 후 재 생성한다.
     */
    public void directInitializeRandomNumbers(String inputNumber) {
        clearRandomBall();
        for (int i = 0; i < inputNumber.length(); i++) {
            int number = Character.getNumericValue(inputNumber.charAt(i));
            this.randomBalls.add(new Ball (i, number));
        }
    }

    /**
     * 해당 객체를 사용했던 내역들을 초기화 시켜준다.
     * */
    public void clearRandomBall() {
        this.randomBalls = new ArrayList<>();
        this.match = new Match();
        this.success = false;
    }

    /**
     * 중복없는 랜덤 숫자 생성.
     * */
    private ArrayList<Integer> generateRandomNumbers() {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < BASEBALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUM, BASEBALL_MAX_NUM);
            set.add(randomNumber);
        }
        return new ArrayList<>(set);
    }

    public List<Ball> getRandomBalls() {
        return randomBalls;
    }
}
