# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

* 랜덤 숫자 지정 #1
  ```
  Feature #1
  - 프로그램 시작 시 랜덤한 숫자 3자리를 생성
  ```

* 사용자 숫자 입력 처리 #2
  ```
  Feature #2
  
  Feature #2-1 사용자 입력 저장
  Feature #2-2 사용자 입력 Validation
  - 입력값 length check
  - 입력값의 숫자 check
  - 입력값의 숫자 범위 check
  - 입력값의 숫자 중복 check
  Feature #2-3
  - 허용된 값이 아닌 경우, 사용자에게 알림
  - 입력 다시 받기
  ```
* 숫자 판정 체크 #3
  ```
   Feature #3
   - 1번째 자리 비교, 스트라이크/볼/낫싱 판정
   - 2번째 자리 비교, 스트라이크/볼/낫싱 판정
   - 3번째 자리 비교, 스트라이크/볼/낫싱 판정
   - 숫자 판정 결과 출력
  ```
* 승리 판단 #4
  ```
  Feature #4
  - 
  ```
* 게임 종료 #6
  * 게임 재시작 #6-1
  * 프로그램 종료 #6-2
* 승리 판단 #7

## commit convention
### commit message template
```
<type>: <feature number> <subject>
<BLANK LINE>
<body>
```
### type
```
feat (feature)
fix (bug fix)
docs (documentation)
refactor
test (when adding missing tests)
```