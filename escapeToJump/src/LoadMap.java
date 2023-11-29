import world.Map;

import static util.Value.*;
import static world.Map.Stage;


public class LoadMap {
     public static char[][] map = new char[MAP_Y_SIZE][MAP_X_SIZE];
    public static void LoadMap() {
        for(int i = 0; i < Stage[stage].length; ++i){
            map[i] = Stage[stage][i].toCharArray();
        }
        MAN = MAN_FRONT;

    }

}
