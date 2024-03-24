package controller;

import cli.CLIGameUI;
import dto.State;
import gameLogics.InitiatingSequence;
import gameLogics.InningSequence;

import java.util.List;

public class GameController {
    CLIGameUI cliGameUI;
    List<Integer> answer;


    public GameController() {
        this.cliGameUI = new CLIGameUI();
        this.answer = null;
    }
    public void playGame(){
        boolean finish = false;
        while (!finish) {
            initializeGame();
            State currentState = initializeGame();
            while (!InningSequence.checkEndState(currentState)){
                doInningSequence(currentState);
            }
            cliGameUI.printEndMessage();
            finish = !cliGameUI.askContinue();
        }
    }

    private State initializeGame(){
        this.answer = InitiatingSequence.generateAnswer();
        return InitiatingSequence.getInitialState();
    }
    private void doInningSequence(State currentState){
        List<Integer> pitchResult;
        pitchResult = cliGameUI.getPitch();
        InningSequence.playInning(this.answer, pitchResult, currentState);
        cliGameUI.printPitchResult(currentState.getStrike(), currentState.getBall());
    }
}
