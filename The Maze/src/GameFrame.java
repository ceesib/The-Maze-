import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{

    public static final int  WIDTH = 809,HEIGHT = 600;
    public static int ROW = 650 , COL = 400; 
    public static  Queue<Cell> cells = new LinkedList<>();
    public static Map<String,Cell> population = new HashMap<>(); 
    public static final int GHEIGHT =JPanel.WIDTH*27  ,GWIDTH = JPanel.HEIGHT*26-9;


    public GameFrame(){
        //Maze maze = new Maze(this);
        this.setTitle("The Maze");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.BLACK.darker());
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
                if(i-1>0 && population.containsKey(i-1+" "+j)) cell.topOff();
                if(j-1>0 && population.containsKey(i+" "+(j-1)))  cell.leftOff();

                this.add(cell);
                population.put(i+" "+j, cell);   
            }
        }
            
        //MazeGenerator mazeGenerator = new MazeGenerator(cells);
    } 
}