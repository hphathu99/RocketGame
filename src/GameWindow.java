import input.Listener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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