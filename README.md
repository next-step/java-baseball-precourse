# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
필 수
프로그래밍 요구사항1 - 제약사항

- 숫자야구게임을실행하는시작점은src/main/java폴더의baseball.Application의main()이다.
- 숫자야구게임은JDK8버전에서실행가능해야한다.JDK8에서정상동작하지않을경우0점처리한다.
- JDK에서제공하는Random및ScannerAPI대신camp.nextstep.edu.missionutils에서제공하
는Randoms및ConsoleAPI를사용하여구현해야한다.
- Random값추출은camp.nextstep.edu.missionutils.Randoms의pickNumberInRange()를활용한다.
- 사용자가입력하는값은camp.nextstep.edu.missionutils.Console의readLine()을활용한다.
- 프로그램구현을완료했을때src/test/java폴더의baseball.ApplicationTest에있는2개의TestCase가성공해야한
다.테스트가실패할경우0점처리한다.
- ApplicationTest에서제공하는2개의TestCase는숫자야구게임구현을위한최소한의TestCase이다.
- 필수요구사항은아니지만제공하는소스코드를참고해숫자야구게임을위한모든TestCase를추가해보는것도
테스트에대한좋은연습이될수있다.

프로그래밍 요구사항2 - 제약사항

- 자바코드컨벤션을지키면서프로그래밍한다.
- https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
[
4.2 블럭 들여쓰기: +4 스페이스
새 블록 또는 블록과 유사한 구조(block-like construct)가 열릴 때마다 들여쓰기가 네 칸씩 증가합니다. 블록이 끝나면 들여쓰기는 이전 들여쓰기 단계로 돌아갑니다. 들여쓰기 단계는 블록 전체의 코드와 주석 모두에 적용됩니다.

4.4 열 제한: 120
Java 코드의 열 제한은 120자입니다. "문자"는 유니코드 코드 포인트를 의미합니다.

4.5.2 들여쓰기 지속은 최소 +8 스페이스
줄 바꿈 시 그 다음 줄은 원래 줄에서 +8 이상 들여씁니다.

4.6.1 수직 빈 줄
...

빈 줄은 가독성을 향상시키기 위해서라면 어디든(예를 들면 논리적으로 코드를 구분하기 위해 문장 사이) 사용 될 수 있습니다. 클래스의 첫 번째 멤버나 초기화(initializer) 또는 마지막 멤버 또는 초기화(initializer) 뒤의 빈 줄은 권장되지도 비권장하지도 않습니다.

클래스의 첫 번째 멤버나 초기화(initializer) 앞에 있는 빈줄을 강제하지 않습니다.
]
- indent(인덴트,들여쓰기)depth를2가넘지않도록구현한다.1까지만허용한다.
- 예를들어while문안에if문이있으면들여쓰기는2이다.
- 힌트:indent(인덴트,들여쓰기)depth를줄이는좋은방법은함수(또는메소드)를분리하면된다.
- 자바8에추가된streamapi를사용하지않고구현해야한다.단,람다는사용가능하다.
- else예약어를쓰지않는다.
- 힌트:if조건절에서값을return하는방식으로구현하면else를사용하지않아도된다.
- else를쓰지말라고하니switch/case로구현하는경우가있는데switch/case도허용하지않는다.
- 함수(또는메소드)의길이가10라인을넘어가지않도록구현한다.
- 함수(또는메소드)가한가지일만잘하도록구현한다.

프로그래밍 요구사항3 - 단위 테스트

- 도메인로직에단위테스트를구현해야한다.단,UI(System.out,System.in,Scanner)로직은제외
- 핵심로직을구현하는코드와UI를담당하는로직을분리해구현한다.
- 힌트는MVC패턴기반으로구현한후View,Controller를제외한Model에대한단위테스트를추가하는것에집
중한다.
- JUnit5와AssertJ사용법에익숙하지않은개발자는첨부한"학습테스트를통해JUnit학습하기.pdf"문서를참고해
사용법을학습한후JUnit5기반단위테스트를구현한다.

과제 진행 요구사항
- 미션은https://github.com/next-step/java-baseball-precourse저장소를fork/clone해시작한다.
- 기능을구현하기전에docs/README.md파일에구현할기능목록을정리해추가한다.
- git의commit단위는앞단계에서docs/README.md파일에정리한기능목록단위또는의미있는단위로Commit
한다.
- 커밋메시지컨벤션참고해commitlog를남기려고노력해본다.
https://gist.github.com/stephenparish/9941e89d80e2bc58a153
- 과제진행및제출방법은프리코스과제제출문서를참고한다.

과제 제출 전 체크리스트 - 0점 방지
- 터미널에서“java-version”을실행해자바8인지확인한다.또는Eclipse,Intellij와같
은IDE의자바8로실행하는지확인한다.
- 터미널에서터미널에서Mac또는Linux사용자의경우“./gradlewcleantest”명령을
실행하고,Windows사용자의경우“gradlew.batcleantest”명령을실행할때모든테
스트가통과하는지확인한다.
------------------------------------------------------------------------------------------------------------------

기능 구현 순서
1. random num array 생성
camp.nextstep.edu.missionutils.Randoms의pickNumberInRange() 활용하여 랜덤숫자 3개를 생성하여 담는다.

Computer class 생성

2. 사용자 input 을 통해 array 생성
camp.nextstep.edu.missionutils.Console의readLine() 활용하여 세자리 수를 받아 담아둔다.

User class 생성

2-1. 예외 처리
사용자가잘못된값을입력할경우IllegalArgumentException을발생시킨후애플리케이션은종료되어야한다.
사용자가 잘못된 값 입력하는 경우
- 숫자가 아닌 문자를 입력한 case
- 숫자 3개를 입력하지 않은 case
- 1~9의 숫자 이외의 숫자를 입력한 case

User class 안에 예외 처리

3. 스트라이크 확인하기.
구현기능 1번과 2번에서 생성된 array를 각각의 인덱스 위치의 값들을 확인
동일하다면 스트라이크 값을 +1

4. 볼 확인하기.
구현기능 1번과 2번에서 생성된 array의 값이 각각의 인덱스를 제외한 곳에서
발견이 된다면 볼 값을 +1

5. 결과 안내.

5-1. 정답인 경우 case
정답 메시지를 출력 후 새로운 게임을 선택할지 종료할지 input값 받기 (input 값의 경우 1과 2가 아닌 경우 재 선택 메시지 뛰우기)
= 3스트라이크
  3개의숫자를모두맞히셨습니다!게임종료
  게임을새로시작하려면1,종료하려면2를입력하세요.


5-2. 틀린 경우 case
5-2-1. 스트라이크, 볼 모두 0 = 낫싱 
5-2-2. 스트라이크, 볼 하나라도 존재 = 1볼 1스트라이크 / 1스트라이크 / 1볼






