package Snake;

import frmmain.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private int DELAY = 80;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    boolean inGame = true;
//    NewJFrame f;
//    JPanel pn;
    private int Score = 0;

    static Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

//    public Board(NewJFrame f, JPanel pn) {
//        this.f = f;
//        this.pn = pn;
//        addKeyListener(new TAdapter());
//        setBackground(Color.white);
//
//        ImageIcon iid = new ImageIcon(this.getClass().getResource("dot.png"));
//        ball = iid.getImage();
//
//        ImageIcon iia = new ImageIcon(this.getClass().getResource("ap.png"));
//        apple = iia.getImage();
//
//        ImageIcon iih = new ImageIcon(this.getClass().getResource("head.png"));
//        head = iih.getImage();
//
//        setFocusable(true);
//        initGame();
//    }

    public Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.white);

        ImageIcon iid = new ImageIcon(this.getClass().getResource("dot.png"));
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(this.getClass().getResource("ap.png"));
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon(this.getClass().getResource("head.png"));
        head = iih.getImage();

        setFocusable(true);
        initGame();
    }
//    Boolean rv;
//
//    Board(Boolean ex) {
//        if (ex) {
//            if (timer.isRunning()) {
//                timer.stop();
//            } else {
//                timer.start();
//            }
//        }
//    }

    public void initGame() {
//size dot
        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
//speedif

        timer = new Timer(DELAY, this);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
            g.dispose();

        } else {

            gameOver(g);

        }
    }

    public void gameOver(Graphics g) {
        String msg = "Game Over : " + Score + "..." + DELAY;
        Font small = new Font("Helvetica", Font.BOLD, 24);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2,
                HEIGHT / 2);
    }

    public void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            Score += 100;

            locateApple();
        }
    }

    public void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (left) {
            x[0] -= DOT_SIZE;
        }

        if (right) {
            x[0] += DOT_SIZE;
        }

        if (up) {
            y[0] -= DOT_SIZE;
        }

        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    public void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] > HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] > WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
    }

    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            checkCollision();
            move();

        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            if (inGame) {
                if ((key == KeyEvent.VK_LEFT) && (!right)) {
                    left = true;
                    up = false;
                    down = false;
                } else if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                    right = true;
                    up = false;
                    down = false;
                } else if ((key == KeyEvent.VK_UP) && (!down)) {
                    up = true;
                    right = false;
                    left = false;
                } else if ((key == KeyEvent.VK_DOWN) && (!up)) {
                    down = true;
                    right = false;
                    left = false;
                } else if ((key == KeyEvent.VK_ESCAPE && timer.isRunning())) {
                    timer.stop();
                    JOptionPane.showConfirmDialog(null, "Do you really wanna exit application?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (JOptionPane.YES_OPTION == 1) {
                        System.exit(0);
                    } else {
                        timer.start();
                    }
                } else if (key == KeyEvent.VK_SPACE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                } else if (key == KeyEvent.VK_R && timer.isRunning()) {
                    inGame = false;
                }
            } else if ((key == 's' || key == 'S') && timer.isRunning()) {

                inGame = false;
                //initGame();
            }
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        int result = JOptionPane.showConfirmDialog(this, "Do you really wanna exit application?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
