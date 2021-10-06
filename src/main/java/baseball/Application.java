package baseball;

import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Role;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public class Application {

    /**
     *  야구 게임 시작, 실행, 종료 및 재시작
     */
    public static void main(String[] args) {
        do {
            Computer computer = ready();
            playBall(computer);
        } while (!exitOrRestart());
    }

    /**
     * Computer 생성 및 임의의 서로 다른 3자리 수 주입
     * @return Computer
     */
    public static Computer ready() {
        return new Computer();
    }

    /**
     * 게임 실행
     * 1. Gamer가 입력한 서로 다른 3자리 공 입력
     * 2. Role을 통해 스트라이크와 볼 판정
     * 3. 판정된 스트라이크와 볼로 결과 출력
     * 4. 3 스트라이크 시 게임 종료
     * @param computer
     */
    public static void playBall(Computer computer) {
        boolean offFlag = false;
        do {
            Integer[] balls = InputView.inputBalls();
            Role role = new Role(computer, new Gamer(balls)).called();
            if (role.isThreeStrike()) offFlag = true;
            OutputView.printCall(role);
        } while (!offFlag);
    }

    /**
     * 게임 종료 및 재시작 선택
     * @return boolean
     */
    public static boolean exitOrRestart() {
        OutputView.printWinningMessage();
        return InputView.inputExitOrRestart();
    }
}
