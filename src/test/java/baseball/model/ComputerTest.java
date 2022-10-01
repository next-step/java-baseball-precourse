package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {

    @RepeatedTest(10)
    void 컴퓨터의_야구번호_생성_10번_실행() {
        assertDoesNotThrow(() -> {
            Computer.create();
        });
    }
}