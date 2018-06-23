import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public int x;
    public int y;
    public int speedX;
    public int speedY;
    public BufferedImage imageEnemy;

    public Enemy(int x, int y, BufferedImage imageEnemy, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.imageEnemy = imageEnemy;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void run(Player player){
        int dx = this.x - player.x;
        int dy = this.y - player.y;
        boolean moving = true;
        double distance = Math.sqrt(dx*dx + dy*dy);
        double directionX = dx/distance;
        double directionY = dy/distance;

        if(moving) {
            this.x += directionX * speedX;
            this.y += directionY * speedY;
            if (dx == 0 && dy == 0) {
                moving = false;
            }
            if (this.x < 0 || this.x > 1024 - 20) {
                this.speedX = -this.speedX;
            }
            if (this.y < 0 || this.y > 600 - 20) {
                this.speedY = -this.speedY;
            }
        }
//        this.x += this.speedX;
//        this.y += this.speedY;
//        if (this.x < 0 || this.x > 1024 - 20)
//            this.speedX = -this.speedX;
//
//        if (this.y < 0 || this.y > 600 - 20)
//            this.speedY = -this.speedY;
    }

    public void render(Graphics g){
        g.drawImage(this.imageEnemy, this.x, this.y, 20, 20, null);
    }

}
