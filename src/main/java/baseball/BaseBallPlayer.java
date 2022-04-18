package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseBallPlayer {

  public ArrayList<Integer> getPlayerNumbers() {
    String readLine = Console.readLine();
    validPlayerNumber(readLine);

    ArrayList<Integer> playerNumber = getSeparateStringNumber(readLine);
    isValidNumberAfterSeparate(playerNumber);

    return playerNumber;
  }

  public void validPlayerNumber(String s) {
    for(char c : s.toCharArray()) {
      if(!Character.isDigit(c)) {
        throw new IllegalArgumentException();
      }
    }

    if(isValidLength(s.length(), 3)) {
      throw new IllegalArgumentException("세자리 수보다 크거나 작음");
    }
  }

  private boolean isValidLength(int s, int x) {
    return s != x;
  }

  public void isValidNumberAfterSeparate(ArrayList<Integer> numList) {
    Set<Integer> SetNum = new HashSet<>(numList);
    if(SetNum.contains(0)) {
      throw new IllegalArgumentException();
    }
    if(isValidLength(SetNum.size(), 3)) {
      throw new IllegalArgumentException();
    }
  }

  public ArrayList<Integer> getSeparateStringNumber(String readLine) {
    ArrayList<Integer> userNumberList = new ArrayList<>();

    userNumberList.add(getChatAt(readLine, 0));
    userNumberList.add(getChatAt(readLine, 1));
    userNumberList.add(getChatAt(readLine, 2));

    return userNumberList;
  }

  private int getChatAt(String readLine, int index) {
    return readLine.charAt(index) - '0';
  }

  public int confirmEndOrNew() {
    String readLine = Console.readLine();
    return Integer.parseInt(readLine);
  }

}
