import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BulletEnemy extends GameObject {
    public Vector2D velocity;

    public BulletEnemy(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
    }


    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics){
        super.render(graphics);
    }
}
