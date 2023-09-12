import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener
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
		// System.out.println("Hey! I said never push that button! This incident will be reported! (j/k)");
		// view.removeButton();
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

			model.addThing(e.getX(), e.getY());

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
}
