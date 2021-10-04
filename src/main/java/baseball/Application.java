package baseball;

import baseball.printing_sol.output_sol;
import baseball.printing_sol.input_sol;
import baseball.game.game_playing;

public class Application {

    public static void main(String[] args) {
    	
        do{
            game_play();

        }
        while(input_sol.continue_game());

    }
    
    private static void game_play(){
        game_playing computer_num = new game_playing();
        game_playing user_num;

        do{
            user_num=input_sol.input_num();
            output_sol.result_print(computer_num, user_num);
        }
        while(!computer_num.End_chk(user_num));
        output_sol.print_end_msg();
    }
    
}
