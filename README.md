# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Todo

- [x] feat: architecture design - view(input, output), domain(), controller(Application)
- [x] test: Digit.isEqual should return true if it is equal to my digit
- [x] feat: add class Digit {value: int}, fn isEqual(int input) -> bool
- [x] test: add cases for Score.{addStrike, addBall}
- [x] feat: implement Score.{addStrike, addBall} to return renewed Score
- [x] test: Digits.match should return Score
- [x] feat: implement first class collection Digits, fn match - if value and index are equal => strike, else if value
  only equal => ball
- [x] test: add a case for Score.yield output
- [x] feat: implement Score.yield for each cases
- [x] feat: fn generate_digits() -> Digit[3]: random digits generator
- [x] feat: implement Input.scan()
- [x] test: add a case - parseStringToDigits
- [x] feat: implement Digits.parse(String input) -> Digits
- [x] feat: implement Output.print()
- [x] feat: implement loop in controller
- [x] test: add ScoreTest - isDoneIfThreeStrike
- [x] feat: implement Score.isDone()
- [x] feat: implement main logic(1 cycle) in Application with recursive play(Digit)
- [x] feat: implement Input.scanCommand
- [x] feat: 3 strike => scanCommand: 1) replay or 2) quit
- [x] fix: Digits.generate should return unique 3 digits
- [x] refactor: replace pickUniqueNumbersInRange() with pickNumberInRange() + manual logic
- [x] refactor: reduce indentations with extracting pickUniqueNumberInSubRange
- [x] test: add a case parseWrongStringGetsException
- [x] feat: IllegalArgumentException for wrong input
- [x] refactor: split play() from main to controller.Game.play()
- [x] refactor: reduce indentations with extracting Game.replay()
- [x] test: add a case - buildIntegersToDigits, adjust Digits.build() to other cases
- [x] feat: extract Digits.build()
- [x] refactor: extract Digits.renewDuplicated()
- [x] test: add CommandTest{shouldBeREPLAY, shouldBeQUIT, shouldThrowException, replayIsTrueQuitIsFalse}
- [x] feat: implement enum Command {of(), isReplay()}
- [x] test: add Digit case {shouldParseDigitCharToDigit, shouldThrowExceptionWithNonDigitChar}
- [x] rector: split Digits.parse and Digit.parse
- [x] test: add a Digits case digitsMoreOrLessThanThreeThrowException
- [x] feat: add Digits.validate(int length, String payload)