
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Marker<T extends Color> extends JPanel{
    public T colour;
    public Marker(T colour){
        this.colour = colour;
        this.setBackground(Color.BLACK);
        this.setBounds(0,0 ,19, 19);
        this.setVisible(true);   
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
        g2D.setColor(this.colour);
        g2D.fillRect(0, 0, 19, 19);
        g2D.dispose();
    }

}