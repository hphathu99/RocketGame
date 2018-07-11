import base.GameObjectManager;
import game.powerup.Shield;
import game.powerup.TripleShoot;
import game.background.Background;
import game.enemy.Enemy;
import game.enemy.EnemyPower;
import game.player.Player;
import game.star.CreateStar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameCanvas extends JPanel {
    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics;

    public EnemyPower enemyPower = new EnemyPower();
    public Enemy enemy = new Enemy();
//    public Shield shield = new Shield();
//    public TripleShoot tripleShoot = new TripleShoot();

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

    public void renderAll() {
        // run tat ca cac object trong list cua base.GameObjectManager
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll(){
        // run tat ca cac object trong list cua base.GameObjectManager
        GameObjectManager.instance.runAll();
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
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new CreateStar());
//        GameObjectManager.instance.add(new CreateEnemy());
        GameObjectManager.instance.add(new Shield());
        GameObjectManager.instance.add(new TripleShoot());
        this.setupPlayer();
        this.setupEnemy();
        this.setupEnemyPower();
//        this.setupShield();
//        this.setupTripleShoot();
    }

    private void setupPlayer(){
        Player player = new Player();
        player.position.set(100, 200);
        GameObjectManager.instance.add(player);
    }

    private void setupEnemy(){
        Enemy enemy = new Enemy();
        this.enemy.position.set(800, 400);
        GameObjectManager.instance.add(enemy);
    }

    private void setupEnemyPower(){
        EnemyPower enemyPower = new EnemyPower();
        this.enemyPower.position.set(600, 300);
        GameObjectManager.instance.add(enemyPower);
    }
/*
    private void setupShield(){
        Shield shield = new Shield();
        this.shield.position.set(400, 600);
        GameObjectManager.instance.add(shield);
    }

    private void setupTripleShoot(){
        TripleShoot tripleShoot = new TripleShoot();
        this.tripleShoot.position.set(300, 200);
        GameObjectManager.instance.add(tripleShoot);
    }
 */
}
