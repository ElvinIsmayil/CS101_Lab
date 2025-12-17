/**
 * Increments the score on collision with the hero
 */
public class ScoreBonus extends Bonus {
    /* ToDo */
    public ScoreBonus(GameGrid grid, int row, int col){
        super(grid, row, col, 'S');
    }

    @Override
    public int getPrecendence() {
        return 1;
    }

    @Override
    public void move() {
        // Bonus is stationary
    }
}