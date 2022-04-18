package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class App {
    private final String startMessage;
    private final String restartMessage;
    private boolean complete;
    private final BaseballController baseballController;
    private Processor processor;

    public App() {
        baseballController = new BaseballController();
        complete = false;
        startMessage = "숫자를입력해주세요 : ";
        restartMessage = "게임을새로시작하려면1,종료하려면2를입력하세요.";
        processor = new GameProcessor();
    }

    private interface Processor {
        Processor run();
    }

    private class GameProcessor implements Processor {

        @Override
        public Processor run() {
            System.out.println(startMessage);
            String input = readLine();

            Result point = baseballController.getPoint(input);
            System.out.println(getPointMessage(point));

            if(point.strikeCnt == 3){
                return new SelectionProcessor();
            }

            return new GameProcessor();
        }
    }

    private class SelectionProcessor implements Processor {

        @Override
        public Processor run() {
            System.out.println(restartMessage);
            String input = readLine();

            if ("1".equals(input)) {
                baseballController.reset();
                return new GameProcessor();
            } else {
                complete = true;
                System.out.println("게임 종료");
                return null;
            }
        }
    }

    public void runLoop(){
        while (!complete){
            processor = processor.run();
        }
    }

    private String getPointMessage(Result result){
        if(result.ballCnt + result.strikeCnt == 0) {
            return "낫싱";
        }

        if(result.strikeCnt == 0) {
            return result.ballCnt +  "볼";
        }

        if(result.strikeCnt > 0 && result.ballCnt == 0) {
            return result.strikeCnt +  "스트라이크";
        }

        return result.ballCnt+"볼" + " "+ result.strikeCnt +  "스트라이크";
    }
}
