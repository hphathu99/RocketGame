package game.enemy;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import renderer.ImageRenderer;

import java.util.Random;

public class EnemyPower extends GameObject {
    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    private Random random = new Random();
    public BoxCollider boxCollider;


    public EnemyPower() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyPowerShoot();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.velocity.set(1.5f,0);
        this.enemyShoot.run(this);
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
    }
}
