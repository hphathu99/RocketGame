import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer {

    private List<Vector2D> vertices;
    private Polygon polygon;
    public double angle = 0.0;
    private Color color;

    public PolygonRenderer(Color color, Vector2D... vertices){ // mang, bien phai viet cuoi cung
        this.color = color;
        this.vertices = Arrays.asList(vertices);
        this.polygon = new Polygon();
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        this.polygon.reset();

        /*
        Tinh toa do trong tam tam giac
        Vector2D center = new Vector2D();
        this.vertices.forEach(vertex -> center.addUp(vertex)):
        center.multiply(1.0f / (float) this.vertices.size());
         */

        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f /(float) this.vertices.size())
                .rotate(this.angle);

        /*
         * Ham reduce(s, (a, b) -> a+b)
         * s: khoi tao gia tri ban dau
         * dat a = s, s+b roi gan lai a
         * lap lai den tat ca cac phan tu
         */

        Vector2D translation = position.subtract(center);

        this.vertices
                .stream()
                .map(vertex -> vertex.rotate(angle))
                .map(vertex -> vertex.add(translation))
                .forEach(vertex -> polygon.addPoint((int)vertex.x, (int)vertex.y));
        /*
         * Ham map: tao ra 1 list moi voi moi phan tu dc modify theo function
         */
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);

    }
}
