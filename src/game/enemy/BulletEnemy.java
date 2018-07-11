package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physics.BoxCollider;
import renderer.ImageRenderer;

public class BulletEnemy extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        Player player = GameObjectManager.instance.checkCollision3(this);
        if(player != null){
            player.isAlive = false;
            this.isAlive = false;

        }
    }

}
