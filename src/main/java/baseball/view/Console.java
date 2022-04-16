package baseball.view;

import baseball.model.Result;

public class Console {

    public void displayTypeNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void displayResult(Result result){
        if (displayNothing(result)) {
            return;
        }

        StringBuilder sb = getResultString(result);
        System.out.println(sb);
    }

    private StringBuilder getResultString(Result result) {
        StringBuilder sb = new StringBuilder();
        if(result.getBall().isBallExisted()){
            sb.append(result.getBall().getCount()).append("볼 ");
        }
        if(result.getStrike().isStrikeExisted()){
            sb.append(result.getStrike().getCount()).append("스트라이크");
        }
        return sb;
    }

    private boolean displayNothing(Result result) {
        if(result.isNothing()){
            System.out.println("낫싱");
            return true;
        }
        return false;
    }

    public void gameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려명 1, 종료하려면 2를 입력하세요.");
    }
}
