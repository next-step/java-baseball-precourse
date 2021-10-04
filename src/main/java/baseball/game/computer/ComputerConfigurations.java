package baseball.game.computer;

import java.util.ArrayList;

public class ComputerConfigurations {

    ComputerNumber computerNumber = new ComputerNumber();
    NumberValidate numberValidate = new NumberValidate(computerNumber.getComputerRandomNumber());
    ArrayList<Boolean> validateResults = numberValidate.getValidateResults();

    private int validatedRandomNumber = configure();

    public int getValidatedRandomNumber() {
        return validatedRandomNumber;
    }

    public int configure() {
        while (validateResults.contains(false)) {
            computerNumber = new ComputerNumber();
            numberValidate = new NumberValidate(computerNumber.getComputerRandomNumber());
            this.validateResults = numberValidate.getValidateResults();
        }
        return computerNumber.getComputerRandomNumber();
        //return true;
    }
}
