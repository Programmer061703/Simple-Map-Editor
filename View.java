import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GraphicsConfigTemplate;
import java.awt.List;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;






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

		// Use a for loop to read in the Bible.txt into an array



		





		
		
	}

	public void paintComponent(Graphics g)
	{

		// Clear the background
		g.setColor(new Color(10, 249, 42));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		

		

		
		// Selector for Purple box

		
		g.drawImage(this.images[Controller.index], 0, 0, null);
		
		// Draws Images 

		for(int i = 0; i < model.things.size(); i++ ){

			g.drawImage(this.images[model.things.get(i).type], (model.things.get(i).getPoint().x  - this.images[model.things.get(i).type].getWidth() /2) - scrollx, (model.things.get(i).getPoint().y - this.images[model.things.get(i).type].getHeight()/2) - scrolly, null);
			
			// Print out the x and y coordinates of the mouse to the terminal
			
		}
		

		// Draw the purple box
		g.setColor(new Color(255, 0, 255));
		g.fillRect(0, 0, 200, 200);
		
		// Draw the selector for the purple box
		g.drawImage(this.images[Controller.index], 0, 0, null);



	


		
		


		
		

		
	}
	
}


 class Bible extends JFrame{


	private static int currentLineIndex;
	
	
	
	// Reads in the bible.txt to an array
   
	
	public static ArrayList<String> loadBible() {
        // Create an ArrayList to store the lines of the text file
        ArrayList<String> lines = new ArrayList<>();

        // Define the path to your bible.txt file
        String filePath = "bible.txt";

        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            
            // Read each line of the file and add it to the ArrayList
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // Exit the program if an error occurs
        }

		return lines; 

        
        
        
    }

	public static void DisplayBible(){
		
		JFrame frame = new JFrame("Bible Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea));

        ArrayList<String> lines = loadBible();
        currentLineIndex = 0;
		

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentLineIndex < lines.size()) {
                    textArea.append(lines.get(currentLineIndex) + "\n");
                    currentLineIndex++;
                } else {
                    // All lines have been displayed; stop the timer
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        frame.setVisible(true);
        timer.start();
    }


     public void AsciiArtWindow() {
       
    }

   

		






	}



	 class AudioPlayer{

		public static void playAudio() {
        // Hardcoded audio file path
        String audioFilePath = "HolyMusic.wav";

        try {
            // Create an AudioInputStream to read the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath));

            // Get the audio format from the input stream
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Set up the data line info
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);

            // Get a source data line (for playback)
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

            // Open the source data line and start it
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // Read and play the audio data
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                sourceDataLine.write(buffer, 0, bytesRead);
            }

            // Wait for the audio to finish playing
            sourceDataLine.drain();

            // Close the audio input stream and the data line
            audioInputStream.close();
            sourceDataLine.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


	}

    
}



 class Ascii extends JFrame {

    private String asciiArt;

    public Ascii(String asciiArt) {
        this.asciiArt = asciiArt;
        setTitle("ASCII Art Display");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a custom JPanel with the ASCII art
        setContentPane(new AsciiPanel());
    }

    private static String getAsciiArt() {
        // Replace this with your own ASCII art
        return                     "\t-------------------\n" +
                                    "\t\t|---------------|\n" +
                                     "\t\t|-------------|\n" +
                        "\t|->----------|-------------|----------<-|\n" +
                        "\t| >___----------------------------___<  |\n" +
                        "\t| |+++++++++++++++     +++++++++++++++| |\n" +
                        "\t| |__+++++++++++++     +++++++++++++__| |\n" +
                        "\t|_>  -------|               |-------  >_|\n" +
                                    "\t\t|               |\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++     +++++|\n" +
                                    "\t\t|+++++++++++++++|\n" +
                                    "\t\t|+++++++++++++++|\n" +
                                    "\t\t|+++++++++++++++|\n" +
                                    "\t\t|---------------|\n" + 
                                    "\t\t|---------------|\n" +
                                   "\t\t-------------------";
    }

      public static void AsciiArtWindow() {
        // Create an instance of the Ascii class and make it visible
        Ascii ascii = new Ascii(getAsciiArt());
        ascii.setVisible(true);
    }
    class AsciiPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Display ASCII art in the center of the panel
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));
        String[] lines = asciiArt.split("\n");
        
        // Calculate the center of the panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int totalHeight = lines.length * 20; // Assuming each line has a height of 20 pixels
        int y = (panelHeight - totalHeight) / 2;

        // Draw each line at the center
        for (String line : lines) {
            int x = (panelWidth - g.getFontMetrics().stringWidth(line)) / 2;
            g.drawString(line, x, y);
            y += 20; // Assuming each line has a height of 20 pixels
        }
    }
}

}
