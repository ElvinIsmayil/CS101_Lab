import java.util.Random;

/**
 * Implements a monster that moves randomly on the grid
 */
public class RandomMonster extends Monster {
    /* ToDo */
    public RandomMonster(GameGrid grid, int row, int col){
        super(grid, row, col, 'R');
        this.rng = new Random();
    }
    @Override
    public int getPrecendence(){
        return 2;
    }
    @Override
    public void move() {
       int randomPosition = this.rng.nextInt(1,5);

        switch (randomPosition) {
        case 1: 
            if (row > 0) row--;
            break;
        case 2: 
            if (row < GameMgr.GRID_HEIGHT - 1) row++;
            break;
        case 3: 
            if (col > 0) col--;
            break;
        case 4: 
            if (col < GameMgr.GRID_WIDTH - 1) col++;
            break;
    }
       
    }


}