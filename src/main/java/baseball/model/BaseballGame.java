package baseball.model;

import static baseball.Constant.CommonConstant.NUM_END_IDX;
import static baseball.Constant.CommonConstant.NUM_START_IDX;
import static baseball.Constant.CommonConstant.VALID_NUM_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.util.Lists;

public class BaseballGame {
    private List<Integer> answerNumList;

    public BaseballGame() {
        generateAnswerNumList();
    }

    public List<Integer> getAnswerNumList() {
        return answerNumList;
    }

    public void run() {
        boolean isNotGameClear;
        do {
            String playerNumWord = GameGuidePrinter.printAskInputNumber();
            GameSystem.validateWord(playerNumWord);

            Player player = new Player(convertWordToNumArray(playerNumWord), answerNumList);
            GameGuidePrinter.printHint(player);
            isNotGameClear = !player.isThreeStrike();
        } while (isNotGameClear);
    }

    private void generateAnswerNumList() {
        answerNumList = Lists.newArrayList();

        while (answerNumList.size() < VALID_NUM_LENGTH) {
            Integer newNum = Randoms.pickNumberInRange(NUM_START_IDX, NUM_END_IDX);
            addNumToList(answerNumList, newNum);
        }
    }

    private void addNumToList(List<Integer> newAnswerNumList, Integer newNum) {
        if (newAnswerNumList.contains(newNum)) {
            return;
        }

        newAnswerNumList.add(newNum);
    }

    private Integer[] convertWordToNumArray(String numWord) {
        Integer[] numArray = new Integer[3];

        for (int i = 0; i < numWord.length(); i++) {
            numArray[i] = Character.getNumericValue(numWord.charAt(i));
        }

        return numArray;
    }
}
