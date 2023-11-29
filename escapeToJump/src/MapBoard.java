import javax.swing.*;

import java.awt.*;

import static util.Value.*;
import static world.Map.Stage;

public class MapBoard extends JPanel {
    static Image aImage;


    void initWorld(Graphics g) {
        while (true) {
            for (int iY = 0; iY < MAP_Y_SIZE; ++iY) {
                char[] MapLine = Stage[stage][iY].toCharArray();
                for (int iX = 0; iX < MAP_X_SIZE; ++iX) {
                    switch (LoadMap.map[iY][iX]) {
                        case '#':
                            aImage = BOMB;
                            break;
                        case '@':
                            aImage = MAN;
                            MAN_POSITION_X = iX;
                            MAN_POSITION_Y = iY;
                            break;
                        case '$':
                            aImage = END;
                            if ('$' == MapLine[iX]) {
                                END_GAME = false;
                            }
                            break;
                        case '&':
                            aImage = START;
                            break;
                        case '.':
                            aImage = PORTAL;
                            break;
                        default:
                            aImage = WALL;
                            break;
                    }
                    g.drawImage(aImage, iX * IX_SIZE + 75, iY * IY_SIZE + 50,this);
                }
                System.out.println(LoadMap.map[iY]); //디버깅 코드
            }
            if (END_GAME == true) {
                ++stage;
                if (Stage.length <= stage) {
                    JOptionPane.showMessageDialog(null, "종료");
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(null, "NEXT STAGE");
                LoadMap.LoadMap();
                continue;
            } else if (GAME_OVER == true) {
                JOptionPane.showMessageDialog(null, "GAME OVER \n PRESS BUTTON HOME");
                ++stage;
                --stage;
                LoadMap.LoadMap();
                repaint();
                GAME_OVER = false;
            }
            break;
        }
    }
}

