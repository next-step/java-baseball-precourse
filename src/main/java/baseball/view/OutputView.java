package baseball.view;

import baseball.Application;
import baseball.model.Computer;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    int[] ballOrStrike;

    private void inputBallOrStrike(Computer computer, Player player){
        ballOrStrike = new int[2];

        for(int i = 0; i < 3; i++){
            if(computer.getValue(i) == player.getValue(i)){
                ballOrStrike[1]++;
                continue;
            }

            if(computer.contains(player.getValue(i))){
                ballOrStrike[0]++;
            }
        }
    }

    public boolean printOutputView(Computer computer, Player player){
        inputBallOrStrike(computer, player);

        StringBuilder sb = new StringBuilder();

        if(ballOrStrike[1] >= 3){
            sb.append(ballOrStrike[1]).append("스트라이크");
            System.out.println(sb);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if(ballOrStrike[0] == 0 && ballOrStrike[1] == 0){
            sb.append("낫싱");
            System.out.println(sb);
            return false;
        }

        if(ballOrStrike[0] > 0){
            sb.append(ballOrStrike[0]).append("볼 ");
        }

        if(ballOrStrike[1] > 0){
            sb.append(ballOrStrike[1]).append("스트라이크");
        }

        System.out.println(sb);

        return false;
    }

    public boolean restartOrExit(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if(input.contentEquals("1")){
            return true;
        }

        return false;
    }
}
