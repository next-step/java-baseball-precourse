package baseball.service;

import baseball.domain.PickNumberMatchResultView;
import baseball.exception.NotMatchPickNumberSizeException;

public interface GameService {

    /**
     * 입력한 깂을 비교하여 카운트하고 매치 결과를 반환하는 메소드
     * @param readPickNumber 사용자가 입력한 값
     * @return 매치 결과 뷰
     */
    PickNumberMatchResultView comparePickNumber(String readPickNumber);

    /**
     * 입력한 깂의 유효성을 검증하는 메소드
     * <p>
     * 사용자가 잘못된 값을 입력할 경우 [ERROR]로 시작하는 에러 메시지를 출력하고 게임을 계속 진행한다.
     * </p>
     * @param readPickNumber 사용자가 입력한 값
     * @return 유효한 경우 true, 유효하지 않은 경우 false
     * @throws NotMatchPickNumberSizeException 입력한 값의 사이즈가 게임 설정 사이즈와 일치하지 않는 경우 발생하는 예외
     */
    boolean isValidReadPickNumber(String readPickNumber);
}
