package game.player;

import base.FrameCounter;
import base.GameObjectAttributes;
import base.GameObjectManager;

public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;
    public boolean shoot = false;

    public PlayerShoot(){
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player player) {
        if(this.frameCounter.run() && shoot == true){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}
