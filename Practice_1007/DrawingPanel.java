package Practice_1007;

import java.awt.*; //graphics
import java.awt.event.*; // actionListener
import java.awt.image.*; //BufferedImage
import javax.swing.*; //JFrame, JPanel, JLabel
import javax.swing.event.*; //MouseListener

public class DrawingPanel extends MouseInputAdapter implements ActionListener {
	private JFrame frame; // overall window frame
	private JPanel panel; // drawing surface
	private JLabel statusBar; // status bar
	private Graphics g; // drawing pen

	// constructs a drawing panel of given size
	public DrawingPanel(int width, int height) {
		// set up the empty image onto which we will draw
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();
		g.setColor(Color.BLACK);

		// encloses the image in a label inside a panel
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(image));
		panel = new JPanel(new FlowLayout());
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(width, height));
		panel.add(label);

		// the status bar that shows the mouse position
		statusBar = new JLabel(" ");

		// attaches listener to observe mouse movement
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		// sets up the JFrame
		frame = new JFrame("Drawing Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(statusBar, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);

		// starts a repaint timer to refresh the screen
		Timer timer = new Timer(250, this);
		timer.start();
	}

	// obtains the Graphics object to draw on the panel
	public Graphics getGraphics() {
		return g;
	}

	// sets the background color of the drawing panel
	public void setBackground(Color c) {
		panel.setBackground(c);

	}
	// shows or hides the drawing panel on the screen

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	// used for timer that repeatedly repaints screen
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
	}

	// draws status bar text when mouse moves
	public void mouseMoved(MouseEvent e) {
		statusBar.setText("(" + e.getX() + ", " + e.getY() + ")");
	}

	public static void main (String[] arge) {
		DrawingPanel panel = new DrawingPanel(520, 240);
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();
		drawBook(g, 20, 35, 100);
		drawBook(g, 150, 70, 60);
		drawBook(g, 300, 10, 200);
		
	}
	
	// Draws a book of the given size at the given position.
	public static void drawBook(Graphics g, int x, int y, int size) {
		g.setColor(Color.CYAN); // cyan background
		g.fillRect(x, y, size, size);
		g.setColor(Color.WHITE); // white "bjp" text
		g.drawString("BJP", x + size/2, y + size/5);
		g.setColor(new Color(191, 118, 73));
		for (int i = 0; i < 10; i++) { // orange "bricks"
				g.fillRect(x, // x
							y + size/10 * i, // y
								size/10 * (i + 1), // width
								size/10 - 1); 
		}
	}
	
	
	
}
