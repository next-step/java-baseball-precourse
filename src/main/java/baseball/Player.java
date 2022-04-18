package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerNums = new ArrayList<>();

    public void playerNums(String value) {
        playerNums.clear();
        for (String val : value.split("")) {
            playerNums.add(Integer.valueOf(val));
        }
        checkNumsSize();
    }

    public void checkNumsSize() {
        if (playerNums.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
