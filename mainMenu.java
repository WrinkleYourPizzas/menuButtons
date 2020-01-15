import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainMenu implements MouseListener {	//KeyListener is like ActionListener but for keyboard
	private static final int height = 625;	//Window dimensions
	private static final int width = 900;

	public static Image backgroundImage = Toolkit.getDefaultToolkit().createImage("pvz.png").getScaledInstance(width, height,java.awt.Image.SCALE_SMOOTH);

	public static Clickables moreWaysToPlay = new Clickables(-0.003, 565.0, -240.0);	//Create the button 

	JFrame frame;	
	JPanel panel = new Canvas();	

	public mainMenu() {
		//Add the bottom, left, and right boundaries to the button
		
		//Linear uses the format y = mx + b, parameters are m, b, and an int(-1 for left, 1 for right, 0 for bottom)
		//Parabola uses vertex for y = a(x-h)^2 + b, parameters are a, h, b plus an int(-1 for left, 1 for right, 0 for bottom)
		
		//Linears only works when put on the sides though, so 0 is pretty much unusable, and parabolas only work for 
		//top and bottom so 1 and -1 are useless. They're just there if you want to make modifications in the future
		
		//I had to make the equations in Desmos so it overlapped the image though 
		
		moreWaysToPlay.createLinear(-7.0, 2800.0, -1);	//Left line
		moreWaysToPlay.createLinear(3.0, -2500.0, 1);	//Right line
		moreWaysToPlay.createParabola(-0.0001, -340.0, -320.0, 0);	//Button Line
		
		frame = new JFrame("Menu");	//Frame stuff
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		//frame.setResizable(false);
		frame.addMouseListener(this);

		panel.setLayout(new BorderLayout());	

		frame.add(panel);

		frame.setLocationRelativeTo(null);	//Make the frame visible
		frame.setVisible(true);
		
		frame.repaint();
		panel.repaint();
	}

	public static class Canvas extends JPanel {	//Make a new JPanel which unlike regular JPanels you can draw objects onto 
		public void paintComponent(Graphics g) {
			super.paintComponent(g);	//Call paintComponent from the overlord JPanel

			g.drawImage(backgroundImage, 0, 0, null);		
		}
	}

	public void mouseClicked(MouseEvent e) {	//Upon mouse click
		int clickX = e.getX();
		int clickY = -e.getY();

		System.out.println(clickX + ", " + clickY);
		System.out.println(moreWaysToPlay.clicked(clickX, clickY));	//If mouse clicked on a clickable thing
	}

	public void mousePressed(MouseEvent e) {}	//Homeless dudes
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


	public static void main(String[] args) {	//Call the graphics constructor
		new mainMenu();
	}
}
