# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)





## 구현할 기능 목록



### 1. 범위에 유효한 숫자 검증

* Ball의 숫자는 1-9 까지의 숫자, 0 일 경우 예외 발생
* Balls의 숫자는 서로 다른 숫자, 같은 숫자가 있는 경우 예외 발생
* Balls에 포함된 Ball의 숫자는 3개, 3개가 이닌 경우 예외 발생



### 2. 결과 출력 기능

* GamePlayer의 Ball과 Computer의 Ball의 pos와 number 가 같으면 스트라이크
* GamePlayer의 Balls 안에 Ball객체가 Computer의 Balls안의 Ball객체와 pos가 다르지만 number같으면, 볼 
* GamePlayer의 Balls 안에 Ball객체가, Computer의 Balls안의 Ball객체와 pos, number 둘다 일치하지 않을때 낫싱

* "3 스트라이크" 가 발생한 경우 야구 게임(BaseballGame) 종료



### 3. Computer 의 숫자 생성 기능

* 1-9까지 서로 다른 수로 이루어진 3자리 숫자 생성



### 4. GamePlayer 입력값 검증

* GamePlayer가 숫자가 아닌 값을 입력했을 경우,  "[ERROR] 1-9까지 숫자를 입력하십시오." 를 출력 후 게임 진행 

* GamePlayer가 숫자가 3자리가 아닌 경우, "[ERROR] 3자리 숫자를 입력하십시오." 를 출력 후 게임 진행

* 야구 게임(BaseballGame) 종료 상태에서, GamePlayer가 "1" 혹은 "2" 이외의 값을 입력시 "[ERROR] 1(야구 게임 다시 시작)과 2(게임 종료) 둘 중 하나만 입력 가능합니다" 출력 후 종료 확인 메시지 출력.



### 5. 게임 종료

* 야구 게임(BaseballGame) 종료 상태 발생시, 게임 결과 메시지 "3개의 숫자를 모두 맞히셨습니다! 게임 끝" 과

  종료 확인메시지 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요" 출력

* 종료 확인 메시지 출력 후, "2"을 입력 시 게임(Game) 완전 종료.

* 종료 확인 메시지 출력 후,  "1"을 입력 시 야구 게임(BaseballGame)  다시 시작. 





---



**메시지 정의**

* 게임 결과 메시지(GameResultMessage) : ""
* 종료 확인 메시지(ExitConfirmationMessage) : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"
* 종료 확인 에러 메시지(ExitConfirmationErrorMessage) :  "[ERROR] 1과 2 둘 중 하나만 입력 가능합니다"
* 입력 숫자 길이 에러 메시지 (InputNumberLengthErrorMessage) : "[ERROR] 3자리 숫자를 입력하십시오."
* 입력 값 에러 메시지(InputValueErrorMessage) : "[ERROR] 0-9 숫자를 입력하십시오"
* 입력 값 범위 에러 메시지(InputRangeValueErrorMessage) : "[ERROR] 서로 다른 숫자를 입력하십시오





