package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final static int MIN_LOCATION = 1;
    private final static int MAX_LOCATION = 3;
    private final static Map<Integer, Location> LOCATION_MAP;

    static {
        LOCATION_MAP = new HashMap<>();
        for (int location = MIN_LOCATION; location <= MAX_LOCATION; location++) {
            LOCATION_MAP.put(location, new Location(location));
        }
    }

    private final int location;

    private Location(int location) {
        this.location = location;
    }

    public static Location from(int location) {
        locationValid(location);
        return LOCATION_MAP.get(location);
    }

    private static void locationValid(int location) {
        if (!LOCATION_MAP.containsKey(location)) {
            throw new IllegalArgumentException("위치가 가능한 범위에 있지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return location;
    }
}
