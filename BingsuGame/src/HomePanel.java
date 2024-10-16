import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    private ImageIcon gamemanual1 = new ImageIcon("게임방법1.png");
    private ImageIcon gamemanual2 = new ImageIcon("게임방법2.png");
    private ImageIcon gamestart1 = new ImageIcon("게임시작1.png");
    private ImageIcon gamestart2 = new ImageIcon("게임시작2.png");
    private ImageIcon gameranking1 = new ImageIcon("랭킹보기1.png");
    private ImageIcon gameranking2 = new ImageIcon("랭킹보기2.png");

    public JButton ManualButton = new JButton(gamemanual1);
    public JButton StartButton = new JButton(gamestart1);
    public JButton RankingButton = new JButton(gameranking1);

    public void paintComponent(Graphics g) {
    	setLayout(null);
        ImageIcon HomebgIcon = new ImageIcon("홈화면.png");
        g.drawImage(HomebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public JButton ManualButton() {
    	ManualButton.setBounds(370, 235, 235, 80);
        ManualButton.setBorderPainted(false);
        ManualButton.setContentAreaFilled(false);
        ManualButton.setRolloverIcon(gamemanual2);
        return ManualButton;
    }
    
    public JButton StartButton() {
    	StartButton.setBounds(370, 320, 235, 80);
        StartButton.setBorderPainted(false);
        StartButton.setContentAreaFilled(false);
        StartButton.setRolloverIcon(gamestart2);
        return StartButton;
    }
    
    public JButton ShowButton() {
    	RankingButton.setBounds(370, 405, 235, 80);
    	RankingButton.setBorderPainted(false);
    	RankingButton.setContentAreaFilled(false);
    	RankingButton.setRolloverIcon(gameranking2);
        return RankingButton;
    }

    public HomePanel() {
    	setLayout(null);
    	ManualButton();
    	StartButton();
    	ShowButton();
    	add(ManualButton);
    	add(StartButton);
    	add(RankingButton);
    }
}