import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static util.Value.*;


public class Run extends JPanel implements ActionListener, KeyListener {
    MapBoard board = new MapBoard();


    public void MyGame() {
        this.setFocusable(true);
        this.requestFocus();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(DISPLAY_Y + LEFT_THICK, DISPLAY_X + BOTTOM_THICK));
        this.addKeyListener(this);
        this.setVisible(true);
        add(board);
        LoadMap loadMap = new LoadMap(); // LoadMap 인스턴스 생성
        loadMap.LoadMap(); // 로드맵 호출
        repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        END_GAME = true;
        board.initWorld(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Run paint = new Run();
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paint.MyGame();
        frame.getContentPane().add(paint);
        frame.pack();
        frame.setResizable(false);

        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        iX = MAN_POSITION_X; // iX 새 좌표값, MAN_POSITION_X은 기존 좌표값
        iY = MAN_POSITION_Y; // iY 새 좌표값, MAN_POSITION_Y은 기존 좌표값

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                if (MAN == MAN_BACK) {
                    MAN = MAN_BACK;
                    iY = MAN_POSITION_Y - 2;
                }
                if (MAN == MAN_FRONT) {
                    MAN = MAN_FRONT;
                    iY = MAN_POSITION_Y + 2;
                }
                if (MAN == MAN_LEFT) {
                    MAN = MAN_LEFT;
                    iX = MAN_POSITION_X - 2;
                }
                if (MAN == MAN_RIGHT) {
                    MAN = MAN_RIGHT;
                    iX = MAN_POSITION_X + 2;
                }
                break;
            case KeyEvent.VK_HOME:
                LoadMap.LoadMap();
                repaint();
                return;
            case KeyEvent.VK_UP:
                MAN = MAN_BACK;
                --iY;
                break;
            case KeyEvent.VK_DOWN:
                MAN = MAN_FRONT;
                ++iY;
                break;
            case KeyEvent.VK_LEFT:
                MAN = MAN_LEFT;
                --iX;
                break;
            case KeyEvent.VK_RIGHT:
                MAN = MAN_RIGHT;
                ++iX;
                break;
            case KeyEvent.VK_PAGE_UP:
                stage++;
                LoadMap.LoadMap();
                repaint();
                return;
            case KeyEvent.VK_PAGE_DOWN:
                stage--;
                LoadMap.LoadMap();
                repaint();
                return;
            default:
                return;
        }
        repaint();
        ManMove.ManMove(iX, iY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}

