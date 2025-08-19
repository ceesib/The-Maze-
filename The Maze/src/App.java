import java.awt.Point;

public class App {
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];
        //TimeUnit.MILLISECONDS.sleep(750);

        MazeGenerator<GameFrame> mazeGenerator = new MazeGenerator<>(gameFrame,visited,15,15);
        Thread mazeThread = new Thread(mazeGenerator);
        mazeThread.start();
        mazeThread.join();
        Traverse traverse= new Traverse(gameFrame,"DFS",new Point(1,1),new Point(35,51));
        GameFrame.population.get(1+" "+1).walls[2] = false;
        traverse.dfs(new Point(1,1), new Point(35,51));

      
    }
}