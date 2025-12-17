

/**
 * Implements the hero (the player) of the game. Can move in one of four
 * directions in each round. Aims to reach the target location on the grid.
 */
public class Hero extends GameObject {
    private int health = 100;
    private int score = 0;
    private char direction;

    public Hero(GameGrid grid, int row, int col) {
        super(grid, row, col, 'P');
    }

    /* ToDo */
    @Override
    public int getPrecendence(){
        return 5;
    }

    public int getHealth(){
        return this.health;
    }

    public int getScore(){
        return this.score;
    }

    @Override
    public void move(){
        switch (direction) {
        case 'w': 
            if (row > 0) row--;
            break;
        case 's': 
            if (row < GameMgr.GRID_HEIGHT - 1) row++;
            break;
        case 'a': 
            if (col > 0) col--;
            break;
        case 'd': 
            if (col < GameMgr.GRID_WIDTH - 1) col++;
            break;
    }
    }

    public boolean isTargetReached(){
        return (this.col == GameMgr.GRID_WIDTH-1 && this.row == GameMgr.GRID_HEIGHT-1);
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    @Override
    public void handleCollision(GameObject obj){
        if(obj instanceof HealthBonus){
            addHealth(10);
            grid.removeGameObject(obj);
        }
         else if(obj instanceof ScoreBonus){
            increaseScore(1);
            grid.removeGameObject(obj);
        }
        else if(obj instanceof RandomMonster){
            takeDamage(10);
            grid.removeGameObject(obj);
        }
        else if(obj instanceof ChasingMonster){
            takeDamage(10);
        }
    }

    public void increaseScore(int scr){
        this.score += scr;
    }

    public void addHealth(int hlth){
        this.health += hlth;
    }

    public void takeDamage(int dmg){
        this.health -= dmg;
    }

    public void setDirection(char dir){
        this.direction = dir;
    }
    




}