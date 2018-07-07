import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    public static Listener instance = new Listener();
    public boolean left = false;
    public boolean right = false;

    private Listener(){

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            this.left = true;
//            System.out.println(this.left);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           this.right = true;
//            System.out.println(this.right);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
