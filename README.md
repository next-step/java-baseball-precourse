# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능 목록
* 임의의 서로 다른 3자리 숫자 생성 로직 개발
  * camp.nextstep.edu.missionutils.Randoms.pickNumberInRange 이용한 임의의 서로 다른 숫자 생성
* 사용자 숫자 입력 및 입력값 validation 로직 개발
  * 자리수에 맞지 않는 숫자 입력하거나, start/end 숫자 사이의 값을 입력하지 않은 경우 validation
* 임의의 3자리 숫자와 사용자가 입력한 3자리 숫자 비교 로직 개발
  * 동일한 자리에 존재하는 strike 숫자와 위치 상관없이 동일한 숫자 개수 찾아 비교
* 숫자 비교 결과에 따른 분기 처리 개발
  * 숫자 비교 결과 strike 수가 자리수와 동일하면 게임 종료
    * 종료 시, 다시 게임을 시작할 지 체크
  * 숫자 비교 결과 strike 수가 자리수와 동일하지 않으면, 사용자 입력 받아 다시 숫자 비교
* 각 로직들을 순차적으로 실행할 controller와 view 개발
  * view는 출력과 입력으로 각각 나누어 개발
* 각 로직에 따른 테스트코드 작성(도메인 영역에 한함)