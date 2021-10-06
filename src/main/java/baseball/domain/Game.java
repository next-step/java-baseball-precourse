package baseball.domain;

public class Game {

    private final String answer;

    public Game(final String answer) {
        validate(answer);
        this.answer = answer;
    }

    private void validate(final String answer) {
        try {
            Integer.parseInt(answer);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 문자는 입력할 수 없습니다.");
        }

        if (answer.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 외 숫자는 입력할 수 없습니다.");
        }

        if (answer.contains("0")) {
            throw new IllegalArgumentException("[ERROR] 각 자리에 1부터 9까지 외 다른 숫자는 입력할 수 없습니다.");
        }

        for (int i = 0; i < answer.length() - 1; i++) {
            for (int j = i + 1; j < answer.length(); j++) {
                if (answer.charAt(i) == answer.charAt(j)) {
                    throw new IllegalArgumentException("[ERROR] 서로 같은 수로 이루어진 숫자를 입력할 수 없습니다.");
                }
            }
        }
    }
}
