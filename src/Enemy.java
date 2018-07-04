import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameObject{
    public Vector2D velocity;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyBasicShoot();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        enemyShoot.run(this);
    }

    public void render(Graphics g){
        super.render(g);
        ((EnemyBasicShoot) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(g));
    }

}
