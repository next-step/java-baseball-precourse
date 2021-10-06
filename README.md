# 야구게임 모델소개
## BallCount
* 컴퓨터가랜덤으로 뽑은 값과 유저가 입력한 값 2개를 파라미터로 받아 배열로 깊이와 길이로 비교하여 스트라이크 볼을 판단하 그 결과를 반환한다

## RandomValueModel
 * 컴퓨터가 랜덤한 3자리의 숫자를 뽑아 반환한다.
 
## ReGame
 * 3스트라이크 이후 개임 종료 또는 속행 여부 판단을 위한 입력을 받는다.

##SeparateNumber
 * 3자리 숫자를 연산을 통해 3자리배열로 반환한다.

##UserInputValue
 * 유저가 입력한 값 게임의 규칙에 맞게 검증하여 int 형태로 한다.

##BaseballGameController 
 * 게임 클리어시 속행과 종료를 위한 컨트롤러

##GameStartController
 * 최초 게임 시작을 위한 컨트롤러
 * UserInputValue에서 생성된 Exception을 처리