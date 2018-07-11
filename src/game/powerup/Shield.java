package game.powerup;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import renderer.ImageRenderer;

import java.util.Random;

public class Shield extends GameObject {

    public BoxCollider boxCollider;
    private Random random = new Random();

    public Shield() {
        this.position = new Vector2D(random.nextInt(990) + 30, random.nextInt(570) + 30);
        this.renderer = new ImageRenderer("resources/images/powerup_shield.png", 30, 30);
        this.boxCollider = new BoxCollider(5, 5);
    }

    @Override
    public void run(){
        super.run();
    }

}
