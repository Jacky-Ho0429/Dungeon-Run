import processing.core.PApplet;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

/**
 * Main class to execute sketch
 * @author Preston Wong and Jacky Ho
 *
 */
class Main {
  public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    String[] processingArgs = {"MySketch"};
	Sketch mySketch = new Sketch();
	PApplet.runSketch(processingArgs, mySketch);


    // plays background music
    Scanner scanner = new Scanner(System.in);
		
	// finds the wav file to play
	File file = new File("Music/Music2.wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

	// preps the music file, opens it, and plays it from the start and makes go forever
	Clip clip = AudioSystem.getClip();
	clip.open(audioStream);
	clip.loop(Clip.LOOP_CONTINUOUSLY);
	clip.start();

	String response = scanner.next(); 
	

	}
    


  }
  
