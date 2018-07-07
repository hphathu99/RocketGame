import java.awt.*;
import java.util.Random;

public class Player extends GameObject{
    public Vector2D velocity;
    public double angle = 0.0; // goc quay cua vector
    public Random random = new Random();
    public PlayerAttack playerAttack;
    public PlayerMove playerMove;


    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(0, 0),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.velocity = new Vector2D(3.5f, 0);
        this.playerAttack = new PlayerShoot();
        this.playerMove = new PlayerMove();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.playerAttack.run(this);
        this.playerMove.move(this);
        this.backToScreen();
    }

    public void backToScreen(){
        if (this.position.x < 0) {
            this.position.x = 1024 - 20;
            this.position.y = random.nextInt(600);
        } else if (this.position.x > 1024 - 20) {
            this.position.x = 0;
            this.position.y = random.nextInt(600);
        }
        if (this.position.y < 0) {
            this.position.y = 600 - 20;
            this.position.x = random.nextInt(1024);
        } else if (this.position.y > 600 - 20) {
            this.position.x = 0;
            this.position.y = random.nextInt(1024);
        }
    }
}
