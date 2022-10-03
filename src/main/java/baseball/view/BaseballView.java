package baseball.view;

import baseball.model.BaseBall;

import java.util.ArrayList;
import java.util.List;

public class BaseballView {
    public static String toSatusString(BaseBall data) {
        List<String> result = new ArrayList<>();

        if (data.getBallCount() > 0) result.add(data.getBallCount()+"볼");
        if (data.getStrikeCount() > 0) result.add(data.getStrikeCount()+"스트라이크");
        if (data.getStrikeCount() == 3) result.add("\n"+toCompleteString(data));

        return result.size() == 0 ? "낫싱" : String.join(" ", result);
    }

    public static String toCompleteString(BaseBall data) {
        return data.getExpectValue().length()+"의 숫자를 모두 맞추셨습니다! 게임종료";
    }
}
