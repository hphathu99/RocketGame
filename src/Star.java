import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star {

//    public int x;
//    public int y;
//    public BufferedImage image;
//    public int velX;
//    public int velY;
//
//    public Star(int x, int y, BufferedImage image, int velX, int velY) {
//        this.x = x;
//        this.y = y;
//        this.image = image;
//        this.velX = velX;
//        this.velY = velY;
//    }

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.image = image;
        this.velocity = new Vector2D();
    }

    public void run(){
        this.position.addUp(this.velocity);
    }

    public void render (Graphics g){
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
    }
}
