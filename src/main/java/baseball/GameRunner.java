package baseball;

public class GameRunner {
    public void run() {
        boolean isVictory = false;
        Computer computer = new Computer();

        while(!isVictory) {
            Player player = new Player();
            Judgement judgement = new Judgement(computer.getRandomNums(), player.getPlayerNumbers());
            isVictory = judgement.judge();
            System.out.println(judgement.printJudgeResult());
        }

        System.out.println(OutputView.VICTORY_WORD);
    }

}
