public class App {
    public static void main(String[] args) throws Exception {
        GameFrame gameFrame = new GameFrame();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];
        MazeGenerator mazeGenerator = new MazeGenerator(gameFrame,visited,29,45);
        Thread mazeThread = new Thread(mazeGenerator);
        mazeThread.start();
   
        //System.out.print(mazeGenerator);  
    }
}
