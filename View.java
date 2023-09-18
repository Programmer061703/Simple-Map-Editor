import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GraphicsConfigTemplate;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Point;

class View extends JPanel
{
	JButton saveB;
	JButton loadB; 
	BufferedImage[] images; 
	Model model;
	static int scrollx; 
	static int  scrolly;
	

	View(Controller c, Model m)
	{
		// Add save button
		saveB = new JButton("Save");
		saveB.addActionListener(c);
		saveB.setFocusable(false);
		this.add(saveB);




		// Load save button 
		loadB = new JButton("Load");
		loadB.setFocusable(false);
		loadB.addActionListener(c);
		this.add(loadB);


		// Link up to other objects
		c.setView(this);
		model = m;

		// Send mouse events to the controller
		this.addMouseListener(c);
		this.addMouseMotionListener(c);

		
		
		// Use a for loop to load the images for the things array
		this.images = new BufferedImage[Game.Things.length];
		for(int i = 0; i < Game.Things.length; i++)
		{
			try
			{
				images[i] = ImageIO.read(new File("images/" + Game.Things[i] + ".png"));
			} catch(Exception e) {
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}



		
		
	}

	public void paintComponent(Graphics g)
	{

		// Clear the background
		g.setColor(new Color(10, 249, 42));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Change color to purple
		g.setColor(new Color(255, 0, 255));
		// Draw a 200 x 200 box at top left of window
		g.fillRect(0, 0, 200, 200);

		
		// Selector for Purple box

		
		g.drawImage(this.images[Controller.index], 0, 0, null);
		
		// Draw in Green

		for(int i = 0; i < model.things.size(); i++ ){

			g.drawImage(this.images[model.things.get(i).type], (model.things.get(i).getPoint().x  - this.images[model.things.get(i).type].getWidth() /2) - scrollx, (model.things.get(i).getPoint().y - this.images[model.things.get(i).type].getHeight()/2) - scrolly, null);
			
			// Print out the x and y coordinates of the mouse to the terminal

			Point p = MouseInfo.getPointerInfo().getLocation();

			System.out.println("X: " + p.getX() + " Y: " + p.getY());

			

			

			
		}


		
		


		
		

		
	}
	
}
