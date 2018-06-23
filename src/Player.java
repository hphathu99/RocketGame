import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    public int x;
    public int y;
    public BufferedImage image;
    public int speedX;
    public int speedY;

    public Player(int x, int y, BufferedImage image, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void render(Graphics g){
//        g.drawImage(this.image, this.x, this.y, 32, 32, null);
        Graphics2D gr = (Graphics2D)g;
        gr.setColor(Color.RED);
        int xCoord[] = {x, x + 10, x + 50};
        int yCoord[] =  {y,y + 50, y + 20};
        gr.drawPolygon(xCoord, yCoord, 3);
    }

}
