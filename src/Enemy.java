import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    public Vector2D position;
    public Vector2D velocity;
    public BufferedImage image;
    public ArrayList<Bullet> list;
    private int countBullet = 0;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.list = new ArrayList<>();
        this.image = image;
    }

    public void run(){
        this.position.addUp(this.velocity);
//        this.createBullet(this);
//        list.forEach(bullet -> bullet.run());
    }

//    public void createBullet(Enemy enemy){
//        if (this.countBullet == 10) {
//            for(int i = 0; i < 10; i++){
//                Bullet bullet = new Bullet();
//                bullet.position.set(enemy.position);
//                bullet.velocity.set(new Vector2D(3.5f,0).rotate(i*60));
//                this.list.add(bullet);
//            }
//            this.countBullet = 0;
//        }
//        else{
//            this.countBullet++;
//        }
//    }

    public void render(Graphics g){
        g.drawImage(this.image, (int)this.position.x,(int) this.position.y, 20, 20, null);
        list.forEach(bullet -> bullet.render(g));
    }

}
