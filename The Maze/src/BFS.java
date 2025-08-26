
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BFS implements  GridMethods<Queue<Cell>,Map<Cell,Cell>>{
    public GameFrame gameFrame;
    public Point start,end;
    public BFS(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }
    public void bfs(Point start, Point end) throws InterruptedException{
        this.start = start;
        this.end = end;
        Queue<Cell> cells = new LinkedList<>();
        Queue<Cell> cleanQueue = new LinkedList<>();
        Map<Cell,Cell> path = new HashMap<>();

        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];
        
        if(GameFrame.population.containsKey(start.x+" "+ start.y)) {
            cells.offer(GameFrame.population.get(start.x+" "+ start.y));
        }
        
        while(!cells.isEmpty()){
            Cell cell = cells.poll();
            cleanQueue.offer(cell);
            
            visited[cell.x][cell.y] = true;
            cell.travel = true;
            cell.forward = true;
            
            this.gameFrame.repaint();
            computeNeighbours(cell, cells,visited,path);
            TimeUnit.MILLISECONDS.sleep(10);
        }  
        TimeUnit.MILLISECONDS.sleep(20);
        cleanup(cleanQueue);
        markPath(path);
    }

    public void computeNeighbours(Cell cell, Queue<Cell> cells, boolean[][] visited,Map<Cell,Cell> path){

        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        for(int i = 0;i<dx.length;i++){
                int newX = dx[i]+cell.x;
                int newY = dy[i]+cell.y;
                int direction = 0;
                if(dx[i]==-1 && dy[i]==0) direction = 0; 
                else if(dx[i]==0 && dy[i]==1) direction = 1;
                else if(dx[i]==1 && dy[i]==0) direction = 2; 
                else if(dx[i]==0 && dy[i]==-1) direction =3; 
                
                if(newX>0 && newY>0 && newX<visited.length && newY<visited[0].length && !visited[newX][newY]){
                    // for any valid neighbour I need to know the entrance;
                    if(!cell.walls[direction]){
                        Cell c = GameFrame.population.get(newX +" "+ newY);
                        cells.offer(c);
                        path.put(c,cell);
                    }
                }
            }

    }

    @Override
    public void cleanup(Queue<Cell> cleanQueue){
        while(!cleanQueue.isEmpty()){
            var c = cleanQueue.poll();
            c.forward = false;
            c.travel = false;
        }
        this.gameFrame.repaint();
    }

    @Override
    public void markPath(Map<Cell,Cell> path) throws InterruptedException{
        var end_cell = GameFrame.population.get(this.end.x+" "+this.end.y);
        end_cell.forward = false;
        end_cell.travel = true;
        this.gameFrame.repaint();
        var start = path.get(GameFrame.population.get(this.end.x+" "+this.end.y));
        
        while(start != GameFrame.population.get(this.start.x+" "+this.start.y)){
            
            var nextParent = path.get(start);
            start.forward = false;
            start.travel = true;
            this.gameFrame.repaint();
            TimeUnit.MILLISECONDS.sleep(10);
            start = nextParent;
        }
        var start_cell = GameFrame.population.get(this.start.x+" "+this.start.y);
        start_cell.forward = false;
        start_cell.travel = true;
        this.gameFrame.repaint();
    }
}