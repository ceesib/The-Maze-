import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    public static final int  WIDTH = 800,HEIGHT = 600;

    public GameFrame(){
        this.setTitle("The Maze");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.CYAN.darker());
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}