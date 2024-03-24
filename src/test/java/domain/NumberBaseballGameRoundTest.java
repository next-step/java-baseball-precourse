package domain;

import domain.dto.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.numberGenerator.RandomNumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static util.converter.IntegerListConverter.mapToInts;

class NumberBaseballGameRoundTest {
    @RepeatedTest(500)
    @DisplayName("시스템은 게임이 시작되면 1~9사이의 서로 다른 수로 이루어진 3자리 숫자를 생성한다")
    void init() {
        //given
        NumberBaseballGameRound game = new NumberBaseballGameRound(new RandomNumberGenerator());

        //when
        game.init();

        //then
        List<Integer> answer = game.getAnswer();

        assertThat(answer.size()).isEqualTo(3);

        for (int number : answer) {
            assertThat(number).isBetween(1, 9);
        }

        Set<Integer> numberSet = new HashSet<>(answer);
        assertThat(answer.size()).isEqualTo(numberSet.size());
    }

    @ParameterizedTest
    @CsvSource(value = {
            // answer : input : expected(strike, ball)
            "1,2,3 : 1,2,3 : 3,0",
            "1,2,3 : 1,2,4 : 2,0",
            "1,2,3 : 1,3,2 : 1,2",
            "1,2,3 : 1,3,4 : 1,1",
            "1,2,3 : 1,4,5 : 1,0",
            "1,2,3 : 3,1,2 : 0,3",
            "1,2,3 : 3,4,2 : 0,2",
            "1,2,3 : 3,4,5 : 0,1",
            "1,2,3 : 4,5,6 : 0,0"
    }, delimiter = ':')
    @DisplayName("시스템은 사용자의 입력을 받으면 정답과 비교하여 판정 결과를 반환한다")
    void judge(String answer, String input, String expected) {
        //given
        NumberBaseballGameRound game = new NumberBaseballGameRound((lowerBound, upperBound, n) -> mapToInts(answer, ","));
        game.init();

        //when
        GameResult result = game.judge(mapToInts(input, ","));

        //then
        List<Integer> expectedResult = mapToInts(expected, ",");
        assertThat(result.getStrikeCount()).isEqualTo(expectedResult.get(0));
        assertThat(result.getBallCount()).isEqualTo(expectedResult.get(1));
    }
}
