package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 컴퓨터의_수_중복확인() {
        Player computer = new Player();
        computer.setRandomBaseBall();

        assertEquals(Sets.newHashSet(computer.getBaseBalls()).size(), computer.getBaseBalls().size());
    }

    @Test
    void 사용자의_수_중복확인() throws IllegalArgumentException {
        Player user = new Player();
        String input = "141";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_한글() throws IllegalArgumentException {
        Player user = new Player();
        String input = "한글임";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_영어() throws IllegalArgumentException {
        Player user = new Player();
        String input = "aBc";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_음수() throws IllegalArgumentException {
        Player user = new Player();
        String input = "-1-2-3";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_특수문자() throws IllegalArgumentException {
        Player user = new Player();
        String input = "1**";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_Null() throws IllegalArgumentException {
        Player user = new Player();

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(null));
    }

    @Test
    void 사용자의_수_입력오류_길이0() throws IllegalArgumentException {
        Player user = new Player();
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_길이1() throws IllegalArgumentException {
        Player user = new Player();
        String input = "3";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

    @Test
    void 사용자의_수_입력오류_길이2() throws IllegalArgumentException {
        Player user = new Player();
        String input = "12";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }


    @Test
    void 사용자의_수_입력성공_길이3() throws IllegalArgumentException {
        Player user = new Player();
        String input = "123";
        user.setBaseBalls(input);

        assertEquals(user.getBaseBalls().size(), input.length());
    }


    @Test
    void 사용자의_수_입력오류_길이4() throws IllegalArgumentException {
        Player user = new Player();
        String input = "1234";

        assertThrows(IllegalArgumentException.class, () -> user.setBaseBalls(input));
    }

}
