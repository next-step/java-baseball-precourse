package baseball.logic;

import java.util.Collection;

public interface GameLogic {

	boolean process(Collection origin, Collection value);

	Object generateNumbers();

}
