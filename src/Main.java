import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(10, 10);
        Thread uiThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                switch (scanner.nextLine()) {
                    case "u":
                        snakeGame.setSnakeDirection(Direction.UP);
                        break;
                    case "d":
                        snakeGame.setSnakeDirection(Direction.DOWN);
                        break;
                    case "r":
                        snakeGame.setSnakeDirection(Direction.RIGHT);
                        break;
                    case "l":
                        snakeGame.setSnakeDirection(Direction.LEFT);
                        break;
                    default:
                        System.out.println("Niepoprawny kierunek ruchu (u, d, r, l)");
                }
            }
        });
        uiThread.setDaemon(true);
        uiThread.start();
        snakeGame.start();
    }
}