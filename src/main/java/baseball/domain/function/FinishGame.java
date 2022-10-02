package baseball.domain.function;

import baseball.game.Context;
import baseball.io.InputFunction;
import baseball.io.OutputFunction;

public class FinishGame implements Functions {

    private final String RE_START = "1";
    private final String END_GAME = "2";


    @Override
    public Functions command(Context context) {
        //게임 재진행 여부에 따라 종료 또는 재스타트 여부 확인

        OutputFunction.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = InputFunction.readLine();


        if(command.equals(RE_START)){
            return new GameStart();
        }

        if(command.equals(END_GAME)){
            OutputFunction.println("게임 종료");
            return new ExitGame();
        }

        throw new IllegalArgumentException("게임 종료");
    }


    @Override
    public boolean isPlay() {
        return true;
    }


}
