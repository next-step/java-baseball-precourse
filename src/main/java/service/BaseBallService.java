package service;

import dto.BassBall;
import nextstep.utils.CustomUtils;

public class BaseBallService {

    public void running() {

        this.init();

    }

    /**
     * 초기화
     */
    public void init(){
        // 정답 재설정
        int number =  nextstep.utils.Randoms.pickNumberInRange(100,999);
        //100이상 또는 같은숫자 존재시
        if(number < 100 || !CustomUtils.chkSameNum(number)){
            this.init();
            return;
        }

        BassBall bbObj = new BassBall(String.valueOf(number),"N");
        System.out.println("정답 설정 :: " + bbObj.getBaseBallNum());
    }


}
