package Utils;

import config.Policy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {
    @Test
    @DisplayName("RandomNumber Length 확인")
    void getRandomNumber(){
        Assertions.assertThat(RandomNumber.get().length()).isEqualTo(Policy.IN_GAME_NUMBER_LENGTH);
    }

    @Test
    @DisplayName("같은 값이 나오나?")
    void isRandom(){
        Assertions.assertThat(RandomNumber.get()).isNotEqualTo(RandomNumber.get());
        Assertions.assertThat(RandomNumber.get()).isNotEqualTo(RandomNumber.get());
        Assertions.assertThat(RandomNumber.get()).isNotEqualTo(RandomNumber.get());
        Assertions.assertThat(RandomNumber.get()).isNotEqualTo(RandomNumber.get());
        Assertions.assertThat(RandomNumber.get()).isNotEqualTo(RandomNumber.get());
    }
}