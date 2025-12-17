import java.util.Random;

/**
 * Base class for monster game objects
 */
public abstract class Monster extends GameObject {
    protected int damage; // amount by which health is decreased on hitting hero
    protected Random rng;

    /* ToDo */
    public Monster(GameGrid grid, int row, int col, char symbol) {
        super(grid, row, col, symbol);
    }
    
}