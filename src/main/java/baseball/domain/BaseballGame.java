package baseball.domain;

import baseball.feature.Service;
import baseball.ui.UI;

public class BaseballGame {
    private final int NUMBER_DIGIT = 3;

    private Integer[] answer;
    private boolean continueFlag = false;
    private UI ui;
    private Service service;

    public BaseballGame(UI ui, Service service) {
        this.ui = ui;
        this.service = service;
        // 게임 생성과 같이 정답 생성
        answer = service.makeRandomDigit(NUMBER_DIGIT);
    }

    //게임 시작
    public void play() {
        boolean continueInput = true;
        // 반복입력
        while (continueInput) {
            continueInput = gameStart();
        }
    }

    private boolean gameStart(){
        String input = ui.startAndInputNumber();

        if(!service.isValid(input)){
            ui.printError();
            return true;
        }

        Integer[] inputNums = service.stringToInt(input);

        CheckResult checkResult = service.getCheckResult(answer, inputNums);
        ui.printResult(checkResult);

        if(checkResult.isCorrect()){
            continueFlag = ui.getSelection();
            return false;
        }
        return true;

    }

    public boolean continuePlay(){
        return this.continueFlag;
    }



}
