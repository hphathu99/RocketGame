import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    public double angle = 0.0; // goc quay cua vector
    public List<Bullet> bulletList;
    private List<Vector2D> vertices;
    private Polygon polygon;
    private Random random = new Random();
    private int countBullet = 0;

    public Player() {
        this.position = new Vector2D();
        this.vertices = Arrays.asList(
                new Vector2D(0, 0),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.polygon = new Polygon();
        this.velocity = new Vector2D(3.5f, 0);
        this.bulletList = new ArrayList<>();
    }

    public void render(Graphics graphics){
        this.polygon.reset();

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1 / this.vertices.size())
                .rotate(this.angle);

        Vector2D translation = this.position.subtract(center);

        this.vertices
                .stream()
                .map(vertex -> vertex.rotate(angle))
                .map(vertex -> vertex.add(translation))
                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));

        graphics.setColor(Color.RED);
        graphics.fillPolygon(this.polygon);
        bulletList.forEach(bullet -> bullet.render(graphics));
    }

    public void run(){
        this.position.addUp(this.velocity);
        if(this.position.x < 0){
            this.position.x = 1024 - 20;
            this.position.y = random.nextInt(600);
        } else if (this.position.x > 1024 - 20){
            this.position.x = 0;
            this.position.y = random.nextInt(600);
        }
        if(this.position.y < 0){
            this.position.y = 600 - 20;
            this.position.x = random.nextInt(1024);
        } else if (this.position.y > 600 - 20){
            this.position.x = 0;
            this.position.y = random.nextInt(1024);
        }
        this.createBullet(this);
        bulletList.forEach(bullet -> bullet.run());
    }

    public void createBullet(Player player){
        if (this.countBullet == 10) {
            for(int i = 0; i < 10; i++){
                Bullet bullet = new Bullet();
                bullet.position.set(player.position);
                bullet.velocity.set(new Vector2D(3.5f,0).rotate(player.angle));
                this.bulletList.add(bullet);
            }
            this.countBullet = 0;
        }
        else{
            this.countBullet++;
        }
    }

}
