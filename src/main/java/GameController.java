import java.util.ArrayList;
import java.util.List;

public class GameController {
    private OutputView output=new OutputView();
    private InputView input=new InputView();
    private Computer computer;
    private Numbers answer;

    public GameController(){
        this.answer=new Numbers();
        this.computer=new Computer(answer.getNumbers());
        System.out.println(answer.getNumbers());
    }

    public void playTurn(){
        String userInput = input.getUserNumbers();
        if(input.validateInput(userInput)){
            List<Integer> user = parseInput(userInput);
            int[] score = computer.checkAnswer(user);
            getHint(score);
        }
    }

    public boolean isEnded(){
        return computer.isEnded;
    }

    public List<Integer> parseInput(String userinput){
        List<Integer> input=new ArrayList<>();
        String[] changedInput=userinput.split("");
        for(int i=0;i<3;i++){
            input.add(Integer.parseInt(changedInput[i]));
        }
        return input;
    }

    private void getHint(int[] score){
        int strike=score[0];
        int ball=score[1];
        if(strike>0){
            output.printStrike(strike);
        }
        if(ball>0){
            output.printBall(ball);
        }
        if(strike==0 && ball==0){
            output.printNothing();
        }
        System.out.println();
    }


}
