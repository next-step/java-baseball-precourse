# 미션 - 숫자 야구 게임

## 구현할 기능 목록

- [숫자 생성]

  - `1에서 9까지 서로 다른 수`로 이루어진 `세 자리 수`를 생성한다.
  - `세 자리 수 두 개를 비교`하여 결과를 출력한다.
      - 같은 수가 같은 자리에 있으면 `스트라이크` 출력.
      - 같은 수가 다른 자리에 있으면 `볼` 출력.
      - 같은 수가 전혀 없으면 포볼 또는 `낫싱` 출력.



- [게임 진행]

  1. 플레이어에게 세 자리 수를 입력받는다.
     - 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine()**을 활용한다.
  2. 컴퓨터가 생성한 1부터 9까지 서로 다른 임의의 수로 구성된 세 자리수와 비교한다.
     - camp.nextstep.edu.missionutils의 **Randoms** API의 **pickNumberInRange()** 활용.
  3. 숫자를 모두 맞힐 때까지 반복하고, 숫자를 모두 맞히면 게임을 종료한다.
  4. 게임이 종료되면 입력을 받아 게임을 다시 시작하거나 완전히 종료한다.
  5. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료한다.
  


- [예외 처리]
  - 세 자리 수가 아닌 값을 입력했을 때 예외를 발생시킨다.
  - 1에서 9까지 수가 아닌 값을 입력했을 때 예외를 발생시킨다.


## ✔️ Commit Conventions
- feat: 기능 관련 커밋
- fix: 버그 수정 관련 커밋
- docs: 문서 관련 커밋
- refactor: 기능 수정 관련 커밋
- test: 테스트 관련 커밋

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.


