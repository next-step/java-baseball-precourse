package baseball.dto;

import java.util.List;
import java.util.Objects;

/**
 * 상대방(컴퓨터)에 의해 생성된 값을 Setter/Getter 처리를 담당하는 DTO
 * @author Timothy
 * @version 1.0
 */
public class GameNumberDto {
    List<Integer> gameNumberList;


    public GameNumberDto() {
    }

    public GameNumberDto(List<Integer> gameNumberList) {
        this.gameNumberList = gameNumberList;
    }

    public List<Integer> getGameNumberList() {
        return gameNumberList;
    }

    public void setGameNumberList(List<Integer> gameNumberList) {
        this.gameNumberList = gameNumberList;
    }

    // start: Builder 패턴
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private GameNumberDto dto = new GameNumberDto();

        public Builder gameNumberList(List<Integer> gameNumberList) {
            dto.gameNumberList = gameNumberList;
            return this;
        }

        public GameNumberDto build() {
            return dto;
        }
    }
    // end: Builder 패턴

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumberDto that = (GameNumberDto) o;
        return Objects.equals(gameNumberList, that.gameNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumberList);
    }
}
