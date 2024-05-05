# java-baseball-precourse
## 기능 요구사항
- [x] 프로그램은 1에서 9까지 서로 다른 임의의 수 3개를 생성
- [x] 플레이어는 1에서 9까지의 서로 다른 3개의 숫자를 입력
    - 문자 입력, 0 입력, 3개가 아닌 숫자 입력, 같은 숫자 입력  
      &rarr; `IllegalArgumentException` 발생
- [x] 프로그램은 플레이어의 입력에 대한 결과를 출력
    - 같은 수 같은 자리 &rarr; 스트라이크
    - 같은 수 다른 자리 &rarr; 볼
    - 다른 수 &rarr; 낫싱
- [x] 플레이어가 프로그램이 생성한 3개의 숫자를 모두 맞히면 게임 종료
    - 플레이어는 게임을 다시 시작하거나 완전히 종료할 수 있음