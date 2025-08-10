
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Marker extends JPanel{

    public Marker(){
        this.setBackground(Color.pink.darker());
        this.setBounds(6,8 , 6, 6);
        this.setVisible(true);   
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(6, 8, 6, 6);
        g.dispose();
    }

}