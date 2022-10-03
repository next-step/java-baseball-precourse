package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
/**
 * packageName    : baseball
 * fileName       : GameNumber
 * author         : BOM
 * date           : 2022-09-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-30        BOM       최초 생성
 * 2022-10-02        BOM       getHintFromUserInput,checkInputByChar,checkIfCharIsStrike 추가
 */
public class GameNumber {
    private int gameNumberLength;

    /*생성자 Method*/
    public GameNumber(int length) {
        this.gameNumberLength = length;
    }


    /*String으로 랜덤한 gameNumberLength 자리수를 생성하는 메서드*/
    public String getRandomNumberString() {
        String gameAnswer = "";
        while (gameAnswer.length() < gameNumberLength) {
            gameAnswer = pickRandomNumber(gameAnswer);
        }
        return gameAnswer;
    }

    /*랜덤한 숫자를 골라 기존 수에 해당 숫자가 있는지 체크한 후 뒷자리에 해당 숫자 추가*/
    public String pickRandomNumber(String gameAnswer) {
        String pickedNumber = String.valueOf(pickNumberInRange(1, 9));
        if (!gameAnswer.contains(pickedNumber)) {
            gameAnswer += pickedNumber;
        }
        return gameAnswer;
    }

    /*받은 input을 정답과 비교하여 힌트를 생성하는 메서드*/
    public void getHintFromUserInput(String input, String gameAnswerNumber, Hint hint) {
        for (int i = 0; i < input.length(); i++) {
            checkInputByChar(input,gameAnswerNumber,i,hint);
        }
    }

    /*input의 자리수별로 정답과 비교하는 메서드*/
    private void checkInputByChar(String input, String gameAnswerNumber, int i,Hint hint){
        if(gameAnswerNumber.contains(input.substring(i,i+1))){
            checkIfCharIsStrike(input,gameAnswerNumber,i,hint);
        }
    }

    /*정답 안에 있는 숫자가 Strike 인지 Ball인지 여부 판단하여 힌트에 넣는 메서드*/
    private void checkIfCharIsStrike(String input, String gameAnswerNumber, int i,Hint hint){
        if(gameAnswerNumber.charAt(i)==input.charAt(i)) {
            hint.setStrike(hint.getStrike() + 1);
            return;
        }
        hint.setBall(hint.getBall() + 1);
    }
}
