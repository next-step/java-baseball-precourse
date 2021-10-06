package baseball;

import java.util.List;

public class BaseballGame {

    boolean end;
    ViewConsole console;

    public BaseballGame(ViewConsole viewConsole) {
        this.end = false;
        this.console = viewConsole;
    }

    public void startNewGame(){
        List<Integer> answer = GameUtils.generateAnswer();
        playGame(answer);
        finishGame();
    }

    private void playGame(List<Integer> answer) {
        Record record;
        do {
            List<Integer> input = console.enterNumber();
            record = GameUtils.match(answer,input);
            console.printOutput(record.renderResult());
        }while (!record.checkFinished());
    }

    private void finishGame() {
        if(console.askOfFinishGame()){
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
