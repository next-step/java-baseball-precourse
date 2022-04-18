package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Player {
    public User() {
    }

    public User(String input, int size) {
        super.setSize(size);
        super.setNumbers(createUserNumbers(input));
    }

    private List<Integer> createUserNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < super.getSize(); i++) {
            numbers.add(input.charAt(i) - '0');
        }

        return numbers;
    }
}
