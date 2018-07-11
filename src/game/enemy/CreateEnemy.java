package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;

import java.util.Random;

public class CreateEnemy extends GameObject {
    private FrameCounter frameCounter;
    private Random random = new Random();

    public CreateEnemy(){
        this.frameCounter = new FrameCounter(5);
    }

    public void run(){
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = new Enemy();
            enemy.position.set(1024, random.nextInt(600) + 1);

            GameObjectManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}
