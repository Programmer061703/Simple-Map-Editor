import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import netscape.javascript.JSObject;

class Model
{
	static int speed = 4;
	ArrayList<Thing> things;

	Model()
	{
		
		
		this.things = new ArrayList<Thing>();
		
	}

	public void update()
	{
		
	}

    public void reset()
    {
        
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
			double distance = Math.sqrt(Math.pow((x + View.scrollx)  - this.things.get(i).x,2) + Math.pow((y + View.scrolly)  - things.get(i).y,2));

			if (distance < closest_distance){
				closest_thing = i; 
				closest_distance = distance; 
			}
		}

			things.remove(closest_thing); 

		
	}


		public  Json marshal()
	{
  	Json map = Json.newObject();
  	Json list_of_things = Json.newList();
  	map.add("things", list_of_things);
  	for (Thing t : this.things)
  	{
   	 	list_of_things.add(t.marshal());
		

				

 	}
 	 return map;
	 

	}

	public Json unMarshal(Json ob){

		Json list_of_things = ob.get("things");
		this.things.clear();

		for(int i = 0; i < list_of_things.size(); i++){
			this.things.add(new Thing(list_of_things.get(i)));
		}


		return list_of_things;
	}

	
	

	public void save(){

		try {
			FileWriter writer = new FileWriter("map.json");
			writer.write(this.marshal().toString());
			writer.close();
			
		  } catch (IOException exception) {
			exception.printStackTrace();
			System.exit(1);
		  }

	}

	public void load(){
		Json ob = Json.load("map.json");
		unMarshal(ob);
		System.out.println(ob);



		

		


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

		Json marshal(){
				Json j = Json.newObject(); 
				j.add("x",this.x);
				j.add("y", this.y);
				j.add("kind", this.type);


				return j; 
		}

		Thing(Json ob){
			this.x = (int)ob.getLong("x");
			this.y = (int)ob.getLong("y");
			this.type = (int)ob.getLong("kind");
		}
}


	

