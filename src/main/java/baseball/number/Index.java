package baseball.number;

import java.util.Objects;

import static baseball.number.NumberConstant.*;

public class Index {

    private final int index;

    public Index(int index) {
        if (index < INITIAL_INDEX || index >= COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("인덱스는 " + INITIAL_INDEX + "이상, " + COUNT_OF_NUMBERS + "미만의 숫자만 가질 수 있습니다.");
        }
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index1 = (Index) o;
        return index == index1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
