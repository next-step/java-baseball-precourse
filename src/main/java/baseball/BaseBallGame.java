package baseball;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import nextstep.utils.Randoms;

public class BaseBallGame extends GameTemplate{
    private View view = null;
    private Game game = null;


    @Override
    public void start() {
        view = new View();
        game = new Game();
        game.setAnswer(makeAnswer());
    }

    @Override
    public void play() {
        while (game.isEnd()){
            String inputNum = view.inputNum();
            getScore(inputNum);
            setZero();
        }
    }

    @Override
    public boolean end() {
        return view.inputIsEnd() == 2;
    }

    public void printScore(){
        if(game.isEnd()){
            view.printScore(game.getStrike(),0);
        }
        view.printScore(game.getStrike(),game.getBall());
    }

    public void setZero(){
        game.setStrike(0);
        game.setBall(0);
    }

    public void getScore(String inputNum){
        if(validation(inputNum)) return;
        char[] answerChars = game.getAnswer().toCharArray();
        char[] inputChars = inputNum.toCharArray();
        strikeCount(answerChars,inputChars);
        if(game.getStrike() ==3){
            game.setEnd(true);
        }
        printScore();
    }

    public void strikeCount(char[] answerChars, char[] inputChars){
        int preStrike;
        for(int i = 0; i < answerChars.length; i++){
            preStrike = game.getStrike();
            compareCharsToPlusStrike(answerChars[i], inputChars[i]);
            ballCount(preStrike, answerChars, inputChars[i]);
        }
    }

    public void ballCount(int preStrike, char[] answerChars, char inputChar){
        if(preStrike == game.getStrike()) ballCount(answerChars, inputChar);
    }

    public void ballCount(char[] answerChars, char inputChar){
        for (char answerChar : answerChars) {
            compareCharsToPlusBall(answerChar, inputChar);
        }
    }

    public void compareCharsToPlusStrike(char answerChar, char inputChar){
        if (answerChar == inputChar) game.setStrike(game.getStrike() + 1);
    }

    public void compareCharsToPlusBall(char answerChar, char inputChar){
        if (answerChar == inputChar) game.setBall(game.getBall() + 1);
    }

    public String makeAnswer(){
        String answer = "";
        while(answer.length() < 3){
            int tmp = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(String.valueOf(tmp))) {
                answer += String.valueOf(tmp);
            }
        }
        return answer;
    }

    public boolean validation(String number) {
        if(number.length() != 3 || number.contains("0")){
            view.printError();
            return false;
        }
        return true;
    }

}
