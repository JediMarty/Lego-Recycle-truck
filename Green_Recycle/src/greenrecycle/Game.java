package greenrecycle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame implements KeyListener{
	
	JLabel bg;
	JLabel car;
	JLabel leaf1;
	JLabel leaf2;
	JLabel leaf3;
	JLabel leaf4;
    JLabel points;
    ImageIcon map1 = new ImageIcon("map_Park.png");
	ImageIcon carImgfw = new ImageIcon("car_Pos1.png");
	ImageIcon carImgleft = new ImageIcon("car_Pos2.png");
	ImageIcon carImgright = new ImageIcon("car_Pos3.png");
	ImageIcon carImgbw = new ImageIcon("car_Pos4.png");
	ImageIcon leaves = new ImageIcon("leaves.png");
	ImageIcon quit = new ImageIcon("quit_button.png");
	JButton QuitButton = new JButton();
	//
	JPanel cardPanel = new JPanel(new CardLayout());
	JPanel gamepanel1 = new JPanel();
	JPanel gamepanel2 = new JPanel();
	JPanel gamepanel3 = new JPanel();
	
	Random rand = new Random();
	int randomx, randomy;
	int point = 0;
	Boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
	
	public Game() {
		
		bg = new JLabel();
		bg.setIcon(map1);
		bg.setBounds(0, 0, 800, 800);
		
		car = new JLabel();
        car.setIcon(carImgfw);
		car.setBounds(600,600,100,100);
		
		leaf1 = new JLabel();
		leaf1.setIcon(leaves);
		randomx = rand.nextInt(680);
		randomy = rand.nextInt(660);
		leaf1.setBounds(randomx,randomy,100,100);
		
		leaf2 = new JLabel();
		leaf2.setIcon(leaves);
		randomx = rand.nextInt(680);
		randomy = rand.nextInt(660);
		leaf2.setBounds(randomx,randomy,100,100);
		
		leaf3 = new JLabel();
		leaf3.setIcon(leaves);
		randomx = rand.nextInt(680);
		randomy = rand.nextInt(660);
		leaf3.setBounds(randomx,randomy,100,100);
		
		leaf4 = new JLabel();
		leaf4.setIcon(leaves);
		randomx = rand.nextInt(680);
		randomy = rand.nextInt(660);
		leaf4.setBounds(randomx,randomy,100,100);
		
		points = new JLabel();
		points.setText("0");
		points.setForeground(Color.WHITE);
		points.setFont(new Font("", Font.PLAIN, 40));
		points.setBounds(740,-40,150,150);
		
		QuitButton.setIcon(quit);
		QuitButton.setBorderPainted(false);
		QuitButton.setBounds(700, 730, 80, 30);
		QuitButton.setContentAreaFilled(false);
		QuitButton.setFocusPainted(false);
		QuitButton.setOpaque(false);
		//QuitButton.addActionListener(this);
	    QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	    gamepanel1.add(QuitButton);
	    gamepanel1.add(car);
	    gamepanel1.add(leaf1);
	    gamepanel1.add(leaf2);
	    gamepanel1.add(leaf3);
	    gamepanel1.add(leaf4);
	    gamepanel1.add(points);
	    gamepanel1.add(bg);
	    gamepanel1.setLayout(null);
	    
	    cardPanel.add(gamepanel1);

	    this.setName("Green Recycle");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GREEN);
		this.setLayout(null);
	    cardPanel.setBounds(0,0,800,800);
		this.add(cardPanel);
		this.setFocusable(true); 
		this.requestFocusInWindow();
		this.addKeyListener(this);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Game();
		
	}

	public void isColect() {
	
		if (car.getBounds().intersects(leaf1.getBounds())) {
			
			this.score();
			flag1 = true;
			this.leafGenerator();
		
			}
		else if (car.getBounds().intersects(leaf2.getBounds())){
			
			this.score();
			flag2 = true;
			this.leafGenerator();
		
		}
		else if (car.getBounds().intersects(leaf3.getBounds())){
		
			this.score();
			flag3 = true;
			this.leafGenerator();
			
		}
		else if (car.getBounds().intersects(leaf4.getBounds())){
		
			this.score();
			flag4 = true;
			this.leafGenerator();
			
		}
	     else {
				flag1 = false;
				flag2 = false;
				flag3 = false;
				flag4 = false;
			}
			
		}
	
	public void leafGenerator() {
		if (flag1 == true) {
			randomx = rand.nextInt(680);
			randomy = rand.nextInt(660);
			leaf1.setBounds(randomx,randomy,100,100);
		    flag1 = false;
		}
		else if (flag2 == true) {
			randomx = rand.nextInt(680);
			randomy = rand.nextInt(660);
			leaf2.setBounds(randomx,randomy,100,100);
			flag2 = false;
		}
		else if (flag3 == true) {
			randomx = rand.nextInt(680);
			randomy = rand.nextInt(660);
			leaf3.setBounds(randomx,randomy,100,100);
			flag3 = false;
			}
		else if (flag4 == true) {
			randomx = rand.nextInt(680);
			randomy = rand.nextInt(660);
			leaf4.setBounds(randomx,randomy,100,100);
			flag4 = false;
			}
	}
	
	
	public void score() {
		point +=1;
		points.setText(String.valueOf(point));
		
	}
	
	public void changescene() {
		CardLayout cl = (CardLayout) (cardPanel.getLayout());
		cl.next(cardPanel);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case 37: if (car.getX() == 0) {
			car.setLocation(car.getX(), car.getY());
		}
		else 
			{
			car.setLocation(car.getX()-10, car.getY());
			}
		         this.isColect();
		         car.setIcon(carImgleft); 
		         break;
		
		case 38: if (car.getY() == 0) {
			car.setLocation(car.getX(), car.getY());
		}
		else {
			car.setLocation(car.getX(), car.getY()-10);
		}
		        this.isColect();
		        car.setIcon(carImgfw);
		        break;
		
		case 39:  if (car.getX() == 680) {
			car.setLocation(car.getX(), car.getY());
		}
		else {
			car.setLocation(car.getX()+10, car.getY());
		}
		         this.isColect();
		         car.setIcon(carImgright);
		         break;
		
		case 40: if (car.getY() == 660) {
			car.setLocation(car.getX(), car.getY());
		}
		else {
			car.setLocation(car.getX(), car.getY()+10);
		}
		         this.isColect();
		         car.setIcon(carImgbw);
		         break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
