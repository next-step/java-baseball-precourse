package service;

import dto.BassBall;
import nextstep.utils.CustomUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseBallService {

    public void running(BassBall bbObj) {

        if(bbObj == null){
            bbObj = this.init();
        }

        //입력값 받기
        String inputText = this.inputText();

        //입력값 체크
        Map <String,String> verifyInfo = this.verify(inputText);
        if(!"0".equals(verifyInfo.get("reCode"))){
            System.out.println("[SYSTEM MESSAGE] " + verifyInfo.get("eMsg"));
            running(bbObj);
            return;
        }

        //야구 로직
        bbObj =  this.chkData(bbObj, verifyInfo.get("returnStr"));
        System.out.println("[SYSTEM MESSAGE] ( 입력값: " + verifyInfo.get("returnStr")+" ) -"+ bbObj.getMsg());

        if("3".equals(bbObj.getStrike())){
            this.exit();
        }else if(!"3".equals(bbObj.getStrike())){
            this.running(bbObj);
        }
    }

    /**
     * 초기화
     */
    public BassBall init(){
        int number =  nextstep.utils.Randoms.pickNumberInRange(100,999);

        if(number > 99 && CustomUtils.chkSameNum(number)){
            BassBall bbObj = new BassBall(String.valueOf(number),"N");
            System.out.println("정답 설정 :: " + bbObj.getBaseBallNum());
            return bbObj;
        }

        return this.init();
    }

    /**
     * 사용자 정답 입력
     * @return
     */
    public String inputText(){
        //사용자 값 입력 받기
        System.out.println("3자리 숫자를 입력하세요.(모든 입력값에 대하여 숫자만 대상이됩니다)");
        String inputText = nextstep.utils.Console.readLine();
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
            result.put("eMsg"," 올바른 유효 값이 아닙니다. 세자리에 숫자를 입력하여 주세요.");
            return result;
        }

        result.put("reCode","0");
        result.put("returnStr",inputStr);

        //System.out.println("====== END : validationText =========");

        return result;
    }

    /**
     * 배이스볼 체크로직
     * @param inputData : 사용자 입력값
     * @return
     */
    public BassBall chkData(BassBall bbObj, String inputData) {

        //System.out.println("====== START : baseBall Process =========");

        Map<String, String> result = new HashMap<String, String>();

        String[] answerArray = bbObj.getBaseBallNum().split("");
        String[] inputArray = String.valueOf(inputData).split("");

        int strike = 0;
        int ball = 0;

        for (int i =0; i < answerArray.length; i++) {
            for (int j =0; j < inputArray.length; j++) {
                if(answerArray[i].equals(inputArray[j])){
                    if(i==j){
                        strike++;
                    }else{
                        ball++;
                    }
                }
            }
        }

        bbObj.setStrike(String.valueOf(strike));
        bbObj.setBall(String.valueOf(ball));

        String msg = strike+"스트라이크 "+ball +"볼";
        if(0 == strike && 0 == ball){
            msg = "낫싱";
        }else if(3 ==strike){
            msg = strike+"스트라이크";
        }
        bbObj.setMsg(msg);

        //System.out.println("====== END : baseBall Process =========");

        return bbObj;
    }


    /**
     * 종료
     */
    private void exit() {
        System.out.println("[SYSTEM MESSAGE] 정답입니다. 다시 시작하시겠습니까 ? 무작위 입력값 /[게임 끝]");
        String endText = nextstep.utils.Console.readLine();
        endText = CustomUtils.removeSpace(endText);
        System.out.println(endText);
        if(!"게임끝".equals(endText)){
            this.running(null);
        }
    }


}
