# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 목록

- Ball : 정답을 이루는 3자리 수 중 하나
  - 위치와 숫자를 가짐
  - 1 이상 9 이하의 숫자
  - 위치는 0 부터 시작
- BallSatus : Ball 끼리 비교한 결과 상태
  - STRIKE: 위치와 숫자가 모두 같음
  - BALL: 위치는 다르지만 숫자는 같음
  - NONE: 위치도 숫자도 모두 다름
- Balls : 정답을 의미하는 Ball 묶음
  - 사용자가 입력한 값과 비교해서 결과 (CompareResult) 를 반환
- CompareResult
  - 결과는 스트라이크, 볼 갯수를 포함
- BaseBallGame
  - 정답을 갖고 있는 상대방, Computer 와 같은 느낌
  - 사용자의 입력값을 정답과 비교해서 결과를 반환