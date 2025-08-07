import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import  javax.swing.JButton;
import javax.swing.JPanel;
public abstract class Button extends JButton{
    public String buttonName;
    public ButtonManager buttonManager;
    public JPanel buttonPanel;
    
    public Button(ButtonManager buttonManager, String buttonName,JPanel buttonPanel ,GridBagConstraints gbc){
        this.buttonPanel =buttonPanel;
        this.buttonManager = buttonManager;
        this.buttonName = buttonName ;
    }

    public JButton createButton(){
        this.setText(this.buttonName);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setFont(new Font("BISON",Font.PLAIN,13));
        this.setBackground(Color.green);

        return this;   
    }
    public abstract void addButton();
}