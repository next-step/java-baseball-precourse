package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseBallRepository {
    private static int strikeCount;
    private static int ballCount;
    private static List<String> list;

    public BaseBallRepository() {
        strikeCount = 0;
        ballCount = 0;
        list = get3DigitByRandomize(); // 랜덤 숫자 생성
    }

    /**
     * strike, ball 개수 세기
     *
     * @param input
     */
    public void countBaseball(String input) {
        // 카운트 초기화
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < 3; i++){
            // 현재 각 자리의 랜덤 숫자가 사용자가 입력한 값에 존재하는지 판단
            int matchedIdx = input.indexOf(list.get(i));
            if(matchedIdx != -1 && matchedIdx == i) { strikeCount += 1; }
            if(matchedIdx != -1 && matchedIdx != i) { ballCount += 1; }
        }
    }

    /**
     * 랜덤 숫자 생성기
     *
     * @return 숫자 3개 포함한 리스트
     */
    private List<String> get3DigitByRandomize() {
        List<String> list = new ArrayList<>();

        while(list.size() != 3){
            // 랜덤 1자리 숫자 생성
            String num = String.valueOf(pickNumberInRange(1, 9));
            // 중복이 아니라면 추가
            if(!list.contains(num)){ list.add(num); }
        }
        return list;
    }

    /**
     * 야구 게임 후처리
     */
    public void postProcessOfBaseball(String input) {
        if(strikeCount == 3 && "1".equals(input)) {
            list = get3DigitByRandomize(); // 랜덤 숫자 재생성
            strikeCount = 0;
        }
    }

    /**
     *  현재 맞힌 상태 출력
     */
    public void printCountStatus() {
        // 현재 맞힌 상태 출력
        if(ballCount != 0) System.out.printf("%d볼 ", ballCount);
        if(strikeCount != 0) System.out.printf("%d스트라이크", strikeCount);
        if(strikeCount == 0 && ballCount == 0) System.out.print("낫싱");
        System.out.println();
    }

    public int getStrikeCount(){
        return strikeCount;
    }
}
