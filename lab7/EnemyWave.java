package lab7;

public class EnemyWave {
    
    // Instance variable
    // * TODO: Implement variable
    private String[] enemyWave;
     
    /*
     * Initializes an EnemyWave with a given number of enemies.
     * Enemies are first placed into the array and then shuffled randomly.
     */
    public EnemyWave (int numberOfEnemies) {
        // * TODO: Implement this constructor
        this.enemyWave = new String[TowerDefenseGame.ROWS]; 
        initializeWave(numberOfEnemies);
        shuffleArray();
    } 
    
    /*
     * Fills the wave array with enemies for the first 'numberOfEnemies' positions
     * and empty symbols in the remaining positions.
     */
    private void initializeWave (int numberOfEnemies) {
        // * TODO: Implement this method
        for (int i = 0; i < numberOfEnemies; i++) {
            this.enemyWave[i] = TowerDefenseGame.ENEMY_SYMBOL;
        }
        for (int i = numberOfEnemies; i < TowerDefenseGame.ROWS; i++) {
            this.enemyWave[i] = TowerDefenseGame.EMPTY_SYMBOL;
        }
    }

    /*
     * Randomly shuffles the positions of enemies and empty symbols
     * using Fisher–Yates shuffle algorithm.
     */
    private void shuffleArray () {
        // * TODO: Implement this method 
        for (int i = this.enemyWave.length - 1; i > 0; i--) {
            int randomIndex = TowerDefenseGame.random.nextInt(i + 1);
            String temp = this.enemyWave[i];
            this.enemyWave[i] = this.enemyWave[randomIndex];
            this.enemyWave[randomIndex] = temp;
        }
    }    

    /*
     * Attempts to hit an enemy at the given index.
     * If an enemy is present, it is replaced with an empty symbol and the method returns 1. 
     * Otherwise, it returns 0.
     */
    public int hitEnemy (int index) {
        // * TODO: Implement this method
        if(enemyWave[index].equals(TowerDefenseGame.ENEMY_SYMBOL)){
            enemyWave[index] = TowerDefenseGame.EMPTY_SYMBOL;
            return 1;
        }
        return 0; 
    }

    /*
     * Counts and returns the number of enemies still alive in this wave.
     */
    public int getNumberOfEnemies () {
        //* TODO: Implement this method
        int count = 0;
        for (int i = 0; i < enemyWave.length; i++) {
            if(this.enemyWave[i].equals(TowerDefenseGame.ENEMY_SYMBOL)){
                count++;
            }
        }
        return count;
    }

    // Getter
    public String[] getEnemyWave () {
        // * TODO: Implement this method
        return this.enemyWave;
    }

   
    
}

