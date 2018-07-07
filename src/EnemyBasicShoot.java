import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnemyBasicShoot implements EnemyShoot {
    private FrameCounter frameCounter;

    public EnemyBasicShoot(){
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Enemy enemy) {
        if(this.frameCounter.run()){
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(new Vector2D(3.0f, 0.0f)).rotate(270);
            GameObjectManager.instance.add(bulletEnemy);
            frameCounter.reset();
        }

    }

    @Override
    public void run(EnemyPower enemyPower) {

    }
}

