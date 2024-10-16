import java.awt.*;
import javax.swing.*;

public class ManualPanel extends JPanel {
    private JLabel label = new JLabel();
    private ImageIcon gamehome1 = new ImageIcon("이전으로1.png");
    private ImageIcon gamehome2 = new ImageIcon("이전으로2.png");
    private ImageIcon gamestart1 = new ImageIcon("게임시작1.png");
    private ImageIcon gamestart2 = new ImageIcon("게임시작2.png");
    
    public JButton HomeButton = new JButton(gamehome1);
    public JButton StartButton = new JButton(gamestart1);

    public void paintComponent(Graphics g) {
        ImageIcon ManualbgIcon = new ImageIcon("메뉴얼화면.png");
        g.drawImage(ManualbgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public JButton HomeButton() {
    	HomeButton.setBounds(30, 425, 235, 80);
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setRolloverIcon(gamehome2);
        return HomeButton;
    }
    
    public JButton StartButton() {
    	StartButton.setBounds(720, 425, 235, 80);
        StartButton.setBorderPainted(false);
        StartButton.setContentAreaFilled(false);
        StartButton.setRolloverIcon(gamestart2);
        return StartButton;
    }
    
    public ManualPanel() {
        add(label);
        setLayout(null);
        HomeButton();
        StartButton();
        add(HomeButton);
        add(StartButton);
    }
}
