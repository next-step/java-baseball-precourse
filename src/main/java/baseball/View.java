package baseball;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import camp.nextstep.edu.missionutils.*;

public class View {
    public void UI(){
        String inner = new String();
        System.out.printf("숫자를 입력해주세요 : ");
        inner = Console.readLine();
        if(StringUtils.isNotBlank(inner)){
            List<Integer> innerList = Application.controller.innerCheck(inner);
            Application.controller.compare(innerList);
        }
    }

    public void reGame(){
        String reGame = new String();        
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        reGame = Console.readLine();
    
        if("2".equals(reGame)){System.exit(0);}
        Application.controller.gameStart();
    }
}

