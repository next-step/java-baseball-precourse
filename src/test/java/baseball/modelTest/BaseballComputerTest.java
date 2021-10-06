package baseball.modelTest;

import baseball.model.BaseballComputer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballComputerTest {
    BaseballComputer baseballComputer;
    @BeforeEach
    void setup() {
        baseballComputer = new BaseballComputer();
    }

    @Test
    void 컴퓨터랜덤넘버사이즈테스트(){
        String numberString = Integer.toString(baseballComputer.setNumber());
        assert numberString.length()==3;
    }

    @Test
    void 컴퓨터랜덤넘버범위테스트(){
        int computerNumber = baseballComputer.setNumber();
        assert computerNumber>=100 && computerNumber<=999;
    }

    @Test
    void 컴퓨터랜덤넘버0포함테스트(){
        String numberString = Integer.toString(baseballComputer.setNumber());
        assert !numberString.contains("0");
    }
}
