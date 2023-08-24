import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	JButton b1;
	BufferedImage turtle_image;
	Model model;

	View(Controller c, Model m)
	{
		// // Make a button
		// b1 = new JButton("Never push me!");
		// b1.addActionListener(c);
		// this.add(b1);

		// Link up to other objects
		c.setView(this);
		model = m;

		// Send mouse events to the controller
		this.addMouseListener(c);

		// Load the turtle image
		try
		{
			this.turtle_image = ImageIO.read(new File("images/turtle.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	public void paintComponent(Graphics g)
	{
		// Clear the background
		g.setColor(new Color(10, 249, 42));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Draw the image so that its bottom center is at (x,y)
		int w = this.turtle_image.getWidth();
		int h = this.turtle_image.getHeight();
		g.drawImage(this.turtle_image, model.turtle_x - w / 2, model.turtle_y - h, null);
	}
	
	// void removeButton()
	// {
	// 	this.remove(this.b1);
	// 	this.repaint();
	// }
}
