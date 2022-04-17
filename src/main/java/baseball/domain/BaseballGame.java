package baseball.domain;

import baseball.constants.BaseballGameStatus;
import baseball.util.StringUtil;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


public class BaseballGame {
    private final Computer computer;
    private final BaseballGameRule baseballGameRule;

    @Builder
    public BaseballGame(final Computer computer, final BaseballGameRule baseballGameRule) {
        this.computer = computer;
        this.baseballGameRule = baseballGameRule;
    }

    private BaseballGameStatus status = BaseballGameStatus.BEFORE_START;

    public boolean isEnd() {
        return this.status == BaseballGameStatus.END;
    }

    private List<Integer> randomNumbers = new ArrayList<>();
    // 테스트용
    // 실제 동작에서 set 사용 X
    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void start() {
        this.randomNumbers = computer.getChoiceNumbers();
        this.status = BaseballGameStatus.START;
    }

    public BaseballGameResult pitch(String numbers) {
        validateNumbers(numbers);
        List<Integer> inputNumbers = StringUtil.numbersStringToList(numbers);
        BaseballGameResult result = baseballGameRule.judge(inputNumbers, randomNumbers);
        if(result.getStrike() == 3) end();
        return result;
    }

    private void end() {
        this.status = BaseballGameStatus.END;
    }

    private void validateNumbers(String numbers) {
        if(numbers == null || numbers.length() > 3) {
            throw new IllegalArgumentException("세자리 이상의 수가 입력 되었습니다.");
        }
        for(int i = 0; i < numbers.length(); i++) {
            isNotNumber(numbers.charAt(i));
        }
    }

    private void isNotNumber(char number) {
        if(false == ((int) number >= 49 && (int) number <= 57)) {
            throw new IllegalArgumentException("잘못된 숫자 값이 입력 되었습니다.");
        }
    }
}
