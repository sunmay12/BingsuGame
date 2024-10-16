import java.awt.*;
import javax.swing.*;

public class EndGamePanel extends JPanel {
    private JLabel label = new JLabel();
    private JLabel drawRanking = new JLabel();

    private ImageIcon gamestart1 = new ImageIcon("게임시작r1.png");
    private ImageIcon gamestart2 = new ImageIcon("게임시작r2.png");

    public JButton StartButton = new JButton(gamestart1);

    public void paintComponent(Graphics g) {
    	setLayout(null);
        ImageIcon HomebgIcon = new ImageIcon("종료화면.png");
        g.drawImage(HomebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public JButton StartButton() {
        StartButton.setBounds(770, 447, 200, 60);
        StartButton.setBorderPainted(false);
        StartButton.setContentAreaFilled(false);
        StartButton.setRolloverIcon(gamestart2);
        return StartButton;
    }

    public void drawRanking(String name, int score) {
    	int x = 100;
    	int y = 50;
    	drawRanking.setText(name + score);
       	drawRanking.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
       	drawRanking.setBounds(x, y, 400, 40);
        add(drawRanking);
    }
    
    public EndGamePanel() {
        add(label);
        setLayout(null);
        StartButton();
        add(StartButton);
    }
}
