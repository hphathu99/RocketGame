import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;

    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    public ArrayList<Integer> listXStar = new ArrayList<Integer>();
    public ArrayList<Integer> listYStar = new ArrayList<Integer>();
    public ArrayList<Integer> ranStarSpeed = new ArrayList<Integer>();
    public int positionXEnemy = 500;
    public int positionYEnemy = 200;
    public int positionXPlayer = 500;
    public int positionYPlayer = 300;

    public GameCanvas(){
        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void getStar(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            listXStar.add(random.nextInt(1020));
            listYStar.add(random.nextInt(590));
            ranStarSpeed.add(random.nextInt(8) + 1);
        }
    }

    public void renderAll() {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, 1024, 600);
        for (int i = 0; i < 10; i++){
            graphics.drawImage(this.starImage, listXStar.get(i), listYStar.get(i), 5, 5, null);
        }
        graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 20, 20, null);
        graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 32, 32, null);
        this.repaint();
    }
}
