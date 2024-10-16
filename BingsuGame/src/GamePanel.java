import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private ScorePanel scorePanel = new ScorePanel();
    private HeartPanel heartPanel = new HeartPanel();
    private TextSource textsource = new TextSource();
    private EndGamePanel endgamePanel = new EndGamePanel();
    private JTextField input = new JTextField(100);
    private JLabel nameLabel;
    private RankingPanel rankingPanel = new RankingPanel();

    private WordThread wordThread;
    private JLabel currentWordLabel;
    private String name;
    private Timer timer;
    private JLabel previousLabel;
    
    private ImageIcon back = new ImageIcon("생명화면.png");
    private ImageIcon bowl = new ImageIcon("빙수그릇.png");
    private ImageIcon ice = new ImageIcon("얼음추가.png");
    private ImageIcon strawberry1 = new ImageIcon("딸기추가.png");
    private ImageIcon strawberry2 = new ImageIcon("딸기아이스크림추가.png");
    private ImageIcon strawberry3 = new ImageIcon("딸기시럽추가.png");
    private ImageIcon mango1 = new ImageIcon("망고추가.png");
    private ImageIcon mango2 = new ImageIcon("망고떡추가.png");
    private ImageIcon mango3 = new ImageIcon("망고떡에아이스크림추가.png");
    private ImageIcon mango4 = new ImageIcon("망고시럽추가.png");
    private ImageIcon greentea1 = new ImageIcon("녹차가루추가.png");
    private ImageIcon greentea2 = new ImageIcon("녹차에떡추가.png");
    private ImageIcon greentea3 = new ImageIcon("녹차견과류추가.png");
    private ImageIcon greentea4 = new ImageIcon("녹차견과아이스크림추가.png");
    private ImageIcon greentea5 = new ImageIcon("녹차시럽추가.png");
    
    private ImageIcon strawberry = new ImageIcon("딸기빙수완성.png");
    private ImageIcon mango = new ImageIcon("망고빙수완성.png");
    private ImageIcon greentea = new ImageIcon("녹차빙수완성.png");
    
    public GamePanel() {
        setLayout(null);
        input.setBounds(115, 460, 500, 30);
        input.setVisible(true);
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
        add(input);
        scorePanel.setBounds(850, 131, 130, 50);
        scorePanel.setVisible(true);
        add(scorePanel);
        heartPanel.setBounds(763, 198, 200, 65);
        heartPanel.setVisible(true);
        add(heartPanel);
    }

    private void handleKeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String inputWord = input.getText();
            if (wordThread != null) {
                boolean isMatched = wordThread.checkWordMatched(inputWord);
                if (isMatched) {
                    // 맞은 경우 화면의 글자를 처리
                    if (currentWordLabel != null) {
                        currentWordLabel.setVisible(false);
                        remove(currentWordLabel);
                        repaint();
                    }
                    scorePanel.increase();
                } else {
                    scorePanel.decrease();
                }
                input.setText("");
            }
        }
    }

    public void startGame(String name) {
        this.name = name;

        if (wordThread != null && wordThread.isAlive()) {
            return;
        }

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordThread = new WordThread();
                wordThread.start();
            }
        });
        timer.start();
    }
    
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public class WordThread extends Thread {
        private JLabel newWord;
        private Timer Imagetimer;

        public JLabel getNewWord() {
            return newWord;
        }

        private boolean checkWordMatched(String inputWord) {
            if (newWord.getText().equals(inputWord)) {
                return true;
            }
            return false;
        }
        
        public void resumeGame() {
            Imagetimer.restart();
        }
        
        private void addImage(ImageIcon icon) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (previousLabel != null) {
                        remove(previousLabel);
                    }
                    JLabel newLabel = new JLabel(icon);
                    newLabel.setSize(245, 191);
                    newLabel.setLocation(733, 329);
                    add(newLabel);
                    revalidate();
                    repaint();
                    previousLabel = newLabel;
                }
            });
        }
        
        private void addClearImage(ImageIcon icon) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (previousLabel != null) {
                        remove(previousLabel);
                        revalidate();
                        repaint();
                    }

                    JLabel newLabel = new JLabel(icon);
                    newLabel.setSize(985, 517);
                    newLabel.setLocation(0, 0);
                    add(newLabel);
                    input.setVisible(false);
                    scorePanel.setVisible(false);
                    heartPanel.setVisible(false); 
                    nameLabel.setVisible(false);
                    revalidate();
                    repaint();

                    Timer clearImageTimer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    remove(newLabel);
                                    input.setVisible(true);
                                    input.requestFocus();
                                    scorePanel.setVisible(true);
                                    heartPanel.setVisible(true);
                                    nameLabel.setVisible(true);
                                    repaint();
                                }
                            });
                        }
                    });
                    clearImageTimer.setRepeats(false);
                    clearImageTimer.start();
                    previousLabel = newLabel;
                    scorePanel.increase();
                }
            });
        }

        @Override
        public void run() {
            newWord = new JLabel(textsource.get());
            newWord.setFont(new Font("배달의민족 주아", Font.BOLD, 30));

            JLabel nameLabel = new JLabel(name);
            Font font = new Font("배달의민족 주아", Font.PLAIN, 45);
            nameLabel.setFont(font);
            nameLabel.setSize(200, 60);
            nameLabel.setLocation(738, 2);
            add(nameLabel);
            
            GamePanel.this.setNameLabel(nameLabel);
            GamePanel.this.add(nameLabel);

            int x = (int) (Math.random() * 600 + 1);
            int y = 0;

            Imagetimer = new Timer(10, new ActionListener() {
                JLabel previousLabel = null;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (scorePanel.getScore() >= 10 && scorePanel.getScore() < 30) {
                        addImage(bowl);
                    }
                    else if (scorePanel.getScore() >= 30 && scorePanel.getScore() < 50) {
                        addImage(ice);
                    }
                    else if (scorePanel.getScore() >= 50 && scorePanel.getScore() < 70) {
                        addImage(strawberry1);
                    }
                    else if (scorePanel.getScore() >= 70 && scorePanel.getScore() < 90) {
                        addImage(strawberry2);
                    }
                    else if (scorePanel.getScore() >= 90 && scorePanel.getScore() < 110) {
                        addImage(strawberry3);
                    }
                    else if (scorePanel.getScore() == 110) {
                        addClearImage(strawberry);
                    }
                    else if (scorePanel.getScore() > 110 && scorePanel.getScore() < 140) {
                        addImage(bowl);
                    }
                    else if (scorePanel.getScore() >= 140 && scorePanel.getScore() < 170) {
                        addImage(ice);
                    }
                    else if (scorePanel.getScore() >= 170 && scorePanel.getScore() < 200) {
                        addImage(mango1);
                    }
                    else if (scorePanel.getScore() >= 200 && scorePanel.getScore() < 230) {
                        addImage(mango2);
                    }
                    else if (scorePanel.getScore() >= 230 && scorePanel.getScore() < 260) {
                        addImage(mango3);
                    }
                    else if (scorePanel.getScore() >= 210 && scorePanel.getScore() < 230) {
                        addImage(mango4);
                    }
                    else if (scorePanel.getScore() == 230) {
                        addClearImage(mango);
                    }
                    else if (scorePanel.getScore() > 230 && scorePanel.getScore() < 270) {
                        addImage(bowl);
                    }
                    else if (scorePanel.getScore() >= 270 && scorePanel.getScore() < 310) {
                        addImage(ice);
                    }
                    else if (scorePanel.getScore() >= 310 && scorePanel.getScore() < 350) {
                        addImage(greentea1);
                    }
                    else if (scorePanel.getScore() >= 350 && scorePanel.getScore() < 390) {
                        addImage(greentea2);
                    }
                    else if (scorePanel.getScore() >= 390 && scorePanel.getScore() < 430) {
                        addImage(greentea3);
                    }
                    else if (scorePanel.getScore() >= 430 && scorePanel.getScore() < 470) {
                        addImage(greentea4);
                    }
                    else if (scorePanel.getScore() >= 510 && scorePanel.getScore() < 550) {
                        addImage(greentea5);
                    }
                    else if (scorePanel.getScore() == 550) {
                        addClearImage(greentea);
                    	stopGame();
                    }
                }
            });

            Imagetimer.setRepeats(false);
            Imagetimer.start();

            while (y <= 460) {
                newWord.setBounds(x, y, 200, 30);
                GamePanel.this.add(newWord);
                GamePanel.this.repaint();

                y += 5;
                
                if (scorePanel.getScore() > 110 && scorePanel.getScore() < 230) {
                	y += 5.5;
                }
                
                if (scorePanel.getScore() > 230 && scorePanel.getScore() < 550) {
                	y += 6;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (checkWordMatched(input.getText())) {
                    currentWordLabel = newWord;
                    newWord.setVisible(false);
                    GamePanel.this.remove(newWord);
                    GamePanel.this.repaint();
                    scorePanel.increase();
                    return;
                }
            }

            if (y > 460) {
                newWord.setVisible(false);
                GamePanel.this.remove(newWord);
                GamePanel.this.repaint();
                heartPanel.decrease();
            }
            
            if (heartPanel.getHeart() == 0) {
            	stopGame();
            }
        }
    }

    private void stopGame() {
        // 게임 중지 및 score, name을 rankingPanel에 전달
        timer.stop();
        if (wordThread != null) {
            wordThread.interrupt();
        }

        int score = scorePanel.getScore();
        
        //rankingPanel.drawRanking(name, score);
        endgamePanel.drawRanking(name, score);

        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "EndGamePanel");
    }

    public void paintComponent(Graphics g) {
        ImageIcon GamebgIcon = new ImageIcon("게임화면.png");
        g.drawImage(GamebgIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
