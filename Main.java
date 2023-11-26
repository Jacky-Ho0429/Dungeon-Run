import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author Preston Wong and Jacky Ho
 *
 */
class Main {
	  	public static void main(String[] args) {

    	String[] processingArgs = {"TowerDefenseGame"};
		TowerDefenseGame mySketch = new TowerDefenseGame();
	    PApplet.runSketch(processingArgs, mySketch);
		PApplet.main("TowerDefenseGame");
	}
}
  
