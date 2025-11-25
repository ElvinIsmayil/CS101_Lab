package lab7;
import java.util.ArrayList;

public class GameManager {
    
    // Instance variables
    // * TODO: Implement variable
    public Tower tower;
    public ArrayList<EnemyWave> enemyWaves;
    public int enemyWavesLeft;

    /*
     * Initializes the GameManager.
     * Creates a new tower with initial health and score.
     * Prepares an empty map filled with empty enemy waves.
     * Adds the first enemy wave to start the game.
     */
    public GameManager () {
        //* TODO: Implement this constructor
        this.tower = new Tower(TowerDefenseGame.INITIAL_HEALTH, 0, Tower.symbol);
        generateEmptyMap();
        generateNextEnemyWave(true);
    }

    /*n
     * Fills the map with empty enemy waves.
     */
    private void generateEmptyMap () {
        // * TODO: Implement this method
        this.enemyWaves = new ArrayList<EnemyWave>();
        this.enemyWavesLeft = TowerDefenseGame.ENEMY_WAVES;
        for (int i = 0; i < TowerDefenseGame.COLUMNS; i++) {
            EnemyWave emptyWave = new EnemyWave(0);  
            enemyWaves.add(emptyWave);
    }
    addNextEnemyWave();
        
    }

    /*
     * Creates a new enemy wave.
     * If hasEnemies is true, a random number of enemies is spawned
     * up to the maximum enemy spawn rate.
     */
    private EnemyWave generateNextEnemyWave (boolean hasEnemies) {
        // * TODO: Implement this method
        int enemyWaveCount = 0;
        if(hasEnemies){
            enemyWaveCount = TowerDefenseGame.random.nextInt(1,TowerDefenseGame.MAX_ENEMY_SPAWN_RATE + 1);
            
        }
        EnemyWave enemyWave = new EnemyWave(enemyWaveCount);
        return enemyWave; 
    }

    /*
     * Returns the number of enemies left in the wave at the given column index.
     */
    public int getNumberOfEnemies (int index) {
        // * TODO: Implement this method
        int enemyCount = 0;
        EnemyWave enemyWave = this.enemyWaves.get(index);
        String[] arr = enemyWave.getEnemyWave();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(TowerDefenseGame.ENEMY_SYMBOL)){
                enemyCount++;
            }
        }
        return enemyCount;

    }

    /*
     * Removes the oldest enemy wave from the map.
     * Adds a new enemy wave at the end of the map.
     * Decreases the count of remaining waves.
     */
    public void addNextEnemyWave () {
        // * TODO: Implement this method
        if(hasEnemyWavesLeft()){
            this.enemyWaves.remove(0);
            EnemyWave enemyWave = generateNextEnemyWave(true);
            enemyWaves.add(enemyWave);
            this.enemyWavesLeft--;
        }
    }

    /*
     * Attempts to hit an enemy at the given column and row index.
     * Returns 1 if an enemy is hit, and 0 otherwise.
     */
    public int hitEnemy (int columnIndex, int rowIndex) {
        // * TODO: Implement this method
        EnemyWave enemyWave = this.enemyWaves.get(columnIndex);
        String[] arr = enemyWave.getEnemyWave();
        if(arr[rowIndex].equals(TowerDefenseGame.ENEMY_SYMBOL)){
            arr[rowIndex] = TowerDefenseGame.EMPTY_SYMBOL;
            return 1;
        }
        return 0; 
    }

    /*
     * Returns the tower object used in the game.
     */
    public Tower getTower () {
        // * TODO: Implement this method
        return this.tower;
    }

    /*
     * Returns true if there are still enemy waves left to spawn.
     */
    public boolean hasEnemyWavesLeft () {
        // * TODO: Implement this method
        
        return this.enemyWavesLeft > 0;
    }

    /*
     * Checks whether the game is over.
     * The game ends if the tower is destroyed or no enemy waves remain.
     */
    public boolean isGameOver () {
        //* TODO: Implement this method
        return(!this.tower.isStanding() || enemyWavesLeft == 0);
    }

    /*
     *  Reduces the tower's health based on enemies that reached the front column.
     *  Each remaining enemy decreases the tower's health by 1.
     */
    public void handleTowerDamage () {
         // * TODO: Implement this method
         if(!enemyWaves.isEmpty()){
            EnemyWave frontWave = enemyWaves.get(0);
            int numberOfEnemies = frontWave.getNumberOfEnemies();
            for (int i = 0; i < numberOfEnemies; i++) {
                this.tower.takeDamage(1);
            } 
         }
    }

    // Getters
    public ArrayList<EnemyWave> getEnemyWaves () {
        // * TODO: Implement this method
        return enemyWaves;
    }

    public int getEnemyWavesLeft () {
        // * TODO: Implement this method
        return enemyWavesLeft;
    }
   
}


