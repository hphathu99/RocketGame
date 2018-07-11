package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.powerup.Shield;
import physics.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Vector2D velocity;
    public double angle = 0.0; // goc quay cua vector
    public BoxCollider boxCollider;

    public Player() {
        this.velocity = new Vector2D();
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(0, 0),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.boxCollider = new BoxCollider(20, 16);
    }

    @Override
    public void run() {
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        Shield shield = GameObjectManager.instance.checkCollision4(this);
        if(shield != null){
//            createShield();
            for(int i = 0; i < 3; i++){
                if(!this.isAlive){
                    this.isAlive = true;
                }
            }
        }
    }

//    public void createShield(Graphics g){
//        g.drawOval((int) this.position.x, (int) this.position.y, 25, 25);
//    }


}
