import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class MazeGenerator<T extends JFrame> implements Runnable{
    public Stack<Cell> cells,cellPath;
    public Map<String,Cell> population;
    public boolean[][] visited ;
    public  T gameFrame;
    public int x,y;

    public MazeGenerator(T gameFrame, boolean [][] visited,int x, int y){
        this.gameFrame = gameFrame;
        this.population = GameFrame.population;
        this.visited = visited;
        this.x = x;
        this.y = y;
        this.cells = new Stack<>();
        this.cellPath = new Stack<>();
    }

    public void createMaze(boolean[][] vis,int i,int j) throws InterruptedException{
        String current_key = i+" "+j;
       
        ArrayList<Struct<String,Integer>> neighboursList = new ArrayList<>();
        if(i<0 || j<0 || j>=vis[0].length || i>=vis.length ) return;
        if(i>0 && j>0 && j<vis[0].length && i<vis.length && vis[i][j] &&cells.isEmpty()) return;
    
        cells.push(population.get(current_key));
        Cell current_cell  = null;

        while(!cells.isEmpty()){
            current_cell = cells.pop();
            current_cell.show = true;
            current_cell.mark = true;
            Opening.createOpening(current_cell);
            vis[current_cell.x][current_cell.y] = true;
            this.cellPath.push(current_cell);
            computeNeighbours(current_cell, vis, neighboursList);
            if(!neighboursList.isEmpty()) removeWalls(current_cell, neighboursList, vis);
            else{
                while(!cellPath.isEmpty()){
                    Cell c = cellPath.pop();
                    computeNeighbours(c, vis, neighboursList);
                    c.show = true;
                    c.mark = false;
                    this.gameFrame.repaint();
                    
                    if(!neighboursList.isEmpty()) {
                        cells.push(c);
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(15);
                }
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

    public void computeNeighbours(Cell current_cell,boolean[][] vis,ArrayList<Struct<String,Integer>> neighboursList){
        int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
        for(int k = 0;k<dx.length;k++){
                int row = dy[k]+ current_cell.x;
                int col = dx[k]+ current_cell.y;
                String key = row+" "+col;
                if(row>0 && col>0 && row<vis.length && col<vis[0].length&& !vis[row][col]) {
                    int current_wall = Integer.MAX_VALUE;
                    int opposite_wall = Integer.MAX_VALUE;
                    if(dx[k]==0 && dy[k]==-1) {
                        current_wall = 0;
                        opposite_wall = 2;
                    }
                    else if(dx[k]==0 && dy[k]==1) {
                        current_wall = 2;
                        opposite_wall = 0;
                    }
                    else if(dx[k]==-1 && dy[k]==0) {
                        current_wall = 3;
                        opposite_wall = 1;
                    }
                    else if(dx[k]==1 && dy[k]==0) {
                        current_wall = 1;
                        opposite_wall = 3;
                    }
                   
                    neighboursList.add(new Struct<>(key, current_wall,opposite_wall));
            }
        }
    }
    public void removeWalls(Cell current_cell,ArrayList<Struct<String,Integer>> neighboursList,boolean[][] vis) throws InterruptedException{
        
        Random random = new Random();
        int chosenKeyNumber = random.nextInt(0, neighboursList.size());
        Struct<String,Integer> struct = neighboursList.get(chosenKeyNumber);
        String chosenKey = struct.key;
        Cell cell = population.get(chosenKey);
        
        vis[cell.x][cell.y] = true;
        cells.push(cell);
        this.cellPath.push(cell);

        current_cell.walls[struct.current_wall] = false;
        cell.walls[struct.opposite_wall] = false;
        cell.show = true;
        this.gameFrame.repaint();
        cell.revalidate();
        TimeUnit.MILLISECONDS.sleep(10);

        neighboursList.clear();  
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