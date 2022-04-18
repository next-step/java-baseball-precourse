package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerNums = new ArrayList<>();
    String playerNum;

    public void playerNums(String value) {
        playerNum = "";
        playerNums.clear();
        for (String val : value.split("")) {
            playerNums.add(Integer.valueOf(val));
            playerNum += val;
        }
        checkNumsSize();
    }

    public void checkNumsSize() {
        if (playerNums.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public String answer(String value) {
        return value;
    }
}
