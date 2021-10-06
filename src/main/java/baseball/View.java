package baseball;

import nextstep.utils.Console;

public class View {
    public String inputNum(){
        System.out.print("숫자를 입력해주세요:");
        return Console.readLine();
    }

    public int inputIsEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return Integer.parseInt(Console.readLine());
    }

    public void printScore(int strike, int ball){
        if(strike > 0)
            System.out.print(strike + "스트라이크 ");
        if(ball > 0)
            System.out.print(ball + "볼");
        if(strike <= 0 && ball <= 0)
            System.out.print("낫싱");
        System.out.println("");
    }

    public void printError(){
        System.out.println("[ERROR] 3자리 숫자를 입력해주세요(0제외)");
    }
}
