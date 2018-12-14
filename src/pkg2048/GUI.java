package pkg2048;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Hashtable;
import java.util.Map;
import java.net.URL;
public class GUI {
    
    Game game;
    
    int aukstis = 424;
    int plotis = 328;
    int dydis = 296;
    int riba = 16;
    Color fonoSpalva = new Color (238, 207, 84);
    Font largeFeedbackFont = new Font("Sanserif", 0, 40);
    Font smallFeedbackFont = new Font("Sanserif", 0, 20);
    
    JLabel scoreLabel;
    
    Map skaiciukai;
    lentele l;
    
    
    MyFrame frame;
    
    public GUI() {
        game= new Game();
        frame = new MyFrame();
        frame.setFocusable(true);
        frame.addKeyListener(new MyFrame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        loadskaiciukai();
        
        l = new lentele();
        //l.setFocusable(true);
        
       JPanel upPanel = new JPanel();
       upPanel.setLayout(new GridLayout());
       upPanel.setPreferredSize(new Dimension(plotis, 112));
       JLabel pavadinimas = new JLabel("2048", SwingConstants.CENTER);
       pavadinimas.setFont(new Font("Serif", Font.BOLD, 20));
       upPanel.add(pavadinimas);
       scoreLabel = new JLabel("<html>Score:<br>0</html>", SwingConstants.CENTER);
       upPanel.add(scoreLabel);
       upPanel.add(new JLabel("<html>High Score:<br>224450</html>", SwingConstants.CENTER));
       upPanel.setBackground(fonoSpalva);
       
       JPanel kaire = new JPanel();
       kaire.setPreferredSize(new Dimension(riba, dydis));
       kaire.setBackground(fonoSpalva);
       
       JPanel desine = new JPanel();
       desine.setPreferredSize(new Dimension(riba, dydis));
       desine.setBackground(fonoSpalva);
       
       JPanel apacia = new JPanel();
       apacia.setPreferredSize(new Dimension(plotis, riba));
       apacia.setBackground(fonoSpalva);
       
       frame.getContentPane().add(upPanel, BorderLayout.NORTH);
       frame.getContentPane().add(kaire, BorderLayout.WEST);
       frame.getContentPane().add(desine, BorderLayout.EAST);
       frame.getContentPane().add(apacia, BorderLayout.SOUTH);
       frame.getContentPane().add(l, BorderLayout.CENTER);
       
       frame.getContentPane().setPreferredSize(new Dimension(plotis, aukstis));
       frame.pack();
       frame.setVisible(true);
    }
    
    private void loadskaiciukai() {
        skaiciukai = new Hashtable();
        ClassLoader cldr = this.getClass().getClassLoader();
        URL url0000 = cldr.getResource("images/0.png");
        URL url0002 = cldr.getResource("images/2.png");
        URL url0004 = cldr.getResource("images/4.png");
        URL url0008 = cldr.getResource("images/8.png");
        URL url0016 = cldr.getResource("images/16.png");
        URL url0032 = cldr.getResource("images/32.png");
        URL url0064 = cldr.getResource("images/64.png");
        URL url0128 = cldr.getResource("images/128.png");
        URL url0256 = cldr.getResource("images/256.png");
        URL url0512 = cldr.getResource("images/512.png");
        URL url1024 = cldr.getResource("images/1024.png");
        URL url2048 = cldr.getResource("images/2048.png");
        skaiciukai.put(0, new ImageIcon(url0000));
        skaiciukai.put(2, new ImageIcon(url0002));
        skaiciukai.put(4, new ImageIcon(url0004));
        skaiciukai.put(8, new ImageIcon(url0008));
        skaiciukai.put(16, new ImageIcon(url0016));
        skaiciukai.put(32, new ImageIcon(url0032));
        skaiciukai.put(64, new ImageIcon(url0064));
        skaiciukai.put(128, new ImageIcon(url0128));
        skaiciukai.put(256, new ImageIcon(url0256));
        skaiciukai.put(512, new ImageIcon(url0512));
        skaiciukai.put(1024, new ImageIcon(url1024));
        skaiciukai.put(2048, new ImageIcon(url2048));
    }
    
            
    class lentele extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            int[][] board = game.getlentele();
            for (int y = 1; y < 5; y++) {
                for (int x = 1; x < 5; x++) {
                    int X = (8 * x) +(64 * (x-1));
                    int Y = (8 * y) + (64 * (y-1));
                    int thisNumber = board[y-1][x-1];
                    
                    if (skaiciukai.containsKey(thisNumber)) {
                    ImageIcon thisTile = (ImageIcon) skaiciukai.get(thisNumber);
                    thisTile.paintIcon(this, g, X, Y);
                    }
                }
            }
        }
}
    class LaimejimoLent extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setFont(largeFeedbackFont);
            g.setColor(new Color(0, 120, 0));
            g.drawString("Laimejote!", 20, 50);
            g.setFont(smallFeedbackFont);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Paspauskite Enter", 20, 70);
        }
    }
    class PralaimejimoLent extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setFont(largeFeedbackFont);
            g.setColor(new Color(80, 0, 0));
            g.drawString("Pralaimejote..", 20, 50);
            g.setFont(smallFeedbackFont);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Paspauskite Enter", 20, 90);
        }
    }
    class MyFrame extends JFrame implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (game.getState() == Busena.CONTINUE) {
        if (key == KeyEvent.VK_UP) {
            System.out.println("paspaudete i virsu");
            game.Aukstyn();
            game.pridetiSkaiciu();
            game.checkState();
            l.repaint();
            updateScore();
        }
        else if (key == KeyEvent.VK_DOWN) {
            System.out.println("paspaudete i apacia");
            game.Zemyn();
            game.pridetiSkaiciu();
            game.checkState();
            l.repaint();
            updateScore();
        }
        else if (key == KeyEvent.VK_LEFT) {
            System.out.println("paspaudete i kaire");
            game.Kaire();
            game.pridetiSkaiciu();
            game.checkState();
            l.repaint();
            updateScore();
        }
        else if (key == KeyEvent.VK_RIGHT) {
            System.out.println("paspaudete i desine");
            game.Desine();
            game.pridetiSkaiciu();
            game.checkState();
            updateScore();
            l.repaint();
        }
        Busena b = game.getState();
        if (b == Busena.LOSE) {
            frame.getContentPane().remove(l);
            frame.getContentPane().add(new PralaimejimoLent(), BorderLayout.CENTER);
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
        }
        else if (b == Busena.WIN){
            frame.getContentPane().remove(l);
            frame.getContentPane().add(new LaimejimoLent(), BorderLayout.CENTER);
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
        }
        }
        else {
            if (key == KeyEvent.VK_ENTER) {
                game = new Game();
                frame.remove(((BorderLayout)getLayout()).getLayoutComponent(BorderLayout.CENTER));
                frame.getContentPane().add(l);
                l.repaint();
            frame.getContentPane().invalidate();
            frame.getContentPane().validate();
            }
        }
    }
        @Override
        public void keyTyped(KeyEvent e) {}
    }
    public void updateScore() {
        scoreLabel.setText("<html>Score:<br>" + game.getScore() + "<html>");
    }
}
