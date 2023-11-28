import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.Iterator;


public class TowerDefenseGame extends PApplet {

    PImage[] imgMap;
    PImage imgEnemy;
    
    int intMap = 1;

    float[] fltPathX = {0, 165, 165, 280, 280, 445, 445, 165, 165, 535, 535, 635, 635, 535, 535, 165, 165};
    float[] fltPathY = {305, 305, 225, 225, 490, 490, 145, 145, 60, 60, 140, 140, 225, 225, 380, 380, 518};
    int intframeCounter;

    ArrayList<Enemy> enemies;
    test

    public void settings() {

        // Set Screen Size
        size(695, 518);

        // Load Maps & Sprites
        imgMap = new PImage[3];

        for (int i = 1; i < 3; i++) {
            
            imgMap[i] = loadImage("Maps/Map" + i + ".png");

        }

        imgEnemy = loadImage("Sprites/Enemy.png");

    }

    public void setup() {

        // Initialize Enemy At The Start Of The Path
        enemies = new ArrayList<>();
        enemies.add(new Enemy(fltPathX[0], fltPathY[0]));;
        
    }

    public void addEnemy() {


        enemies.add(new Enemy(fltPathX[0], fltPathY[0]));
    }

    public void draw() {
        background(255);

        // Draw the path
        stroke(0);
        if (intMap == 1) {
            image(imgMap[1], 0, 0);

            for (int i = 1; i < fltPathX.length; i++) {
            noStroke();
            line(fltPathX[i - 1], fltPathY[i - 1], fltPathX[i], fltPathY[i]);
            }
        }

        // Update and draw the enemies
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {

            Enemy enemy = iterator.next();
            enemy.update();
            enemy.display();

            // Optionally, you can remove the enemy from the ArrayList if it's at (165, 518)
            if (enemy.x == 165 && enemy.y == 518) {

                iterator.remove();

            }

        }

    // Add a new enemy every 60 frames
    if (intframeCounter % 60 == 0) {
        addEnemy();
    }

    intframeCounter++;
    }


    class Enemy {
        float x, y;
        int currentPathIndex = 0;
        float speed = 2;

        Enemy(float startX, float startY) {
            x = startX;
            y = startY;
        }

        void update() {
            // Move towards the next point in the path
            float targetX = fltPathX[currentPathIndex];
            float targetY = fltPathY[currentPathIndex];
            float dx = targetX - x;
            float dy = targetY - y;
            float distance = sqrt(dx * dx + dy * dy);

            if (distance > 1) {
                // Normalize the direction vector
                dx /= distance;
                dy /= distance;

                // Move towards the target
                x += dx * speed;
                y += dy * speed;
            } else {
                // Reached the current point, move to the next point in the path
                currentPathIndex = (currentPathIndex + 1) % fltPathX.length;

                // Check if the enemy is at the specified position, and remove it if true
                if (x == 165 && y == 518) {
                    // Remove the enemy from the ArrayList
                    enemies.remove(this);
                }
            }
        }


        void display() {

                fill(255, 0, 0);
                image(imgEnemy, x - 10, y - 10);

        }
    }

    public static void main(String[] args) {
        PApplet.main("TowerDefenseGame");
    }
}
