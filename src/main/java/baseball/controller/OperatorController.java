package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ValidatorService;
import baseball.vo.RuleVo;
import baseball.vo.enumtype.InterfaceMsg;
import baseball.vo.enumtype.ValidationMsg;

public class OperatorController {
    private ComputerService computerService = ComputerService.getInstance();
    private ValidatorService validatorService = ValidatorService.getInstance();
    private PlayerService playerService = PlayerService.getInstance();

    private String inputGameNumber;

    // start: Singleton Holder
    private OperatorController() {
    }

    private static class InnerComputerService {
        private static final OperatorController instance = new OperatorController();
    }

    public static OperatorController getInstance() {
        return InnerComputerService.instance;
    }
    // end: Singleton Holder

    /**
     * 초기화 작업 : 상대방(컴퓨터)가 새로운 값을 갖도록 한 뒤, 게임 시작
     */
    public void initOperator() {
        computerService.initGameNumber(); // 상대방(컴퓨터)가 새로운 값을 갖도록 함
        printMenu();
    }

    /**
     * Player와 interface하는 영역
     */
    private void printMenu() {
        System.out.println(InterfaceMsg.GAME_INFO.getValue()); // 야구게임 안내
        do {
            System.out.print(InterfaceMsg.REQUEST_INPUT.getValue());
            String inputGameNumber = readLine(); System.out.println(inputGameNumber); // Player로부터 야구게임 값을 입력받음
            Integer[] gameResultArray = operateGame(inputGameNumber);
            inputGameNumber = operateGameResult(gameResultArray);
            if (inputGameNumber.equals("1")) continue;
            if (inputGameNumber.equals("2")) break;

        } while (!inputGameNumber.equals("2")); // 야구게임 종료
    }

    /**
     * 야구게임의 결과를 얻기 위한 중간 처리
     * @param inputGameNumber
     * @return gameResult : Integer[]
     */
    private Integer[] operateGame(String inputGameNumber) {
        validateInputNumber(inputGameNumber); // 야구게임 입력 숫자 검증
        this.inputGameNumber = inputGameNumber;
        // 사용자에게 야구게임 입력값을 저장하도록 메시지를 보냄 - Player는 String 타입의 야구게임 입력값을 List<Integer>로 보관
        playerService.setPlayerInputGameNumber(inputGameNumber);
        // 상대방(컴퓨터)에게 사용자가 갖고 있는 야구게임 입력값을 전달
        computerService.setPlayerInputGameNumberList(playerService.getPlayerInputGameNumberDto().getGameNumberList());
        // 상대방(컴퓨터)으로부터 게임의 결괏값을 전달받음
        return computerService.getGameResult();
    }

    /**
     * 야구게임 결과에 따라 Player와 interface하는 영역
     * @param gameResultArray
     * @return
     */
    private String operateGameResult(Integer[] gameResultArray) {
        System.out.println(gameResultArray2String(gameResultArray)); // 결과 출력
        if (gameResultArray[1] == RuleVo.getGameNumbersLen()) { // 3스트라이크
            System.out.println(String.valueOf(RuleVo.getGameNumbersLen()) + InterfaceMsg.GAME_RESULT_SUCCESS.getValue());
            System.out.println(InterfaceMsg.GAME_END_RESTART.getValue());
            String inputGameNumber = readLine();
            System.out.println(inputGameNumber);
            if (inputGameNumber.equals("1")) computerService.initGameNumber(); // 새로운 게임을 위해 새로운 번호 생성
            return inputGameNumber;
        }
        return "1"; // 게임 계속
    }

    /**
     * 야구게임 결과를 문자열로 반환
     * @param gameResultArray
     * @return String
     */
    private String gameResultArray2String(Integer[] gameResultArray) {
        if (gameResultArray[0] != 0 && gameResultArray[1] != 0) { // 볼 & 스트라이크
            return String.valueOf(gameResultArray[0]) +  InterfaceMsg.GAME_RESULT_BALL.getValue() + " " + String.valueOf(gameResultArray[1]) +  InterfaceMsg.GAME_RESULT_STRIKE.getValue();
        }
        if (gameResultArray[0] != 0 && gameResultArray[1] == 0) return String.valueOf(gameResultArray[0]) +  InterfaceMsg.GAME_RESULT_BALL.getValue(); // 볼
        if (gameResultArray[0] == 0 && gameResultArray[1] != 0) return String.valueOf(gameResultArray[1]) +  InterfaceMsg.GAME_RESULT_STRIKE.getValue(); // 스트라이크

        return InterfaceMsg.GAME_RESULT_NOTHING.getValue(); // if (gameResultArray[0] == 0 && gameResultArray[1] == 0)
    }

    /**
     * 야구게임 입력 숫자 검증
     * @param userGameNumber : String
     */
    private void validateInputNumber(String userGameNumber) {
        ValidationMsg validationMsg = validatorService.validationUserInput(userGameNumber);
        if (validationMsg != ValidationMsg.PROPER_TYPE) {
            System.out.println(validationMsg.getValue()); // 검증 도중 발견한 문제의 내용을 출력
            throw new IllegalArgumentException(); // 야구게임의 조건 사항
        }
    }
}
