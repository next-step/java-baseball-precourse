package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerTest {
    @Test
    void 랜덤_배열생성_중복_확인(){
        Computer computer = new Computer(3);
        computer.makeQuiz(1, 9);
        List<Integer> quizList = computer.getQuizList();
        // 중복확인
        Set<Integer> set = new HashSet<>(quizList);
        assertThat(set.size() < quizList.size()).isFalse();
    }
}
