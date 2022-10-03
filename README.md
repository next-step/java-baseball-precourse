# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## [과제]기능 정리
* 게임 전체 로직 클래스 (BaseballGame)
  - 문자열 입력 받기(메소드)
  - 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
  - 재실행, 종료여부 판단
    - 입력값을 받아 1이면 재실행여부 true, 2이면 false로 준다


* 입력값 유효성 검증 (CheckValidation)
  - 3글자가 아니면 IllegalArgumentException 발생
  - 숫자가 아닌 다른문자가 들어오면 IllegalArgumentException 발생


* 랜덤숫자 생성 (RandomUtils)
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()을 사용한다
  - 1부터 9까지 서로 다른 수로 이루어진 3자리의 수


* 입력값을 비교를 위해 List 타입으로 변환 (ConvertUtils)


* 볼스트라이크 여부 확인 (BallAndStrike)
  - 같은 수가 같은 자리에 있으면 스트라이크
  - 다른 자리에 있으면 볼 
  - 같은 수가 전혀 없으면 낫싱
  - 결과값 출력 기능 
  

