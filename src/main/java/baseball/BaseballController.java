package baseball;

import java.util.ArrayList;

public class BaseballController {
    private BaseballGenerator baseballGenerator;
    private BaseballCounter baseBallCounter;

    public BaseballController() {
        this.baseballGenerator = new RandomBaseballGenerator() ;
        this.baseBallCounter = new BaseballCounter(baseballGenerator);
    }

    public Result getPoint(String input){
        ArrayList<Integer> arrayList = Utils.stringToTntArray(input);

        int ballCount = baseBallCounter.getBallCount(arrayList);
        int strikeCount = baseBallCounter.getStrikeCount(arrayList);

        return new Result(ballCount, strikeCount);
    }

    public void reset(){
        this.baseballGenerator = new RandomBaseballGenerator();
        this.baseBallCounter = new BaseballCounter(baseballGenerator);
    }
}
