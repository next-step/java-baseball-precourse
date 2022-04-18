# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능목록

* TASK_TEST_001 : String 테스트

* TASK_TEST_002 : SET 테스트

* TASK_BASE_001 : NUMBER 검증 유틸
  1. 숫자 검증 및 기능 유틸 생성 
  
* TASK_BASE_002 : 스트라이크 존
  1. 랜덤 난수 3자리(서로 다른수) 생성

* TASK_BASE_003 : 투수 객체
  1. Scanner에서 입력받은 숫자를 검증하고 전달
  
* TASK_BASE_004 : 판정 Enum 생성
  1. 심판이 사용할 판정 및 출력 위한 Enum 생성
  
* TASK_BASE_005 : 룰
  1. 스트라이크 룰 작성 (같은 자리 같은 수)
  2. 볼 룰 작성 (다른 자리 같은 수)
  
* TASK_BASE_006 : 심판(룰 판정)
  1. Rule에 따라 판정 피드백
  
* TASK_BASE_007 : 플레이 컨트롤러
  1. 스트라이크 존 초기화
  2. 투수 초기화
  3. 심판 초기화
  4. 게임 진행
  5. 심판 판정에 따른 게임 진행 컨트롤
  6. 입력값에 따라 종료여부 판단