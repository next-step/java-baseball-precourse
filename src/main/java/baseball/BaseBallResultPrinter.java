package baseball;

/**
 * Name : BaseBallGameResultPrinter <br/>
 * Description : 야구게임 결과 출력 클래스
 */
public class BaseBallResultPrinter {
    private BaseBallGameResultConverter baseBallGameResultConverter;

    public BaseBallResultPrinter() {
        this.baseBallGameResultConverter = new BaseBallGameResultConverter();
    }

    public void print(int[] result) {
        String convertGameResult = baseBallGameResultConverter.convertGameResult(result);
        System.out.println(convertGameResult);
    }
}
