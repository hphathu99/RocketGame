import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bullet {
    public Vector2D position;
    public Vector2D velocity;
    public BufferedImage image;

    public Bullet(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
//        this.loadImage("resources/images/circle.png");
    }

//    private BufferedImage loadImage(String path){
//        try {
//            return ImageIO.read(new File(path));
//        } catch (Exception e){
//            return null;
//        }
//    }

    public void run(){
        this.position.addUp(this.velocity);
    }

    public void render(Graphics g){
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, 2, 2, null);
    }
}
