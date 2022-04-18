package baseball.util;

public class BaseBallGameUtil {


  /**
   * int arr 중복체크
   *
   * @param arr
   * @param val
   * @return
   */
  public static boolean isDuplications(int[] arr, int val) {
    for (int value : arr) {
      if (value == val) {
        return true;
      }
    }
    return false;
  }

  /**
   * char Arr 중복체크
   *
   * @param arr
   * @param number
   * @return
   */
  public static boolean isDuplications(char[] arr, char number) {
    for (int value : arr) {
      if (value == number) {
        return true;
      }
    }
    return false;
  }

  /**
   * Stgring  -> Char Arr 변환
   *
   * @param str
   * @return
   */
  public static char[] stringToCharArr(String str) {
    char[] charArray = new char[str.length()];

    for (int i = 0; i < str.length(); i++) {
      charArray[i] = str.charAt(i);
    }

    return charArray;
  }

  /**
   * 비교 값 인덱스
   *
   * @param arr
   * @param value
   * @return
   */
  public static int getCompareValueAndGetIndex(final int[] arr, final int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return -1;
  }

}
