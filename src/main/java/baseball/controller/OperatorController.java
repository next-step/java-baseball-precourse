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
//        initOperator();
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
        System.out.println(InterfaceMsg.GAME_INFO.getValue());
        while (true) {
            String inputGameNumber = readLine();
            System.out.println(inputGameNumber);
            if (inputGameNumber.equals("2")) break;
            System.out.print(InterfaceMsg.REQUEST_INPUT.getValue());
            operateGame(inputGameNumber);
        }
    }

    private void operateGame(String inputGameNumber) {
        validateInputNumber(inputGameNumber); // 야구게임 입력 숫자 검증
        this.inputGameNumber = inputGameNumber;
        // 사용자에게 야구게임 입력값을 저장하도록 메시지를 보냄 - Player는 String 타입의 야구게임 입력값을 List<Integer>로 보관
        playerService.setPlayerInputGameNumber(inputGameNumber);
        // 컴퓨터에게 사용자가 갖고 있는 야구게임 입력값을 전달하여 그 결과에 따라 게임을 진행
    }

    /**
     * 야구게임 입력 숫자 검증
     * @param userGameNumber : String
     */
    private void validateInputNumber(String userGameNumber) {
        ValidationMsg validationMsg = validatorService.validationUserInput(userGameNumber);
        if (validationMsg != ValidationMsg.PROPER_TYPE) {
            System.out.println(validationMsg.getValue());
            throw new IllegalArgumentException();
        }
    }
}
