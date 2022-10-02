package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("같은 값-같은 자리는 스트라이크로 기록한다")
    void test() {
        User user = new User();
        String threeStrike = "123";
        List<Ball> answer = new ArrayList<>();
        answer.add(new Ball(1));
        answer.add(new Ball(2));
        answer.add(new Ball(3));
        assertEquals(user.guessAndGetResult(threeStrike, answer), "3스트라이크");
    }

    @Test
    @DisplayName("같은 값-다른 자리는 볼로 기록한다")
    void test2() {
        User user = new User();
        String threeBall = "312";
        List<Ball> answer = new ArrayList<>();
        answer.add(new Ball(1));
        answer.add(new Ball(2));
        answer.add(new Ball(3));
        assertEquals(user.guessAndGetResult(threeBall, answer), "3볼");
    }

    @Test
    @DisplayName("같은 값-같은 자리는 스트라이크 같은 값-다른 자리는 볼로 기록한다")
    void test3() {
        User user = new User();
        String threeBall = "142";
        List<Ball> answer = new ArrayList<>();
        answer.add(new Ball(1));
        answer.add(new Ball(2));
        answer.add(new Ball(3));
        assertEquals(user.guessAndGetResult(threeBall, answer), "1볼 1스트라이크");
    }
}