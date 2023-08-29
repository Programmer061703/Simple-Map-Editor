import java.util.ArrayList;

class Model
{
	int turtle_x;
	int turtle_y;
	int dest_x;
	int dest_y;
	static int speed = 4;
	ArrayList<Thing> things;

	Model()
	{
		this.turtle_x = 100;
		this.turtle_y = 100;
		this.dest_x = 150;
		this.dest_y = 100;
		this.things = new ArrayList<Thing>();
	}

	public void update()
	{
		if(this.turtle_x < this.dest_x)
            this.turtle_x += Math.min(speed, dest_x - turtle_x);
		else if(this.turtle_x > this.dest_x)
            this.turtle_x -= Math.max(speed, dest_x - turtle_x);
		if(this.turtle_y < this.dest_y)
            this.turtle_y += Math.min(speed, dest_y - turtle_y);
		else if(this.turtle_y > this.dest_y)
            this.turtle_y -= Math.max(speed, dest_y - turtle_y);
	}

    public void reset()
    {
        turtle_x = 200;
        turtle_y = 200;
        dest_x = turtle_x;
        dest_y = turtle_y;
    }

	public void setDestination(int x, int y)
	{
		this.dest_x = x;
		this.dest_y = y;
	}

	//Add a class to represent a thing

	class Thing
	{
		int x;
		int y;
		int type;

		Thing(int x, int y, int type)
		{
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	
	public void addThing(int x, int y)
	{

		things.add(new Thing(x, y, 0));
		
	}

	

	




	

	



	

}