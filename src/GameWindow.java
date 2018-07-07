import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;


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
//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_LEFT){
//                    gameCanvas.player.angle -= 5.0;
//                }
//                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//                    gameCanvas.player.angle += 5.0;
//                }
//
//                gameCanvas.player.velocity.set(
//                        (new Vector2D(3.5f, 0.0f).rotate(gameCanvas.player.angle))
//                );
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        });
        this.addKeyListener(Listener.instance);
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