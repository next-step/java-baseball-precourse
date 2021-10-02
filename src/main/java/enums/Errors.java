package enums;

public enum Errors {
  INPUT_ERROR_AND_REINPUT("잘못된 입력입니다. 다시 입력해주세요."),
  INPUT_ERROR_AND_EXIT("잘못된 입력입니다. 게임을 종료합니다.");

  private final String desc;

  Errors(String desc) {
    this.desc = desc;
  }

  public static String getDesc(Errors error) {
    return "[ERROR] "+error.desc;
  }
}
