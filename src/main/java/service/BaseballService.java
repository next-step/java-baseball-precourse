package service;

import nextstep.utils.CustomUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseballService {

    private String initYN = "Y";
    private int baseBallNumber = 0;
    private int outCount = 0;


    public void running() {

        if("Y".equals(initYN)){
            this.init();
        }

        while (outCount < 3){

            //입력값 받기
            String inputText = this.inputText();

            //입력값 체크
            Map <String,String> verifyInfo = this.verify(inputText);
            if(!"0".equals(verifyInfo.get("reCode"))){
                System.out.println("오류 " + verifyInfo.get("eMsg"));
                running();
                break;
            }

            //야구 로직
            Map <String,String> baseInfo = this.chkData(verifyInfo.get("returnStr"));
            System.out.println("카운트  [" + outCount + "]  -  " + baseInfo.get("msg"));

            if("3".equals(baseInfo.get("strike"))){
                this.exit();
                break;
            }
            outCount++;
        }

        if(outCount == 3){
            System.out.println("정답은 : " + baseBallNumber);
            System.out.println("정답 재설정 합니다");
            this.init();
            this.running();
        }

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

        baseBallNumber = number;
        System.out.println("정답 설정 :: " + baseBallNumber);
        //아웃카운트 초기화
        initYN ="N";
        outCount = 0;

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
    public Map <String, String> verify(String inputStr) {

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

    /**
     * 배이스볼 체크로직
     * @param inputData : 사용자 입력값
     * @return
     */
    public Map<String, String> chkData(String inputData) {

        //System.out.println("====== START : baseBall Process =========");

        Map<String, String> result = new HashMap<String, String>();

        String[] answerArray = String.valueOf(baseBallNumber).split("");
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

        result.put("strike", String.valueOf(strike));
        result.put("ball", String.valueOf(ball));

        String msg = strike+"스트라이크 "+ball +"볼";
        if(0 == strike && 0 == ball){
            msg = "낫싱";
        }else if(3 ==strike){
            msg = strike+"스트라이크";
        }
        result.put("msg", msg);

        //System.out.println("====== END : baseBall Process =========");

        return result;
    }


    /**
     * 종료
     */
    private void exit() {
        System.out.println("정답입니다 :: [" + baseBallNumber + "] 다시 시작하시겠습니까 ? 무작위 입력값 /[게임 끝]");
        String endText = nextstep.utils.Console.readLine();
        endText = CustomUtils.removeSpace(endText);
        if(!"게임끝".equals(endText)){
            initYN = "Y";
            this.init();
            this.running();
        }
    }
}
