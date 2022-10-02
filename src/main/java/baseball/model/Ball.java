package baseball.model;

import baseball.code.BallCount;
import baseball.code.BallValueRange;

public class Ball {
  private int value;
  private int index;

  public int getValue() {
    return value;
  }

  public int getIndex() {
    return index;
  }

  public void isBetweenNumberRange() {
    if (this.value < BallValueRange.MIN_NUMBER_RANGE.getValue()
        || this.value > BallValueRange.MAX_NUMBER_RANGE.getValue()) {
      throw new IllegalArgumentException("1-9까지의 숫자를 입력하세요.");
    }

    if (this.value == 0) {
      throw new IllegalArgumentException("잘못된 입력입니다.");
    }
  }

  public void isBetweenIndexRange() {
    if (this.index < BallValueRange.MIN_INDEX_RANGE.getValue()
        || this.index > BallValueRange.MAX_INDEX_RANGE.getValue()) {
      throw new IllegalArgumentException("서로 다른 세자리 수를 입력 하세요.");
    }
  }

  public BallCount compareBall(Ball ball) {
    if(this.index==ball.index && this.value ==ball.value){
      return BallCount.STRIKE;
    }

    if(this.index!=ball.index && this.value ==ball.value){
      return BallCount.BALL;
    }

    return BallCount.NOTHING;
  }

  public Ball(){}

  public Ball(BallBuilder ballBuilder){
    this.value = ballBuilder.value;
    this.index = ballBuilder.index;
  }

  public static class BallBuilder{
    private int value;
    private int index;

    public BallBuilder value(int value){
      this.value = value;
      return this;
    }

    public BallBuilder index(int index){
      this.index = index;
      return this;
    }

    public Ball build() {
      Ball ball = new Ball(this);
      ball.isBetweenIndexRange();
      ball.isBetweenNumberRange();
      return ball;
    }
  }
}
