package baseball.game;

import java.util.*;
import nextstep.utils.Randoms;

public class game_playing{


    private static int SIZE=3;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private List<game_playing> game_playing;

    private int value;

    public game_playing(String num_str){
        List<game_playing> user_num=new ArrayList<>();

        for(String i : num_str.split("")){
            user_num.add(new game_playing());
        }
        num_check(user_num);
        this.game_playing=user_num;
    }

    public game_playing() {
        List<game_playing> computer_num = new ArrayList<>();
        while (computer_num.size() < SIZE) {
            game_playing random_num = new game_playing();
            add_Random_num(computer_num, random_num);
        }

        this.game_playing = computer_num;

    }

    private void add_Random_num(List<game_playing> game_playings, game_playing random_num){
       if(!game_playings.contains(random_num)){
           game_playings.add(random_num);

       }
    }

    private void num_check(List<game_playing> game_playings){
        Set<game_playing> set_num=new HashSet<>(game_playings);

        if(set_num.size()!=SIZE) {
            throw new IllegalArgumentException("3자리의 숫자로 입력해 주세요");
        }
    }


    public int strike_cnt(game_playing user_num){
        int cnt=0;
        for(int i=0;i<user_num.size();i++){
            cnt+=strike_chk(i,user_num.getGame_playings().get(i));
        }

        return cnt;
    }

    public int ball_cnt(game_playing user_num){
        int cnt=0;
        for(int i=0;i<user_num.size();i++){
            cnt+=ball_chk(i,user_num.getGame_playings().get(i));
        }
        return cnt;
    }


    private int strike_chk(int idx, game_playing num){
        if(game_playing.get(idx).equals(num)){
            return 1;
        }

        return 0;
    }

    private int ball_chk(int idx, game_playing num){
        if(strike_chk(idx,num)==0 && game_playing.contains(num)){
            return 1;
        }

        return 0;
    }


    public boolean End_chk(game_playing user_num){
        return strike_cnt(user_num)==3;
    }

    public boolean Nothing_chk(game_playing user_num){
        return strike_cnt(user_num)==0
                && ball_cnt(user_num)==0;
    }

    public boolean has_strike(game_playing user_num){
        return strike_cnt(user_num)!=0;
    }
    public boolean has_ball(game_playing user_num){
        return ball_cnt(user_num)!=0;
    }




    public List<game_playing> getGame_playings(){
        return game_playing;

    }

    public int size(){
        return game_playing.size();

    }

}
