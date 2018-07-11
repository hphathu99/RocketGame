package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class EnemyPowerShoot implements EnemyShoot{
    public FrameCounter frameCounter;

    public EnemyPowerShoot(){
        this.frameCounter = new FrameCounter(50);
    }

    @Override
    public void run(EnemyPower enemyPower) {
        if(this.frameCounter.run()){
            for(double angle = 0.0; angle < 360.0; angle += 360.0/10.0){
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemyPower.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3.0f, 0.0f)).rotate(angle)
                );
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }

    @Override
    public void run(Enemy enemy) {

    }
}
