import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomeCardLayout extends JPanel {
    private ManualPanel manualPanel = new ManualPanel();
    private JPanel HomeCard = new JPanel();
    private JPanel GameStartCard = new JPanel();
    private JPanel RankingCard = new JPanel();
    private JPanel ManualCard = new JPanel();
    
    private String currentCard = "HomePanel";

    private ImageIcon gamemanual1 = new ImageIcon("게임방법1.png");
    private ImageIcon gamemanual2 = new ImageIcon("게임방법2.png");
    private ImageIcon gamestart1 = new ImageIcon("게임시작1.png");
    private ImageIcon gamestart2 = new ImageIcon("게임시작2.png");
    private ImageIcon gameranking1 = new ImageIcon("랭킹보기1.png");
    private ImageIcon gameranking2 = new ImageIcon("랭킹보기2.png");
    private ImageIcon gamehome1 = new ImageIcon("이전으로1.png");
    private ImageIcon gamehome2 = new ImageIcon("이전으로2.png");

    private JButton ManualButton = new JButton(gamemanual1);
    private JButton StartButton = new JButton(gamestart1);
    private JButton RankingButton = new JButton(gameranking1);
    private JButton HomeButton = new JButton(gamehome1);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentCard.equals("ManualPanel")) {
            paintManualComponent(g);
        } else {
            paintHomeComponent(g);
        }
    }

    public void paintHomeComponent(Graphics g) {
    	setLayout(null);
        ImageIcon HomebgIcon = new ImageIcon("홈화면.png");
        g.drawImage(HomebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);

        ManualButton.setBounds(380, 250, 150, 80);
        ManualButton.setBorderPainted(false);
        ManualButton.setContentAreaFilled(false);
        ManualButton.setRolloverIcon(gamemanual2);
        HomeCard.add(ManualButton);

        StartButton.setBounds(380, 400, 150, 80);
        StartButton.setBorderPainted(false);
        StartButton.setContentAreaFilled(false);
        StartButton.setRolloverIcon(gamestart2);
        GameStartCard.add(StartButton);

        RankingButton.setBounds(380, 450, 150, 80);
        RankingButton.setBorderPainted(false);
        RankingButton.setContentAreaFilled(false);
        RankingButton.setRolloverIcon(gameranking2);
        RankingCard.add(RankingButton);

        HomeButton.setBounds(10, 10, 100, 30);
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setRolloverIcon(gamehome2);
        ManualCard.add(HomeButton);
    }

    public void paintManualComponent(Graphics g) {
        ImageIcon ManualbgIcon = new ImageIcon("메뉴얼화면.png");
        g.drawImage(ManualbgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public HomeCardLayout() {
        CardLayout cards = new CardLayout();
        JPanel cardPanel;
    	setLayout(cards);

    	this.add(HomeCard, "HomePanel");
        this.add(ManualCard, "ManualPanel");
        this.add(RankingCard, "RankingPanel");
        this.add(GameStartCard, "GamePanel1");

        ManualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cards.next(HomeCardLayout.this);
                currentCard = "ManualPanel";
                repaint();
            }
        });

        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cards.next(HomeCardLayout.this);
                currentCard = "GamePanel1";
                repaint();
            }
        });

        RankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cards.next(HomeCardLayout.this);
                currentCard = "RankingPanel";
                repaint();
            }
        });

        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cards.next(HomeCardLayout.this);
                currentCard = "HomePanel";
                repaint();
            }
        });
    }
}
