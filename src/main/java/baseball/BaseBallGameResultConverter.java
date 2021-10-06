package baseball;

/**
 * Name : BaseBallGameResultPrinter <br/>
 * Description : 야구게임 결과 출력 클래스
 */
public class BaseBallGameResultConverter {

    public String  convertGameResult(int[] result) {
        if (isNothing(result)) {
            return "낫싱";
        }
        if (isStrikes(result)) {
            return result[0] + "스트라이크";
        }
        if (isBalls(result)) {
            return result[1] + "볼";
        }
        return result[0] + "스트라이크 " + result[1] + "볼";
    }

    private boolean isBalls(int[] result) {
        return result[0] == 0 && result[1] > 0;
    }

    private boolean isStrikes(int[] result) {
        return result[0] > 0 && result[1] == 0;
    }

    private boolean isNothing(int[] result) {
        return result[0] == 0 && result[1] == 0;
    }
}
