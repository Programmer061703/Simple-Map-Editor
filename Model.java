import java.util.ArrayList;

class Model
{
	
	int dest_x;
	int dest_y;
	static int speed = 4;
	ArrayList<Thing> things;

	Model()
	{
		
		this.dest_x = 150;
		this.dest_y = 100;
		this.things = new ArrayList<Thing>();
		
	}

	public void update()
	{
		
	}

    public void reset()
    {
        
    }

	public void setDestination(int x, int y)
	{
		this.dest_x = x;
		this.dest_y = y;
	}

	//Add a class to represent a thing


	
	public void addThing(int x, int y)
	{

		things.add(new Thing(x, y, Controller.index)); // May want to change later
		
	}

	public void removeThing(int x, int y){

		double closest_distance = Double.MAX_VALUE; 

		int closest_thing = -1; 

		for(int i = 0; i < things.size(); i++){
			double distance = Math.sqrt(Math.pow(x - this.things.get(i).x,2) + Math.pow(y - things.get(i).y,2));

			if (distance < closest_distance){
				closest_thing = i; 
				closest_distance = distance; 
			}
		}

			things.remove(closest_thing); 

		
	}

}


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