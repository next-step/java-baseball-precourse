package baseball.referee;

public class RefereeResult {

    private CompareResult compareResult;
    private String hint;

    public RefereeResult(CompareResult compareResult, String hint) {
        this.compareResult = compareResult;
        this.hint = hint;
    }

    public RefereeResult(CompareResult compareResult) {
        this.compareResult = compareResult;
    }

    public static RefereeResult create(CompareResult compareResult, String hint) {
        return new RefereeResult(compareResult, hint);
    }

    public static RefereeResult create(CompareResult compareResult) {
        return new RefereeResult(compareResult);
    }

    public CompareResult getCompareResult() {
        return compareResult;
    }

    public String getHint() {
        return hint;
    }

}
