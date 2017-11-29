public class Person {
    private boolean alive;
    private short livingNeighbors;

    public Person (boolean alive){
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public short getLivingNeighbors() {
        return livingNeighbors;
    }

    public void setLivingNeighbors(short livingNeighbors) {
        this.livingNeighbors = livingNeighbors;
    }

    public void determineSurvival(){
        if (alive){
            alive = (livingNeighbors == 2 || livingNeighbors == 3);
        } else {
            alive = (livingNeighbors == 3);
        }
    }
}
