package baseball.domain;

import java.util.ArrayList;
import baseball.exception.SizeMisseException;

public class UserRandomNumber {

        private static ArrayList<Integer> userBaseballNumbers;

        public UserRandomNumber(String requireBaseBallNumber) {
            this.userBaseballNumbers = BaseBallNumberFormat(requireBaseBallNumber);
        }

        // 입력 받은 내용 arraylist에 담아둔다.
        private ArrayList<Integer> BaseBallNumberFormat(String requireBaseBallNumber) {
            //사이즈 검증 후 arraylist에 담는다.
            validateUserNumbers(requireBaseBallNumber);
            ArrayList<Integer> userNumbersList = new ArrayList<>();
            for (int i = 0; i < requireBaseBallNumber.length(); i++) {
                userNumbersList.add((int)requireBaseBallNumber.charAt(i));
            }
            return userNumbersList;
        }

        public int ballCount(ArrayList<Integer> computerRandomNumbers) {

        }

        private boolean isBall(int targetIndex, ArrayList<Integer> computerRandomNumbers) {

        }

        public int strikeCount(ArrayList<Integer> computerRandomNumbers) {

        }

        private boolean isStrike(int targetIndex, ArrayList<Integer> computerRandomNumbers) {

        }

        private void validateUserNumbers(String requireBaseBallNumber) {
            if (requireBaseBallNumber.length() != 3) {
                throw new SizeMisseException();
            }
        }

}
