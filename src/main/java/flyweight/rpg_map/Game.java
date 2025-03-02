package flyweight.rpg_map;

public class Game {
    public static void main(String[] args) {
        Map map = createMap("Wilderness"); // Change to "Wilderness" for WildernessMap
        map.display();
    }

    public static Map createMap(String type) {
        if ("City".equalsIgnoreCase(type)) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }
}
