package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class StrikeZone {

    public static final Integer ZONES_LENGTH = 3;

    private final List<Integer> ZONES;

    public StrikeZone(){
        this.ZONES = createZones();
    }

    public List<Integer> getZones(){
        return this.ZONES;
    }

    private List<Integer> createZones(){
        List<Integer> zones = new ArrayList<>(ZONES_LENGTH);
        for(int i=0, length = ZONES_LENGTH; i < length; i++){
            addZone(zones);
        }
        return zones;
    }

    private void addZone(List<Integer> zones){
        Integer zone = Randoms.pickNumberInRange(1, 9);
        if(!zones.contains(zone)){
            zones.add(zone);
            return;
        }
        addZone(zones);
    }
}