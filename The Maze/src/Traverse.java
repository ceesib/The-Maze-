
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Traverse{
    public GameFrame gameFrame;
    public Cell cell;
    public String algorithm;
    public Traverse(GameFrame gameFrame,String algorithm, Point start , Point end){
        this.gameFrame = gameFrame;
        this.algorithm = algorithm;
        Cell start_cell = GameFrame.population.get(start.x+" "+start.y);
        Cell end_cell = GameFrame.population.get(end.x+" "+end.y);
        //start_cell.add(new Marker<>(Color.red,start.x,start.y));
       // end_cell.add(new Marker<>(Color.green,end.x,end.y));
    }

    public void dfs(Point start,Point end) throws InterruptedException{
        Stack<Cell> cells = new Stack<>();
        Stack<Cell> path = new Stack<>();
        boolean[][] visited = new boolean[GameFrame.GHEIGHT][GameFrame.GWIDTH];
       
        ArrayList<Cell> neighbours = new ArrayList<>();
        if(GameFrame.population.containsKey(start.x+" "+ start.y)) {
            cells.push(GameFrame.population.get(start.x+" "+ start.y));
            path.push(GameFrame.population.get(start.x+" "+ start.y));
        }
        while(!cells.isEmpty()){
            Cell cell = cells.pop();
            if(!visited[cell.x][cell.y]) {
                visited[cell.x][cell.y] = true;
                cell.travel = true;
                cell.forward = true;
            }
            if(cell.seen){
                //System.out.println("remove: "+cell.i+" "+cell.j);
                cell.forward = false;
                cell.travel = false; 
            }
            this.gameFrame.repaint();
            if(cell.x == end.x && cell.y == end.y) return;


            computeNeighbours(cell, neighbours,visited);
            if(!neighbours.isEmpty()){
                Random random = new Random();
                int num = random.nextInt(0, neighbours.size());
                Cell c = neighbours.get(num);
                
                cells.push(c);
                path.push(c);
            }
            else{
                while(!path.isEmpty()){
                    Cell c = path.pop();
                
                   
                    computeNeighbours(c,neighbours,visited);
                    if(!neighbours.isEmpty()){
                       // System.out.println("seen: " +c.seen);
                      
                        c.forward = true;
                        c.travel = true;
                        c.seen = true;
                        
                
                        cells.push(c);
                        
                        break;
                    }
                    c.forward = false;
                    c.travel = false;
                    this.gameFrame.repaint();
                    TimeUnit.MILLISECONDS.sleep(20);
                }
            }

            neighbours.clear();
            TimeUnit.MILLISECONDS.sleep(20);
            

        }


    }
    public void computeNeighbours(Cell cell, ArrayList<Cell> neighbours, boolean[][] visited){
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        for(int i = 0;i<dx.length;i++){
                int newX = dx[i]+cell.x;
                int newY = dy[i]+cell.y;
                int direction = 0;
                if(dx[i]==-1 && dy[i]==0) direction = 0; 
                else if(dx[i]==1 && dy[i]==0) direction = 2; 
                else if(dx[i]==0 && dy[i]==-1) direction =3; 
                else if(dx[i]==0 && dy[i]==1) direction = 1;
                
                
                if(newX>0 && newY>0 && newX<visited.length && newY<visited[0].length && !visited[newX][newY]){
                    // for any valid neighbour I need to know the entrance;
                    if(!cell.walls[direction]){
                        Cell c = GameFrame.population.get(newX +" "+ newY);
                        neighbours.add(c);
                    }
                }
            }
    }
}
