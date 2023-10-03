import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	View view;
	Model model;

	// Variables for the box around the Purple box
	

	
	// Variables for the box around save and load
	


	
	int margin = 100;
	
	static int index; 

	Controller(Model m)
	{
		model = m;
	}

	void setView(View v)
	{
		view = v;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == view.saveB)
		{
			model.save();
		}
		else if(e.getSource() == view.loadB)
		{
			model.load();
		}
		
		
	}
	
	public void mousePressed(MouseEvent e)
	{

		
		// Add a thing to the model using method

		  if(e.getX() < 200 && e.getY() < 200){

			index ++; 

			if(index >= Game.Things.length){

				index = 0;

			}



		  }

		  if(e.getButton() == 1 && (e.getX() > 200 || e.getY() > 200)){

			model.addThing(e.getX() + View.scrollx, e.getY() + View.scrolly); 



		  }

		  else if (e.getButton() == 3){

			model.removeThing(e.getX(), e.getY());
		  }


	}



	public void mouseReleased(MouseEvent e) 
	{	}
	
	public void mouseEntered(MouseEvent e) 
	{	}
	
	public void mouseExited(MouseEvent e) 
	{	}
	
	public void mouseClicked(MouseEvent e) 
	{	}
	
	public void keyPressed(KeyEvent e)
	{
		
	}

	public void keyReleased(KeyEvent e)
	{
		
	}

	public void keyTyped(KeyEvent e)
	{	}

	void update()
	{
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
	}

	@Override
	public void mouseMoved(MouseEvent e) {


		//Save Load Box
	int windowWidth = view.getWidth();
	
	int SboxX = windowWidth/2 - 100;

	int SboxY = 0;
	int SboxWidth = 200; 
	int SboxHeight = 120;
	//Purple Box
	int PboxX = 0; 
    int PboxY = 0;
    int PboxWidth = 200; 
    int PboxHeight = 200;
	Point p = MouseInfo.getPointerInfo().getLocation();
	
	
	

		// Purple Box 
		if(e.getX() >= PboxX && e.getX() <= (PboxWidth) && e.getY() >= PboxY && e.getY() <= ( PboxHeight)) {

			
			System.out.println("Mouse is in the box");
			
 



		}

		// Save and Load Box

		else if(e.getX() >= SboxX && e.getX() <= (SboxX + SboxWidth) && e.getY() >= SboxY && e.getY() <= (SboxY + SboxHeight)){

			System.out.println("Mouse is in the box");
			
			

		}

		// Mouse is not in the box
		else{

			//System.out.println("Mouse is not in the box");

		try{


				
				// Scroll to the right
			if (p.x >= (view.getWidth() - margin)) {  

				Robot robot = new Robot();
				
				
				robot.mouseMove(view.getWidth() - margin, p.y);
				View.scrollx += 10;

				


			}

			// Scroll to the left
			else if (p.x <= margin) {

				Robot robot = new Robot();
				
				robot.mouseMove(margin, p.y);
				
				View.scrollx -= 10;
			}

			// Scroll up
			else if (p.y <= margin) {  

				Robot robot = new Robot();

				robot.mouseMove(p.x, margin);
				
				View.scrolly -= 10;
			}

			// Scroll down
			else if (p.y >= (view.getHeight() - margin)) {  

				Robot robot = new Robot();

				robot.mouseMove(p.x, view.getHeight() - margin);
				
				View.scrolly += 10;
			}
		}
		catch(Exception ex){

			ex.printStackTrace(System.err);
			System.exit(1);


		}
		

		
	}
}





}
