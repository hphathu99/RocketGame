import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;
    public int enemySpeedX = 2;
    public int enemySpeedY = 2;
    public int ranPlayerPosY = 0;
    public int ranStarSpeed = 0;

    public GameWindow(){
        this.setSize(1024,600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Random rand = new Random();
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(gameCanvas.positionXPlayer < 10){
                        ranPlayerPosY = rand.nextInt(570);
                        gameCanvas.positionYPlayer = ranPlayerPosY;
                        gameCanvas.positionXPlayer = 1020;
                    } else {
                        gameCanvas.positionXPlayer -= 5;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(gameCanvas.positionXPlayer > 980){
                        ranPlayerPosY = rand.nextInt(570);
                        gameCanvas.positionXPlayer = 0;
                        gameCanvas.positionYPlayer = ranPlayerPosY;
                    } else {
                        gameCanvas.positionXPlayer += 5;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.setVisible(true);
    }

    public void gameLoop(){
        while(true){
            // nanoTime lay so milisecond tinh tu thoi diem 00:00:00 ngay 1/1/1970
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                Random rand = new Random();
                gameCanvas.getStar();
                for(int i = 0; i < 10; i++){
                    int curStarSpeed = gameCanvas.listXStar.get(i) - gameCanvas.ranStarSpeed.get(i);
                    gameCanvas.listXStar.set(i, curStarSpeed);
                }
                this.gameCanvas.positionYEnemy += this.enemySpeedY;
                this.gameCanvas.positionXEnemy += this.enemySpeedX;
                if(this.gameCanvas.positionYEnemy == 570){
                    enemySpeedY = -enemySpeedY;
                }
                if(this.gameCanvas.positionYEnemy == 0){
                    enemySpeedY = -enemySpeedY;
                }
                if(this.gameCanvas.positionXEnemy == 1000){
                    enemySpeedX = -enemySpeedX;
                }
                if(this.gameCanvas.positionXEnemy == 0){
                    enemySpeedX = -enemySpeedX;
                }
                ranPlayerPosY = rand.nextInt(570);
                if(this.gameCanvas.positionXPlayer == 1000){
                    this.gameCanvas.positionXPlayer = 0;
                    this.gameCanvas.positionYPlayer = ranPlayerPosY;
                }
                if(this.gameCanvas.positionYPlayer == 0){
                    this.gameCanvas.positionXPlayer = 1000;
                    this.gameCanvas.positionYPlayer = ranPlayerPosY;
                }
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}