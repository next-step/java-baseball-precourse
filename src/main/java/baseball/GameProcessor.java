package baseball;

import java.util.List;
import java.util.Objects;

public class CalculateCounts {

    public int strikeCount = 0;
    public int ballCount = 0;

    public boolean compareEach(List<Integer> computerNumberList, List<String> playerNumberList) {
        int count = 3;
        for (int index = 0; index < count; index++) {
            Integer computerNumber = computerNumberList.get(index);
            Integer playerNumber = Integer.parseInt(playerNumberList.get(index));

            calculateStrikes(computerNumber, playerNumber);
            calculateBall(index, computerNumberList, playerNumber);
        }
        printResult();
        return strikeCount == 3;
    }

    // TODO : 프린터 클래스 새로 생성
    // TODO : 하드코딩 치환 필요한가?
    private void printResult() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCount == 0) {
            System.out.printf("%d스트라이크 \n",strikeCount);
            return;
        }
        if (strikeCount == 0) {
            System.out.printf("%d볼 \n", ballCount);
            return;
        }
        System.out.printf("%d볼 %d스트라이크 \n", ballCount, strikeCount);
    }

    public void calculateStrikes(Integer computerNumber, Integer playerNumber) {
        if (Objects.equals(computerNumber, playerNumber)) {
            strikeCount += 1;
        }
    }

    public void calculateBall(int i, List<Integer> computerNumber, Integer playerNumber) {
        if (computerNumber.contains(playerNumber) && !Objects.equals(computerNumber.get(i), playerNumber)) {
            ballCount += 1;
        }
    }

}
