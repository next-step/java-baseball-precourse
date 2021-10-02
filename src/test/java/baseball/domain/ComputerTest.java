package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Computer Domain Test")
class ComputerTest {

    @DisplayName("Computer 생성자 Test")
    @Test
    public void initComputerTest() {
        Computer computer = new Computer();
        assertNotNull(computer);
        assertNotNull(computer.getBaseballNumber());
    }
}