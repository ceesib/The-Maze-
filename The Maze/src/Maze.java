import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
public class Maze extends JPanel{
    public GameFrame gameFrame;
    public static int HEIGHT = 650,WIDTH = 400,ROW = 650 , COL = 400, size = 20; 

    public Maze(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        this.setBounds(60,60, 660, 400);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        Cell cell = new Cell(0,0);
        this.add(cell);
        this.gameFrame.add(Maze.this);

    }
    public void createCells(){
        for(int i = 60; i<ROW;i++){
            for(int j= 60;i<COL;j++){
                Cell cell = new Cell(i, j);
                this.add(cell);
            }
        }
    }  
}