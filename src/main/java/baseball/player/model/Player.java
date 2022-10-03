package baseball.player.model;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public boolean keepPlaying() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String keepPlaying = Console.readLine();
        return Integer.parseInt(keepPlaying) == 1;
    }

    public void enterNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String text = Console.readLine();
        System.out.println(text + "을 입력했습니다.");

    }

}
