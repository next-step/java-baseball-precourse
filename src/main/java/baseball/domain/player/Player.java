package baseball.domain.player;

import baseball.domain.number.InputNumber;
import baseball.io.InputFunction;

public class Player {

    private InputNumber number;

    public Player(String input){
        number = new InputNumber(input);

    }


    public InputNumber getInputNumber(){
        return number;
    }
}
