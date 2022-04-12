# 프리코스 1주차

## 기능
- Character: 1이닝에 해당하는 play 추상 메소드 설계. 조준 위치는 중복이 없도록 설계.
  - Computer: 게임 한 세트가 시작될 때, 번호 초기화
  - Player: 1이닝 때마다 번호 초기화
- BaseballGame: 반복문을 구현해서 지속성 있도록 만들고, 프론트 컨트롤러 역할을 해주는 객체
  - 새로 시작시, 재귀 호출해서 스택에 쌓이게 되는 현상을 막고 싶다. => Map과 Lambda를 통해 라우팅될 뷰를 받도록 설계해보자.
- Score: 점수 계산을 위임받는다. 
  - 숫자를 하나씩 비교하는 과정을 `라운드`라고 정의한다.
  - 각 Enum 프로퍼티가 자신의 점수를 계산할 수 있도록 설계하자.
  - Score 타입을 찾는 로직은 Enum 자신이 들고 있지는 않아도 될것 같다.
- BaseBallController
- View
  - InputView
  - CompleteMenuView
- INPUT_LENGTH constant

## 아쉬운점
- 현실에서도 어색하지 않아야되는데, play 메소드가 어색하다.
  - 플레이어의 경우 play()는 이닝이지만, 컴퓨터의 경우 play()는 1 Game이다.
- 컨트롤러에서 뷰와 api를 분리하지 못했다.
  - 완전히 분리하려고 하니, 그 영향이 BaseballGame 객체까지 전파됐다.
  - 컨트롤러와 BaseballGame이 필요 이상으로 거대해진다고 생각이 들었다.