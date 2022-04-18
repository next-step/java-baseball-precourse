package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGameModelImpl implements BaseBallGameModel{
    public String target;
    @Override
    public void setTarget() {
        boolean isValid = false;
        while(!isValid) {
            String input = buildNumber();
            if(isValidNumber(input)) {
                isValid = true;
                this.target =  input;
            }
        }
    }

    private String buildNumber() {
        int candidate = Randoms.pickNumberInRange(1,9);
        String input = String.valueOf(candidate);
        StringBuilder numberString = new StringBuilder();
        while(numberString.length() < 3) {
            numberString.append(input);
            input = String.valueOf(Randoms.pickNumberInRange(1,9));
        }
        return numberString.toString();
    }

    @Override
    public boolean isValidNumber(String input) {
        String regexOnlyNumber = "[1-9]+";
        if(!input.matches(regexOnlyNumber)) return false;
        if(input.length() > 3) return false;
        if(input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)) return false;
        return true;
    }

    @Override
    public int isBallCount(String input) {
        int countBall = 0;
        for(int i=0;i<3;i++) {
            int indexOne = (i+1)%3;
            int indexTwo = (i+2)%3;
            if(input.charAt(i) == target.charAt(indexOne) || input.charAt(i) == target.charAt(indexTwo)) countBall++;
        }
        return countBall;
    }

    @Override
    public int isStrikeCount(String input) {
        int countStrike = 0;
        for(int i=0;i<3;i++) {
            if(input.charAt(i) == target.charAt(i)) countStrike++;
        }
        return countStrike;
    }
}
