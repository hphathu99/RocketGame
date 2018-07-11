package base;
/*
 * Dua ra mot list quan ly tat ca cac nhan vat trong base.GameObject
 * Su dung design pattern Singleton
 */

import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemy.EnemyPower;
import game.player.BulletPlayer;
import game.player.Player;
import game.powerup.Shield;
import physics.BoxCollider;
import physics.CheckCollision;

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
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer(){

//        game.player.Player player = null;
//        for (base.GameObject gameObject:this.list){
//            if(gameObject instanceof game.player.Player){
//                return (game.player.Player) gameObject;
//            }
//        }

        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> gameObject.isAlive)
                .findFirst()
                .orElse(null);
    }

    public Enemy checkCollision(BulletPlayer bulletPlayer){
        return (Enemy) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider other = ((Enemy) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public EnemyPower checkCollision2(BulletPlayer bulletPlayer){
        return (EnemyPower) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof EnemyPower)
                .filter(gameObject -> {
                    BoxCollider other = ((EnemyPower) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public Player checkCollision3 (BulletEnemy bulletEnemy){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider other = ((Player) gameObject).boxCollider;
                    return bulletEnemy.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public Shield checkCollision4 (Player player) {
        return (Shield) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Shield)
                .filter(gameObject -> {
                    BoxCollider other = ((Shield) gameObject).boxCollider;
                    return player.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

}
