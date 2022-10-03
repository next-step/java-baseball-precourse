package baseball.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    void 중복_값_체크_예외발생(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);

        assertThatIllegalArgumentException().isThrownBy(
                () -> NumberValidator.validateUnique(list)
        ).withMessage("같은 값이 2번 이상 검출되었습니다.");
    }
}