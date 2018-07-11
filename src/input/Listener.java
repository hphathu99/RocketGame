package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    public static Listener instance = new Listener();
    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean space = false;

    private Listener(){

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           this.right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.space = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            this.up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.space = false;
        }
    }
}
