import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Star extends GameObject{

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }
}
