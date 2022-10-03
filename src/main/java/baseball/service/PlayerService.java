package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.dto.PlayerInputGameNumberDto;

/**
 * 야구게임에서 Player의 역할과 정보처리를 하는 Player Service
 * 예) GUI 형식의 게임에서 보여지는 1인칭 아바타의 정보를 처리
 * 실질적으로 Operator가 Validator를 통해 검증받은 숫자형태의 문자열을 List<Integer>로 보관
 */
public class PlayerService {
    private PlayerInputGameNumberDto playerInputGameNumberDto;

    // start: Singleton Holder
    private PlayerService() {
    }

    private static class InnerPlayerService {
        private static final PlayerService instance = new PlayerService();
    }

    public static PlayerService getInstance() {
        return InnerPlayerService.instance;
    }
    // end: Singleton Holder

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
}
