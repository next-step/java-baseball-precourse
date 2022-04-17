package baseball.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {

    public static final String BALLS = "balls";

    public static final String STRIKES = "strikes";

    private static final BiPredicate<Integer, Integer> STRIKE_JUDGEMENT = (i, p) -> i == p;

    private static final BiPredicate<Integer, Integer> BALL_JUDGEMENT = (i, p) -> i != p && p > -1;

    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private static final int NUMBER_COUNT = 3;

    private List<Integer> goalNumbers = new ArrayList<>(3);

    private final Map<String, Integer> result = new HashMap<>();

    private boolean gameOver = false;

    public void generateGoalNumbers() {
    	for (int i = 0; i < 3; i++) {
    		goalNumbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
    	}
    	System.out.println("생성: " + goalNumbers);
    }

    public void validateInputNumbers(String userInput) {
        Optional.ofNullable(userInput)
                .orElseThrow(IllegalArgumentException::new);
        validate3digitsNumber(userInput);
        validateHasZero(userInput);
        validateDuplicatedNumber(userInput);
    }

    private void validate3digitsNumber(String userInput) {
        try {
            check3digitsNumber(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void check3digitsNumber(String userInput) {
    	int number = Integer.valueOf(userInput);
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }
    }
    
    private void validateHasZero(String userInput) {
    	if (userInput.indexOf("0") > -1) {
    		throw new IllegalArgumentException();
    	}
    }

    private void validateDuplicatedNumber(String userInput) {
        for (int i = 0, len = userInput.length() - 1; i < len; i++) {
            checkNumber(userInput, i);
        }
    }

    private void checkNumber(String userInput, int start) {
        int target = start + 1;
        while (target < NUMBER_COUNT) {
            compareCharacters(userInput.charAt(start), userInput.charAt(target++));
        }
    }

    private void compareCharacters(char a, char b) {
        if (a == b) {
            throw new IllegalArgumentException();
        }
    }

    public void judgeResult(String userInput) {
        ListIterator<Integer> itr = goalNumbers.listIterator();
        while (itr.hasNext()) {
            int index = itr.nextIndex();
            int position = findMatchedPosition(userInput, String.valueOf(itr.next()));
            updateResult(index, position);
        }
    }

    private int findMatchedPosition(String userInput, String goal) {
        return userInput.indexOf(String.valueOf(goal));
    }

    private void updateResult(int index, int position) {
    	result.put(STRIKES, getBallCounts(STRIKES, index, position));
    	result.put(BALLS, getBallCounts(BALLS, index, position));
    	gameOver = (result.get(STRIKES) == 3);
    }
    
    private int getBallCounts(String status, int index, int position) {
    	BiPredicate<Integer, Integer> judgement = (status.equals(STRIKES)) ? STRIKE_JUDGEMENT : BALL_JUDGEMENT;
    	int counts = getStatusCount(judgement, position, index);
    	return result.containsKey(status) ? result.get(status) + counts : counts;
    }

    private int getStatusCount(BiPredicate<Integer, Integer> judgement, int index, int position) {
        return judgement.test(position, index) ? 1 : 0;
    }
    
    public void clearResult() {
    	result.clear();
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
