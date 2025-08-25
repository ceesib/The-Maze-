import java.awt.Point;

public class App {
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];

        MazeGenerator<GameFrame> mazeGenerator = new MazeGenerator<>(gameFrame,visited,12,30);
        Thread mazeThread = new Thread(mazeGenerator);
        mazeThread.start();
        mazeThread.join();
        Traverse traverse= new Traverse(gameFrame,"BFS",new Point(1,1),new Point(35,51));   
    }
}