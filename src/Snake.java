import java.util.Collections;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> body;
    private Direction direcion;

    public Snake(Point head, List<Point> body, Direction direcion) {
        this.head = head;
        this.body = body;
        this.direcion = direcion;
    }

    public Snake() {
        this(new Point(0, 0), Collections.emptyList(), Direction.RIGHT);
    }

}
