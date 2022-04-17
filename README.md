# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.
## 구현 기능 목록
### 0. 공통코드 ( BBCODE )
* 시스템 전체에서 사용할 공통코드
  * NT : 일치하지 않음
  * OB : 원볼
  * TWB : 투볼
  * THB : 쓰리볼
  * OS : 원스트라이크
  * TWS : 투스트라이크
  * THS : 쓰리스트라이크
  * OBOS : 원볼원스트라이크
  * TWBOS : 투볼원스트라이크
  * OBTWS : 원볼투스트라이크
### 1. Controller ( BaseBallGameController )
#### 1-1 생성자  
* 최초 실행시 BaseBallGameModel 초기화
* 최초 실행시 BaseBallGameView 초기화
#### 1-2 게임실행준비 ( private void beforeGameStart() )
* Model의 setTargetNumber() 호출
* playGame() 호출
#### 1-3 게임진행 ( private void playGame() )
* 사용자에게 숫자 입력받아 BaseBallGameModel에 전달
* camp.nextstep.edu.missionutils.Console의 readLine()을 통해 값 입력받음
* Model의 validNumber()를 통해 검증 
* BaseBallGameModel의 validNumber의 Return이 THS인 경우 endGame() 호출, isContinue 호출
#### 1-4 게임재시작 여부 ( private void isContinue())
* 사용자에게 숫자 입력받아 목표 숫자 재설정 후 다시 실행할지 확인
* 1 입력시 beforeGameStart() 호출
* 2 입력시 종료
### 2. UI ( BaseBallGameView )
#### 2-1. protected void printCodeMean(BBCODE code)
* 전달받은 Enum의 코드값("TEXT") 호출 ( protected void printOut( BBCODE code ) )
#### 2-2. protected void reqNumber()
* 숫자를 입력해주세요 : 
#### 2-3. protected void endGame()
* 3개 숫자를 모두 맞추셨습니다! 게임종료
#### 2-4. protected void continueGame()
* 게임을 새로 시작하려면 1, 종료하려 2를 입력하세요.
### 3. Model ( BaseBallGameModel )
#### 3-1. 목표 숫자 설정 ( protected void setTarget() )
* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()을 이용
    * 100 - 999 사이의 값 가져오기
    * 각 자리수의 숫자가 모두 다른지 체크 후 하나라도 같다면 다시뽑기
#### 3-2. 입력받은 숫자 검증 ( protected BBCODE validNumber( String input ) )
* 사용자에게 전달받은 숫자를 보고 STATUS 값 리턴
#### 3-3. 볼이 몇갠지 확인 ( private String isBallCount(String input) ) 
* 사용자에게 전달받은 숫자에 볼이 몇갠지 리턴
#### 3-4. 스트라이크가 몇갠지 확인 ( private String isStrikeCount(String input) )
* 사용자에게 전달받은 숫자에 스트라이크가 몇갠지 리턴
## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
