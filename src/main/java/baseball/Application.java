package baseball;

import service.BaseballService;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("##### 야구게임을 시작합니다 ####");

        BaseballService bbService = new BaseballService();
        bbService.running();

    }
}
