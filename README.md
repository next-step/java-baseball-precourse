# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
---
## 프로그래밍 요구사항
- JDK 8 버전에서 실행가능해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 
- 람다는 사용 가능하다. 
- else 예약어를 쓰지 않는다.
- switch/case도 허용하지 않는다. 
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

---
## 구현 기능 목록
- 공은 숫자와 위치를 갖는다.
- 숫자는 1부터 9사이의 수이다.
- 숫자는 3자리를 갖는다.
- 각 숫자는 서로 다른 수이다.
- 같은 숫자와 같은 위치면 스트라이크 이다.
- 같은 숫자와 다른 위치면 볼이다.
- 수와 위치가 모두 다르면 낫싱이다.
- 세개의 수를 모두 맞추면 승리한다.
- 컴퓨터는 임의의 수 3개를 선택한다.
- 컴퓨터는 플레이어가 입력한 숫자에 대한 결과를 출력한다.
- 플레이어는 3개의 숫자를 입력한다.
- 플레이어가 승리하고 1을 입력하면 다시 시작한다.
- 플레이어가 승리하고 2를 입력하면 게임이 종료된다.
- 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.

