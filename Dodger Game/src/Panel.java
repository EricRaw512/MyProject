import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener{
	
	JPanel player;
	Action upAction;
	Action leftAction;
	Action rightAction;
	Action downAction;
	Timer timer;
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	Enemy enemy4;
	Enemy enemy5;
	Enemy enemy6;
	Enemy enemy7;
	Enemy enemy8;
	Enemy enemy9;
	Enemy enemy10;
	Enemy change;
	int theScore;
	int scoreX;
	int scoreY;
	Random random;
	int time;

	public Panel() {
		random = new Random();
		scoreX = random.nextInt(475)+1;
		scoreY = random.nextInt(475)+1;
		enemy1 = new Enemy();
		enemy2 = new Enemy();
		enemy3 = new Enemy();
		enemy4 = new Enemy();
		enemy5 = new Enemy();
		enemy6 = new Enemy();
		enemy7 = new Enemy();
		enemy8 = new Enemy();
		enemy9 = new Enemy();
		enemy10 = new Enemy();
		setLayout(null);
		player = new JPanel();
		player.setBackground(Color.RED);
		player.setPreferredSize(new Dimension(25,25));
		player.setBounds(250, 400, 25, 25);
		player.setOpaque(true);
		
		upAction = new Up();
		leftAction = new Left();
		downAction = new Down();
		rightAction = new Right();
		
		player.getInputMap().put(KeyStroke.getKeyStroke('w'), "UpAction");
		player.getActionMap().put("UpAction", upAction);
		player.getInputMap().put(KeyStroke.getKeyStroke('s'), "DownAction");
		player.getActionMap().put("DownAction", downAction);
		player.getInputMap().put(KeyStroke.getKeyStroke('a'), "LeftAction");
		player.getActionMap().put("LeftAction", leftAction);
		player.getInputMap().put(KeyStroke.getKeyStroke('d'), "RightAction");
		player.getActionMap().put("RightAction", rightAction);
		player.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpAction");
		player.getActionMap().put("UpAction", upAction);
		player.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DownAction");
		player.getActionMap().put("DownAction", downAction);
		player.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftAction");
		player.getActionMap().put("LeftAction", leftAction);
		player.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RightAction");
		player.getActionMap().put("RightAction", rightAction);
		this.setPreferredSize(new Dimension (500,500));
		this.add(player);
		timer = new Timer(10,this);
		timer.start();
	}
	public void paint(Graphics g) {
		
		Graphics2D enemy = (Graphics2D) g;
		super.paint(g);
		enemy.drawString("Score : " + theScore, 0, 10);
		//enemy.drawString("High Score : " + MYPANEL.highScore, 0, 20); there no high score yet
		enemy.fillRect(enemy1.x, enemy1.y, enemy1.area, enemy1.area);
		enemy.fillRect(enemy2.x, enemy2.y, enemy2.area, enemy2.area);
		enemy.fillRect(enemy3.x, enemy3.y, enemy3.area, enemy3.area);
		enemy.fillRect(enemy4.x, enemy4.y, enemy4.area, enemy4.area);
		enemy.fillRect(enemy5.x, enemy5.y, enemy5.area, enemy5.area);
		enemy.fillRect(enemy6.x, enemy6.y, enemy6.area, enemy6.area);
		enemy.fillRect(enemy7.x, enemy7.y, enemy7.area, enemy7.area);
		enemy.fillRect(enemy8.x, enemy8.y, enemy8.area, enemy8.area);
		enemy.fillRect(enemy9.x, enemy9.y, enemy9.area, enemy9.area);
		enemy.fillRect(enemy10.x, enemy10.y, enemy10.area, enemy10.area);
		enemy.setColor(Color.blue);
		enemy.fillRect(scoreX,scoreY,25,25);

		
	}
	public class Up extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (player.getY() >= 5)
				player.setLocation(player.getX(), player.getY()-10);
		}
		
	}
	public class Down extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (player.getY() <= 470)
				player.setLocation(player.getX(), player.getY()+10);
			
		}
		
	}
	public class Left extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (player.getX() >= 5)
				player.setLocation(player.getX()-10, player.getY());
			
		}
	}
	public class Right extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (player.getX() <= 470)
				player.setLocation(player.getX()+10, player.getY());
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		collision(enemy1, player.getX(), player.getY());
		collision(enemy2, player.getX(), player.getY());
		collision(enemy3, player.getX(), player.getY());
		collision(enemy4, player.getX(), player.getY());
		collision(enemy5, player.getX(), player.getY());
		collision(enemy6, player.getX(), player.getY());
		collision(enemy7, player.getX(), player.getY());
		collision(enemy8, player.getX(), player.getY());
		collision(enemy9, player.getX(), player.getY());
		collision(enemy10, player.getX(), player.getY());
		if ((player.getX() <= scoreX && scoreX <= player.getX() + 25 || player.getX() <= scoreX + 25 && scoreX + 25 <= player.getX() + 25)  && 
			(player.getY() <= scoreY && scoreY <= player.getY() + 25 || player.getY() <= scoreY+25  && scoreY+25 <= player.getY() + 25)) {
			theScore += 500;
			scoreX = random.nextInt(475)+1;
			scoreY = random.nextInt(475)+1;
			time = 0;
			}
		else if (time == 500) {
			scoreX = random.nextInt(475)+1;
			scoreY = random.nextInt(475)+1;
			time = 0;
			}
		else {
			theScore ++;
			time ++;
		}
	}
	public void collision (Enemy enemy,int x1 ,int y1) {
			if (enemy.y >= 500) {
				enemy.y = 0;
				enemy.x = random.nextInt(475)+1;
				enemy.area = random.nextInt(25)+10;
				enemy.fall = random.nextInt(3)+1;
				repaint();
			}
			else {
				enemy.y += enemy.fall + ((theScore +1) *0.00075);
				repaint();	
			}
			if ((x1 < enemy.x  && enemy.x < x1 + 25 || (x1 < enemy.x + enemy.area  && enemy.x + enemy.area < x1 + 25))  && 
				(y1 < enemy.y  && enemy.y < y1 + 25 || y1 < enemy.y + enemy.area  && enemy.y + enemy.area < y1 + 25)) {
				timer.stop();
				}
	}
	public class Enemy {
		
		Random random;
		int x;
		int y;
		int area;
		int fall;

		
		public Enemy () {
			random = new Random();
			x = random.nextInt(475)+1;
			y = random.nextInt(50)+1;
			area = random.nextInt(25)+10;
			fall = random.nextInt(3)+1;
		}
	}
}