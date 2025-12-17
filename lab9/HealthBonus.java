/**
 * Implements a health bonus which increases hero's health on collision
 */
public class HealthBonus extends Bonus {
    /* ToDo */
    public HealthBonus(GameGrid grid, int row, int col){
        super(grid, row, col, 'H');
    }


    @Override
    public int getPrecendence(){
        return 3;
    }


    @Override
    public void move() {
        // Bonus is stationary
    }

    
}