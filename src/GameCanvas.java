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

    List<Star> stars;
    int countStar = 0;

    Enemy enemy;

    Player player;

    public ArrayList<Integer> listXStar = new ArrayList<Integer>();
    public ArrayList<Integer> listYStar = new ArrayList<Integer>();
    public ArrayList<Integer> ranStarSpeed = new ArrayList<Integer>();

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
        this.stars.forEach(star -> star.render(graphics));
        this.enemy.render(this.graphics);
        this.player.render(this.graphics);
        this.repaint();
    }

    public void runAll(){
        this.createStar();
        this.enemy.run(player);
        this.stars.forEach(star -> star.run());
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
        this.stars = new ArrayList<>();
        this.enemy = new Enemy(300, 200, this.loadImage("resources/images/circle.png"), 3, 3);
        this.player = new Player(500, 200, this. loadImage("resources/images/circle.png"), 5, 0 );
    }

    private void createStar(){
        if (this.countStar == 50) {
            Star star = new Star(1024, this.random.nextInt(600), this.loadImage("resources/images/star.png"), -this.random.nextInt(5) + 1, 0);
            this.stars.add(star);
            this.countStar = 0;
        }
        else{
            this.countStar++;
        }
    }
}
