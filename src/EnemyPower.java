import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class EnemyPower extends GameObject{
    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    private Random random = new Random();

    public EnemyPower() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyPowerShoot();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.backToScreen();
        enemyShoot.run(this);
//        if(this.count == 30){
//            for(double angle = 0.0; angle < 360.0; angle += 360.0/10.0){
//                BulletEnemy bulletEnemy = new BulletEnemy();
//                bulletEnemy.position.set(this.position);
//                bulletEnemy.velocity.set(
//                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
//                );
//                this.bulletEnemies.add(bulletEnemy);
//            }
//            this.count = 0;
//        } else {
//            this.count += 1;
//        }
//        bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void render(Graphics g){
        super.render(g);
        ((EnemyPowerShoot) enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(g));
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
