package baseball;

import java.util.List;

public class BaseballGame {

    boolean end;

    public BaseballGame() {
        this.end = false;
    }

    public void startGame(){
        List<Integer> answer = GameUtils.generateAnswer();
        playRound(answer);
        finishGame();
    }

    private void playRound(List<Integer> answer) {
        Record record;
        do {
            String input = View.enterInput();
            record = new Record(answer,input);
            GameUtils.match(record);
            View.printScore(record);
        }while (!record.checkFinished());
    }


    private void finishGame() {
        if(View.askOfIsEndGame()){
            exitGame();
        }
    }

    private void exitGame() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }
}
