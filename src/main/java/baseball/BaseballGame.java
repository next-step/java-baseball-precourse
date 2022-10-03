package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public boolean start(){
        List<Integer> answerNumbers = new ArrayList<>();
        List<Integer> inputNumbers = new ArrayList<>();

        //랜덤3자리를 발생시킨다.
        answerNumbers = RandomUtils.makeAnswerNumbers();

        while(true){
            //데이터를 입력받는다.
            String inputData = readInputData();

            //inputData 유효성체크
            if(!CheckValidation.sizeCheck(inputData,3) || !CheckValidation.isNumeric(inputData) || !CheckValidation.numberRangeCheck(inputData)) {
                //잘못된 값이 들어오면 IllegalArgumentException 하고 전체종료한다.
                throw new IllegalArgumentException();
            }
            inputNumbers = ConvertUtils.StringToList(inputData);

            //볼스트라이크여부를 판단
            Answer answer = BallAndStrike.check(answerNumbers,inputNumbers);

            //결과출력
            System.out.println(BallAndStrike.printScore(answer));

            //정답을 맞추면 재시작 여부 체크
            if(answer.getStrike()==3){
                return checkRestartYn();
            }
        }
    }

    private boolean checkRestartYn() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(!CheckValidation.sizeCheck(input,1) || !CheckValidation.isNumeric(input)) {
            //잘못된 값이 들어오면 IllegalArgumentException 하고 전체종료한다.
            throw new IllegalArgumentException();
        }
        //1이나 2가 아니면
        if(!input.equals("1") && !input.equals("2") ){
            //잘못된 값이 들어오면 IllegalArgumentException 하고 전체종료한다.
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }

    private String readInputData() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
