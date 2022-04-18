package baseball.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ValidatorService;
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

    public void initOperator() {
        computerService.initGameNumber(); // 상대방(컴퓨터)가 새로운 값을 갖도록 함
        printMenu();
//        computerService.getGameNumberDto().getGameNumberList();
    }

    private void printMenu() {
        System.out.println(InterfaceMsg.GAME_INFO.getValue()); // 야구게임 안내
        while (true) {
            String inputGameNumber = readLine(); System.out.println(inputGameNumber); // Player로부터 야구게임 값을 입력받음
            if (inputGameNumber.equals("2")) break; // 야구게임 종료
            System.out.print(InterfaceMsg.REQUEST_INPUT.getValue());
            operateGame(inputGameNumber);
        }
    }

    private void operateGame(String inputGameNumber) {
        validateInputNumber(inputGameNumber); // 야구게임 입력 숫자 검증
        this.inputGameNumber = inputGameNumber;
        // 사용자에게 야구게임 입력값을 저장하도록 메시지를 보냄 - Player는 String 타입의 야구게임 입력값을 List<Integer>로 보관
        playerService.setPlayerInputGameNumber(inputGameNumber);
        // 상대방(컴퓨터)에게 사용자가 갖고 있는 야구게임 입력값을 전달
        computerService.setPlayerInputGameNumberList(playerService.getPlayerInputGameNumberDto().getGameNumberList());
        // 상대방(컴퓨터)으로부터 게임의 결괏값을 전달받음
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
