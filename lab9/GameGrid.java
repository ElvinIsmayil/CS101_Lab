
import java.util.*;

/**
 * Implements a grid for the maze in our game.
 */
public class GameGrid {

    // constants
    public static String HERO_SYMBOL = "😍";
    public static String RANDOM_MONSTER_SYMBOL = "👿";
    public static String CHASING_MONSTER_SYMBOL = "👹";
    public static String HEALTH_BONUS_SYMBOL = "💛";
    public static String SCORE_BONUS_SYMBOL = "💰";
    public static String FINISH_SYMBOL = "🏁";
    public static String WINNER_SYMBOL = "🥳";
    public static String LOSER_SYMBOL = "🥴️";

    // instance variables
    private int width, height; // dimensions of grid: # of columns & rows, resp.
    private ArrayList<GameObject> objects; // first one is always the hero
    private ArrayList<GameObject> queuedObjectsForRemoval;

    public GameGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.objects = new ArrayList<>();
        this.objects.add(new Hero(this, 0, 0));
        this.queuedObjectsForRemoval = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return (Hero) this.objects.get(0);
    }

    public boolean isAtTarget(int row, int col) {
        if (row == height - 1 && col == width - 1) {
            return true;
        }
        return false;
    }

    public void removeGameObject(GameObject obj) {
        this.queuedObjectsForRemoval.add(obj);
    }

    private void addGameObject(GameObject obj) {
        objects.add(obj);
    }

    public void spawnMonster(int row, int col) {
        Monster monster;
        if (Math.random() < 0.5) {
            monster = new RandomMonster(this, row, col);
        } else {
            monster = new ChasingMonster(this, row, col);
        }
        addGameObject(monster);
    }

    public void spawnBonus(int row, int col) {
        Bonus bonus;
        if (Math.random() < 0.5) {
            bonus = new HealthBonus(this, row, col);
        } else {
            bonus = new ScoreBonus(this, row, col);
        }
        addGameObject(bonus);
    }

    public void spawnGameObject() {
        int row, col;

        do {
            row = (int) (Math.random() * height);
            col = (int) (Math.random() * width);
        } while (isOccupied(row, col));

        if (Math.random() < 0.5) {
            spawnMonster(row, col);
        } else {
            spawnBonus(row, col);
        }
    }

    public boolean isOccupied(int row, int col) {
        for (GameObject obj : objects) {
            if (obj.getRow() == row && obj.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    public void draw() {

        for (int row = 0; row < height; row++) {

            // print horizontal line
            printSeparator();

            boolean printedFinishline = false;
            // print row content
            for (int col = 0; col < width; col++) {

                System.out.print("│");

                if (isAtTarget(row, col)) {
                    System.out.print(" " + FINISH_SYMBOL);
                    printedFinishline =true;
                    break;
                }

                boolean printed = false;

                for (GameObject obj : objects) {
                    if (obj.getRow() == row && obj.getCol() == col) {
                        System.out.print(turnPretty(obj.getSymbol()) + " ");
                        printed = true;
                        break;
                    }
                }

                if (!printed) {
                    System.out.print("   ");
                }
            }
            if (!printedFinishline) {
            System.out.println("│");
            
            
        }
        
    }
    System.out.println();

        // final bottom line
        printSeparator();
    }
    

    private void printSeparator() {
        for (int i = 0; i < width * 4 + 1; i++) {
            System.out.print("―");
        }
        System.out.println();
    }

    public static String turnPretty(char c) {
        if (c == 'P') {
            return HERO_SYMBOL; 
        }else if (c == 'R') {
            return RANDOM_MONSTER_SYMBOL; 
        }else if (c == 'C') {
            return CHASING_MONSTER_SYMBOL; 
        }else if (c == 'H') {
            return HEALTH_BONUS_SYMBOL; 
        }else if (c == 'S') {
            return SCORE_BONUS_SYMBOL;
        }
        return Character.toString(c);
    }

    public void update() {
        for (GameObject obj : objects) {
            obj.move();
        }
    }

    public void checkAndHandleCollisions() {
        Hero hero = getHero();
        for (int i = 1; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            if (hero.getRow() == obj.getRow() && hero.getCol() == obj.getCol()) {
                hero.handleCollision(obj);
            }
        }
        for (int i = 1; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject obj1 = objects.get(i);
                GameObject obj2 = objects.get(j);

                if (obj1.getRow() == obj2.getRow() && obj1.getCol() == obj2.getCol()) {
                    if (GameObject.doesSurviveOnCollision(obj1, obj2)) {
                        removeGameObject(obj2);
                    } else {
                        removeGameObject(obj1);
                    }
                }

            }
        }

    }

    public void removeQueuedObjects() {
        for (GameObject obj : queuedObjectsForRemoval) {
            this.objects.remove(obj);
        }
        queuedObjectsForRemoval.clear();
    }
}
