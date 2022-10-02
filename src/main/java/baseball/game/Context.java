package baseball.game;

import baseball.domain.compare.Compare;
import baseball.domain.function.Functions;
import baseball.domain.function.GameStart;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import baseball.io.InputFunction;
import baseball.io.OutputFunction;

public class Context {


    private Functions whatIsFunctions = new GameStart();

    private Computer computer;
    private Player player;


    public void command() {
        this.whatIsFunctions = this.whatIsFunctions.command(this);
    }

    public void init(){
        computer = new Computer();
    }

    public GameResult compare(){
        Compare compare = new Compare();
        int inputNum = player.getInputNumber().getInputNumber();


        return compare.compareTwoNumber(inputNum, computer.getRANDOM_NUMBER());
    }


    public void inputData(){
        OutputFunction.print("숫자를 입력해주세요 : ");
        this.player = new Player(InputFunction.readLine());
    }


    public boolean isPlay(){

        return this.whatIsFunctions.isPlay();
    }
}
