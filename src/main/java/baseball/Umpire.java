package baseball;

public class Umpire {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static int ballCount = 0;
    private static int strikeCount = 0;

    private Umpire() {
    }

    public static String compareNumber(int gamePlayerNumber, int computerNumber) {
        stringBuilder.setLength(0);
        String[] gamePlayerNumberArray = String.valueOf(gamePlayerNumber).split("");
        String[] computerNumberArray = String.valueOf(computerNumber).split("");
        setBallCount(gamePlayerNumberArray, computerNumberArray);
        setStrikeCount(gamePlayerNumberArray, computerNumberArray);
        setMessage();
        return stringBuilder.toString();
    }

    private static void setBallCount(String[] gamePlayerNumberArray, String[] computerNumberArray) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gamePlayerNumberArray[i].equals(computerNumberArray[j])) ballCount++;
            }
        }
    }

    private static void setStrikeCount(String[] gamePlayerNumberArray, String[] computerNumberArray) {
        for (int i = 0; i < 3; i++) {
            if (gamePlayerNumberArray[i].equals(computerNumberArray[i])) {
                strikeCount++;
                if (ballCount != 0) ballCount--;
            }
        }
    }

    private static void setMessage() {
        if (ballCount != 0) stringBuilder.append(ballCount + "볼 ");
        if (strikeCount != 0) stringBuilder.append(strikeCount + "스트라이크");
        if (ballCount == 0 && strikeCount == 0) stringBuilder.append("낫싱");
        ballCount = 0;
        strikeCount = 0;
    }
}
