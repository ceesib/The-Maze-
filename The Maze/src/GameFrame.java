import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

    public static final int  WIDTH = 809,HEIGHT = 600;
    public static int ROW = 650 , COL = 400; 
    public static Queue<Cell> cells = new LinkedList<>();
    public static Map<String,Cell> population = new HashMap<>(); 
    public int size = 16;
    public static int GHEIGHT ,GWIDTH ;


    public GameFrame(){
        //Maze maze = new Maze(this);
        this.setTitle("The Maze");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.BLACK.darker());

        GHEIGHT = this.getHeight()/(size+1)-5;
        GWIDTH = this.getWidth()/(size+1)-1;

        addCells();
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    public void addCells(){
       
        for(int i = 1; i<GHEIGHT;i++){
            for(int j= 1;j<GWIDTH;j++){
                Cell cell = new Cell(i, j);
                //remove extra walls 
                if(i-1>0) cell.topOff();
                if(j-1>0)  cell.leftOff();

                this.add(cell);
                population.put(i+" "+j, cell);   
                cells.offer(cell);
            }
        }
    } 
}