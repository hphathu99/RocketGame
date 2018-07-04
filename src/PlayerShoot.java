import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements PlayerAttack {

    public List<BulletPlayer> bulletPlayers;
    private int count;

    public PlayerShoot(){
        this.bulletPlayers = new ArrayList<>();
    }

    @Override
    public void run(Player player) {
        if(this.count == 30){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.count = 0;
        }
        this.count++;
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }
}
