import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    public static final int  WIDTH = 909,HEIGHT = 700;
   
    public static Map<String,Cell> population = new HashMap<>(); 
    public final int size = 16;
    public static int GHEIGHT ,GWIDTH ;

    public GameFrame(){

        this.setTitle("The Maze");
       
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.BLACK);

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
                if(i-1>0) cell.topOff();
                if(j-1>0)  cell.leftOff();
                this.add(cell);
                population.put(i+" "+j, cell);   
                Opening.addBorderCell(cell);
            }
        }
        
    } 
}