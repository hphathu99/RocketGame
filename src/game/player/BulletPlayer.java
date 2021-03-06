package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemy.EnemyPower;
import physics.BoxCollider;
import physics.CheckCollision;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 8, 8);
        this.boxCollider = new BoxCollider(8, 8);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 4, this.position.y - 4);
        Enemy enemy = GameObjectManager.instance.checkCollision(this);
        if(enemy != null){
            enemy.isAlive = false;
            this.isAlive = false;
        }
        EnemyPower enemyPower = GameObjectManager.instance.checkCollision2(this);
        if(enemyPower != null){
            enemyPower.isAlive = false;
            this.isAlive = false;
        }
    }

}
