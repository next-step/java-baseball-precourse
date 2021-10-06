package baseball;

import baseball.domain.Record;
import baseball.utils.GameUtils;
import baseball.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilsTest {

    @Test
    void match() {
        //given
        List<Integer> answer = Utils.convertIntegerArray("123");
        List<Integer> input = Utils.convertIntegerArray("123");

        //when
        Record record = GameUtils.match(answer,input);

        //Then
        assertTrue(record.checkFinished());
    }


}