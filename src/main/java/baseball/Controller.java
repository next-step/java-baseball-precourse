package baseball;

import java.util.ArrayList;
import java.util.List;

public class Controller { 
    public void gameStart(){
        Application.comNum = makeNumber();
        init();
    }
    public void init(){
        Application.strike = 0;
        Application.ball = 0;
        Application.nothing = 0;

        Application.ui.UI();
    }

    public List<Integer>makeNumber(){
        List<Integer> comNum = new ArrayList<Integer>();
        while(comNum.size() < 3){
            int random = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            if(comNum.contains(random)){break;}
            comNum.add(random);
        }
        return comNum;
    }

    public List<Integer> innerCheck(String inner){
        try{
            if(!inner.matches("-?\\d+") || inner.length()!=3){throw new IllegalAccessException();}
        }catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        List<Integer> result = innerList(inner);
        return result;
    }

    public List<Integer> innerList(String inner){
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i<inner.length();i++){
            String t = String.valueOf(inner.charAt(i));
            result.add(Integer.parseInt(t));
        }
        return result;
    }

    public void compare(List<Integer> inner){
        for(int i=0; i<Application.count; i++){
            throwBall(inner, i);
        }
        gameCheck();
    }

    public void throwBall(List<Integer> inner, int index){
        if((Application.comNum.get(index) == inner.get(index))&&Application.comNum.contains(inner.get(index))){
            Application.strike++;
            return;
        }
        if(!(Application.comNum.get(index) == inner.get(index))&&Application.comNum.contains(inner.get(index))){
            Application.ball++;
            return;
        }
        Application.nothing++;
    }

    public void gameCheck(){
        String result = score();
        System.out.println(result);
        if(Application.strike < 3){  
            init();
            return;
        }
        Application.ui.reGame();
        
    }

    public String score(){
        String result = "";
        if(Application.ball > 0){
            result+=Application.ball + " 볼";
        }
        if(Application.strike > 0){
            result+=Application.strike + " 스트라이크";
        }
        return result;
    }

    
}
