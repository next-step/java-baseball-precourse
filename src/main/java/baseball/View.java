package baseball;

public interface View {
    /**
     * 숫자입력 요청문구를 출력합니다.
     */
    void askToPutNumber();

    /**
     * 게임을 이겼을 경우 관련문구를 출력합니다.
     */
    void winTheGame();

    /**
     * 게임의 결과문구를 출력합니다..
     */
    void score(Score score);

    /**
     * 게임이 끝난 후의 대시보드를 출력합니다.
     */
    void dashboard();

}
