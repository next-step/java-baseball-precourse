package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

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
}