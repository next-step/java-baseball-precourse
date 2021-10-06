# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

### 도메인
- Number
  - `Number`는 1에서 9까지의 숫자만 가진다
- Numbers
  - `Numbers`는 3자리의 서로 다른 `Number`를 가진다
- Rule
  - `Rule`은 `STRIKE`,`BALL`,`NOTHING`을 가진다
- Strike
  - `Strike`는 `Rule`과 개수를 가진다
- Ball
  - `Ball`는 `Rule`과 개수를 가진다
- Nothing
  - `Nothing`는 `Rule`을 가진다
- Score
  - `Score`은 `Strike`, `Ball`, `Nothing`을 가진다.
- RandomGenerator
  - `RandomGenerator`는 서로 다른 3자리 숫자를 생성한다
- Player
  - `Player`는 `Answer`를 가진다
  - `Player`는 3자리 숫자를 받는다.
- Game
  - `Game`은 `Player`를 가진다

### 요구사항
2. 상대방은 1에서 9까지 서로 다른 임의의 수 3개를 선택한다
   - 1부터 9까지 다른 수 
   - 3자리 수
3. 플레이어는 컴퓨터가 생각하는 3개의 숫자를 입력한다
   - 1부터 9까지 다른 수
   - 3자리 수
4. 컴퓨터는 입력한 숫자에 대한 결과를 출력한다
   - 스트라이크 : 같은 수가 같은 자리 (1스트라이크)
   - 볼 : 같은 수가 다른 자리 (1볼)
   - 포볼/나싱 : 같은 수가 전혀 없는 경우
5. 먼저 상대방의 수를 모두 맞추면 승리한다
6. 새로운 게임을 요청한다
   - 1: 재시작
   - 2: 종료

### 제약사항
- JDK 8에서 정상동작 하지 않을 경우 0점 처리한다
- nextstep.utils 패키지의 Random, Console API 사용한다
  - Random 값 추출 : Random.pickNumberInRange
  - 사용자 입력 : Console.readLine
- 구현 완료 후, ApplicationTest의 2개 테스트 케이스 성공 확인
- 숫자 야구 게임을 위한 모든 Test Case 추가
- 자바 코드 컨벤션을 지킨다 (https://naver.github.io/hackday-conventions-java/)
- indent depth는 1까지만 허용
- stream을 사용하지 않는다 (람다는 가능)
- else를 사용하지 않는다
- 함수는 10라인을 넘지 않는다
- 도메인 로직에 단위 테스트를 구현한다
- MVC 패턴으로 구현한다
- Model에 댛ㄴ 단위 테스트만 구현

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
