# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 요구사항
- 야구게임에서 상대방의 역할은 컴퓨터가 한다.
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 생성한다.
- 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력한다.
- 힌트를 얻는다.
  - 같은 수가 같은 자리에 있으면 스트라이크이다.
  - 다른 자리에 있으면 볼이다.
  - 같은 수가 전혀 없으면 포볼 또는 낫싱이다.
  - 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- 컴퓨터는 입력한 숫자에 대한 힌트(결과)를 출력한다.
- 위 과정을 반복하여 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 [ERROR]로 시작하는 에러 메시지를 출력하고 게임을 계속 진행할 수 있어야 한다.

## 기능 구현

### Domain

- Ball
  - play() : 해당 볼의 인덱스와 수를 비교하여 스트라이크, 볼, 낫싱 판별
- Balls
  - 볼 일급 컬렉션으로 3개의 볼을 관리
  - play() : 3개의 볼을 판별하여 PlayResult에 저장
- PlayResult
  - strike와 ball의 카운트를 저장
  - increaseCount() : 볼 상태에 따라 strike, ball 카운트 증가
  - isEndGame() : 게임 종료 판별
  - resultMessage() : 힌트 메시지 생성
- ComputerBaseballNumber
  - createNumbers() : 서로 다른 수 3개 생성 후 List로 반환
- UserBaseballNumber
  - createNumbers() : 유저가 입력한 수를 List로 반환
  - validate() : 입력한 수를 검증

### Controller

- BaseballGame
  - run()
    - 게임 시작
    - computerNumbers 생성
    - 게임 상태에 따라 재시작, 종료 판별
  - startGame()
    - 게임이 종료될 때까지 유저 입력 및 힌트 출력
    - 게임이 종료되면 입력에 따라 재시작, 종료 상태 변경
  - inputNumber()
    - 유저가 입력한 값을 검증을 거쳐 List로 반환
  - restartOrEndGame()
    - 게임 종료 후 입력에 따라 재시작, 종료 상태 변경

### View

- BaseballPrint
  - print(), println()을 통해 콘솔 출력
  
- BaseballInput
  - input() : 사용자 입력
  
### Exception

- ErrorMessage
  - 에러 메시지를 담은 enum 객체

- BaseballException
  - 에러 메시지 출력