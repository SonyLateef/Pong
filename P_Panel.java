import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class P_Panel extends JPanel {

    Timer timer;
    Ball ball;
    Player player;

    public P_Panel(int width, int height) {
        setBounds(0,0,width, height);
        ball = new Ball(400, 400, 10, -3, 2);
        player = new Player(0, getHeight()/2);

        setupKeyListener();
        timer = new Timer(1000/60, e -> {
            ball.move(getWidth(), getHeight());
            repaint();
        });
        timer.start();
    }

    public void update(){
        Collision();
        repaint();
    }

    public void setupKeyListener(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.pressed(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.released(e.getKeyCode());
            }
        });
    }

    public void Collision(){
        if(player.getHitBox().intersects(ball.getHitBox()))
            ball.setVx(-ball.getVx());
            ball.setVy((-ball.getVy()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ball.draw(g2);
        player.draw(g2);
        Collision();
        player.move(getWidth());
    }

}