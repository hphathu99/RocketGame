/*
 * Dua ra mot list quan ly tat ca cac nhan vat trong GameObject
 * Su dung design pattern Singleton
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private ArrayList<GameObject> tempList = new ArrayList<>();

    private GameObjectManager(){
        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }

    public void runAll(){
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer(){

//        Player player = null;
//        for (GameObject gameObject:this.list){
//            if(gameObject instanceof Player){
//                return (Player) gameObject;
//            }
//        }

        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }
}
