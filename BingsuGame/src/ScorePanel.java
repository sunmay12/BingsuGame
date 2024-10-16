import java.awt.*;
import javax.swing.*;

public class ScorePanel extends JPanel {
	private int score = 0;
	//private JLabel textLabel = new JLabel("점수:");
	private JLabel scoreLabel = new JLabel(Integer.toString(score));
	
	public void paintComponent(Graphics g) {
    	//setLayout(null);
        //ImageIcon ScorebgIcon = new ImageIcon("화면.png");
        //g.drawImage(ScorebgIcon.getImage(), 0, 0, 10000, 100, this);
    }
	
	public ScorePanel() {
		setLayout(null);
		Font font = new Font("배달의민족 주아", Font.PLAIN, 40);
		//textLabel.setFont(font);
		//textLabel.setSize(100, 30);
		//textLabel.setLocation(40,10);
		//add(textLabel);
		
		scoreLabel.setFont(font);
		scoreLabel.setSize(150,60);
		scoreLabel.setLocation(0,0);
		add(scoreLabel);
	}
	
	public void increase() {
		score += 10;
		scoreLabel.setText(Integer.toString(score));
	}
	
	public void decrease() {
		score -= 10;
		scoreLabel.setText(Integer.toString(score));
	}
	
	public int getScore() {
		return score;
	}
}
