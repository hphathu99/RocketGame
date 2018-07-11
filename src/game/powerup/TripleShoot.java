package game.powerup;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import renderer.ImageRenderer;

import java.util.Random;

public class TripleShoot extends GameObject {

    public BoxCollider boxCollider;
    private Random random = new Random();

    public TripleShoot(){
        this.position = new Vector2D(random.nextInt(1000) + 20, random.nextInt(580) + 20);
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run(){
        super.run();
    }
}
