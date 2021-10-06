package baseball;

/**
 * Name : BaseBallGameResultPrinter <br/>
 * Description : 야구게임 결과 출력 클래낫
 */
public class BaseBallGameResultPrinter {
    public String  convertGameResult(int[] result) {
        int strikeCount = result[0];
        int ballCount = result[1];

        if(isNothing(result)) {
            return "낫싱";
        }

        if(isStrikes(result)) {
            return strikeCount + "스트라이크";
        }

        if(isBalls(result))
            return ballCount + "볼";

        return strikeCount + "스트라이크 " + ballCount + "볼";
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
