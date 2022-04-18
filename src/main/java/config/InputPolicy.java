package config;

public class InputPolicy {
    public static boolean defaultPolicy(String userInput, int policyInputLength){
        try{
            if(userInput.length() != policyInputLength){
                return false;
            }

            Integer.valueOf(userInput);

            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }

    public static boolean addPolicyInMenu(String userInput){
        return userInput.equals("1") || userInput.equals("2");
    }
}
