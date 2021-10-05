package baseball.model;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class BaseballModel implements Model{

    private GameStatus gameStatus;
    private int size;
    private List<Integer> randomNumber;

    public BaseballModel(final int size) {
        this.size = size;
        this.generateRandomNumber();
        this.gameStatus = GameStatus.STAGE_START;
    }

    /**
     * 중복되지 않는 랜덤한 번호를 생성한다
     */
    public void generateRandomNumber(){
        this.randomNumber = new ArrayList<>(size);
        while (randomNumber.size() < size){
            pickNumber();
        }
    }

    private void pickNumber() {
        int number = Randoms.pickNumberInRange(0, 9);
        if( randomNumber.contains(number)){
            return;
        }
        randomNumber.add(number);
    }

    public String getRandomNumber() {
        String str = "";
        for(Integer number : randomNumber){
            str += number;
        }
        return str;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
}
