import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x, y, width, height;
    private boolean moveUp, moveDown;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 80;
        moveUp = false;
        moveDown = false;
    }

    public void draw(Graphics2D g2) {
        g2.fillRect(x, y, width, height);
    }

    public void move(int screenWidth) {
        if(moveUp)
            y -= 5;
            if(y + width > screenWidth)
                y = screenWidth - width;
        if(moveDown)
            y += 5;
            if(y < 0)
                y = 0;
    }

    public void pressed(int keyCode) {
        if(keyCode == KeyEvent.VK_W)
            moveUp = true;
        else if (keyCode == KeyEvent.VK_S)
            moveDown = true;
    }

    public void released(int keyCode) {
        if(keyCode == KeyEvent.VK_W)
            moveUp = false;
        else if (keyCode == KeyEvent.VK_S)
            moveDown = false;
    }

    public Rectangle getHitBox(){
        return new Rectangle(x,y,width,height);
    }
}
