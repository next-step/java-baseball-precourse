package baseball.view;

import baseball.domain.BaseballVO;

public interface ViewService {

    // 숫자입력
    String inputAnswer(BaseballVO baseballVO);

    // 입력결과 출력
    String outputMessage(BaseballVO baseballVO);

}
