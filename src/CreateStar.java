import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar extends GameObject {
    public List<Star> stars;
    private int count = 0;
    private Random random = new Random();

    public CreateStar(){
        this.stars = new ArrayList<>();
    }

    public void createStar(){
        if(count == 30){
            Star star = new Star();
            star.position.set(1024, random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3) + 1, 0);
            stars.add(star);
            count = 0;
        } else {
            count++;
        }
    }

}
