package baseball.app;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Rule;
import baseball.utils.io.IOUtils;

public class Baseball {

    public static void start(){
        Referee referee = new Referee(new Rule(), new Computer(), new Player());

        do {
            referee.gameStart();
        }while(referee.isRestart());

        IOUtils.println("게임 종료");
    }
}
