
import static util.Value.*;
import static util.Value.MAN_POSITION_X;
import static world.Map.Stage;

public class ManMove {
    public  static void ManMove(int iX, int iY) {
        if (iX >= 0 && iX < MAP_X_SIZE && iY >= 0 && iY < MAP_Y_SIZE) {
            char[] MapLine = Stage[stage][MAN_POSITION_Y].toCharArray();
            if ('#' != LoadMap.map[iY][iX]) {
                if ('&' == LoadMap.map[iY][iX]) {
                    LoadMap.map[MAN_POSITION_Y][MAN_POSITION_X] = '&'; //@의 기존 위치를 '&'으로 만듦
                    LoadMap.map[iY][iX] = '@'; //@를 새로운 위치로 이동시킴
                } else if ('$' == LoadMap.map[iY][iX]) {
                    LoadMap.map[iY][iX] = ' ';
                } else if ('.' == LoadMap.map[iY][iX]) {
                    while ('.' == LoadMap.map[iY][iX]) {
                        if (MAN == MAN_BACK) {
                            MAN = MAN_BACK;
                            if (!(iY >= 3)) {
                                GAME_OVER = true;
                            }
                            iY = iY - 3;
                            if ('#' == LoadMap.map[iY][iX]) {
                                GAME_OVER = true;
                            }
                        } else if (MAN == MAN_FRONT) {
                            MAN = MAN_FRONT;
                            if (!(iY < MAP_Y_SIZE - 3)){
                                GAME_OVER = true;
                            }
                            iY = iY + 3;
                            if ('#' == LoadMap.map[iY][iX]) {
                                GAME_OVER = true;
                            }
                        } else if (MAN == MAN_LEFT) {
                            MAN = MAN_LEFT;
                            if (!(iX >= 3)) {
                                GAME_OVER = true;
                            }
                                iX = iX - 3;
                            if ('#' == LoadMap.map[iY][iX]) {
                                GAME_OVER = true;
                            }
                        } else if (MAN == MAN_RIGHT) {
                            MAN = MAN_RIGHT;
                            if (!(iX < MAP_X_SIZE - 3)){
                                GAME_OVER = true;
                            }
                                iX = iX + 3;
                            if ('#' == LoadMap.map[iY][iX]) {
                                GAME_OVER = true;
                            }
                        }

                    }

                    LoadMap.map[iY][iX] = '@';
                    if ('.' == LoadMap.map[MAN_POSITION_Y][MAN_POSITION_X]) {
                        LoadMap.map[MAN_POSITION_Y][MAN_POSITION_X] = '.';
                    } else {
                        LoadMap.map[MAN_POSITION_Y][MAN_POSITION_X] = '&';
                    }

                }
            }
        }
    }
}
