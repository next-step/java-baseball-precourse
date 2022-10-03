package baseball.model;

import java.io.ByteArrayInputStream;

public class AbstractDomainTest {

    User setInInput(String input) {
        User user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        user.inputNumber();
        return user;
    }
}
