## 요구 사항

* 상대방은 세 자리 난수를 생성한다
  * 중복 되지 않는 세 자리 난수 생성
* 사용자는 세 자리 숫자를 입력 받는다
  * 입력 가능한 값 : 1 ~ 9
  * 예외
    * 입력 값에 숫자가 아닌 값이 포함 된 경우
    * 중복된 값을 입력한 경우
    * 입력해야 하는 값보다 더 많거나 적은 값을 입력한 경우
    * 입력 값에 0이 포함 된 경우
* 상대방은 생성한 세 자리 난수와 사용자가 입력한 세 자리 숫자에 대한 결과를 출력한다
  * 자릿수와 숫자가 모두 일치할 경우 = 스트라이크
  * 숫자만 맞췄을 경우 = 볼 
  * 모든 난수에 대하여 자릿수와 숫자 모두 일치하지 않은 경우 = 낫싱
* 상대방은 생성한 세 자리 난수와 사용자가 입력한 세 자리 숫자가 일치하면 게임이 종료된다
* 사용자는 게임을 다시 시작하거나 완전히 종료할 수 있다

-- --

## 참고 사항

* **Library**
    * **Java**
        * JDK 8 사용할 것
        * JDK의 Random(), Scanner() 사용 금지
        * JDK 8의 stream api 사용 금지
        * lambda 사용 가능
        * camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용 —> 랜덤 값 추출
        * camp.nextstep.edu.missionutils.Console.readLine() 사용 —> 사용자 입력
    * **Test**
        * [JUnit5](https://www.baeldung.com/parameterized-tests-junit-5)
          , [AssertJ 사용](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion)
* **Test**
    * baseBall.ApplicationTest 의 2개 Test Case 성공
        * 별도 Test Case 생성 가능
    * Doamin Logic 단위 테스트 구현
        * UI 로직 제외
* **[Java Code Convention](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)**
    * indent, depth 는 2를 넘지 않도록 구현
    * else 문 사용 금지
    * switch/case 사용 금지
    * method 길이는 10라인을 넘지 않는다
        * Method가 한 가지 기능을 하도록 한다
* **Git**
    * **Commit**
        * **[Commit Message Convension](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)**
        * README에 정리한 기능 목록 단위로 Commit
        * Convention
            * ```
              <type>(<scope>): <subject>
              <BLANK LINE>
              <body>
              <BLANK LINE>
              <footer>
              ```
            * `<type>`
                * feat (feature)
                *  fix (bug fix)
                *  docs (documentation)
                *  style (formatting, missing semi colons, …)
                *  refactor
                *  test (when adding missing tests)
                *  chore (maintain)
            * `<scope>`
                * Scope could be anything specifying place of the commit change. For example $location, $browser, $compile, $rootScope, ngHref, ngClick, ngView, etc...
            * `<subject>`
                * use imperative, present tense: “change” not “changed” nor “changes”
                *  don't capitalize first letter
                *  no dot (.) at the end
            * `<body>`
                * The first line of the commit message should be a short description (50 characters is the soft limit), and should skip the full stop
                * just as in use imperative, present tense: “change” not “changed” nor “changes”
                *  includes motivation for the change and contrasts with previous behavior
            * `<footer>`
                * All breaking changes have to be mentioned in footer with the description of the change, justification and migration notes
                * Closed bugs should be listed on a separate line in the footer prefixed with "Closes" keyword
                    * ``` Closes #234, #245, #992 ```
