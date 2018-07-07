import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    public boolean left;
    public boolean right;

    public Listener(){
        this.left = false;
        this.right = false;
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
