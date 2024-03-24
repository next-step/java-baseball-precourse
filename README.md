# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Project Structure
- src
  - main
    - java
      - NumberBaseballGameApplication.java
      - NumberBaseballGame.java
      - view
        - NumberBaseballGameView.java
      - domain
        - NumberBaseballGameRound.java
        - dto
          - GameResult.java
      - util
        - numberGenerator
          - NumberGenerator.java
          - RandomNumberGenerator.java
        - converter
          - IntegerListConverter.java
        - validator
          - NumberBaseballGameInputValidator.java
        - exception
          - NumberBaseballGameException.java
    - test
      - domain
        - NumberBaseballGameRoundTest.java

## 숫자야구 요구사항 목록
### USER
- [x] 사용자는 콘솔창에 3자리 숫자를 입력할 수 있다
- [x] 사용자가 3자리 숫자를 입력하면 판정결과가 콘솔창에 출력된다
- [x] 사용자가 콘솔창에 잘못된 값을 입력한 경우 [ERROR]로 시작하는 에러메시지가 출력되고, 이후 게임이 정상적으로 진행된다
- [x] 사용자가 정답을 맞춘 경우 게임이 종료되고, 이후 다시 시작하거나 시스템을 종료하는 안내메시지를 출력한다

## SYSTEM
- [x] 시스템은 게임이 시작되면 1~9사이의 서로 다른 수로 이루어진 3자리 숫자를 생성한다
- [x] 시스템은 사용자의 입력을 받으면 정답과 비교하여 판정 결과를 반환한다
