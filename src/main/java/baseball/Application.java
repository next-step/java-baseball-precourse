package baseball;


import service.BaseBallService;

public class Application {
    public static void main(String[] args) {

        System.out.println("[SYSTEM MESSAGE] 야구게임을 시작합니다.");
        BaseBallService bbService = new BaseBallService();
        bbService.running(null);

    }
}
