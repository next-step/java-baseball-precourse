package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class BaseballModelTest {

    BaseballModel baseballModel;

    @DisplayName("랜덤 값 생성 테스트")
    @RepeatedTest(1000)
    void generateRandomNumber_테스트(){
        //given
        int size = 3;
        baseballModel = new BaseballModel(size);

        //when
        baseballModel.generateRandomNumber();

        //then
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();
        assertThat(randomNumber.length()).isEqualTo(size);

        int randomNumberInt = Integer.parseInt(randomNumber);
        assertThat(randomNumberInt)
                .isGreaterThanOrEqualTo(0)
                .isLessThan((int) Math.pow(10,3));

        int num1 = randomNumberInt / 100;
        int num2 = (randomNumberInt % 100) / 10;
        int num3 = randomNumberInt % 10;

        assertThat(num1).isNotEqualTo(num2);
        assertThat(num2).isNotEqualTo(num3);
        assertThat(num3).isNotEqualTo(num1);
    }

    @Test
    void challenge_테스트_입력내용없음() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballModel.challenge(""))
                .withMessage("[ERROR] 입력된 내용이 없습니다");
    }

    @Test
    void challenge_테스트_크기미일치() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballModel.challenge(randomNumber+"3"))
                .withMessage("[ERROR] 입력값의 크기가 일치하지 않습니다");
    }

    @Test
    void challenge_테스트_0_입력() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballModel.challenge("012"))
                .withMessage("[ERROR] 0은 입력할 수 없습니다");
    }

    @Test
    void challenge_테스트_숫자아닌값_입력() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballModel.challenge("ABC"))
                .withMessage("[ERROR] 숫자가 아닌 값이 입력되었습니다");
    }

    @Test
    void challenge_테스트_중복값_입력() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        assertThat(randomNumber).isNotNull();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballModel.challenge("221"))
                .withMessage("[ERROR] 중복된 값을 입력하였습니다");
    }

    @Test
    void challenge_테스트() {
        //given
        baseballModel = new BaseballModel(3);

        //when
        String randomNumber = baseballModel.getRandomNumber();
        Map<String, Integer> challenge = baseballModel.challenge(randomNumber);

        //then
        int strike = challenge.getOrDefault("STRIKE", 0);
        int ball = challenge.getOrDefault("BALL", 0);
        assertThat(strike).isEqualTo(randomNumber.length());
        assertThat(ball).isEqualTo(0);
    }
}