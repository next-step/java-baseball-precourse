package baseball;

import baseball.service.BaseBallService;

public class Application {

    public static void processRun(BaseBallService service){

        while(service.isAlive()){
            service.viewingOutputText();
            service.processRun();
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현Z
        BaseBallService baseBallService = new BaseBallService();
        processRun(baseBallService);

    }
}
