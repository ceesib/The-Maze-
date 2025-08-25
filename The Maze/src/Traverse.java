
import java.awt.Point;

public class Traverse{
    public GameFrame gameFrame;
    public String algorithm;
    public static boolean found = false;
    public Traverse(GameFrame gameFrame,String algorithm, Point start , Point end) throws InterruptedException{
        this.gameFrame = gameFrame;
        this.algorithm = algorithm;
        if(this.algorithm.equalsIgnoreCase("dfs")){
            DFS algo = new DFS(gameFrame);
            algo.dfs(start, end);
        }
        else if(this.algorithm.equalsIgnoreCase("bfs")){
            BFS algo = new BFS(gameFrame);
            algo.bfs(start, end);
        }
    }
    
}
