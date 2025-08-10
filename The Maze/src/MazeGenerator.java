
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class MazeGenerator implements Runnable{
    public Stack<Cell> cells;
    public Queue<Cell> cellsToProcess;
    public Map<String,Cell> population;
    public boolean[][] visited ;
    public  GameFrame gameFrame;
    public int x,y;
    public MazeGenerator(GameFrame gameFrame, boolean [][] visited,int x, int y){
        this.gameFrame = gameFrame;
        this.cellsToProcess = GameFrame.cells;
        this.population = GameFrame.population;
        this.visited = visited;
        this.x = x;
        this.y = y;
        // this.population.get(1+" "+1).setBackground(Color.red);
        // gameFrame.repaint();
        
        this.cells = new Stack<>();
        // createMaze(visited, 1, 1);
    }
    public void createMaze(boolean[][] vis,int i,int j) throws InterruptedException{
        String current_key = i+" "+j;
       
        //System.out.println("keys: "+keys);
        int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
        ArrayList<String> neighboursList = new ArrayList<>();
        if(i<0 || j<0 || j>=vis[0].length || i>=vis.length ) return;
        if(i>0 && j>0 && j<vis[0].length && i<vis.length && vis[i][j] ) return;

        vis[i][j] = true;
        population.get(current_key).add(new Marker(), Integer.valueOf(1));
       

        
 
        TimeUnit.MILLISECONDS.sleep(500);
        
        for(int k = 0;k<dx.length;k++){
            int newX = dx[k]+ j;
            int newY = dy[k]+ i;
            String key = newY+" "+newX;
            if(newX>0 && newY>0 && newX<vis[0].length && newY<vis.length&& !vis[newY][newX]) neighboursList.add(key);
        }
        System.out.println("Choosing random neighbour from: "+ neighboursList);
        
        if(neighboursList.isEmpty()) return;
        Random random = new Random();
        cells.push(population.get(current_key));

        int chosenKeyNumber = random.nextInt(0, neighboursList.size());
        //System.out.println("chosenKeyNumber: "+ chosenKeyNumber);

        String chosenKey = neighboursList.get(chosenKeyNumber);
        Cell cell = population.get(chosenKey);
        cell.add(new Marker(),Integer.valueOf(1));
        cell.revalidate();
   
        TimeUnit.MILLISECONDS.sleep(500);
        neighboursList.clear();  
        createMaze(vis, cell.x, cell.y);     
    
    }
    @Override
    public void run(){
        try {
            createMaze(visited, x, y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}