package Galagagame01;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class GalagaGame extends JPanel implements KeyListener{
    private boolean running = true;
    
    private ArrayList sprites = new ArrayList();
    private Sprite starship;
    private BufferedImage bgImage;
    private BufferedImage alienImags;
    private BufferedImage shotImags;
    private BufferedImage shipImags;
    private BufferedImage boomImags;
    
    public GalagaGame() {
        //프레임 생성
        JFrame frame = new JFrame("Galaga Game");
        frame.setSize(800,600);
        frame.add(this);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            bgImage = ImageIO.read(new File("bgImage.png"));
            alienImags =ImageIO.read(new File("alien.png"));
            shotImags =ImageIO.read(new File("fire.png"));
            shipImags =ImageIO.read(new File("ship.png"));
            boomImags =ImageIO.read(new File("boom.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.requestFocus();
        this.initSprites();
        addKeyListener(this);
    }
    
    private void initSprites() {
        //필요한 객체 생성, 울히ㅐ의 우주선과 외꼐인 우주선을 만든다.
        starship = new StarShipSprite(this, shipImags, 382,460);
        sprites.add(starship);
        for(int y = 0; y < 5; y ++) {
            for( int x = 0; x < 12; x ++) {
                Sprite alien = new AlienSprite(this, alienImags, (100+ (x*40)), (40 + y*30));
                sprites.add(alien);
            }
        }
    }
    
    private void startGame() {
        sprites.clear();
        initSprites();
    }
    
    public void endGame() {
        System.exit(0);
    }
    
    public void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
    }
    
    public void fire() {
        //포탄이 발사되면 ARralist 객체인 sprites에 추가된다
        ShootSprite shot = new ShootSprite(this, shotImags, starship.getX() + 10, starship.getY() - 30);
        sprites.add(shot);
        ShootSprite shot2 = new ShootSprite(this, shotImags, starship.getX() + 50, starship.getY() - 30);
        sprites.add(shot2); // ????
    }
    
    public void boom() {
        Boom boom = new Boom(this, boomImags, starship.getX() + 10, starship.getY() - 30);
        sprites.add(boom);
        sprites.add(boom);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);
        g.drawImage(bgImage, 0,0, null);
        for(int i = 0; i < sprites.size(); i++) {
            Sprite sprite = (Sprite) sprites.get(i);
            sprite.draw(g);
        }
    }
    
    public void gameLoop() {
        while(running) { //객체를 움직인다
            for(int i = 0; i < sprites.size(); i++) {
                Sprite sprite = (Sprite) sprites.get(i);
                sprite.move();
            }
            
            for(int p = 0; p < sprites.size(); p++) { //층을 검사한다. 
                for(int s = p + 1; s < sprites.size(); s++) {
                    Sprite me = (Sprite) sprites.get(p);
                    Sprite other = (Sprite) sprites.get(s);
                    
                    if(me.checkCollision(other)) {
                        me.handleCollision(other);
                        other.handleCollision(me);
                    }
                }
            }
            repaint(); //다시 그린다
            try {
                Thread.sleep(10);
            } catch(Exception e) {
                
            }
        }
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            starship.setDx(-3);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            starship.setDx(+3);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            starship.setDy(-3);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            starship.setDy(+3);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire();
        }
        if(e.getKeyCode() == KeyEvent.VK_B) {
            boom();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            starship.setDx(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            starship.setDx(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            starship.setDy(0);      
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            starship.setDy(0);      
        }
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }
    
    public static void main(String args[]) {
        GalagaGame g = new GalagaGame();
        g.gameLoop();
        
    }
}

