import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    int countStar = 0;

    List<Star> stars;

    Background background;

    public Player player = new Player();
    public Enemy enemy = new Enemy();

    private Random random = new Random();

    public GameCanvas(){
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemy.render(this.graphics);
        this.repaint();
    }

    public void runAll(){
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.runEnemy();
        this.player.run();
    }

    private BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (Exception e){
            return null;
        }
    }

    private void setupBackBuffered (){
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter(){
        this.background = new Background();
        this.stars = new ArrayList<>();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer(){
        this.player.position.set(100, 200);
    }

    private void setupEnemy(){
        this.enemy.position.set(800, 400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }

    private void createStar(){
        if (this.countStar == 100) {
            Star star = new Star();
            star.position.set(1024, random.nextInt(600));
            star.image = loadImage("resources/images/circle.png");
            star.velocity.set(this.random.nextInt(5) + 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        }
        else{
            this.countStar++;
        }
    }

    private void runEnemy(){
        Vector2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }

}
