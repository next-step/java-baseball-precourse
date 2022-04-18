package baseball.rule;

import java.util.List;

public interface Rule {
    default boolean strike(Integer zone, Integer ball){
        return zone == ball;
    }

    default boolean ball(List<Integer> zones, Integer ball){
        return zones.contains(ball);
    }
}
