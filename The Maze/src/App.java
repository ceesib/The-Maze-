

public class App {
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];

        MazeGenerator<GameFrame> mazeGenerator = new MazeGenerator<>(gameFrame,visited,1,1);
        Thread mazeThread = new Thread(mazeGenerator);
        mazeThread.start();
      
    }
}
