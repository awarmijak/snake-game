import java.util.Random;

import static java.lang.Thread.sleep;

public class SnakeGame {
    private int xBound;
    private int yBound;
    private Snake snake;
    private Point apple;

    public SnakeGame(int xBound, int yBound, Snake snake) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.snake = snake;
    }

    public SnakeGame(int xBound, int yBound) {
        this(xBound, yBound, new Snake());
    }

    public void start() {
        randomizeApple();
        while (isSnakeInBounds()) {
            System.out.println(this);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            snake.expand();
            if (apple.equals(snake.getHead())) {
                randomizeApple();
            } else {
                snake.cutTail();
            }
        /*
        Thread.sleep loop not ended - bug to use RIGHT, UP, DOWN, LEFT - to fix
         */

        }
    }

    private boolean isSnakeInBounds() {
        Point head = snake.getHead();
        int headX = head.getX();
        int headY = head.getY();
        return headX >= 0 && headX < xBound &&
                headY >= 0 && headY < yBound;
    }

    private void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX, appleY);
        } while (snake.contains(apple));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                Point point = new Point(x, y);
                char boardCharacter = getBoardCharacterAt(point);
                stringBuilder.append(boardCharacter);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private char getBoardCharacterAt(Point point) {
        if (point.equals(apple)) {
            return 'A';
        } else if (point.equals(snake.getHead())) {
            return 'H';
        } else if (snake.getBody().contains(point)) {
            return 'B';
        } else {
            return '.';
        }
    }

    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }
}