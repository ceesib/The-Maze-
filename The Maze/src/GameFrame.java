import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame{

    public static final int  WIDTH = 809,HEIGHT = 600;
    public static int ROW = 650 , COL = 400; 
    public static  Queue<Cell> cells = new LinkedList<>();

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
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                for(int i = 1; i<JPanel.HEIGHT*26-9;i++){
                    for(int j= 1;j<JPanel.WIDTH*27;j++){
                        Cell cell = new Cell(i, j);
                        GameFrame.this.add(cell);
                        cells.offer(cell);
                    }
                }
            }
        });
    }

}