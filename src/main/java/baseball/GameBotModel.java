package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class GameBotModel {
    private static final GameBotModel instance = new GameBotModel();
    private BaseballAnswer answer;
    private boolean completed = false;
    private GameBotModel() {
        this.initialize();
    }

    public BaseballAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(BaseballAnswer answer) {
        this.answer = answer;
    }

    public static GameBotModel getInstance() {
        return instance;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void initialize() {
        this.setCompleted(false);
        this.setAnswer(new BaseballAnswer());
    }

    public GameResult[] checkAnswer(int[] input) {
        return this.getAnswer().calcResult(input);
    }
}

class BaseballAnswer {
    private int[] answer = new int[Config.GAME_COUNT];
    private boolean[] memo = new boolean[Config.MAX_NUM + 1];

    BaseballAnswer() {
        this.setAnswer(generateRandomDistinctIntArray());
        this.setMemo(this.generateMemoFrom(this.getAnswer()));
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    public boolean[] getMemo() {
        return memo;
    }

    public void setMemo(boolean[] memo) {
        this.memo = memo;
    }

    private static int getUniqueNumberNotIn(int[] arr) {
        /*
        @param container 이 해시셋에 없는 정수 값을 생성합니다.

        @return 해시셋에 포함되지 않으면서 1~9 범위의 정수를 반환합니다.
         */
        int num = Randoms.pickNumberInRange(Config.MIN_NUM, Config.MAX_NUM);
        if (Utils.intAnyMatch(arr, num)) {
            return getUniqueNumberNotIn(arr);
        }
        return num;
    }

    public static int[] generateRandomDistinctIntArray() {
        /*
        1~9 범위의 서로 다른 정수 3개를 포함하는 배열을 반환합니다.

        @return int[](3) 호출마다 항상 랜덤한 원소로 구성됩니다.
         */

        int[] result = new int[Config.GAME_COUNT];

        for (int i = 0; i < Config.GAME_COUNT; i++) {
            result[i] = getUniqueNumberNotIn(result);
        }
        return result;
    }

    private boolean[] generateMemoFrom(int[] arrNums) {
        boolean[] memo = new boolean[Config.MAX_NUM + 1];
        Arrays.fill(memo, false);

        for (int num : arrNums) {
            memo[num] = true;
        }
        return memo;
    }

    public boolean isBall(int num) {
        boolean[] memo = this.getMemo();
        return memo[num];
    }

    public boolean isStrike(int index, int num) {
        return this.getAnswer()[index] == num;
    }

    private GameResult getRowResult(int index, int num) {
        if (this.isStrike(index, num)) {
            return GameResult.STRIKE;
        } else if (this.isBall(num)) {
            return GameResult.BALL;
        }
        return GameResult.NOTHING;
    }

    public GameResult[] calcResult(int[] input) {
        GameResult[] gameResult = new GameResult[Config.GAME_COUNT];
        for (int i = 0; i < Config.GAME_COUNT; i++) {
            gameResult[i] = this.getRowResult(i, input[i]);
        }
        return gameResult;
    }
}
