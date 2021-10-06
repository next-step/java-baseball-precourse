# ⚾️ 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항 

* 사용자에게 세자리 수를 입력받는다
* 낫싱을 판별한다
* 스트라이크 수를 판별한다
* 볼 수를 판별한다


```
스트라이크: 같은 수 같은 자리
볼: 같은 수 다른 자리
낫싱 or 포볼: 같은 수가 없다
```

1. 컴퓨터가 상대방이다 (1-9까지 서로다른 임의의 수 세개 생성 )
2. 게임 플레이어 (이하 입력자)는 세개의 숫자를 입력하고,
값을 잘못 입력할 경우 [ERROR]로 시작하는 에러 메시지 출력 그 후 게임 계속 진행 
<br>
    ```
    잘못된 입력
        - 숫자가 아닌경우
        - 숫자가 세자리가 아닌경우
        - 숫자가 겹치는 경우
    ```
3. 입력자가 입력한 숫자에 대한 결과값을 반환한다.
4. 1-3의 과정을 반복, 3개의 숫자를 모두 맞추는 경우 게임이 종료
5. 다시 게임을 시작 or 게임을 완전 종료


## 구현할 기능 목록
### src/main/java/baseball/controller
  * BaseballGameController.java
    * 숫자 야구 게임을 시작하는 부분
    * 사용자에게 input 값을 받도록 요청
    * input value가 유효한지 ValidationService에 요청
    * 카운팅에 필요한 파라미터를 세팅하도록 CountingService에 요청

### src/main/java/baseball/view
* UserView.java
  * 사용자에게 input값을 요청하는 메시지를 프린트하고 결과 메시지를 생성하고 프린트하는 부분

### src/main/java/baseball/service
  * ValidationService.java
    * 사용자가 입력한 값이 올바른지 판별 요청하는 부분
  * CountingService.java
    * 사용자가 입력한 값을 토대로 카운팅에 필요한 파라미터를 생성하는 부분
    * Counting에 strike, ball 카운트를 요청

### src/main/java/baseball/domain
  * Validation.java
    * 입력 값이 유효한 값인지 판별
  * Counting.java
    * 입력과 관련하여 볼, 스트라이크를 카운팅, 낫싱을 판별해주는 부분

### src/main/java/baseball/vo
  * GameResult.java
    * strike와 ball의 count를 갖고있음