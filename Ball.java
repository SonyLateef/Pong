import java.awt.*;
public class Ball {

    int x, y, radius, vx, vy, width, height;

    public Ball(int x, int y, int radius, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
    }


    public void move(int width, int height){
        x += vx;
        y += vy;

        if(x + radius*2 >= width){
            vx *= -1;
            x = width - radius*2;
        }
        if(x <= 0){
            vx *= -1;
            x = 0;
        }
        if(y + radius*2 >= height){
            vy *= -1;
            y = height - radius*2;
        }
        if(y <= 0){
            vy *= -1;
            y = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void draw(Graphics2D g2){
        g2.fillOval(x, y, radius*2, radius*2);
    }

    public Rectangle getHitBox(){
        return new Rectangle(x, y, width, height);
    }

}
