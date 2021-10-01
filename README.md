# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능 목록
* Model
  1. CompareResult
     * strike, ball, 시도갯수 정보 저장
     * isClear 클리어여부 boolean 반환
     * isNothing nothing 여부 boolean 반환
  2. Computer
     * length 길이만큼 중복되지 않는 랜덤숫자배열 생성
     * 사용자 입력값 받아서 비교로직 수행, CompareResult 로 반환 
* View
  1. GameView
     * 시작 메뉴 표시
     * 숫자 입력 요청
     * 비교결과 표시
     * 클리어 축하메세지 표시
* Controller
  1. GameController
     * 시작 메뉴 호출 후 사용자 입력 받은 값 1: 게임모드, 2: 종료
     * 게임모드에서는 맞출때까지 숫자 입력 요청 -> 결과비교 -> 게임끝을 반복
* Error
  1. "[Error] 메뉴범위 초과"
  2. "[Error] 숫자 외 입력"
  3. "[Error] 잘못된 숫자 입력"
  