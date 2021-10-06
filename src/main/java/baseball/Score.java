package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Score {
    private List<UserNum> userNums;
    private List<Integer> randomNums;
    private List<String> errorMsgs;

    public Score(List<String> userNums, List<Integer> randomNums) {
        this.userNums = new ArrayList<>();
        for (String userNum : userNums) {
            this.userNums.add(new UserNum(userNum));
        }
        this.randomNums = randomNums;
    }

    public boolean isCorrectNums() {
        errorMsgs = new ArrayList<>();
        for (UserNum userNum : userNums) {
            if (!userNum.isCorrectNum()) {
                errorMsgs.add(userNum.getErrorMsg());
            }
        }
        if(randomNums.size() != userNums.size()) {
            errorMsgs.add("[ERROR]" + randomNums.size() + "개의 숫자를 입력해주세요.");
        }
        if(isDupl()) {
            errorMsgs.add("[ERROR]" + "중복되는 숫자가 있습니다.");
        }
        return errorMsgs.size() <= 0;
    }

    private boolean isDupl() {
        Set<UserNum> userNumsSet = new HashSet<>(userNums);
        return userNums.size() != userNumsSet.size();
    }

    public void printErrorMsgs() {
        for (String errorMsg : errorMsgs) {
            System.out.println(errorMsg);
        }
    }
}
