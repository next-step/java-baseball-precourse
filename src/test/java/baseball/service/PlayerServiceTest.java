package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.dto.PlayerInputGameNumberDto;
import camp.nextstep.edu.missionutils.test.NsTest;

public class PlayerServiceTest extends NsTest {
    private PlayerInputGameNumberDto playerInputGameNumberDto;

    /**
     * Player는 야구게임의 숫자 3개를 받아서, PlayerInputGameNumberDto에 저장한다.
     * String 타입의 야구게임 입력값을 PlayerInputGameNumberDto의 List<Integer>로 보관
     * @param playerInputGameNumber : String
     */
    public void setPlayerInputGameNumber(String playerInputGameNumber) {
        this.playerInputGameNumberDto = PlayerInputGameNumberDto.builder()
            .inputGameNumber(playerInputGameNumber).gameNumberList(generateGameNumberList(playerInputGameNumber)).build();
    }

    /**
     * 야구게임의 숫자 3개를 가진 PlayerInputGameNumberDto를 반환
     * @return playerInputGameNumberDto : PlayerInputGameNumberDto
     */
    public PlayerInputGameNumberDto getPlayerInputGameNumberDto() {
        return playerInputGameNumberDto;
    }

    /**
     * String 타입의 야구게임 입력값을 List<Integer>로 반환
     * @param playerInputGameNumber : String
     * @return playerInputList : List<Integer>
     */
    public List<Integer> generateGameNumberList(String playerInputGameNumber) {
        String[] arrPlayerInputGameNumber = playerInputGameNumber.split("");
        List<Integer> playerInputList = new ArrayList<>();
        for (String playerInputNum : arrPlayerInputGameNumber) {
            playerInputList.add(Integer.parseInt(playerInputNum));
        }
        return playerInputList;
    }

    // playerInputGameNumberDto.gameNumber와 변환되어 저장된 playerInputGameNumberDto.gameNumberList 비교
    @Test
    void playerInputGameNumberDto_gameNumber와_playerInputGameNumberDto_gameNumberList_비교() {
        // give
        String playerInputGameNumber = "365";
        // when
        this.setPlayerInputGameNumber(playerInputGameNumber);
        List<Integer> playerInputList = this.getPlayerInputGameNumberDto().getGameNumberList();
        // then
        assertEquals(playerInputGameNumber, listInteger2String(playerInputList));
    }

    /**
     * List<Integer>를 입력받아, 하나의 문자열로 반환
     * @param playerInputList
     * @return
     */
    private String listInteger2String(List<Integer> playerInputList) {
        return playerInputList.toString().replaceAll("[^0-9]", "");
    }

    @Override
    protected void runMain() {

    }
}
