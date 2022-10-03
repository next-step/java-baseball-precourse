package baseball.model;

import baseball.controller.InputCodeController;
import java.util.List;

public class InputCodeModel {
    public void dataInspection(List<String> datas, List<Integer> numbers){
        int strike = 0;
        int ball = 0;
        for (int i=0;i<3;i++){
            Integer nowData = Integer.valueOf(datas.get(i));
            strike = strikeCounting(nowData,numbers.get(i),strike);
            ball = ballCounting(nowData,numbers,ball,i);
        }
        resultGame(strike,ball);
    }
    private int strikeCounting(Integer data, Integer number, int strike){
        if(data == number){
            strike += 1;
        }
        return strike;
    }
    private int ballCounting(Integer data, List<Integer> numbers, int ball, int step){
        if(numbers.indexOf(data) != step && numbers.indexOf(data) > -1){
            ball += 1;
        }
        return ball;
    }
    private void resultGame(int strike, int ball){
        if(strike == 3 ){
            new InputCodeController().endingGame();
        }
        countPrinter("낫싱",strike == 0 && ball == 0,0);
        countPrinter("%d볼 ",ball>0,ball);
        countPrinter("%d스트라이크",strike>0,strike);
        System.out.print("\n");
    }
    private void countPrinter(String explain,boolean result, int printing){
        if(result){
            System.out.print(String.format(explain,printing));
        }
    }
}
