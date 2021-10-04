package service;

import dto.BassBall;
import nextstep.utils.CustomUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseBallService {

    public void running(BassBall bbObj) {

        System.out.println(bbObj);

        if(bbObj == null){
            System.out.println("INIT#####");
            this.init();
        }

        //입력값 받기
        String inputText = this.inputText();

        //입력값 체크
        Map <String,String> verifyInfo = this.verify(inputText);
        if(!"0".equals(verifyInfo.get("reCode"))){
            System.out.println("[SYSTEM MESSAGE] " + verifyInfo.get("eMsg"));
            running(bbObj);
        }


    }

    /**
     * 초기화
     */
    public void init(){
        int number =  nextstep.utils.Randoms.pickNumberInRange(100,999);
        //100이상 또는 같은숫자 존재시 정답 재설정
        if(number < 100 || !CustomUtils.chkSameNum(number)){
            this.init();
            return;
        }

        BassBall bbObj = new BassBall(String.valueOf(number),"N");
        System.out.println("정답 설정 :: " + bbObj.getBaseBallNum());
    }

    /**
     * 사용자 정답 입력
     * @return
     */
    public String inputText(){
        //사용자 값 입력 받기
        System.out.println("3자리 숫자를 입력하세요.");
        String inputText = nextstep.utils.Console.readLine();
        System.out.println("사용자 입력값 : " + inputText);
        return inputText;
    }

    /**
     *입력데이터 검증
     * @param inputStr
     * @return map.reCode : "0": 정상;  "1"; 비정상
     *        map.eMsg : "비정상시 메세지"
     *        map.returnStr : "야구게임 입력값"
     */
    public Map<String, String> verify(String inputStr) {

        //System.out.println("====== START : validationText =========");

        //모든 공백제거
        inputStr = CustomUtils.removeSpace(inputStr);

        Map <String, String> result = new HashMap<String, String>();
        if("".equals(inputStr)){
            result.put("reCode","1");
            result.put("eMsg","입력값이 없습니다.");
            return result;
        }

        // 입력데이터 숫자 추출
        inputStr = CustomUtils.extractNumber(inputStr);
        if(inputStr.length() != 3){
            result.put("reCode","1");
            result.put("eMsg","세자리에 숫자를 입력하여 주세요.");
            return result;
        }

        result.put("reCode","0");
        result.put("returnStr",inputStr);

        //System.out.println("====== END : validationText =========");

        return result;
    }


}
