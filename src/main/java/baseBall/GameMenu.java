package baseBall;

import Utils.UserInput;

public class GameMenu {
    public void run(){
        while (UserInput.inMenu().equals("1")){
            GameProcess gameProcess = new GameProcess();
            gameProcess.run();
        }

        System.out.println("게임을 종료합니다.");
    }
}
