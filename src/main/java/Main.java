import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to specify your city's width and height? (Y/N)");
        String specify = in.next();
        boolean specifyStructure = (specify.equalsIgnoreCase("Y"));

        int cityWidth = -1;
        int cityHeight = -1;
        City city;
        if (specifyStructure){
            while ((cityWidth < 0) || (cityHeight < 0)){
                System.out.println("Please enter your city's width (no negative values):");
                cityWidth = in.nextInt();

                System.out.println("Please enter your city's height (no negative values):");
                cityHeight = in.nextInt();
            }
            city = new City(cityWidth, cityHeight);
        } else {
            city = new City();
        }

        System.out.println("Please enter the initial state of your city:");
        int people = 0;
        int totalPeople = city.getWidth() * city.getHeight();
        while (people < totalPeople){
            boolean isAlive = in.next().equals("+");
            Person person = new Person(isAlive);
            city.insertPerson(person);
            people++;
        }

        boolean nextState = true;
        while (nextState){
            System.out.println("The next state of your city:");
            city.passTime();

            System.out.println("Would you like to see the next state of your city? (Y/N)");
            String next = in.next();
            nextState = (next.equalsIgnoreCase("Y"));
        }
    }
}
