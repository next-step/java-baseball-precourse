package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class AnswerTest {
    Answer answer;

    @BeforeEach
    void setAnswerTemp() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(4);
        numberList.add(2);
        numberList.add(5);

        Answer answer = new Answer();
        answer.setNumberListForTest(numberList);

        this.answer = answer;
    }

    @DisplayName("Answer 생성 성공")
    @Test
    void createAnswerNumberTest() {
        Answer answer = Answer.createAnswer();
        List<Integer> numberList = answer.getNumberList();
        Assertions.assertEquals(3, numberList.size());
    }

    @DisplayName("1스트라이크 테스트")
    @Test
    void verifyAnswer_1() {
        // when
        Map<Hint, Integer> hintMap = answer.verifyAnswer(Candidate.createCandidateNumber("123"));
        // then
        Assertions.assertEquals(hintMap.get(Hint.스트라이크), 1);
    }

    @DisplayName("1볼 1스트라이크 테스트")
    @Test
    void verifyAnswer_2() {
        // when
        Map<Hint, Integer> hintMap = answer.verifyAnswer(Candidate.createCandidateNumber("456"));
        // then
        Assertions.assertEquals(hintMap.get(Hint.볼), 1);
        Assertions.assertEquals(hintMap.get(Hint.스트라이크), 1);
    }

    @DisplayName("낫싱 테스트")
    @Test
    void verifyAnswer_3() {
        // when
        Map<Hint, Integer> hintMap = answer.verifyAnswer(Candidate.createCandidateNumber("789"));
        // then
        Assertions.assertEquals(hintMap.get(Hint.아웃), 3);
    }

    @DisplayName("2볼 1스트라이크 테스트")
    @Test
    void verifyAnswer_4() {
        // when
        Map<Hint, Integer> hintMap = answer.verifyAnswer(Candidate.createCandidateNumber("452"));
        // then
        Assertions.assertEquals(hintMap.get(Hint.볼), 2);
        Assertions.assertEquals(hintMap.get(Hint.스트라이크), 1);
    }

    @DisplayName("3스트라이크 테스트")
    @Test
    void verifyAnswer_5() {
        // when
        Map<Hint, Integer> hintMap = answer.verifyAnswer(Candidate.createCandidateNumber("425"));
        // then
        Assertions.assertEquals(hintMap.get(Hint.스트라이크), 3);
    }
}