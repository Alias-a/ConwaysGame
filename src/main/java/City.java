public class City {
    private int numCols = 8;
    private int numRows = 6;
    private int nextUnfilledCol = 0;
    private int nextUnfilledRow = 0;
    private Person[][] people;

    public City (int width, int height) {
        this.numCols = width;
        this.numRows = height;
        this.people = new Person[height][width];
    }

    public City (){
        this.people = new Person[numRows][numCols];
    }

    public void insertPerson(Person person) throws Exception {
        if (isFull()) {
            throw new Exception("Can't insert person. The City is full.");
        }

        people[nextUnfilledRow][nextUnfilledCol] = person;

        nextUnfilledCol++;
        if (nextUnfilledCol > (numCols - 1)){
            nextUnfilledCol = 0;
            nextUnfilledRow++;
        }

        if (isFull()) {
            determineLivingNeighbors();
        }
    }

    private void determineLivingNeighbors() {
        int row = 0;
        for (Person[] rowOfPeople : people){
            int col = 0;
            for (Person person : rowOfPeople) {
                Person above = ((row-1) >= 0) ? people[row-1][col] : null;
                Person below = ((row+1) <= numRows - 1) ? people[row+1][col] : null;
                Person toTheRight = ((col+1) <= (numCols - 1)) ? people[row][col+1] : null;
                Person toTheLeft = ((col-1) >= 0) ? people[row][col-1] : null;
                Person aboveToTheLeft = (above != null && toTheLeft != null) ? people[row-1][col-1] : null;
                Person aboveToTheRight = (above != null && toTheRight != null) ? people[row-1][col+1] : null;
                Person belowToTheLeft = (below != null && toTheLeft != null) ? people[row+1][col-1] : null;
                Person belowToTheRight = (below != null && toTheRight != null) ? people[row+1][col+1] : null;
                Person[] neighbors = {above, below, toTheRight, toTheLeft, aboveToTheLeft, aboveToTheRight, belowToTheLeft, belowToTheRight};

                short livingNeighbors = 0;
                for(Person neighbor : neighbors){
                    if (neighbor != null && neighbor.isAlive()){
                        livingNeighbors++;
                    }
                }

                person.setLivingNeighbors(livingNeighbors);

                col++;
            }
            row++;
        }
    }

    private boolean isFull() {
        return (nextUnfilledRow > (numRows - 1));
    }

    public void passTime() {
        for(Person[] columnOfPeople : people){
            for (Person person : columnOfPeople){
                person.determineSurvival();
                System.out.print(person.isAlive() ? "+" : "-");
                System.out.print(" ");
            }
            System.out.print('\n');
        }
        determineLivingNeighbors();
    }

    public Person[][] getPeople() {
        return people;
    }

    public int getWidth() {
        return numCols;
    }

    public int getHeight() {
        return numRows;
    }

    @Override
    public String toString(){
        String city = "";
        for (Person[] rowOfPeople : people){
            for (Person person : rowOfPeople){
                city += (person.isAlive() ? "+" : "-") + " ";
            }
            city += '\n';
        }
        return city;
    }
}
