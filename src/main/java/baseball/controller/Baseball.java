package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Baseball {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play(){
        Computer computer = new Computer();

        boolean flag = true;
        while(flag){
            Player player = inputView.printInputView();

            if(outputView.printOutputView(computer, player)){
                flag = outputView.restartOrExit();

                if(flag){
                    computer = new Computer();
                }
            }
        }
    }
}