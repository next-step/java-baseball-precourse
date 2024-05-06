package game;

public class BaseBallGameService {

    public int checkStrike(String computerNumber, String userNumber){
        int strike = 0;

        for(int i=0; i<3; i++){
            if(computerNumber.charAt(i) == userNumber.charAt(i)){
                strike++;
            }
        }

        return strike;
    }

    public int checkBall(String computerNumber, String userNumber){
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumber.charAt(i) == userNumber.charAt(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }

    public String printGameInfo(int strike, int ball){
        if(strike == 0 && ball == 0){
            return "낫싱";
        } else if(strike > 0 && ball == 0) {
            return strike+"스트라이크";
        } else if(strike == 0 && ball > 0){
            return ball+"볼";
        }
        else{
            return ball+"볼 "+strike+"스트라이크";
        }
    }

    public boolean checkNumberValid(String number){
        if (number.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }

            long count = number.chars().filter(n -> n == c).count();
            if (count > 1){
                throw new IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.");
            }
        }

        return true;
    }

}
