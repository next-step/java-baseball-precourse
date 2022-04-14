package baseball.domain;

import java.util.ArrayList;

import baseball.exception.OnlyNumberException;
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

                if(isBallIndex(targetIndex, computerRandomNumbers) == targetIndex){
                        return 0;
                }

                if(isBallIndex(targetIndex, computerRandomNumbers) == -1){
                        return 0;
                }

                return 1;
        }

        private int isBallIndex(int targetIndex, ArrayList<Integer> computerRandomNumbers){

                return computerRandomNumbers.indexOf(userBaseballNumbers.get(targetIndex));
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
                // 숫자 이외의 문자가 들어 간 것을 방지.
                final String REGEX = "[0-9]+";
                if(!requireBaseBallNumber.matches(REGEX)) {
                        throw new OnlyNumberException();
                }

                if (requireBaseBallNumber.length() != 3) {
                        throw new SizeMisseException();
                }
        }



}
