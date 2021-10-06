package nextstep.test;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import nextstep.utils.Validation;

public class ValidationTest {
    private ArrayList<Integer> numbers;

    @BeforeEach
    void setup(){
        numbers = new ArrayList<Integer>();
        numbers.add(123);
        numbers.add(999);
        numbers.add(012);
        numbers.add(1);
        numbers.add(12);
        numbers.add(-1);
    }
    @Test
    void 밸리데이션() {
        for(int i=0; i<6; i++){
            assertThat(Validation.checkNumberValidation(numbers.indexOf(i)));
        }
    }
}
