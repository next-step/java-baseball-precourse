package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Score {
    private List<UserNum> userNums;
    private List<Integer> randomNums;
    private List<String> errorMsgs;
    private boolean successFlag;

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

    private Map<String, Integer> countResult() {
        int num;
        Map<String, Integer> cntMap = new HashMap<>();
        cntMap.put("strikeCnt", 0);
        cntMap.put("ballCnt", 0);

        for (int idx=0; idx < userNums.size(); idx++) {
            num = userNums.get(idx).getNum();
            if (randomNums.indexOf(num) == idx) {
                cntMap.replace("strikeCnt", cntMap.get("strikeCnt")+1);
                continue;
            }
            if (randomNums.contains(num)) {
                cntMap.replace("ballCnt", cntMap.get("ballCnt")+1);
            }
        }
        return cntMap;
    }

    private String getResult(int strikeCnt, int ballCnt) {
        StringJoiner resultMsg = new StringJoiner(" ");
        successFlag = false;

        if (strikeCnt==0 && ballCnt==0) {
            return "낫싱";
        }
        if(strikeCnt > 0) {
            resultMsg.add(strikeCnt + "스트라이크");
            if(strikeCnt == randomNums.size()) {
                resultMsg.add("\n" + strikeCnt + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
                successFlag = true;
            }
        }
        if (ballCnt > 0) {
            resultMsg.add(ballCnt + "볼");
        }
        return resultMsg.toString();
    }

    public void printErrorMsgs() {
        for (String errorMsg : errorMsgs) {
            System.out.println(errorMsg);
        }
    }
}
