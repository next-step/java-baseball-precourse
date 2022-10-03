package baseball;

import camp.nextstep.edu.missionutils.Randoms;


public class BaseballGame {
    private int mGameNum[];
    private int mInputNum[];
    private int mStrike = 0;
    private int mBall = 0;

    public BaseballGame() {
        mGameNum = new int[3];
    }

    public int[] getNum() {
        return mGameNum.clone();
    }

    public boolean setRandomNumber() {
        for (int i = 0; i < mGameNum.length; i++)
            mGameNum[i] = Randoms.pickNumberInRange(1, 9);

        return true;
    }

    private boolean checkVaildInputLength(String strnum) {
        if (strnum.length() != 3) {
            String errStr = "입력된 문자의 길이가 잘못되었습니다. -> " + strnum;
            throw new IllegalArgumentException(errStr);
        }
        return true;
    }

    private boolean checkVaildNumber(String strnum) {
        for (byte n : strnum.getBytes()) {
            if ((n & 0x30) != 0x30) {
                String errStr = "숫자가 아닌 값이 입력되었습니다. -> " + strnum;
                throw new IllegalArgumentException(errStr);
            }
        }
        return true;
    }

    private boolean checkZeroInNumber(String strnum) {
        for (byte n : strnum.getBytes()) {
            if (n  == 0x30) {
                String errStr = "0은 입력할 수 없습니다. -> " + strnum;
                throw new IllegalArgumentException(errStr);
            }
        }
        return true;
    }
    private boolean checkDuplicatNumber(String strnum) {
        int checkNum = 0;
        for (byte n : strnum.getBytes()) {
            n ^= 0x30;
            if ((checkNum & n) != 0) {
                String errStr = "중복된 숫자가 있습니다. -> " + strnum;
                throw new IllegalArgumentException(errStr);
            }
            checkNum = checkNum << n;
        }
        return true;
    }

    private boolean isVaildNumber(String strnum) {
        checkVaildInputLength(strnum);
        checkVaildNumber(strnum);
        checkZeroInNumber(strnum);
        checkDuplicatNumber(strnum);

        return true;
    }

    private int[] convertStr2IntArr(String strnum) {
        int res[] = new int[3];
        for (int i = 0; i < res.length; i++)
            res[i] = strnum.charAt(i) - 0x30;

        return res;
    }

    private boolean setMemberNumber(int[] number) {
        for (int i = 0; i < mGameNum.length; i++)
            mGameNum[i] = number[i];

        return true;
    }

    public boolean setNumber(String strnum) {
        isVaildNumber(strnum);
        int arrnum[] = convertStr2IntArr(strnum);
        setMemberNumber(arrnum);

        return true;
    }

    private boolean setStrike() {
        int strike = 0;
        for (int i = 0; i < mGameNum.length; i++) {
            if (mGameNum[i] == mInputNum[i]) strike++;
        }
        mStrike = strike;
        return true;
    }

    private int hasNumber(int[] numArray, int number) {
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == number) return 1;
        }
        return 0;
    }

    private boolean setBall() {
        int ball = 0;
        for (int n : mInputNum) {
            ball += hasNumber(mGameNum, n);
        }
        mBall = ball - mStrike;
        return true;
    }

    public int[] inputCompareNumber(String strnum) {
        isVaildNumber(strnum);
        mInputNum = convertStr2IntArr(strnum);

        setStrike();
        setBall();

        return new int[]{mStrike, mBall};
    }

    public int getStrike() {
        return mStrike;
    }

    public int getBall() {
        return mBall;
    }

    public void printNum() {
        for (int i = 0; i < mGameNum.length; i++)
            System.out.print(mGameNum[i]);
        System.out.println();
    }
}
