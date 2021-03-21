import java.util.Random;

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
                Thread.sleep(1000);
            } catch (InterruptedException e)
            return;
        }
        snake.expand();
        if (apple.equals(snake.getHead())) {
            randomizeApple();
        } else {
            snake.cutTail;
        }

    }

}

    private void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX, appleY);
        }
        while (snake.contains(apple));
    }
}
