import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;
    public int ranPlayerPosY = 0;

    public GameWindow(){
        this.setSize(1024,600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.event();
        this.setVisible(true);
    }

    public void gameLoop(){
        while(true){
            // nanoTime lay so milisecond tinh tu thoi diem 00:00:00 ngay 1/1/1970
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }

    private void event(){
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Random rand = new Random();
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(gameCanvas.player.x < 10){
                        ranPlayerPosY = rand.nextInt(570);
                        gameCanvas.player.y =  ranPlayerPosY;
                        gameCanvas.player.x = 1020;
                    } else {
                        gameCanvas.player.x -= 5;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(gameCanvas.player.x > 980){
                        ranPlayerPosY = rand.nextInt(570);
                        gameCanvas.player.x = 0;
                        gameCanvas.player.y = ranPlayerPosY;
                    } else {
                        gameCanvas.player.x += 5;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}