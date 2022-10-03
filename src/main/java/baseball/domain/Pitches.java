package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Pitches extends Baseball {

    ArrayList<Integer> pitches;

    public Pitches(String input) {
        pitches = new ArrayList<>();
        setPitches(input);
    }

    private void setPitches(String input) {
        validateInput(input);
        for (int i = 0; i < NUM_BALL_LEN; i++) {
            pitches.add(Integer.parseInt(input.substring(i, i + 1)));
        }
    }

    private void validateInput(String input) {
        checkInputLength(input);
        checkInputValue(input);
        checkDuplicate(input);
    }

    private void checkInputLength(String input) {
        if (input.length() != NUM_BALL_LEN) {
            System.out.println("입력 자리수 확인");
            throw new IllegalArgumentException();
        }
    }

    private void checkInputValue(String input) {
        if (!input.matches(valPattern)) {
            System.out.println("입력값 확인");
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String input) {
        HashSet<String> strSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            strSet.add(input.substring(i, i + 1));
        }

        if (strSet.size() != NUM_BALL_LEN) {
            System.out.println("중복 값 확인");
            throw new IllegalArgumentException();
        }
    }

    public int getPitch(int index) {
        return pitches.get(index);
    }
}
