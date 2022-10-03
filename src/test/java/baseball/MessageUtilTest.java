package baseball;

import baseball.util.MessageUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MessageUtilTest {

  //게임 시작 msg
  //숫자를 입력해주세요.
  @Test
  @DisplayName("게임 시작 시 msg:")
  void startMsg() {
    MessageUtil.startMsg();
  }

  //볼 , 스트라이크 , 낫싱  출력
  @Test
  @DisplayName("볼 카운트 출력")
  void ballCountMsg() {
    MessageUtil.ballCountMsg(1, 1);
  }

  //게임 종료 msg
  @Test
  @DisplayName("3스트라이크 시 출력 메세지")
  void endMsg() {
    MessageUtil.endMsg();
  }
  //게임재시작
  @Test
  @DisplayName("게임 재시작 여부  출력 메세지")
  void retryMsg() {
    MessageUtil.retryMsg();
  }

}
