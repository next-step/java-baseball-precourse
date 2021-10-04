package baseball.message;

public class MessageServiceImpl implements MessageService {
    @Override
    public void start() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    @Override
    public void finish(int num) {
        System.out.println(num + "개의 숫자를 모두 맞히셨습니다! 게임 끝\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void error() {
        System.out.println("[ERROR] 값을 다시 입력해 주세요.");
    }

    @Override
    public void result(int ball, int strike) {
        StringBuilder message = new StringBuilder();
        if (strike > 0) message.append(strike).append("스트라이크 ");
        if (ball > 0) message.append(ball).append("볼");

        if (message.length() == 0) message.append("낫싱");

        System.out.println(message);
    }
}
