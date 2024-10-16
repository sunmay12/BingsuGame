import java.awt.*;
import javax.swing.*;

public class HeartPanel extends JPanel {
    private int heart = 5;
    private JLabel textLabel = new JLabel("기회");
    private JLabel heartLabel = new JLabel(Integer.toString(heart));
    private ImageIcon spoon = new ImageIcon("생명숟가락.png");
    
    public void paintComponent(Graphics g) {
    	setLayout(null);
        //ImageIcon ScorebgIcon = new ImageIcon("화면.png");
        //g.drawImage(ScorebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    public HeartPanel() {
        setLayout(null);
        //textLabel.setSize(50, 50);
        //textLabel.setLocation(10, 10);
        //add(textLabel);
        //heartLabel.setSize(100, 50);
        //heartLabel.setLocation(70, 10);
        add(heartLabel);
        Spoons();
    }

    private void Spoons() {
        int x = 0;
        for (int i = 0; i < heart; i++) {
            JLabel spoonLabel = new JLabel(spoon);
            spoonLabel.setSize(20, 65);
            spoonLabel.setLocation(x, 0);
            add(spoonLabel);
            x += 40;
        }
    }

    public void decrease() {
        if (heart > 0) {
            heartLabel.setText(Integer.toString(--heart));
            removeAll();
            Spoons();
            repaint();
        }
    }
    
    public int getHeart() {
		return heart;
	}
}
