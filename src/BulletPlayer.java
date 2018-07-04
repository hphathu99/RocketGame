import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;

    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 8, 8);
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }

    public void render (Graphics graphics){
        super.render(graphics);
    }
}
