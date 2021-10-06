package baseball.controller;

import nextstep.utils.Randoms;

import java.util.Set;
import java.util.LinkedHashSet;

/**
 * @author Lee SeungHwan
 * @version 1.1
 */
public class NumberMaker {
    private Set<Integer> ballNumbers;

    /**
     * 중복 제거 및 순서 고려하기 위한 LinkedHashSet
     */
    private NumberMaker() {
        this.ballNumbers = new LinkedHashSet<>(NumberBoundary.LENGTH);
    }

    public static String getBallNumbers() {
        NumberMaker numberMaker = new NumberMaker();
        numberMaker.createBallNumbers();
        return numberMaker.toString();
    }

    /**
     * NumberBoundary 조건에 맞는 랜덤한 숫자 3개가 포함된 Set<Integer> 생성
     */
    public void createBallNumbers() {
        do {
            this.ballNumbers.add(Randoms.pickNumberInRange(NumberBoundary.START_NUM, NumberBoundary.END_NUM));
        } while (this.ballNumbers.size() < NumberBoundary.LENGTH);
    }

    /**
     * @return Set<Integer> 을 String으로 반환
     */
    public String toString(){
        String num = "";
        for(Integer elem : this.ballNumbers){
            num += (elem + "");
        }
        return num;
    }

    /**
     * 난수 생성 조건
     */
    static class NumberBoundary{
        public static final int START_NUM = 1;
        public static final int END_NUM = 9;
        public static final int LENGTH = 3;
    }
}
