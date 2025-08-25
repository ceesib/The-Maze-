
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JLayeredPane;


public class Cell extends JLayeredPane{
    public int i,j,x,y;
    public static final int size = 16;
    public boolean[] walls;
    public boolean top_off ,left_off, show, mark, travel,forward;
 
    public Cell(int i, int j){
        this.x  =i;
        this.y = j;
        this.i = i*size;
        this.j = j*size;
        this.top_off = false;
        this.left_off = false;
        this.show = false;
        this.mark = false;
        this.travel = false;
        this.forward = false;
        this.walls= new boolean[4];
        Arrays.fill(this.walls, true);
        this.setVisible(true);
        this.setBounds(this.j, this.i,size+this.y+1, size+this.x+1);
        this.setLayout(null);
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green.darker());
        if(this.walls[0] && !this.top_off) g.drawLine(this.y,this.x,this.y+size+1,this.x);
        if(this.walls[1]) g.drawLine(this.y+size, this.x, this.y+size, this.x+size);
        if(this.walls[2]) g.drawLine(this.y+size+1, this.x+size, this.y, this.x+size);
        if(this.walls[3] && !this.left_off) g.drawLine(this.y, this.x+size, this.y, this.x);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
       
        if(this.show&& this.mark) {
            g2D.setColor(Color.red.darker());
            g2D.fillRect(this.y,this.x, size+3,size+3);
        }
        else if(this.show && !this.mark){
            g2D.setColor(Color.blue.darker());
            g2D.fillRect(this.y,this.x, size+3,size+3);
        }

        if(this.travel && this.forward){
            g2D.setColor(Color.green.darker());
            g2D.fillRect(this.y,this.x, size+3,size+3);
        }
        else if(this.travel && !this.forward){
            g2D.setColor(Color.white.darker());
            g2D.fillRect(this.y,this.x, size+3,size+3);
        }
        else if(!this.travel && !this.forward){
            g2D.dispose();
        }
       
        
    }

    public void topOff() {
        this.top_off = true;
    }
    public void leftOff(){
        this.left_off  = true;
    }
}