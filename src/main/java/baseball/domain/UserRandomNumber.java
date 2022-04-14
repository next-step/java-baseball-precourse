package baseball.domain;

import java.util.ArrayList;
import baseball.exception.SizeMisseException;
import static java.lang.Character.getNumericValue;

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
                        //charat으로 분리 시 char 형변환으로 아스키코드 형식으로 저장됨으로 아스키코드를 넘버로 변경
                        userNumbersList.add( getNumericValue(requireBaseBallNumber.charAt(i)) );
                }

                System.out.println(userNumbersList);
                return userNumbersList;
        }

        public int ballCount(ArrayList<Integer> computerRandomNumbers) {
                int isBallCount = 0;

                for(int i =0; i < userBaseballNumbers.size(); i++){
                        isBallCount = isBallCount + isBall( i, computerRandomNumbers);
                }

                return isBallCount;
        }


        private int isBall(int targetIndex, ArrayList<Integer> computerRandomNumbers) {
                if(targetIndex != computerRandomNumbers.indexOf(userBaseballNumbers.get(targetIndex) )){
                        return 1;
                }

                return 0;
        }

        public int strikeCount(ArrayList<Integer> computerRandomNumbers) {
                int isStrikeCount = 0;

                for(int i =0; i < userBaseballNumbers.size(); i++){
                        isStrikeCount = isStrikeCount + isStrike( i, computerRandomNumbers);
                }

                return isStrikeCount;
        }

        private int isStrike(int targetIndex, ArrayList<Integer> computerRandomNumbers) {
                if ( computerRandomNumbers.get(targetIndex).equals(userBaseballNumbers.get(targetIndex)) ){
                        return 1;
                }

                return 0;
        }

        private void validateUserNumbers(String requireBaseBallNumber) {
                if (requireBaseBallNumber.length() != 3) {
                        throw new SizeMisseException();
                }
        }

}
