# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## ︎📝 구현할 기능 목록
* 상대방(컴퓨터)의 역할을 하는 Computer가 가질 랜덤 숫자 3개 생성
    * 단, 1 ~ 9까지 숫자를 가지며, 각 숫자는 중복되지 않음
    * 게임이 새로 시작될 때까지, 랜덤 숫자 3개는 변경되지 않음 : Singleton, Builder 패턴 고려
* Controller(Operator)가 Computer에게 야구게임의 랜덤 숫자 3개를 가지도록 메시지 전달
* Computer가 야구게임의 랜덤 숫자 3개를 가짐
* Controller(Operator)가 Player로부터 숫자를 입력받아 임시저장을 한 뒤, 이를 Computer에게 전달
  * 이 때, Validator를 통해 값을 검증한다.
    > 검증 내용 : 입력값이 null, "", 3자리 미만 또는 초과, 0이 입력되면 입력한 값을 Computer에게 전달하지 않고,
    IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
  * 정상적으로 값이 입력이 되었다면, Player를 통해 입력받은 값을 보관하고 있도록 메시지를 보낸다.
* Computer가 Controller(Operator)로부터 전달받은 야구게임의 입력값에 대해 게임의 결과를 판단하고,
  Controller(Operator)에게 결과를 반환
  * 결과값은 enum으로 정리해서, else 키워드 사용 방지 및 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현

## ︎💡 구현할 기능 후보 목록(브레인 스토밍)
### ☕️ 객체 종류
* Computer : 상대방(컴퓨터)의 역할, 랜덤 숫자 3개를 가짐
* Player : 게임 플레이어는 컴퓨터가 선택한 숫자라고 생각되는 3개의 숫자를 입력
* Operator : 게임 진행자(MVC의 Controller 역할 담당. Computer의 기능 분리). 상대방(컴퓨터)이 가진 숫자 3개와 게임 플레이어가 제시한 숫자를 비교

### 🖨 게임 규칙을 사용자에게 출력
* MVC의 View단 - 문자열 출력 확인

### 🤹🏼 Operator(컨트롤러)
* Player가 입력한 값을 Computer에게 전달한다.
* Player가 입력한 값에 따라, Computer가 처리한 값을 전달받아, Player에게 응답
    * 이 때, 입력값이 3자리 미만 또는 초과, 0이 입력되면 입력한 값을 Computer에게 전달하지 않고,
      IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 💻 Computer
* 고정된 3자리의 숫자가 숫자 야구 게임의 컴퓨터가 제시한 숫자라고 가정하고, 같은 숫자가 Test Case에서 성공하는지 확인하는 Test Case
* 컴퓨터가 제시한 숫자라고 가정한 숫자의 길이가 3자리인지 확인하는 Test Case
    * Enum 또는 static final
* 컴퓨터가 제시한 숫자라고 가정한 숫자에서 중복된 숫자가 있는지 확인하는 Test Case
* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 통한 난수 발생 확인 Test Case
* 난수의 길이가 3자리인지 확인하는 Test Case
    * camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange()를 사용하는
      camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest() 사용
* 난수에서 중복된 숫자가 있는지 확인하는 Test Case
* 난수 3자리를 발생시키는 구문을 별도의 method로 작성하고 이름을 초기화 또는 설정과 관련된 이름을 method명으로 지정한 뒤,
  이 method호출이 성공하는지 확인하는 Test Case
* 난수 3자리를 발생시키는 구문을 별도의 method를 @BeforeAll로 설정(?)
* 야구 게임을 시작할 때에 3자리 숫자를 생성한 뒤, Operator에게 게임 시작 메시지 전달
* Operator가 전달해준 Player의 입력값에 따라, 야구 게임의 결과를 저장하고, Operator에게 결과를 가져가도록 메시지 전달

### 🧑🏻‍💻Player
* camp.nextstep.edu.missionutils.Console의 readLine()을 통한 입력 테스트
* baseball package의 ApplicationTest.게임종료_후_재시작() Test Case 성공 테스트
* Computer -> Operator -> Player 순서로 전달받은 결과를 보고, Operator에게 문제의 답이라고 생각되는 값을 전달


### ✏️ 기타
* baseball package의 ApplicationTest.예외_테스트() Test Case 성공 테스트
* 3개의 숫자를 모두 맞춘다음, 게임을 새로 시작하려면 1, 종료하려면 2를 입력한다.
    * 이 때 1과 2를 제외한 숫자가 입력되는지 Test Case 작성

## ⚽ 진행방식
* 미션은 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항 세 가지로 구성
* 기능 구현하기 전에 기능 목록을 만들고, 기능 단위로 commit
* 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현

## 💬 기능 요구사항
* 1 ~ 9까지 서로 다른 수로 이뤄진 3자리 수를 맞추는 게임
* 상대방(컴퓨터)의 숫자 3개 중에서 사용자가 제시한 숫자와 매칭되는 것을 체크했을 때에, 같은 수가 같은 자리에 있으면
  스트라이크, 다른 자리에 있으면 볼, 매칭되는 숫자가 없어서 같은 수가 전혀 없으면 낫싱이라는 힌트를 사용자에게 제시하여
  그 힌트를 이용해서 상대방(컴퓨터)의 수를 맞추면 승리.
    * [예] 상대방(컴퓨터)의 수가 425일때,
    * 123을 제시한 경우 : 1스트라이크
    * 456을 제시한 경우 : 1볼 1스트라이크
    * 789를 제시한 경우 : 낫싱
* 컴퓨터는 1~9까지 서로 다른 임의의 수 3개를 선택.
* 게임 플레이어는 컴퓨터가 선택한 숫자라고 생각되는 3개의 숫자를 입력.
* 컴퓨터는 입력한 숫자에 대한 결과를 출력
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ‍💻 프로그램 실행 결과
* 숫자를 입력해주세요 : 123
    * 1볼 1스트라이크
* 숫자를 입력해주세요 : 145
    * 1볼
* 숫자를입력해주세요 : 671
    * 2볼
* 숫자를 입력해주세요 : 216
    * 1스트라이크
* 숫자를 입력해주세요 : 713
    * 3스트라이크
* 3개의 숫자를 모두 맞히셨습니다! 게임 종료
* 게임을 **새로 시작**하려면 **1**, **종료**하려면 **2**를 입력하세요.
    * 1
* 숫자를 입력해주세요:123
    * 1볼
* ...
* 