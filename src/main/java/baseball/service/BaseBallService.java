package baseball.service;

import baseball.model.BaseBall;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseBallService {
    private BaseBall baseBall;

    public BaseBallService() {
        initData();
    }

    public void initData() {
        baseBall = new BaseBall();

        String conj = "";
        conj += Integer.toString(pickNumberInRange(1,9));
        conj += Integer.toString(pickNumberInRange(1,9));
        conj += Integer.toString(pickNumberInRange(1,9));
        baseBall.setExpectValue(conj);
    }


    public BaseBall countInputData(String input) { // 값 체크는 이미 완료되어 있어야 함
        baseBall.setInputValue(input);
        // 비교 로직 설정
        baseBall.setStrikeCount(countStrike(input));
        baseBall.setBallCount(countBall(input));
        // 값 비교값 입력 후 모델값 리턴
        return baseBall;
    }

    private int countBall(String input) {
        int result = 0;

        for (int i=0; i < 3; i++) {
            int index = baseBall.getExpectValue().indexOf(input.substring(i,i+1));
            if (index != i && index > -1) result ++;
        }

        return result;
    }

    private int countStrike(String input) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == baseBall.getExpectValue().charAt(i)) result++;
        }

        return result;
    }

    public boolean checkComplete() {
        return baseBall.getStrikeCount() == 3;
    }
}
