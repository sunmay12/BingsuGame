import java.awt.*;
import javax.swing.*;

public class RankingPanel extends JPanel {
    private JLabel label = new JLabel();
    private JLabel drawRanking = new JLabel();
    private ImageIcon gamehome1 = new ImageIcon("이전으로r1.png");
    private ImageIcon gamehome2 = new ImageIcon("이전으로r2.png");
    private ImageIcon gamestart1 = new ImageIcon("게임시작r1.png");
    private ImageIcon gamestart2 = new ImageIcon("게임시작r2.png");

    public JButton HomeButton = new JButton(gamehome1);
    public JButton StartButton = new JButton(gamestart1);

    public void paintComponent(Graphics g) {
    	setLayout(null);
        ImageIcon HomebgIcon = new ImageIcon("랭킹화면.png");
        g.drawImage(HomebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public JButton HomeButton() {
        HomeButton.setBounds(12, 447, 200, 60);
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setRolloverIcon(gamehome2);
        return HomeButton;
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
    	for (int i = 0; i < 5; i++) {
    		drawRanking.setText(name + score);
        	drawRanking.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
        	drawRanking.setBounds(x, y, 400, 40);
            add(drawRanking);
            y += 20;
    	}
    }
    
    public RankingPanel() {
        add(label);
        setLayout(null);
        HomeButton();
        StartButton();
        add(HomeButton);
        add(StartButton);
    }
}
