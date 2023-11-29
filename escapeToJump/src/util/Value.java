package util;

import java.awt.*;

public class Value {
    public final static int IX_SIZE = 60; //Image X Size
    public final static int IY_SIZE = 60; //Image Y Size
    public final static int MAP_X_SIZE = 15; //Map X Size
    public final static int MAP_Y_SIZE = 15; //Map Y Size
    public final static int DISPLAY_X = IX_SIZE * MAP_X_SIZE; // Display X Size
    public final static int DISPLAY_Y = IY_SIZE * MAP_Y_SIZE; // Display Y Size
    public final static int LEFT_THICK = 150;
    public final static int BOTTOM_THICK = 100;
    public static String TITLE = "ESCAPE TO JUMP";

    public static Image WALL = Toolkit.getDefaultToolkit().getImage("src/resources/Wall.png");
    public static Image BOMB = Toolkit.getDefaultToolkit().getImage("src/resources/BOMB.png");
    public static Image PORTAL = Toolkit.getDefaultToolkit().getImage("src/resources/PORTAL.png");
    public static Image START = Toolkit.getDefaultToolkit().getImage("src/resources/Road.png");
    public static Image END = Toolkit.getDefaultToolkit().getImage("src/resources/END.png");
    public static Image MAN_FRONT = Toolkit.getDefaultToolkit().getImage("src/resources/MAN_FRONT.png");
    public static Image MAN_BACK = Toolkit.getDefaultToolkit().getImage("src/resources/MAN_BACK.png");
    public static Image MAN_LEFT = Toolkit.getDefaultToolkit().getImage("src/resources/MAN_LEFT.png");
    public static Image MAN_RIGHT = Toolkit.getDefaultToolkit().getImage("src/resources/MAN_RIGHT.png");
    public static Image MAN = MAN_FRONT;



    public static int stage = 0;

    public static int iX = 0;
    public static int iY = 0;

    public static int MAN_POSITION_X = 0;
    public static int MAN_POSITION_Y = 0;

    public static boolean END_GAME = true;

    public static boolean GAME_OVER = false;
}
