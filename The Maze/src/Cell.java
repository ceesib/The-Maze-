
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

public class Cell extends JPanel{
    public int i, j,x,y;
    public final int size = 17;
    public boolean[] walls;
    public boolean top_off ,left_off;
 
    public Cell(int i, int j){
        this.x  =i;
        this.y = j;
        this.i = i*size;
        this.j = j*size;
        this.top_off = false;
        this.left_off = false;
        this.walls= new boolean[4];
        Arrays.fill(this.walls, true);
        this.setBackground(Color.black);
        this.setVisible(true);

        this.setBounds(this.j, this.i,size+this.y+1, size+this.x+1);
        this.setLayout(null);
    }
    public boolean  getCell(int i, int j){
        return GameFrame.population.containsKey(i+" "+j);   
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN.darker());
        this.j /=size;
        this.i /= size;
        
        if(this.walls[0] && !this.top_off) g.drawLine(this.j,this.i,this.j+size+1,this.i);
        if(this.walls[1]) g.drawLine(this.j+size, this.i, this.j+size, this.i+size);
        if(this.walls[2]) g.drawLine(this.j+size+1, this.i+size, this.j, this.i+size);
        if(this.walls[3] && !this.left_off) g.drawLine(this.j, this.i+size, this.j, this.i);
    }
    public void topOff() {
        this.top_off = true;
    }
    public void leftOff(){
        this.left_off  = true;
    }
}