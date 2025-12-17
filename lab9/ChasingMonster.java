
import java.util.Random;

/**
 * Implements a monster following the hero with a certain probability on each round
 */
public class ChasingMonster extends Monster {
    /* ToDo */
    public ChasingMonster(GameGrid grid, int row, int col){
        super(grid, row, col, 'C');
        this.rng = new Random();
    }

    @Override
    public int getPrecendence(){
        return 4;
    }

    @Override
    public void move(){
        int moveTowardsHero = this.rng.nextInt(0,3);
        if(moveTowardsHero != 0){
            Hero hero = grid.getHero();

            boolean moveHorizontally = this.rng.nextBoolean();

            if (moveHorizontally) {
            if (hero.getCol() > col && col < GameMgr.GRID_WIDTH - 1) col++;
            else if (hero.getCol() < col && col > 0) col--;
        } 
        else {
            if (hero.getRow() > row && row < GameMgr.GRID_HEIGHT - 1) row++;
            else if (hero.getRow() < row && row > 0) row--;
        }
            
        }
    }

   

}