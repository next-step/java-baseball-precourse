### 기능 목록
1. 1~9 중 중복되지 않는 무작위 수 3개 뽑기
2. 사용자에게 3개의 수를 입력 받음
3. 사용자가 입력한 3개의 수가 위치까지 모두 일치하는지 검증하고 힌트 제공
    1. 일부 같은 수가 같은 위치에 있을 때: 스트라이크
    2. 일부 같은 수가 다른 위치에 있을 때: 볼
    3. 같은 수가 하나도 없을 때: 낫싱
    4. 모든 수와 위치가 일치하는 경우
        1. 정답 알림
        2. 다시 시작할지(1), 게임을 종료할지 사용자 입력 받음(2)
            1. 종료하면 애플리케이션 종료
            2. 다시 시작하면 1~3.iv.b까지 반복
    5. 사용자의 입력이 유효하지 않을 때: IllegalArgumentException 발생 후 애플리케이션 종료

### 프로그래밍 요구사항
- src/main/java/baseball.Application의 main 메소드에서 시작
- JDK8 버전에서 실행
- JDK의 Random, Scanner 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms, Console API 사용(pickNumberInRange, readLine)
- 프로그램 구현이 완료되면 src/test/java/baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야함
- 자바 코드 컨벤션([https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java))
- indent depth는 1까지만 허용함
- stream API 사용 불가, 람다는 사용 가능
- else절, switch문 사용 금지
- 함수의 길이는 최대 10라인을 넘어가지 말아야함
- 도메인 로직에 단위테스트 구현, UI(System.out, System.in, Scanner)로직은 제외
- 핵심로직과 UI로직 분리(MVC 패턴으로 구현한 후 View, Controller를 제외한 Model의 단위테스트에 집중)
- JUnit5 기반으로 단위테스트 구현