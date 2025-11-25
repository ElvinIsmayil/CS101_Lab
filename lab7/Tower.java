package lab7;

public class Tower {
    
    // Instance variables
    //* TODO: Implement variables
    
    private int health;
    private int score;
    public static String symbol = TowerDefenseGame.TOWER_SYMBOL;


    /*
     * Initializes the Tower with a specified health, score and symbol.
     * When initializing the health variable, call setHealth to prevent negative values.
     */
    public Tower (int health, int score, String symbol) {
        // * TODO: Implement this constructor
        setHealth(health);
        this.score = score;
        this.symbol = symbol;

    }

    /*
     * Returns true if the tower's health is greater than zero, otherwise false.
     */
    public boolean isStanding () {
        // * TODO: Implement this method
       return this.health > 0;
    }

    /*
     * Takes a damage value and decreases the tower's health by that amount.
     * The health value should never go below zero.
     */
    public void takeDamage (int damage) {
        // * TODO: Implement this method
        this.health -= damage;
        if(this.health < 0){
            this.health = 0;
        }
    }

    /*
     * Increases the tower's score by the given value.
     */
    public void incrementScore (int score) {
        // * TODO: Implement this method
        this.score += score;
    }

    /*
     * Returns a string representation of the tower,
     * including its symbol, health, and score.
     */
    @Override
    public String toString () {
        // * TODO: Implement this method
        String tower = "Tower: symbol (" + symbol + "), health (" + health + "), score (" + score + ')';
        return tower; // placeholder, remove before implementation
    }

    // Getters & Setters
    public String getSymbol () {
        // * TODO: Implement this method
        return this.symbol;
    }

    public int getScore () {
        // * TODO: Implement this method
        return this.score;
    }

    public void setScore (int score) {
        // * TODO: Implement this method
        if(score < 0){
            return;
        }
        this.score = score;
    }

    public int getHealth () {
        // * TODO: Implement this method
        return this.health;
    } 

    /*
     * Sets the tower's health to the given value.
     * The health value must not be negative.
     */
    public void setHealth (int health) {
        // * TODO: Implement this method   
        if(health < 0){
            this.health = 0;
        }
        else{
            this.health = health;
        }
    }

}
