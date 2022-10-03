package baseball.controller;

import baseball.model.InputCodeModel;
import baseball.view.InputDataView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class InputCodeController {

    public void statingGame(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,9,3);
        while (true){
            String data = new InputDataView().inputDataScanner("숫자를 입력해주세요 : ");
            inputCode(data, numbers);
        }
    }
    public void endingGame(){
        String endText = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려 1, 종료하려면 2입력하세요.";
        String data = new InputDataView().inputDataScanner(endText);
        expLengthInputData(data,1);
        expNumberInputData(data,"[1-2]+");
        if("1".equals(data)){
            statingGame();
            return;
        }
        System.exit(0);
    }
    public void inputCode(String data, List<Integer> numbers){
        expLengthInputData(data,3);
        expNumberInputData(data,"[0-9]+");
        List<String> datas = Arrays.asList(data.split(""));
        new InputCodeModel().dataInspection(datas,numbers);
    }
    private void expLengthInputData(String data, int length){
        if (data.length() != length){
            throw new IllegalArgumentException("문자열 입력 길이 오류");
        }
    }
    private void expNumberInputData(String data, String exp){
        if(!data.matches(exp)){
            throw new IllegalArgumentException("숫자가 아닌 값 입력");
        }
    }
}

