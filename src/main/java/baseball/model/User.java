package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Player {

    private User(List<Integer> numbers) {
        super(numbers);
    }

    public static User of(final String s) {
        final List<Integer> numbers = new ArrayList<>();

        for (char c : s.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(c)));
        }

        return new User(numbers);
    }
}
