package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Baseball testBall = new Baseball();
    private Baseball testUserBall = new Baseball();
    private Baseball testUserBall2 = new Baseball();

    @BeforeEach
    void setup(){
        testBall.setBallAfterToChar(1, 2, 3);
        testUserBall.setBallAfterToChar(1, 0, 2);
        testUserBall2.setBallAfterToChar(7,8,9);
    }


    @Test
    void generateCounterBaseballs() {

        Baseball CounterBaseball = new Baseball();
        int FirstBall, SecondBall, ThirdBall;
        FirstBall = 1;
        SecondBall = 2;
        while (FirstBall == SecondBall)
            SecondBall = 2;
        ThirdBall = 3;
        while (FirstBall == ThirdBall || SecondBall == ThirdBall)
            ThirdBall = 3;
        CounterBaseball.setBallAfterToChar(FirstBall,SecondBall,ThirdBall);

        Assertions.assertThat(CounterBaseball.getFirst()).isEqualTo(testBall.getFirst());
        Assertions.assertThat(CounterBaseball.getSecond()).isEqualTo(testBall.getSecond());
        Assertions.assertThat(CounterBaseball.getThird()).isEqualTo(testBall.getThird());

    }


}