
/**
 * Base class for bonus game objects
 */
public abstract class Bonus extends GameObject {
    protected int power; // health or score amount

    /* ToDo */
    public Bonus(GameGrid grid, int row, int col, char symbol){
        super(grid, row, col, symbol);
    }


}