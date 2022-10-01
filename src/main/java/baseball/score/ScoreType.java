package baseball.score;

import static baseball.common.Constant.EMPTY;
import static baseball.common.Constant.ZERO_VALUE;

public enum ScoreType implements Type {
    BALL {
        @Override
        public String getDescription(int score) {
            if (score == ZERO_VALUE) return EMPTY;
            return "볼 " + score;
        }
    },
    STRIKE {
        @Override
        public String getDescription(int score) {
            if (score == ZERO_VALUE) return EMPTY;
            return "스트라이크 " + score;
        }
    },
    NOTHING {
        @Override
        public String getDescription(int score) {
            if (score != ZERO_VALUE) return EMPTY;
            return "낫싱";
        }
    };

}
