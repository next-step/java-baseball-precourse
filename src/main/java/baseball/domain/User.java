package baseball.domain;

import java.util.List;

public class User {
    private String readLine;
    private List<Integer> inputList;
    private List<StrikeZone> decisionList;
    private Decision decision;
    private boolean isEndPlay;

    public String getReadLine(){
        return readLine;
    }

    public void setReadLine(String readLine) {
        this.readLine = readLine;
    }

    public boolean getIsEndPlay(){
        return isEndPlay;
    }

    public void setIsEndPlay(boolean isEndPlay){
        this.isEndPlay = isEndPlay;
    }

    public List<Integer> getInputList(){
        return inputList;
    }

    public void setInputList(List<Integer> inputList) {
        this.inputList = inputList;
    }

    public List<StrikeZone> getDecisionList(){
        return decisionList;
    }

    public void setDecisionList(List<StrikeZone> decisionList) {
        this.decisionList = decisionList;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public Decision getDecision(){
        return decision;
    }
}
