
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Marker<T extends Color,I> extends JPanel{
    public T colour;
    public I x,y;
    public Marker(T colour,I x, I y){
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.setBackground(this.colour);
        this.setBounds((int)this.y+1,(int) this.x +1,14, 14);
        this.setVisible(true);   
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f));
        g2D.setColor(this.colour);
        g2D.fillRect((int)this.y+1,(int) this.x+1, 14, 14);
        g2D.dispose();
    }

}