package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CandidateTest {
    @Test
    public void successCreateCandidate() {
        List<Integer> assertList = new ArrayList<>();
        assertList.add(1);
        assertList.add(2);
        assertList.add(3);

        Assertions.assertIterableEquals(assertList
                , Candidate.createCandidateNumber("123").getNumberList());
    }

    @Test
    public void nullInputTest() {
        Assertions.assertThrows(IllegalArgumentException.class
                , () -> Candidate.createCandidateNumber(null));
    }

    @Test
    public void blankInputTest() {
        Assertions.assertThrows(IllegalArgumentException.class
                , () -> Candidate.createCandidateNumber(""));
    }

    @Test
    public void numberOverLengthInputTest() {
        Assertions.assertThrows(IllegalArgumentException.class
                , () -> Candidate.createCandidateNumber("1234"));
    }

    @Test
    public void numberDuplicationTest() {
        Assertions.assertThrows(IllegalArgumentException.class
                , () -> Candidate.createCandidateNumber("224"));
    }
}