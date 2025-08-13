
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Marker<T extends Color> extends JPanel{
    public T colour;
    public Marker(T colour){
        this.colour = colour;
        this.setBackground(Color.BLACK);
        this.setBounds(4,4 , 8, 8);
        this.setVisible(true);   
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.colour);
        g.drawRect(5, 5, 6, 6);
        g.dispose();
    }

}