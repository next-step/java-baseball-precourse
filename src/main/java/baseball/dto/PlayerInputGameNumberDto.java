package baseball.dto;

import java.util.List;
import java.util.Objects;

/**
 * Player가 사용하는 값의 Setter/Getter 처리를 담당하는 DTO
 * @author Timothy
 * @version 1.0
 */
public class PlayerInputGameNumberDto {

    private String gameNumber;
    private List<Integer> gameNumberList;

    public PlayerInputGameNumberDto() {
    }

    public PlayerInputGameNumberDto(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
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
        private PlayerInputGameNumberDto dto = new PlayerInputGameNumberDto();

        public Builder inputGameNumber(String inputGameNumber) {
            dto.gameNumber = inputGameNumber;
            return this;
        }

        public Builder gameNumberList(List<Integer> gameNumberList) {
            dto.gameNumberList = gameNumberList;
            return this;
        }

        public PlayerInputGameNumberDto build() {
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
        PlayerInputGameNumberDto that = (PlayerInputGameNumberDto) o;
        return Objects.equals(gameNumber, that.gameNumber) && Objects.equals(gameNumberList, that.gameNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumber, gameNumberList);
    }
}
