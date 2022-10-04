package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class Player {

    private List<Integer> baseBalls;

    public Player() {
        this.baseBalls = new ArrayList<>();
    }

    public Player(boolean isComputer) {
        this.baseBalls = new ArrayList<>();

        if (isComputer) {
            setRandomBaseBall();
        }
    }

    public void setRandomBaseBall() {
        baseBalls = new ArrayList<>();

        do {
            randomBaseBall();
        } while (baseBalls.size() < Config.MAX_NUMBER);
    }

    private void randomBaseBall() {
        int num = pickNumberInRange(Config.START_NUMBER, Config.END_NUMBER);

        if (!baseBalls.contains(num)) {
            baseBalls.add(num);
        }
    }

    public List<Integer> getBaseBalls() {
        return baseBalls;
    }

    public void setBaseBalls(String input) {
        this.baseBalls = new ArrayList<>();

        nullValidation(input);

        stringToInt(input);

        sizeValidation();
    }

    private void isNumber(char data) {
        if (data >= 49 && data <= 57) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void stringToInt(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            isNumber(input.charAt(i));
            baseBalls.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
    }

    private void sizeValidation() {
        if (new HashSet<>(baseBalls).size() == Config.MAX_NUMBER) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void nullValidation(String value) {
        if (!StringUtils.isBlank(value)) {
            return;
        }

        throw new IllegalArgumentException();
    }
}
