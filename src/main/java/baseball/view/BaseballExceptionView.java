package baseball.view;

public class BaseballExceptionView implements View {

    private String message;

    public BaseballExceptionView(IllegalArgumentException e) {
        this.message = e.getMessage();
    }

    @Override
    public void print() {
        System.out.println(message);
        System.out.print("숫자를 입력해주세요 : ");
    }
}
