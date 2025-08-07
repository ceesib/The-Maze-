
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

public class Cell extends JPanel{
    public int i, j,x,y;
    public final int size = 17;
    public boolean[] walls;
    public Cell(int i, int j){
        this.x  =i;
        this.y = j;
        this.i = i*size;
        this.j = j*size;
        this.walls= new boolean[4];
        Arrays.fill(this.walls, true);
   
        this.setBackground(Color.black);
        this.setVisible(true);

        this.setBounds(this.i+1, this.j+1,size+1+this.x, size+1+this.y);
        this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0x123456));
        this.j /=size;
        this.i /= size;
        
        if(this.walls[0]) g.drawLine(this.i,this.j,this.i+size+1,this.j);
        if(this.walls[1]) g.drawLine(this.i+size, this.j, this.i+size, this.j+size);
        if(this.walls[2]) g.drawLine(this.i+size+1, this.j+size, this.i, this.j+size);
        if(this.walls[3]) g.drawLine(this.i, this.j+size, this.i, this.j);
    }
}