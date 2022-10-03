# Baseball game with Java (자바로 만드는 야구게임)

## Features

1. make application runnable (어플리케이션을 실행가능하게 만든다)
2. make random three digit number with 1~9 and store for a game (게임을 위해 3자리의 랜덤한 숫자를 1~9를 이용해 만들고 저장한다 )
3. take user's input and store it (user의 input을 받고 저장한다)
   - input should be 3-digit number (input은 3자리 숫자여야 한다)
   - input should not contain 0 -> need to think about this
   - input should not duplicate numbers -> need to think about this
4. compare two numbers (두 숫자를 비교한다)
   - same number same spot : strike (같은 숫자 같은 자리: 스트라이크)
   - same number different spot: ball (같은 숫자 다른 자리: 볼)
   - no same number: nothing (같은 숫자 없음: 낫싱)
5. return the result to user (결과를 리턴한다)
6. if user get three strikes then game should be over (스트라이크가 세번이 되면 게임을 종료한다)
   - user can start new game (유저는 게임을 다시 시작 할 수 있다)
   - user can choose to exit baseball game completely (유저는 야구 게임을 완전히 나갈 수 있다)