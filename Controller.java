import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

class Controller implements ActionListener, MouseListener, KeyListener, MouseMotionListener
{
	View view;
	Model model;

	// Variables for the box around the Purple box
	int PboxX = 0; 
    int PboxY = 0;
    int PboxWidth = 200; 
    int PboxHeight = 200;
	// Variables for the box around save and load
	int SboxX = 0; 
	int SboxY = 0;
	int SboxWidth = 200; 
	int SboxHeight = 200;
	
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

			model.addThing(e.getX() + View.scrollx, e.getY() + View.scrolly); // Add ScrollX and ScrollY to this later



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

		
		if(e.getX() >= PboxX && e.getX() <= (PboxX + PboxWidth) && e.getY() >= PboxY && e.getY() <= (PboxY + PboxHeight)) {

			
			System.out.println("Mouse is in the box");
			



		}

		else if(){
			
			

		}

		else{

			//System.out.println("Mouse is not in the box");

				// Scroll to the right
			if (e.getX() >= (view.getWidth() - margin)) {  
				
				
				View.scrollx += 10;
			}

			// Scroll to the left
			else if (e.getX() <= margin) {  
				
				View.scrollx -= 10;
			}

			// Scroll up
			else if (e.getY() <= margin) {  
				
				View.scrolly -= 10;
			}

			// Scroll down
			else if (e.getY() >= (view.getHeight() - margin)) {  
				
				View.scrolly += 10;
			}


		}
		

		
	}
}
