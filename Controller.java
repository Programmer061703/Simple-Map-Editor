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

		// Scroll Right in the X direction

		if(e.getX() <= 100 && e.getY() >= 100){

			View.scrollx -= 10;

		}

		// Scroll Left in the X direction

		else if(e.getX() >= 900 && e.getY() >= 100 ){


			View.scrollx += 10; 


		 }
		// Scroll Up in the Y direction
		else if(e.getX() >= 100 && e.getX() <= 900 && e.getY() <= 100){

			View.scrolly -= 10; 

		}
		
		// Scroll Down in the Y direction

		else if(e.getX() >= 100 && e.getX() <= 900 && e.getY() >= 600){

			View.scrolly += 10; 

		}
		


	}
}
