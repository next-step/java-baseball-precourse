package baseball.domain;

import java.util.ArrayList;

public class UserRandomNumber {

        private static ArrayList<Integer> userBaseballNumbers;

        public UserRandomNumber(String requireBaseBallNumber) {
            this.userBaseballNumbers = BaseBallNumberFormat(requireBaseBallNumber);
        }

        // 입력 받은 내용 arraylist에 담아둔다.
        private ArrayList<Integer> BaseBallNumberFormat(String userNumbers) {
            ArrayList<Integer> userNumbersList = new ArrayList<>();
            for (int i = 0; i < userNumbers.length(); i++) {
                userNumbersList.add((int)userNumbers.charAt(i));
            }
            return userNumbersList;
        }

        public int ballCount(ArrayList<Integer> randomNumbers) {

        }

        private boolean isBall(int targetIndex, ArrayList<Integer> randomNumbers) {

        }

        public int strikeCount(ArrayList<Integer> randomNumbers) {

        }

        private boolean isStrike(int targetIndex, ArrayList<Integer> randomNumbers) {

        }

}
