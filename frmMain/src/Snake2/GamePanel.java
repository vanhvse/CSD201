/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author MocMel
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
//render
    private Graphics2D g2d;
    private BufferedImage image;
    //loop
    private Thread thread;
    private boolean running;
    private long targetTime;
//game stuff
    private final int SIZE = 50;
    private Entity head, apple;
    private ArrayList<Entity> snake;
    public static int score;
    private int level;
    private boolean gameover;
//movement
    private int dx, dy;
//key input
    private boolean up, right, down, left, start;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    //Set speed
    private void setFPS(int fps) {
        targetTime = 1000 / fps;
    }

    @Override
    public void run() {
        if (running) {
            return;
        }
        init();

        long startTime;
        long elapsed;
        long wait;
//system Time >> Speed
        while (running) {
            startTime = System.nanoTime();
            update();
            requestRender();
            elapsed = System.nanoTime() - startTime;
            wait = targetTime - elapsed / 1000000;
            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int k = ke.getKeyCode();
        if (k == KeyEvent.VK_UP) {
            up = true;
        }
        if (k == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (k == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (k == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (k == KeyEvent.VK_ENTER) {
            start = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int k = ke.getKeyCode();
        if (k == KeyEvent.VK_UP) {
            up = false;
        }
        if (k == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (k == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (k == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (k == KeyEvent.VK_ENTER) {
            start = false;
        }
    }

    private void init() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        running = true;
        setUPlevel();
        gameover = false;
        level = 1;
        setFPS(level * 10);
    }

    private void setUPlevel() {
        //head
        snake = new ArrayList<Entity>();
        head = new Entity(SIZE);
        head.setPosition(WIDTH / 2, HEIGHT / 2);//Center
        snake.add(head);
        //body
        //snake.first.length
        for (int i = 1; i < 4; i++) {
            Entity e = new Entity(SIZE);
            e.setPosition(head.getX() + (i * SIZE), head.getY());
            snake.add(e);
        }
        apple = new Entity(SIZE);
        setApple();
        score = 0;
        gameover = false;
        level = 1;
        dx = dy = 0;
        setFPS(level * 10);
    }

    public void setApple() {
        int x = (int) (Math.random() * (WIDTH - SIZE));
        int y = (int) (Math.random() * (HEIGHT - SIZE));
       //Eat box
        x = x - (x % SIZE);
        y = y - (y % SIZE);
        apple.setPosition(x, y);
    }
//layout

    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
//ve cac thuc the

    public void render(Graphics2D g2d) {
        //body
        g2d.clearRect(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.green);
        for (Entity e : snake) {
            e.render(g2d);
        }
        //apple
        g2d.setColor(Color.RED);
        apple.render(g2d);

        if (gameover) {
            g2d.drawString("GAME OVER!", 150, 200);
        }
        g2d.setColor(Color.WHITE);
        g2d.drawString("SCORE : " + score + "   Level : " + level, 10, 10);
        if (dx == 0 && dy == 0) {
            g2d.drawString("READY!", 150, 200);
        }
    }
//move

    private void update() {
        if (gameover) {
            if (start) {
                setUPlevel();
            }
            return;
        }
        //MOVE : up down left right
        if (up && dy == 0) {
            dy = -SIZE;
            dx = 0;
        }
        if (down && dy == 0) {
            dy = SIZE;
            dx = 0;
        }
        if (left && dx == 0) {
            dy = 0;
            dx = -SIZE;
        }
        if (right && dx == 0 && dy != 0) {
            dy = 0;
            dx = SIZE;
        }
        //go straight
        if (dx != 0 || dy != 0) {
            for (int i = snake.size() - 1; i > 0; i--) {
                snake.get(i).setPosition(
                        snake.get(i - 1).getX(),
                        snake.get(i - 1).getY()
                );
            }
            head.move(dx, dy);
        }
        //can duoi va chet==========================
        for (Entity e : snake) {
            if (e.isCollsion(head)) {
                gameover = true;
                break;
            }
        }

        //tang lvl cua ran
        // lenght ++===============================
        if (apple.isCollsion(head)) {
            score++;
            setApple();

            Entity e = new Entity(SIZE);
            e.setPosition(-100, -100);
            snake.add(e);
            if (score % 10 == 0) {
                level++;
                if (level > 10) {
                    level = 10;
                }

                setFPS(level * 5);
            }
        }

        //hack wall===================
        if (head.getX() < 0) {
            head.setX(WIDTH);
        }
        if (head.getY() < 0) {
            head.setY(HEIGHT);
        }
        if (head.getX() > WIDTH) {
            head.setX(0);
        }
        if (head.getY() > HEIGHT) {
            head.setY(0);
        }
    }
}
