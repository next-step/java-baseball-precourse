package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Baseballs {
    private final List<Baseball> baseballs;


    public Baseballs(List<Baseball> baseballs) {
        isValidSize(baseballs);
        isDuplicate(baseballs);
        this.baseballs = baseballs;
    }

    private void isValidSize(List<Baseball> baseballs) {
        if (baseballs.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicate(List<Baseball> baseballs) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                if (baseballs.get(i).equals(baseballs.get(j))) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static Baseballs createMyBaseballs(String baseballNumbers) {
        List<Baseball> baseballs = new ArrayList<>();

        for (int i = 0; i < baseballNumbers.length(); i++) {
            baseballs.add(Baseball.of(baseballNumbers.charAt(i) - '0'));
        }
        return new Baseballs(baseballs);
    }

    public static Baseballs createComBaseballs() {
        List<Baseball> baseballs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            baseballs.add(Baseball.of(pickNumberInRange(1,9)));
        }
        return new Baseballs(baseballs);
    }

    //TODO: 스트라이크 카운트
    //TODO: 볼 카운트

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseballs baseballs = (Baseballs) o;
        return Objects.equals(this.baseballs, baseballs.baseballs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs);
    }
}
