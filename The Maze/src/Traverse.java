
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Traverse{
    public GameFrame gameFrame;
    public Cell cell;
    public String algorithm;
    public static boolean found = false;
    public Traverse(GameFrame gameFrame,String algorithm, Point start , Point end){
        this.gameFrame = gameFrame;
        this.algorithm = algorithm;
    }

    public void dfs(Point start,Point end) throws InterruptedException{
        Stack<Cell> cells = new Stack<>();
        Stack<Cell> route = new Stack<>();
        Queue<Cell> cleanQueue = new LinkedList<>();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];
       
        if(GameFrame.population.containsKey(start.x+" "+ start.y)) {
            cells.push(GameFrame.population.get(start.x+" "+ start.y));
        }
        
        while(!cells.isEmpty()){
            Cell cell = cells.pop();
            if(!found) route.push(cell);
            cleanQueue.offer(cell);
            
            visited[cell.x][cell.y] = true;
            cell.travel = true;
            cell.forward = true;
            
            this.gameFrame.repaint();
            if(cell.x == end.x && cell.y == end.y) found = true;
            int cells_size_current = cells.size();
            computeNeighbours(cell, cells,visited);
            int cells_size_after = cells.size();

            if(cells_size_current==cells_size_after &&!found){
                Cell c = null;
                while(!route.isEmpty() && cells_size_current==cells.size()){
                    c = route.pop();
                    computeNeighbours(c, cells, visited);
                }
                route.push(c);

            }
            TimeUnit.MILLISECONDS.sleep(10);
        }  
        TimeUnit.MILLISECONDS.sleep(50);
        cleanup(cleanQueue);
        markPath(route);
    }
    public void computeNeighbours(Cell cell, Stack<Cell> cells, boolean[][] visited){
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
                        cells.push(c);
                    }
                }
            }

    }
    public void cleanup(Queue<Cell> cleanQueue){
        while(!cleanQueue.isEmpty()){
            var c = cleanQueue.poll();
            c.forward = false;
            c.travel = false;
        }
        this.gameFrame.repaint();
    }
    public void markPath(Stack<Cell> route) throws InterruptedException{
        while(!route.isEmpty()){
            var c = route.pop();
            c.forward = false;
            c.travel = true;
            this.gameFrame.repaint();
            TimeUnit.MILLISECONDS.sleep(20);
        }
        
    }
    
}
