package baseball.player;

import baseball.util.NumberUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pitcher {

    /**
     * 투구
     * 입력 받은 값 검증 및 정제 데이터 전달
     * @return
     */
    public List<Integer> pitch(){
        String ballsText = validateBalls(getPitch());
        List<Integer> balls = NumberUtil.splitNumberByString(ballsText);
        validateBalls(new HashSet<>(balls));
        return balls;
    }

    /**
     * 투구
     * 입력 받은 값 검증
     * @return
     */
    public String getPitch(){
        return validateBalls(Console.readLine());
    }

    /**
     * 텍스트로 입력받은 데이터 검증
     * @param balls
     * @return
     */
    private String validateBalls(String balls) {
        if(!NumberUtil.isNumber(balls))
            throw new IllegalArgumentException("is not Number");

        return balls;
    }

    /**
     * 입력받은 데이터의 정합성 검증
     * @param balls
     * @return
     */
    private Set<Integer> validateBalls(Set<Integer> balls) {
        if (balls.size() != 3)
            throw new IllegalArgumentException("balls size must be equal to 3");
        return balls;
    }
}
