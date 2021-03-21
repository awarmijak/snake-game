
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Snake {
    private Point head;
    private List<Point> body;
    private Direction direction;

    public Snake(Point head, List<Point> body, Direction direction) {
        this.head = head;
        this.body = new ArrayList<>(body);
        this.direction = direction;
    }

    public Snake() {
        this(new Point(0, 0), Collections.emptyList(), Direction.RIGHT);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }

    public void cutTail() {
        body.remove(body.size() - 1);
    }

    public void expand() {
        body.add(0, head);
        head = head.move(direction);
    }

    public Point getHead() {
        return head;
    }

    public List<Point> getBody() {
        return body;
    }

    public boolean contains(Point point) {
        return head.equals(point) || body.contains(point);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}