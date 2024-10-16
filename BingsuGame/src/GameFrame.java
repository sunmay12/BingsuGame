import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private Container contentPane;
    private CardLayout cardLayout = new CardLayout();

    public String name;

    private HomePanel homePanel = new HomePanel();
    private ManualPanel manualPanel = new ManualPanel();
    private RankingPanel rankingPanel = new RankingPanel();
    private ScorePanel scorePanel = new ScorePanel();
    private HeartPanel heartPanel = new HeartPanel();
    private GamePanel gamePanel = new GamePanel();
    private EndGamePanel endgamePanel = new EndGamePanel();
    
    private JOptionPane namepop = new JOptionPane();

    private File file;
    private AudioInputStream audio;
    private Clip clip;
    
    public GameFrame() {
        setTitle("팥빙수 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(998, 555);
        contentPane = this.getContentPane();
        contentPane.setLayout(cardLayout);
		setLocationRelativeTo(null);

        file = new File("팥빙수.wav");
        try {
        	audio = AudioSystem.getAudioInputStream(file);
        	clip = AudioSystem.getClip();
        	clip.open(audio);
        } catch (Exception e) {
        }
        Music();
        
        contentPane.add(homePanel, "HomePanel");
        contentPane.add(manualPanel, "ManualPanel");
        contentPane.add(rankingPanel, "RankingPanel");
        contentPane.add(scorePanel, "ScorePanel");
        contentPane.add(heartPanel, "HeartPanel");
        contentPane.add(gamePanel, "GamePanel");
        contentPane.add(endgamePanel, "EndGamePanel");
        
        homePanel.ManualButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ManualPanel");
            }
        });
        homePanel.StartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = namepop.showInputDialog("4자 이하의 이름을 입력하세요.");
                gamePanel.startGame(name);
                cardLayout.show(contentPane, "GamePanel");
            }
        });
        homePanel.ShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "RankingPanel");
            }
        });
        manualPanel.HomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "HomePanel");
            }
        });
        manualPanel.StartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	name = namepop.showInputDialog("4자 이하의 이름을 입력하세요.");
                gamePanel.startGame(name);
            	cardLayout.show(contentPane, "GamePanel");
            }
        });
        rankingPanel.HomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "HomePanel");
            }
        });
        rankingPanel.StartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = namepop.showInputDialog("4자 이하의 이름을 입력하세요.");
                gamePanel.startGame(name);
                cardLayout.show(contentPane, "GamePanel");
            }
        });
        endgamePanel.StartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = namepop.showInputDialog("4자 이하의 이름을 입력하세요.");
                gamePanel.startGame(name);
                cardLayout.show(contentPane, "GamePanel");
            }
        });
        setResizable(false);
        setVisible(true);
    } 
    private void Music() {
    	if (clip != null) {
    		clip.loop(Clip.LOOP_CONTINUOUSLY);
    		clip.start();
    	} 
    	else {
    		System.out.println("Clip is null");
    	}
    }
}
