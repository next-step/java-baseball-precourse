package baseball.domain.number;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumber {

    private final Set<Number> playerNumbers = new LinkedHashSet<>();

    public PlayerNumber(String playerNumber) {
        for (char charAt : playerNumber.toCharArray()) {
            this.playerNumbers.add(new Number(charAt));
        }
    }

    public List<Integer> toList() {
        List<Integer> result = new ArrayList<>();
        for (Number number : this.playerNumbers) {
            result.add(number.getNumber());
        }
        return result;
    }

    public Set<Number> getPlayerNumbers() {
        return playerNumbers;
    }

    @Override
    public String toString() {
        return "PlayerNumbers{" +
            "numbers=" + playerNumbers +
            '}';
    }
}
