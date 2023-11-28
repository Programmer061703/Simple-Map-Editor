import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.*;
import java.awt.*;

import javax.annotation.processing.SupportedOptions;

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

		if(Controller.index == 9){

			things.add(new Jumper(x, y, Controller.index));
			
		}

		else if(Controller.index == 14){


			things.add(new Thing(x, y, Controller.index));

		Thread bibleThread = new Thread(() -> Bible.DisplayBible());
        Thread audioThread = new Thread(() -> AudioPlayer.playAudio());
		Thread asciiThread = new Thread(() -> Ascii.AsciiArtWindow());

		bibleThread.start();
		audioThread.start();
		asciiThread.start();

		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	
			
		}
		else{

		things.add(new Thing(x, y, Controller.index)); // May want to change later
		}
		
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

			if(list_of_things.get(i).getLong("kind") == 9){

				this.things.add(new Jumper(list_of_things.get(i)));
			}
			else
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
		double t = 0;

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
				j.add("t", this.t);


				return j; 
		}

		public Point getPoint(){
			return new Point(this.x, this.y);
		}

		Thing(Json ob){
			this.x = (int)ob.getLong("x");
			this.y = (int)ob.getLong("y");
			this.type = (int)ob.getLong("kind");
			this.t = (double)ob.getDouble("t");
		}
}

class Jumper extends Thing{

	


	Jumper(int x, int y, int type){
		super(x, y, type);
	}
	Jumper(Json ob){
			super(ob);
		}

	
	@Override
	public Point getPoint(){
		t++;
		int yOff = (int)Math.max(0., 50 * Math.sin(((double)t) / 5));

		return new Point(x, y - yOff);
	}

	//return new Point(this.x, this.y - (int)Math.max(0., 50 * Math.sin(((double)t) / 5)))



}



    



	

	








	

