package baseball.answer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberStrategyTest {

    @Test
    @DisplayName("Answer 생성 테스트")
    void generate_test(){
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        for (int i = 0; i < 10; i++){
            assertThat(new Answer(randomNumberStrategy)).isInstanceOf(Answer.class);
        }
    }
    
}
