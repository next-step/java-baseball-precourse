package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBotModelTest {

    private HashSet<Integer> intArrToHashSet(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        for (int num : arr) {
            result.add(num);
        }
        return result;
    }

    @Test
    void 랜덤_정답_생성() {
        HashSet<Integer> newAnswer = this.intArrToHashSet(BaseballAnswer.generateRandomDistinctIntArray());
        assertThat(newAnswer)
                .hasSize(Config.GAME_COUNT)
                .satisfies(answer -> {
                    for (int num : answer) {
                        assertThat(num)
                                .isNotNull()
                                .isPositive()
                                .isBetween(Config.MIN_NUM, Config.MAX_NUM);

                    }
                });
    }

    @Test
    void GameBot_게임결과() {
        BaseballAnswer answer = new BaseballAnswer();
        answer.setAnswer(new int[]{2, 3, 4});
        answer.setMemo(new boolean[]{false, false, true, true, true, false, false, false, false});

        int[][] inputs = {{2,1,4}, {3,5,2}, {4,2,3}, {2,3,4}};
        GameResult[][] expGameResults = {
                {GameResult.STRIKE, GameResult.NOTHING, GameResult.STRIKE},
                {GameResult.BALL, GameResult.NOTHING, GameResult.BALL},
                {GameResult.BALL, GameResult.BALL, GameResult.BALL},
                {GameResult.STRIKE, GameResult.STRIKE, GameResult.STRIKE}
        };
        for (int i = 0; i < 4; i++) {
            GameResult[] gameResult = answer.calcResult(inputs[i]);
            assertThat(gameResult).isEqualTo(expGameResults[i]);
        }
    }

    @Test
    void GameBot_answer_memo() {
        BaseballAnswer answer = new BaseballAnswer();
        boolean[] memo = answer.getMemo();
        assertThat(memo[0]).isFalse();

        for (int i = 0; i < Config.GAME_COUNT; i++) {
            int num = answer.getAnswer()[i];
            assertThat(memo[num]).isTrue();
        }
    }
}
