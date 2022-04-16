package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    GameService() {
        throw new IllegalArgumentException("Utility class");
    }

    /**
     * 3자리 숫자 생성
     *
     * @return 중복되지 않는 3자리 랜덤 수 생성
     */
    public static String newNumber(int size) {
        StringBuilder pickedNumbers = new StringBuilder();

        for(int i = 0; i < size; i++) {
            pickedNumbers.append(pickRandomNumber(pickedNumbers.toString()));
        }

        return pickedNumbers.toString();
    }

    /**
     * 중복된 숫자를 제외한 랜덤 숫자 pick
     *
     * @param pickedNumbers 이미 선택된 숫자
     * @return 이미 선택된 숫자를 제외하고 랜덤 숫자 반환
     */
    public static String pickRandomNumber(String pickedNumbers) {
        String number = String.valueOf(Randoms.pickNumberInRange(1, 9));

        if (pickedNumbers.contains(number)) {
            return pickRandomNumber(pickedNumbers);
        }

        return number;
    }
}
