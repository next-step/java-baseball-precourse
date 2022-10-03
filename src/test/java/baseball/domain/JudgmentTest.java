package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgmentTest {
    
    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"423:123:2", "812:142:1", "124:732:0"}, delimiter = ':')
    @DisplayName("같은 자리에 같은 숫자가 존재하면 스트라이크 카운트를 증가시킨다.")
    void new_strikeJudgment(String numbers1, String numbers2, int expected){
        // when
        Judgment strikeJudgment = new StrikeJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(strikeJudgment.getCount()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:231:3", "812:142:1", "123:123:0"}, delimiter = ':')
    @DisplayName("다른 자리에 같은 숫자가 존재하면 볼 카운트를 증가시킨다.")
    void new_ballJudgment(String numbers1, String numbers2, int expected){
        // when
        Judgment ballJudgment = new BallJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(ballJudgment.getCount()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:231:0", "812:142:1", "123:456:3"}, delimiter = ':')
    @DisplayName("위치 상관없이 같은 숫자가 존재하지 않으면 낫싱 카운트를 증가시킨다.")
    void new_nothingJudgment(String numbers1, String numbers2, int expected){
        // when
        Judgment nothingJudgment = new NothingJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(nothingJudgment.getCount()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:123:3스트라이크", "123:124:2스트라이크", "123:145:1스트라이크", "123:456:''"}, delimiter = ':')
    @DisplayName("스트라이크 판정 결과를 반환한다.")
    void getResult_strikeJudgment_string(String numbers1, String numbers2, String expected){
        // when
        Judgment strikeJudgment = new StrikeJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(strikeJudgment.getResult()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:231:3볼", "123:234:2볼", "123:245:1볼", "123:456:''"}, delimiter = ':')
    @DisplayName("볼 판정 결과를 반환한다.")
    void getResult_ballJudgment_string(String numbers1, String numbers2, String expected){
        // when
        Judgment ballJudgment = new BallJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(ballJudgment.getResult()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:123:''", "123:124:''", "123:145:''", "123:456:낫싱"}, delimiter = ':')
    @DisplayName("낫싱 판정 결과를 반환한다.")
    void getResult_nothingJudgment_string(String numbers1, String numbers2, String expected){
        // when
        Judgment nothingJudgment = new NothingJudgment(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));
        
        // then
        assertThat(nothingJudgment.getResult()).isEqualTo(expected);    
    }
}
