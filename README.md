# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

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
-  indent(인덴트,들여쓰기)depth를2가넘지않도록구현한다.1까지만허용한다.
- 예를들어while문안에if문이있으면들여쓰기는2이다.
- 힌트:indent(인덴트,들여쓰기)depth를줄이는좋은방법은함수(또는메소드)를분리하면된다.
- 자바8에추가된streamapi를사용하지않고구현해야한다.단,람다는사용가능하다.
- else예약어를쓰지않는다.
- 힌트:if조건절에서값을return하는방식으로구현하면else를사용하지않아도된다.
- else를쓰지말라고하니switch/case로구현하는경우가있는데switch/case도허용하지않는다.
- 함수(또는메소드)의길이가10라인을넘어가지않도록구현한다.
- 함수(또는메소드)가한가지일만잘하도록구현한다

프로그래밍 요구사항3 - 단위 테스트
- 도메인로직에단위테스트를구현해야한다.단,UI(System.out,System.in,Scanner)로직은제외
- 핵심로직을구현하는코드와UI를담당하는로직을분리해구현한다.
- 힌트는MVC패턴기반으로구현한후View,Controller를제외한Model에대한단위테스트를추가하는것에집
중한다.
- JUnit5와AssertJ사용법에익숙하지않은개발자는첨부한"학습테스트를통해JUnit학습하기.pdf"문서를참고해
사용법을학습한후JUnit5기반단위테스트를구현한다

과제 진행 요구사항
- 미션은https://github.com/next-step/java-baseball-precourse저장소를fork/clone해시작한다.
- 기능을구현하기전에docs/README.md파일에구현할기능목록을정리해추가한다.
- git의commit단위는앞단계에서docs/README.md파일에정리한기능목록단위또는의미있는단위로Commit
한다.
- 커밋메시지컨벤션참고해commitlog를남기려고노력해본다.
- 과제진행및제출방법은프리코스과제제출문서를참고한다.

과제 제출 전 체크리스트 - 0점 방지
- 터미널에서“java-version”을실행해자바8인지확인한다.또는Eclipse,Intellij와같
은IDE의자바8로실행하는지확인한다.
- 터미널에서터미널에서Mac또는Linux사용자의경우“./gradlewcleantest”명령을
실행하고,Windows사용자의경우“gradlew.batcleantest”명령을실행할때모든테
스트가통과하는지확인한다.
